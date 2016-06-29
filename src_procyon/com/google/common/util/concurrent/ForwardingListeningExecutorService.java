package com.google.common.util.concurrent;

import java.util.concurrent.*;

public abstract class ForwardingListeningExecutorService extends ForwardingExecutorService implements ListeningExecutorService
{
    @Override
    protected abstract ListeningExecutorService delegate();
    
    @Override
    public ListenableFuture submit(final Callable callable) {
        return this.delegate().submit(callable);
    }
    
    @Override
    public ListenableFuture submit(final Runnable runnable) {
        return this.delegate().submit(runnable);
    }
    
    @Override
    public ListenableFuture submit(final Runnable runnable, final Object o) {
        return this.delegate().submit(runnable, o);
    }
}
