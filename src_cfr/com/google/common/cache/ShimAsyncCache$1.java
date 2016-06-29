/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.ShimAsyncCache;
import com.google.common.util.concurrent.ListenableFuture;

final class ShimAsyncCache$1
implements Function {
    ShimAsyncCache$1() {
    }

    public ListenableFuture apply(ListenableFuture listenableFuture) {
        return ShimAsyncCache.access$100(listenableFuture);
    }
}

