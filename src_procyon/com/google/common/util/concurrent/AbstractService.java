package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import java.util.*;
import com.google.common.base.*;
import java.util.concurrent.*;

@Beta
public abstract class AbstractService implements Service
{
    private static final ListenerCallQueue$Callback STARTING_CALLBACK;
    private static final ListenerCallQueue$Callback RUNNING_CALLBACK;
    private static final ListenerCallQueue$Callback STOPPING_FROM_STARTING_CALLBACK;
    private static final ListenerCallQueue$Callback STOPPING_FROM_RUNNING_CALLBACK;
    private static final ListenerCallQueue$Callback TERMINATED_FROM_NEW_CALLBACK;
    private static final ListenerCallQueue$Callback TERMINATED_FROM_RUNNING_CALLBACK;
    private static final ListenerCallQueue$Callback TERMINATED_FROM_STOPPING_CALLBACK;
    private final Monitor monitor;
    private final Monitor$Guard isStartable;
    private final Monitor$Guard isStoppable;
    private final Monitor$Guard hasReachedRunning;
    private final Monitor$Guard isStopped;
    @GuardedBy("monitor")
    private final List listeners;
    @GuardedBy("monitor")
    private volatile AbstractService$StateSnapshot snapshot;
    
    private static ListenerCallQueue$Callback terminatedCallback(final Service$State service$State) {
        final String value = String.valueOf(service$State);
        return new AbstractService$3(new StringBuilder(21 + String.valueOf(value).length()).append("terminated({from = ").append(value).append("})").toString(), service$State);
    }
    
    private static ListenerCallQueue$Callback stoppingCallback(final Service$State service$State) {
        final String value = String.valueOf(service$State);
        return new AbstractService$4(new StringBuilder(19 + String.valueOf(value).length()).append("stopping({from = ").append(value).append("})").toString(), service$State);
    }
    
    protected AbstractService() {
        this.monitor = new Monitor();
        this.isStartable = new AbstractService$5(this, this.monitor);
        this.isStoppable = new AbstractService$6(this, this.monitor);
        this.hasReachedRunning = new AbstractService$7(this, this.monitor);
        this.isStopped = new AbstractService$8(this, this.monitor);
        this.listeners = Collections.synchronizedList(new ArrayList<Object>());
        this.snapshot = new AbstractService$StateSnapshot(Service$State.NEW);
    }
    
    protected abstract void doStart();
    
    protected abstract void doStop();
    
    @Override
    public final Service startAsync() {
        if (this.monitor.enterIf(this.isStartable)) {
            try {
                this.snapshot = new AbstractService$StateSnapshot(Service$State.STARTING);
                this.starting();
                this.doStart();
            }
            catch (Throwable t) {
                this.notifyFailed(t);
            }
            finally {
                this.monitor.leave();
                this.executeListeners();
            }
            return this;
        }
        final String value = String.valueOf(this);
        throw new IllegalStateException(new StringBuilder(33 + String.valueOf(value).length()).append("Service ").append(value).append(" has already been started").toString());
    }
    
