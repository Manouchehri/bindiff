/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;

public abstract class ForwardingListenableFuture$SimpleForwardingListenableFuture
extends ForwardingListenableFuture {
    private final ListenableFuture delegate;

    protected ForwardingListenableFuture$SimpleForwardingListenableFuture(ListenableFuture listenableFuture) {
        this.delegate = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }

    @Override
    protected final ListenableFuture delegate() {
        return this.delegate;
    }
}

