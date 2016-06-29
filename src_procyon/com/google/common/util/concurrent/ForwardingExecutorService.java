package com.google.common.util.concurrent;

import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;

public abstract class ForwardingExecutorService extends ForwardingObject implements ExecutorService
{
    @Override
    protected abstract ExecutorService delegate();
    
    @Override
    public boolean awaitTermination(final long n, final TimeUnit timeUnit) {
        return this.delegate().awaitTermination(n, timeUnit);
    }
    
    @Override
    public List invokeAll(final Collection collection) {
        return this.delegate().invokeAll((Collection<? extends Callable<Object>>)collection);
    }
    
    @Override
    public List invokeAll(final Collection collection, final long n, final TimeUnit timeUnit) {
        return this.delegate().invokeAll((Collection<? extends Callable<Object>>)collection, n, timeUnit);
    }
    
    @Override
    public Object invokeAny(final Collection collection) {
        return this.delegate().invokeAny((Collection<? extends Callable<Object>>)collection);
    }
    
    @Override
    public Object invokeAny(final Collection collection, final long n, final TimeUnit timeUnit) {
        return this.delegate().invokeAny((Collection<? extends Callable<Object>>)collection, n, timeUnit);
    }
    
    @Override
    public boolean isShutdown() {
        return this.delegate().isShutdown();
    }
    
    @Override
    public boolean isTerminated() {
        return this.delegate().isTerminated();
    }
    
    @Override
    public void shutdown() {
        this.delegate().shutdown();
    }
    
    @Override
    public List shutdownNow() {
        return this.delegate().shutdownNow();
    }
    
    @Override
    public void execute(final Runnable runnable) {
        this.delegate().execute(runnable);
    }
    
    @Override
    public Future submit(final Callable callable) {
        return this.delegate().submit((Callable<Object>)callable);
    }
    
    @Override
    public Future submit(final Runnable runnable) {
        return this.delegate().submit(runnable);
    }
    
    @Override
    public Future submit(final Runnable runnable, final Object o) {
        return this.delegate().submit(runnable, o);
    }
}
