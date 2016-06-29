/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$2;
import com.google.common.util.concurrent.AbstractScheduledService$3;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Beta
public abstract class AbstractScheduledService
implements Service {
    private static final Logger logger = Logger.getLogger(AbstractScheduledService.class.getName());
    private final AbstractService delegate;

    protected AbstractScheduledService() {
        this.delegate = new AbstractScheduledService$1(this);
    }

    protected abstract void runOneIteration();

    protected void startUp() {
    }

    protected void shutDown() {
    }

    protected abstract AbstractScheduledService$Scheduler scheduler();

    protected ScheduledExecutorService executor() {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new AbstractScheduledService$2(this));
        this.addListener(new AbstractScheduledService$3(this, scheduledExecutorService), MoreExecutors.directExecutor());
        return scheduledExecutorService;
    }

    protected String serviceName() {
        return this.getClass().getSimpleName();
    }

    public String toString() {
        String string = this.serviceName();
        String string2 = String.valueOf((Object)((Object)this.state()));
        return new StringBuilder(3 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(" [").append(string2).append("]").toString();
    }

    @Override
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override
    public final Service$State state() {
        return this.delegate.state();
    }

    @Override
    public final void addListener(Service$Listener service$Listener, Executor executor) {
        this.delegate.addListener(service$Listener, executor);
    }

    @Override
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    @Override
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override
    public final void awaitRunning(long l2, TimeUnit timeUnit) {
        this.delegate.awaitRunning(l2, timeUnit);
    }

    @Override
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override
    public final void awaitTerminated(long l2, TimeUnit timeUnit) {
        this.delegate.awaitTerminated(l2, timeUnit);
    }

    static /* synthetic */ Logger access$300() {
        return logger;
    }

    static /* synthetic */ AbstractService access$400(AbstractScheduledService abstractScheduledService) {
        return abstractScheduledService.delegate;
    }
}

