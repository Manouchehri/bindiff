package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;
import java.util.*;

@GwtIncompatible("TODO")
class MoreExecutors$ListeningDecorator extends AbstractListeningExecutorService
{
    private final ExecutorService delegate;
    
    MoreExecutors$ListeningDecorator(final ExecutorService executorService) {
        this.delegate = (ExecutorService)Preconditions.checkNotNull(executorService);
    }
    
    @Override
    public boolean awaitTermination(final long n, final TimeUnit timeUnit) {
        return this.delegate.awaitTermination(n, timeUnit);
    }
    
    @Override
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }
    
    @Override
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }
    
    @Override
    public void shutdown() {
        this.delegate.shutdown();
    }
    
    @Override
    public List shutdownNow() {
        return this.delegate.shutdownNow();
    }
    
    @Override
    public void execute(final Runnable runnable) {
        this.delegate.execute(runnable);
    }
}
