package com.google.common.util.concurrent;

import java.util.concurrent.*;

abstract class AbstractFuture$TrustedFuture extends AbstractFuture
{
    @Override
    public final Object get() {
        return super.get();
    }
    
    @Override
    public final Object get(final long n, final TimeUnit timeUnit) {
        return super.get(n, timeUnit);
    }
    
    @Override
    public final boolean isDone() {
        return super.isDone();
    }
    
    @Override
    public final boolean isCancelled() {
        return super.isCancelled();
    }
    
    @Override
    public final void addListener(final Runnable runnable, final Executor executor) {
        super.addListener(runnable, executor);
    }
}
