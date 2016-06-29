package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;
import java.util.concurrent.*;

@GoogleInternal
final class RateLimitingExecutorService extends AbstractExecutorService implements ListeningExecutorService
{
    private final ListeningScheduledExecutorService delegate;
    private final RateLimiter rateLimiter;
    private final int permitsPerTask;
    
    RateLimitingExecutorService(final RateLimiter rateLimiter, final ListeningScheduledExecutorService listeningScheduledExecutorService, final int permitsPerTask) {
        Preconditions.checkArgument(permitsPerTask > 0, (Object)"Requested permitsPerTask must be positive");
        this.rateLimiter = rateLimiter.checkSupportsAsync();
        this.delegate = (ListeningScheduledExecutorService)Preconditions.checkNotNull(listeningScheduledExecutorService);
        this.permitsPerTask = permitsPerTask;
    }
    
    @Override
    public ListenableFuture submit(final Runnable runnable, @Nullable final Object o) {
        Preconditions.checkNotNull(runnable);
        return this.delegate.schedule((Callable)Executors.callable(runnable, o), this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
    }
    
    @Override
    public ListenableFuture submit(final Callable callable) {
        Preconditions.checkNotNull(callable);
        return this.delegate.schedule(callable, this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
    }
    
    @Override
    public ListenableFuture submit(final Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        return this.delegate.schedule(runnable, this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
    }
    
    @Override
    public void execute(final Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        this.delegate.schedule(runnable, this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
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
    public boolean awaitTermination(final long n, final TimeUnit timeUnit) {
        return this.delegate.awaitTermination(n, timeUnit);
    }
}
