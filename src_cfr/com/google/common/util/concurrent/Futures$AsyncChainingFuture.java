/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures$AbstractChainingFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$AsyncChainingFuture
extends Futures$AbstractChainingFuture {
    Futures$AsyncChainingFuture(ListenableFuture listenableFuture, AsyncFunction asyncFunction) {
        super(listenableFuture, asyncFunction);
    }

    void doTransform(AsyncFunction asyncFunction, Object object) {
        ListenableFuture listenableFuture = asyncFunction.apply(object);
        Preconditions.checkNotNull(listenableFuture, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
        this.setFuture(listenableFuture);
    }
}

