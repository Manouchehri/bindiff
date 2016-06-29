/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public abstract class ForwardingListenableFuture
extends ForwardingFuture
implements ListenableFuture {
    protected ForwardingListenableFuture() {
    }

    @Override
    protected abstract ListenableFuture delegate();

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        this.delegate().addListener(runnable, executor);
    }
}

