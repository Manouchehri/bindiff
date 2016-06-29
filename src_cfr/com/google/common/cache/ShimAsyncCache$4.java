/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.AsyncCacheLoader;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.ShimAsyncCache$CacheHolder;
import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

final class ShimAsyncCache$4
extends CacheLoader {
    final /* synthetic */ ShimAsyncCache$CacheHolder val$holder;
    final /* synthetic */ AsyncCacheLoader val$loader;
    final /* synthetic */ ThreadLocal val$batch;

    ShimAsyncCache$4(ShimAsyncCache$CacheHolder cacheHolder, AsyncCacheLoader asyncCacheLoader, ThreadLocal threadLocal) {
        this.val$holder = cacheHolder;
        this.val$loader = asyncCacheLoader;
        this.val$batch = threadLocal;
    }

    @Override
    public ShimAsyncCache$Entry load(Object object) {
        return new ShimAsyncCache$Entry(this.val$holder.cache, this.val$loader, this.val$batch, object);
    }

    public ListenableFuture reload(Object object, ShimAsyncCache$Entry shimAsyncCache$Entry) {
        shimAsyncCache$Entry.maybeLoad(ShimAsyncCache$LoadWhen.ALWAYS);
        return Futures.immediateFuture(shimAsyncCache$Entry);
    }
}

