/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.AsyncCacheLoader;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

final class AsyncCacheLoader$AsyncFunctionToCacheLoader
extends AsyncCacheLoader {
    final AsyncFunction computingFunction;

    AsyncCacheLoader$AsyncFunctionToCacheLoader(AsyncFunction asyncFunction) {
        this.computingFunction = (AsyncFunction)Preconditions.checkNotNull(asyncFunction);
    }

    @Override
    protected ListenableFuture load(Object object) {
        Preconditions.checkNotNull(object);
        try {
            return this.computingFunction.apply(object);
        }
        catch (Exception var2_2) {
            return Futures.immediateFailedFuture(var2_2);
        }
    }
}

