/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.RateLimiter;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GoogleInternal
final class RateLimitingExecutorService
extends AbstractExecutorService
implements ListeningExecutorService {
    private final ListeningScheduledExecutorService delegate;
    private final RateLimiter rateLimiter;
    private final int permitsPerTask;

    RateLimitingExecutorService(RateLimiter rateLimiter, ListeningScheduledExecutorService listeningScheduledExecutorService, int n2) {
        Preconditions.checkArgument(n2 > 0, "Requested permitsPerTask must be positive");
        this.rateLimiter = rateLimiter.checkSupportsAsync();
        this.delegate = (ListeningScheduledExecutorService)Preconditions.checkNotNull(listeningScheduledExecutorService);
        this.permitsPerTask = n2;
    }

    @Override
    public ListenableFuture submit(Runnable runnable, @Nullable Object object) {
        Preconditions.checkNotNull(runnable);
        return this.delegate.schedule(Executors.callable(runnable, object), this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
    }

    @Override
    public ListenableFuture submit(Callable callable) {
        Preconditions.checkNotNull(callable);
        return this.delegate.schedule(callable, this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
    }

    @Override
    public ListenableFuture submit(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        return this.delegate.schedule(runnable, this.rateLimiter.reserve(this.permitsPerTask), TimeUnit.MICROSECONDS);
    }

    @Override
    public void execute(Runnable runnable) {
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

    public List shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override
    public boolean awaitTermination(long l2, TimeUnit timeUnit) {
        return this.delegate.awaitTermination(l2, timeUnit);
    }
}