    @Override
    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable)) {
            try {
                final Service$State state = this.state();
                switch (AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
                    case 1: {
                        this.snapshot = new AbstractService$StateSnapshot(Service$State.TERMINATED);
                        this.terminated(Service$State.NEW);
                        break;
                    }
                    case 2: {
                        this.snapshot = new AbstractService$StateSnapshot(Service$State.STARTING, true, null);
                        this.stopping(Service$State.STARTING);
                        break;
                    }
                    case 3: {
                        this.snapshot = new AbstractService$StateSnapshot(Service$State.STOPPING);
                        this.stopping(Service$State.RUNNING);
                        this.doStop();
                        break;
                    }
                    case 4:
                    case 5:
                    case 6: {
                        final String value = String.valueOf(state);
                        throw new AssertionError((Object)new StringBuilder(45 + String.valueOf(value).length()).append("isStoppable is incorrectly implemented, saw: ").append(value).toString());
                    }
                    default: {
                        final String value2 = String.valueOf(state);
                        throw new AssertionError((Object)new StringBuilder(18 + String.valueOf(value2).length()).append("Unexpected state: ").append(value2).toString());
                    }
                }
            }
            catch (Throwable t) {
                this.notifyFailed(t);
            }
            finally {
                this.monitor.leave();
                this.executeListeners();
            }
        }
        return this;
    }
    
    @Override
    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        try {
            this.checkCurrentState(Service$State.RUNNING);
        }
        finally {
            this.monitor.leave();
        }
    }
    
    @Override
    public final void awaitRunning(final long n, final TimeUnit timeUnit) {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, n, timeUnit)) {
            try {
                this.checkCurrentState(Service$State.RUNNING);
            }
            finally {
                this.monitor.leave();
            }
            return;
        }
        final String value = String.valueOf(this);
        final String value2 = String.valueOf(this.state());
        throw new TimeoutException(new StringBuilder(66 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Timed out waiting for ").append(value).append(" to reach the RUNNING state. ").append("Current state: ").append(value2).toString());
    }
    
    @Override
    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        try {
            this.checkCurrentState(Service$State.TERMINATED);
        }
        finally {
            this.monitor.leave();
        }
    }
    
    @Override
    public final void awaitTerminated(final long n, final TimeUnit timeUnit) {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, n, timeUnit)) {
            try {
                this.checkCurrentState(Service$State.TERMINATED);
            }
            finally {
                this.monitor.leave();
            }
            return;
        }
        final String value = String.valueOf(this);
        final String value2 = String.valueOf(this.state());
        throw new TimeoutException(new StringBuilder(65 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Timed out waiting for ").append(value).append(" to reach a terminal state. ").append("Current state: ").append(value2).toString());
    }
    
    @GuardedBy("monitor")
    private void checkCurrentState(final Service$State service$State) {
        final Service$State state = this.state();
        if (state == service$State) {
            return;
        }
        if (state == Service$State.FAILED) {
            final String value = String.valueOf(service$State);
            throw new IllegalStateException(new StringBuilder(55 + String.valueOf(value).length()).append("Expected the service to be ").append(value).append(", but the service has FAILED").toString(), this.failureCause());
        }
        final String value2 = String.valueOf(service$State);
        final String value3 = String.valueOf(state);
        throw new IllegalStateException(new StringBuilder(37 + String.valueOf(value2).length() + String.valueOf(value3).length()).append("Expected the service to be ").append(value2).append(", but was ").append(value3).toString());
    }
    
    protected final void notifyStarted() {
        this.monitor.enter();
        try {
            if (this.snapshot.state != Service$State.STARTING) {
                final String value = String.valueOf(this.snapshot.state);
                final IllegalStateException ex = new IllegalStateException(new StringBuilder(43 + String.valueOf(value).length()).append("Cannot notifyStarted() when the service is ").append(value).toString());
                this.notifyFailed(ex);
                throw ex;
            }
            if (this.snapshot.shutdownWhenStartupFinishes) {
                this.snapshot = new AbstractService$StateSnapshot(Service$State.STOPPING);
                this.doStop();
            }
            else {
                this.snapshot = new AbstractService$StateSnapshot(Service$State.RUNNING);
                this.running();
            }
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }
    
    protected final void notifyStopped() {
        this.monitor.enter();
        try {
            final Service$State state = this.snapshot.state;
            if (state != Service$State.STOPPING && state != Service$State.RUNNING) {
                final String value = String.valueOf(state);
                final IllegalStateException ex = new IllegalStateException(new StringBuilder(43 + String.valueOf(value).length()).append("Cannot notifyStopped() when the service is ").append(value).toString());
                this.notifyFailed(ex);
                throw ex;
            }
            this.snapshot = new AbstractService$StateSnapshot(Service$State.TERMINATED);
            this.terminated(state);
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }
    
    protected final void notifyFailed(final Throwable t) {
        Preconditions.checkNotNull(t);
        this.monitor.enter();
        try {
            final Service$State state = this.state();
            switch (AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
                case 1:
                case 5: {
                    final String value = String.valueOf(state);
                    throw new IllegalStateException(new StringBuilder(22 + String.valueOf(value).length()).append("Failed while in state:").append(value).toString(), t);
                }
                case 2:
                case 3:
                case 4: {
                    this.snapshot = new AbstractService$StateSnapshot(Service$State.FAILED, false, t);
                    this.failed(state, t);
                    break;
                }
                case 6: {
                    break;
                }
                default: {
                    final String value2 = String.valueOf(state);
                    throw new AssertionError((Object)new StringBuilder(18 + String.valueOf(value2).length()).append("Unexpected state: ").append(value2).toString());
                }
            }
        }
        finally {
            this.monitor.leave();
            this.executeListeners();
        }
    }
    
    @Override
    public final boolean isRunning() {
        return this.state() == Service$State.RUNNING;
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
    public final void addListener(final Service$Listener service$Listener, final Executor executor) {
        Preconditions.checkNotNull(service$Listener, (Object)"listener");
        Preconditions.checkNotNull(executor, (Object)"executor");
        this.monitor.enter();
        try {
            if (!this.state().isTerminal()) {
                this.listeners.add(new ListenerCallQueue(service$Listener, executor));
            }
        }
        finally {
            this.monitor.leave();
        }
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.getClass().getSimpleName());
        final String value2 = String.valueOf(this.state());
        return new StringBuilder(3 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append(" [").append(value2).append("]").toString();
    }
    
    private void executeListeners() {
        if (!this.monitor.isOccupiedByCurrentThread()) {
            for (int i = 0; i < this.listeners.size(); ++i) {
                ((ListenerCallQueue)this.listeners.get(i)).execute();
            }
        }
    }
    
    @GuardedBy("monitor")
    private void starting() {
        AbstractService.STARTING_CALLBACK.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    private void running() {
        AbstractService.RUNNING_CALLBACK.enqueueOn(this.listeners);
    }
    
    @GuardedBy("monitor")
    private void stopping(final Service$State service$State) {
        if (service$State == Service$State.STARTING) {
            AbstractService.STOPPING_FROM_STARTING_CALLBACK.enqueueOn(this.listeners);
        }
        else {
            if (service$State != Service$State.RUNNING) {
                throw new AssertionError();
            }
            AbstractService.STOPPING_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
        }
    }
    
    @GuardedBy("monitor")
    private void terminated(final Service$State service$State) {
        switch (AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[service$State.ordinal()]) {
            case 1: {
                AbstractService.TERMINATED_FROM_NEW_CALLBACK.enqueueOn(this.listeners);
                break;
            }
            case 3: {
                AbstractService.TERMINATED_FROM_RUNNING_CALLBACK.enqueueOn(this.listeners);
                break;
            }
            case 4: {
                AbstractService.TERMINATED_FROM_STOPPING_CALLBACK.enqueueOn(this.listeners);
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    @GuardedBy("monitor")
    private void failed(final Service$State service$State, final Throwable t) {
        final String value = String.valueOf(service$State);
        final String value2 = String.valueOf(t);
        new AbstractService$9(this, new StringBuilder(27 + String.valueOf(value).length() + String.valueOf(value2).length()).append("failed({from = ").append(value).append(", cause = ").append(value2).append("})").toString(), service$State, t).enqueueOn(this.listeners);
    }
    
    static {
        STARTING_CALLBACK = new AbstractService$1("starting()");
        RUNNING_CALLBACK = new AbstractService$2("running()");
        STOPPING_FROM_STARTING_CALLBACK = stoppingCallback(Service$State.STARTING);
        STOPPING_FROM_RUNNING_CALLBACK = stoppingCallback(Service$State.RUNNING);
        TERMINATED_FROM_NEW_CALLBACK = terminatedCallback(Service$State.NEW);
        TERMINATED_FROM_RUNNING_CALLBACK = terminatedCallback(Service$State.RUNNING);
        TERMINATED_FROM_STOPPING_CALLBACK = terminatedCallback(Service$State.STOPPING);
    }
}
