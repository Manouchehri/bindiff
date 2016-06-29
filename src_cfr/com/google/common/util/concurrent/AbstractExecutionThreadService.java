/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1;
import com.google.common.util.concurrent.AbstractExecutionThreadService$2;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Beta
public abstract class AbstractExecutionThreadService
implements Service {
    private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service delegate;

    protected AbstractExecutionThreadService() {
        this.delegate = new AbstractExecutionThreadService$1(this);
    }

    protected void startUp() {
    }

    protected abstract void run();

    protected void shutDown() {
    }

    protected void triggerShutdown() {
    }

    protected Executor executor() {
        return new AbstractExecutionThreadService$2(this);
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
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
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

    protected String serviceName() {
        return this.getClass().getSimpleName();
    }

    static /* synthetic */ Logger access$000() {
        return logger;
    }
}

