package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;

@Beta
public abstract class AbstractIdleService implements Service
{
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
    
    @Override
    public String toString() {
        final String serviceName = this.serviceName();
        final String value = String.valueOf(this.state());
        return new StringBuilder(3 + String.valueOf(serviceName).length() + String.valueOf(value).length()).append(serviceName).append(" [").append(value).append("]").toString();
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
    public final void addListener(final Service$Listener service$Listener, final Executor executor) {
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
    public final void awaitRunning(final long n, final TimeUnit timeUnit) {
        this.delegate.awaitRunning(n, timeUnit);
    }
    
    @Override
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }
    
    @Override
    public final void awaitTerminated(final long n, final TimeUnit timeUnit) {
        this.delegate.awaitTerminated(n, timeUnit);
    }
    
    protected String serviceName() {
        return this.getClass().getSimpleName();
    }
}
