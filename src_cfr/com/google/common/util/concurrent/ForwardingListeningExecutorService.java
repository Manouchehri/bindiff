/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingExecutorService;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public abstract class ForwardingListeningExecutorService
extends ForwardingExecutorService
implements ListeningExecutorService {
    protected ForwardingListeningExecutorService() {
    }

    @Override
    protected abstract ListeningExecutorService delegate();

    @Override
    public ListenableFuture submit(Callable callable) {
        return this.delegate().submit(callable);
    }

    @Override
    public ListenableFuture submit(Runnable runnable) {
        return this.delegate().submit(runnable);
    }

    @Override
    public ListenableFuture submit(Runnable runnable, Object object) {
        return this.delegate().submit(runnable, object);
    }
}

