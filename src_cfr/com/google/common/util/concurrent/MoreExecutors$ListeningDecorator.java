/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractListeningExecutorService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@GwtIncompatible(value="TODO")
class MoreExecutors$ListeningDecorator
extends AbstractListeningExecutorService {
    private final ExecutorService delegate;

    MoreExecutors$ListeningDecorator(ExecutorService executorService) {
        this.delegate = (ExecutorService)Preconditions.checkNotNull(executorService);
    }

    @Override
    public boolean awaitTermination(long l2, TimeUnit timeUnit) {
        return this.delegate.awaitTermination(l2, timeUnit);
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
    public void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }
}

