/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.AsyncCacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.ShimAsyncCache;
import com.google.common.cache.ShimAsyncCache$Entry$1;
import com.google.common.cache.ShimAsyncCache$Entry$EntryState;
import com.google.common.cache.ShimAsyncCache$Entry$Waiting;
import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.cache.ShimAsyncCache$PersistentQueue;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

class ShimAsyncCache$Entry {
    final ConcurrentMap cache;
    final AsyncCacheLoader loader;
    final ThreadLocal batch;
    final Object key;
    final AtomicReference state;

    ShimAsyncCache$Entry(LoadingCache loadingCache, AsyncCacheLoader asyncCacheLoader, ThreadLocal threadLocal, Object object) {
        this.state = new AtomicReference<ShimAsyncCache$Entry$Waiting>(new ShimAsyncCache$Entry$Waiting(this, ShimAsyncCache$PersistentQueue.empty(), SettableFuture.create()));
        this.cache = loadingCache.asMap();
        this.loader = asyncCacheLoader;
        this.batch = threadLocal;
        this.key = object;
    }

    @Nullable
    Object getIfPresent() {
        return ((ShimAsyncCache$Entry$EntryState)this.state.get()).getIfPresent();
    }

    ListenableFuture getOrLoadFuture() {
        return ((ShimAsyncCache$Entry$EntryState)this.state.get()).getOrLoadFuture();
    }

    void maybeLoad(ShimAsyncCache$LoadWhen shimAsyncCache$LoadWhen) {
        ((ShimAsyncCache$Entry$EntryState)this.state.get()).maybeLoad(shimAsyncCache$LoadWhen);
    }

    void addFuture(ListenableFuture listenableFuture) {
        this.refreshEntry();
        ((ShimAsyncCache$Entry$EntryState)this.state.get()).addFuture(listenableFuture);
        this.listen(listenableFuture);
    }

    void refreshEntry() {
        this.cache.replace(this.key, this, this);
    }

    void listen(ListenableFuture listenableFuture) {
        listenableFuture.addListener(new ShimAsyncCache$Entry$1(this, listenableFuture), MoreExecutors.directExecutor());
    }

    void loadOrBatch(SettableFuture settableFuture) {
        this.refreshEntry();
        Map map = (Map)this.batch.get();
        if (map != null) {
            map.put(this.key, settableFuture);
        } else {
            settableFuture.setFuture(ShimAsyncCache.access$000(this.loader, this.key));
        }
        this.listen(settableFuture);
    }
}

