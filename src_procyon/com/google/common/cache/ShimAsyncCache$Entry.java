package com.google.common.cache;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;
import com.google.common.util.concurrent.*;
import com.google.common.collect.*;
import com.google.common.base.*;

class ShimAsyncCache$Entry
{
    final ConcurrentMap cache;
    final AsyncCacheLoader loader;
    final ThreadLocal batch;
    final Object key;
    final AtomicReference state;
    
    ShimAsyncCache$Entry(final LoadingCache loadingCache, final AsyncCacheLoader loader, final ThreadLocal batch, final Object key) {
        this.state = new AtomicReference((V)new ShimAsyncCache$Entry$Waiting(this, ShimAsyncCache$PersistentQueue.empty(), SettableFuture.create()));
        this.cache = loadingCache.asMap();
        this.loader = loader;
        this.batch = batch;
        this.key = key;
    }
    
    @Nullable
    Object getIfPresent() {
        return this.state.get().getIfPresent();
    }
    
    ListenableFuture getOrLoadFuture() {
        return this.state.get().getOrLoadFuture();
    }
    
    void maybeLoad(final ShimAsyncCache$LoadWhen shimAsyncCache$LoadWhen) {
        this.state.get().maybeLoad(shimAsyncCache$LoadWhen);
    }
    
    void addFuture(final ListenableFuture listenableFuture) {
        this.refreshEntry();
        this.state.get().addFuture(listenableFuture);
        this.listen(listenableFuture);
    }
    
    void refreshEntry() {
        this.cache.replace(this.key, this, this);
    }
    
    void listen(final ListenableFuture listenableFuture) {
        listenableFuture.addListener(new ShimAsyncCache$Entry$1(this, listenableFuture), MoreExecutors.directExecutor());
    }
    
    void loadOrBatch(final SettableFuture settableFuture) {
        this.refreshEntry();
        final Map<Object, SettableFuture> map = this.batch.get();
        if (map != null) {
            map.put(this.key, settableFuture);
        }
        else {
            settableFuture.setFuture(loadNullHostile(this.loader, this.key));
        }
        this.listen(settableFuture);
    }
}
