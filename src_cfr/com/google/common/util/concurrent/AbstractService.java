/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractService$1;
import com.google.common.util.concurrent.AbstractService$10;
import com.google.common.util.concurrent.AbstractService$2;
import com.google.common.util.concurrent.AbstractService$3;
import com.google.common.util.concurrent.AbstractService$4;
import com.google.common.util.concurrent.AbstractService$5;
import com.google.common.util.concurrent.AbstractService$6;
import com.google.common.util.concurrent.AbstractService$7;
import com.google.common.util.concurrent.AbstractService$8;
import com.google.common.util.concurrent.AbstractService$9;
import com.google.common.util.concurrent.AbstractService$StateSnapshot;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Monitor$Guard;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

@Beta
public abstract class AbstractService
implements Service {
    private static final ListenerCallQueue$Callback STARTING_CALLBACK = new AbstractService$1("starting()");
    private static final ListenerCallQueue$Callback RUNNING_CALLBACK = new AbstractService$2("running()");
    private static final ListenerCallQueue$Callback STOPPING_FROM_STARTING_CALLBACK = AbstractService.stoppingCallback(Service$State.STARTING);
    private static final ListenerCallQueue$Callback STOPPING_FROM_RUNNING_CALLBACK = AbstractService.stoppingCallback(Service$State.RUNNING);
    private static final ListenerCallQueue$Callback TERMINATED_FROM_NEW_CALLBACK = AbstractService.terminatedCallback(Service$State.NEW);
    private static final ListenerCallQueue$Callback TERMINATED_FROM_RUNNING_CALLBACK = AbstractService.terminatedCallback(Service$State.RUNNING);
    private static final ListenerCallQueue$Callback TERMINATED_FROM_STOPPING_CALLBACK = AbstractService.terminatedCallback(Service$State.STOPPING);
    private final Monitor monitor = new Monitor();
    private final Monitor$Guard isStartable;
    private final Monitor$Guard isStoppable;
    private final Monitor$Guard hasReachedRunning;
    private final Monitor$Guard isStopped;
    @GuardedBy(value="monitor")
    private final List listeners;
    @GuardedBy(value="monitor")
    private volatile AbstractService$StateSnapshot snapshot;

    private static ListenerCallQueue$Callback terminatedCallback(Service$State service$State) {
        String string = String.valueOf((Object)service$State);
        return new AbstractService$3(new StringBuilder(21 + String.valueOf(string).length()).append("terminated({from = ").append(string).append("})").toString(), service$State);
    }

    private static ListenerCallQueue$Callback stoppingCallback(Service$State service$State) {
        String string = String.valueOf((Object)service$State);
        return new AbstractService$4(new StringBuilder(19 + String.valueOf(string).length()).append("stopping({from = ").append(string).append("})").toString(), service$State);
    }

    protected AbstractService() {
        this.isStartable = new AbstractService$5(this, this.monitor);
        this.isStoppable = new AbstractService$6(this, this.monitor);
        this.hasReachedRunning = new AbstractService$7(this, this.monitor);
        this.isStopped = new AbstractService$8(this, this.monitor);
        this.listeners = Collections.synchronizedList(new ArrayList());
        this.snapshot = new AbstractService$StateSnapshot(Service$State.NEW);
    }

    protected abstract void doStart();

    protected abstract void doStop();

    @Override
    public final Service startAsync() {
        if (!this.monitor.enterIf(this.isStartable)) {
            String string = String.valueOf(this);
            throw new IllegalStateException(new StringBuilder(33 + String.valueOf(string).length()).append("Service ").append(string).append(" has already been started").toString());
        }
        try {
            this.snapshot = new AbstractService$StateSnapshot(Service$State.STARTING);
            this.starting();
            this.doStart();
            return this;
        }
        catch (Throwable var1_1) {
            this.notifyFailed(var1_1);
            return this;
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }

    @Override
    public final Service stopAsync() {
        if (!this.monitor.enterIf(this.isStoppable)) return this;
        try {
            Service$State service$State = this.state();
            switch (AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[service$State.ordinal()]) {
                case 1: {
                    this.snapshot = new AbstractService$StateSnapshot(Service$State.TERMINATED);
                    this.terminated(Service$State.NEW);
                    return this;
                }
                case 2: {
                    this.snapshot = new AbstractService$StateSnapshot(Service$State.STARTING, true, null);
                    this.stopping(Service$State.STARTING);
                    return this;
                }
                case 3: {
                    this.snapshot = new AbstractService$StateSnapshot(Service$State.STOPPING);
                    this.stopping(Service$State.RUNNING);
                    this.doStop();
                    return this;
                }
                case 4: 
                case 5: 
                case 6: {
                    String string = String.valueOf((Object)((Object)service$State));
                    throw new AssertionError((Object)new StringBuilder(45 + String.valueOf(string).length()).append("isStoppable is incorrectly implemented, saw: ").append(string).toString());
                }
            }
            String string = String.valueOf((Object)((Object)service$State));
            throw new AssertionError((Object)new StringBuilder(18 + String.valueOf(string).length()).append("Unexpected state: ").append(string).toString());
        }
        catch (Throwable var1_2) {
            this.notifyFailed(var1_2);
            return this;
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }

    @Override
    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        try {
            this.checkCurrentState(Service$State.RUNNING);
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void awaitRunning(long l2, TimeUnit timeUnit) {
        if (!this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, l2, timeUnit)) {
            String string = String.valueOf(this);
            String string2 = String.valueOf((Object)((Object)this.state()));
            throw new TimeoutException(new StringBuilder(66 + String.valueOf(string).length() + String.valueOf(string2).length()).append("Timed out waiting for ").append(string).append(" to reach the RUNNING state. ").append("Current state: ").append(string2).toString());
        }
        try {
            this.checkCurrentState(Service$State.RUNNING);
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    @Override
    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        try {
            this.checkCurrentState(Service$State.TERMINATED);
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void awaitTerminated(long l2, TimeUnit timeUnit) {
        if (!this.monitor.enterWhenUninterruptibly(this.isStopped, l2, timeUnit)) {
            String string = String.valueOf(this);
            String string2 = String.valueOf((Object)((Object)this.state()));
            throw new TimeoutException(new StringBuilder(65 + String.valueOf(string).length() + String.valueOf(string2).length()).append("Timed out waiting for ").append(string).append(" to reach a terminal state. ").append("Current state: ").append(string2).toString());
        }
        try {
            this.checkCurrentState(Service$State.TERMINATED);
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    @GuardedBy(value="monitor")
    private void checkCurrentState(Service$State service$State) {
        Service$State service$State2 = this.state();
        if (service$State2 == service$State) return;
        if (service$State2 == Service$State.FAILED) {
            String string = String.valueOf((Object)((Object)service$State));
            throw new IllegalStateException(new StringBuilder(55 + String.valueOf(string).length()).append("Expected the service to be ").append(string).append(", but the service has FAILED").toString(), this.failureCause());
        }
        String string = String.valueOf((Object)((Object)service$State));
        String string2 = String.valueOf((Object)((Object)service$State2));
        throw new IllegalStateException(new StringBuilder(37 + String.valueOf(string).length() + String.valueOf(string2).length()).append("Expected the service to be ").append(string).append(", but was ").append(string2).toString());
    }

    protected final void notifyStarted() {
        this.monitor.enter();
        try {
            if (this.snapshot.state != Service$State.STARTING) {
                String string = String.valueOf((Object)((Object)this.snapshot.state));
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(43 + String.valueOf(string).length()).append("Cannot notifyStarted() when the service is ").append(string).toString());
                this.notifyFailed(illegalStateException);
                throw illegalStateException;
            }
            if (this.snapshot.shutdownWhenStartupFinishes) {
                this.snapshot = new AbstractService$StateSnapshot(Service$State.STOPPING);
                this.doStop();
                return;
            }
            this.snapshot = new AbstractService$StateSnapshot(Service$State.RUNNING);
            this.running();
            return;
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void notifyStopped() {
        this.monitor.enter();
        try {
            Service$State service$State = this.snapshot.state;
            if (service$State != Service$State.STOPPING && service$State != Service$State.RUNNING) {
                String string = String.valueOf((Object)((Object)service$State));
                IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(43 + String.valueOf(string).length()).append("Cannot notifyStopped() when the service is ").append(string).toString());
                this.notifyFailed(illegalStateException);
                throw illegalStateException;
            }
            this.snapshot = new AbstractService$StateSnapshot(Service$State.TERMINATED);
            this.terminated(service$State);
            return;
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected final void notifyFailed(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        this.monitor.enter();
        try {
            Service$State service$State = this.state();
            switch (AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[service$State.ordinal()]) {
                case 1: 
                case 5: {
                    String string = String.valueOf((Object)((Object)service$State));
                    throw new IllegalStateException(new StringBuilder(22 + String.valueOf(string).length()).append("Failed while in state:").append(string).toString(), throwable);
                }
                case 2: 
                case 3: 
                case 4: {
                    this.snapshot = new AbstractService$StateSnapshot(Service$State.FAILED, false, throwable);
                    this.failed(service$State, throwable);
                    return;
                }
                case 6: {
                    return;
                }
            }
            String string = String.valueOf((Object)((Object)service$State));
            throw new AssertionError((Object)new StringBuilder(18 + String.valueOf(string).length()).append("Unexpected state: ").append(string).toString());
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }

    @Override
    public final boolean isRunning() {
        if (this.state() != Service$State.RUNNING) return false;
        return true;
    }

    @Override
    public final Service$State state() {
        return this.snapshot.externalState();
    }

    @Override
    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    @Override
    public final void addListener(Service$Listener service$Listener, Executor executor) {
        Preconditions.checkNotNull(service$Listener, "listener");
        Preconditions.checkNotNull(executor, "executor");
        this.monitor.enter();
        try {
            if (this.state().isTerminal()) return;
            this.listeners.add(new ListenerCallQueue(service$Listener, executor));
            return;
        }
        finally {
            this.monitor.leave();
        }
    }

    public String toString() {
        String string = String.valueOf(this.getClass().getSimpleName());
        String string2 = String.valueOf((Object)((Object)this.state()));
        return new StringBuilder(3 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(" [").append(string2).append("]").toString();
    }

    private void executeListeners() {
        if (this.monitor.isOccupiedByCurrentThread()) return;
        int n2 = 0;
        while (n2 < this.listeners.size()) {
            ((ListenerCallQueue)this.listeners.get(n2)).execute();
            ++n2;
        }
    }

    @GuardedBy(value="monitor")
    private void starting() {
        STARTING_CALLBACK.enqueueOn(this.listeners);
    }

    @GuardedBy(value="monitor")
    private void running() {
        RUNNING_CALLBACK.enqueueOn(this.listeners);
    }

    @GuardedBy(value="monitor")
    private void stopping(Service$State service$State) {
        if (service$State == Service$State.STARTING) {
            STOPPING_FROM_STARTING_CALLBACK.enqueueOn(this.listeners);
            return;
        }
        if (service$State != Service$State.RUNNING) throw new AssertionError();
        STOPPING_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
    }

    @GuardedBy(value="monitor")
    private void terminated(Service$State service$State) {
        switch (service$State) {
            case NEW: {
                TERMINATED_FROM_NEW_CALLBACK.enqueueOn(this.listeners);
                return;
            }
            case RUNNING: {
                TERMINATED_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
                return;
            }
            case STOPPING: {
                TERMINATED_FROM_STOPPING_CALLBACK.enqueueOn(this.listeners);
                return;
            }
        }
        throw new AssertionError();
    }

    @GuardedBy(value="monitor")
    private void failed(Service$State service$State, Throwable throwable) {
        String string = String.valueOf((Object)((Object)service$State));
        String string2 = String.valueOf(throwable);
        new AbstractService$9(this, new StringBuilder(27 + String.valueOf(string).length() + String.valueOf(string2).length()).append("failed({from = ").append(string).append(", cause = ").append(string2).append("})").toString(), service$State, throwable).enqueueOn(this.listeners);
    }
}

