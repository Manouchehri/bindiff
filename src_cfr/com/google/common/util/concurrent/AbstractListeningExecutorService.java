/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractListeningExecutorService
extends AbstractExecutorService
implements ListeningExecutorService {
    protected final RunnableFuture newTaskFor(Runnable runnable, Object object) {
        return TrustedListenableFutureTask.create(runnable, object);
    }

    protected final RunnableFuture newTaskFor(Callable callable) {
        return TrustedListenableFutureTask.create(callable);
    }

    @Override
    public ListenableFuture submit(Runnable runnable) {
        return (ListenableFuture)super.submit(runnable);
    }

    @Override
    public ListenableFuture submit(Runnable runnable, @Nullable Object object) {
        return (ListenableFuture)super.submit(runnable, object);
    }

    @Override
    public ListenableFuture submit(Callable callable) {
        return (ListenableFuture)super.submit(callable);
    }
}

