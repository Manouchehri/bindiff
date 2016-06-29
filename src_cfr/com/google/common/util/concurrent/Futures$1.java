/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureFallback;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$1
implements AsyncFunction {
    final /* synthetic */ FutureFallback val$fallback;

    Futures$1(FutureFallback futureFallback) {
        this.val$fallback = futureFallback;
    }

    public ListenableFuture apply(Throwable throwable) {
        return (ListenableFuture)Preconditions.checkNotNull(this.val$fallback.create(throwable), "FutureFallback.create returned null instead of a Future. Did you mean to return immediateFuture(null)?");
    }
}

