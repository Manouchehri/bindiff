/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures$AbstractCatchingFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$AsyncCatchingFuture
extends Futures$AbstractCatchingFuture {
    Futures$AsyncCatchingFuture(ListenableFuture listenableFuture, Class class_, AsyncFunction asyncFunction) {
        super(listenableFuture, class_, asyncFunction);
    }

    void doFallback(AsyncFunction asyncFunction, Throwable throwable) {
        ListenableFuture listenableFuture = asyncFunction.apply(throwable);
        Preconditions.checkNotNull(listenableFuture, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
        this.setFuture(listenableFuture);
    }
}

