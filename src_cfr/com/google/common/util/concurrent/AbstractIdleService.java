/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractIdleService$1;
import com.google.common.util.concurrent.AbstractIdleService$2;
import com.google.common.util.concurrent.AbstractIdleService$3;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Beta
public abstract class AbstractIdleService
implements Service {
    private final Supplier threadNameSupplier;
    private final Service delegate;

    protected AbstractIdleService() {
        this.threadNameSupplier = new AbstractIdleService$1(this);
        this.delegate = new AbstractIdleService$2(this);
    }

    protected abstract void startUp();

    protected abstract void shutDown();

    protected Executor executor() {
        return new AbstractIdleService$3(this);
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

    protected String serviceName() {
        return this.getClass().getSimpleName();
    }

    static /* synthetic */ Supplier access$000(AbstractIdleService abstractIdleService) {
        return abstractIdleService.threadNameSupplier;
    }
}

