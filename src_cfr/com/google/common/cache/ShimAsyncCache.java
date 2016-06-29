/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.cache.AsyncCacheLoader;
import com.google.common.cache.AsyncLoadingCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.ShimAsyncCache$1;
import com.google.common.cache.ShimAsyncCache$2;
import com.google.common.cache.ShimAsyncCache$3;
import com.google.common.cache.ShimAsyncCache$4;
import com.google.common.cache.ShimAsyncCache$CacheHolder;
import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

@GoogleInternal
@GwtIncompatible(value="Futures")
final class ShimAsyncCache
implements AsyncLoadingCache {
    private final LoadingCache cache;
    private final ThreadLocal batch;
    private final AsyncCacheLoader loader;

    private ShimAsyncCache(LoadingCache loadingCache, ThreadLocal threadLocal, AsyncCacheLoader asyncCacheLoader) {
        this.cache = loadingCache;
        this.batch = threadLocal;
        this.loader = asyncCacheLoader;
    }

    @Override
    public ListenableFuture get(Object object) {
        return ((ShimAsyncCache$Entry)this.cache.getUnchecked(object)).getOrLoadFuture();
    }

    @Override
    public ImmutableMap getAll(Iterable iterable) {
        Object k2;
        Object object3;
        ListenableFuture listenableFuture;
        Object object2;
        Future future;
        Preconditions.checkState(this.batch.get() == null, "Cannot call getAll() recursively.");
        this.batch.set(new LinkedHashMap());
        LinkedHashMap<Object, Future> linkedHashMap = new LinkedHashMap<Object, Future>();
        for (Object object3 : iterable) {
            object2 = (ShimAsyncCache$Entry)this.cache.getUnchecked(object3);
            linkedHashMap.put(object3, object2.getOrLoadFuture());
        }
        Map map = (Map)this.batch.get();
        this.batch.remove();
        if (map.isEmpty()) return ImmutableMap.copyOf(linkedHashMap);
        object3 = ImmutableSet.copyOf(map.keySet());
        object2 = ShimAsyncCache.loadAllNullHostile(this.loader, (Set)object3);
        for (Map.Entry entry2 : object2.entrySet()) {
            k2 = entry2.getKey();
            listenableFuture = (ListenableFuture)entry2.getValue();
            future = (SettableFuture)map.remove(k2);
            if (future != null) {
                future.setFuture(listenableFuture);
                if (!listenableFuture.isDone()) continue;
                linkedHashMap.put(k2, listenableFuture);
                continue;
            }
            this.makeEntry(k2).addFuture(listenableFuture);
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry2;
            entry2 = iterator.next();
            k2 = entry2.getKey();
            listenableFuture = (SettableFuture)entry2.getValue();
            future = ShimAsyncCache.loadNullHostile(this.loader, k2);
            listenableFuture.setFuture((ListenableFuture)future);
            if (!future.isDone()) continue;
            linkedHashMap.put(k2, future);
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }

    private static ListenableFuture loadNullHostile(AsyncCacheLoader asyncCacheLoader, Object object) {
        try {
            return ShimAsyncCache.nullHostileFuture(asyncCacheLoader.load(object));
        }
        catch (RuntimeException var2_2) {
            return Futures.immediateFailedFuture(var2_2);
        }
    }

    private static Map loadAllNullHostile(AsyncCacheLoader asyncCacheLoader, Set set) {
        try {
            return Maps.transformValues(asyncCacheLoader.loadAll(set), (Function)new ShimAsyncCache$1());
        }
        catch (RuntimeException var2_2) {
            return Maps.toMap(set, (Function)new ShimAsyncCache$2(var2_2));
        }
    }

    private static ListenableFuture nullHostileFuture(ListenableFuture listenableFuture) {
        return Futures.transform(listenableFuture, new ShimAsyncCache$3());
    }

    private ShimAsyncCache$Entry makeEntry(Object object) {
        ShimAsyncCache$Entry shimAsyncCache$Entry;
        ShimAsyncCache$Entry shimAsyncCache$Entry2 = new ShimAsyncCache$Entry(this.cache, this.loader, this.batch, object);
        ShimAsyncCache$Entry shimAsyncCache$Entry3 = this.cache.asMap().putIfAbsent(object, shimAsyncCache$Entry2);
        if (shimAsyncCache$Entry3 != null) {
            shimAsyncCache$Entry = shimAsyncCache$Entry3;
            return shimAsyncCache$Entry;
        }
        shimAsyncCache$Entry = shimAsyncCache$Entry2;
        return shimAsyncCache$Entry;
    }

    @Nullable
    @Override
    public Object getIfPresent(Object object) {
        ShimAsyncCache$Entry shimAsyncCache$Entry = (ShimAsyncCache$Entry)this.cache.getIfPresent(object);
        if (shimAsyncCache$Entry == null) return null;
        Object object2 = shimAsyncCache$Entry.getIfPresent();
        return object2;
    }

    @Override
    public void invalidateAll() {
        this.cache.invalidateAll();
    }

    @Override
    public void invalidate(Object object) {
        this.cache.invalidate(object);
    }

    @Override
    public void put(Object object, Object object2) {
        Preconditions.checkNotNull(object2);
        ShimAsyncCache$Entry shimAsyncCache$Entry = (ShimAsyncCache$Entry)this.cache.getIfPresent(object);
        if (shimAsyncCache$Entry == null) {
            shimAsyncCache$Entry = this.makeEntry(object);
        }
        shimAsyncCache$Entry.addFuture(Futures.immediateFuture(object2));
    }

    static ShimAsyncCache from(CacheBuilder cacheBuilder, AsyncCacheLoader asyncCacheLoader) {
        Preconditions.checkNotNull(asyncCacheLoader);
        ThreadLocal threadLocal = new ThreadLocal();
        ShimAsyncCache$CacheHolder shimAsyncCache$CacheHolder = new ShimAsyncCache$CacheHolder(null);
        shimAsyncCache$CacheHolder.cache = cacheBuilder.build(new ShimAsyncCache$4(shimAsyncCache$CacheHolder, asyncCacheLoader, threadLocal));
        return new ShimAsyncCache(shimAsyncCache$CacheHolder.cache, threadLocal, asyncCacheLoader);
    }

    static /* synthetic */ ListenableFuture access$000(AsyncCacheLoader asyncCacheLoader, Object object) {
        return ShimAsyncCache.loadNullHostile(asyncCacheLoader, object);
    }

    static /* synthetic */ ListenableFuture access$100(ListenableFuture listenableFuture) {
        return ShimAsyncCache.nullHostileFuture(listenableFuture);
    }
}

