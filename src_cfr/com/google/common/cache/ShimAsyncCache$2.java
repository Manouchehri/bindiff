/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

final class ShimAsyncCache$2
implements Function {
    final /* synthetic */ RuntimeException val$e;

    ShimAsyncCache$2(RuntimeException runtimeException) {
        this.val$e = runtimeException;
    }

    @Override
    public ListenableFuture apply(Object object) {
        return Futures.immediateFailedFuture(this.val$e);
    }
}

