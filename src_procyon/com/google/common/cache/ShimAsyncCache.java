package com.google.common.cache;

import com.google.common.annotations.*;
import java.util.*;
import com.google.common.util.concurrent.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import javax.annotation.*;

@GoogleInternal
@GwtIncompatible("Futures")
final class ShimAsyncCache implements AsyncLoadingCache
{
    private final LoadingCache cache;
    private final ThreadLocal batch;
    private final AsyncCacheLoader loader;
    
    private ShimAsyncCache(final LoadingCache cache, final ThreadLocal batch, final AsyncCacheLoader loader) {
        this.cache = cache;
        this.batch = batch;
        this.loader = loader;
    }
    
    @Override
    public ListenableFuture get(final Object o) {
        return ((ShimAsyncCache$Entry)this.cache.getUnchecked(o)).getOrLoadFuture();
    }
    
    @Override
    public ImmutableMap getAll(final Iterable iterable) {
        Preconditions.checkState(this.batch.get() == null, (Object)"Cannot call getAll() recursively.");
        this.batch.set(new LinkedHashMap());
        final LinkedHashMap<Object, ListenableFuture> linkedHashMap = new LinkedHashMap<Object, ListenableFuture>();
        for (final Object next : iterable) {
            linkedHashMap.put(next, ((ShimAsyncCache$Entry)this.cache.getUnchecked(next)).getOrLoadFuture());
        }
        final Map<K, SettableFuture> map = this.batch.get();
        this.batch.remove();
        if (!map.isEmpty()) {
            for (final Map.Entry<Object, V> entry : loadAllNullHostile(this.loader, ImmutableSet.copyOf(map.keySet())).entrySet()) {
                final Object key = entry.getKey();
                final ListenableFuture future = (ListenableFuture)entry.getValue();
                final SettableFuture settableFuture = map.remove(key);
                if (settableFuture != null) {
                    settableFuture.setFuture(future);
                    if (!future.isDone()) {
                        continue;
                    }
                    linkedHashMap.put(key, future);
                }
                else {
                    this.makeEntry(key).addFuture(future);
                }
            }
            for (final Map.Entry<K, SettableFuture> entry2 : map.entrySet()) {
                final K key2 = entry2.getKey();
                final SettableFuture settableFuture2 = entry2.getValue();
                final ListenableFuture loadNullHostile = loadNullHostile(this.loader, key2);
                settableFuture2.setFuture(loadNullHostile);
                if (loadNullHostile.isDone()) {
                    linkedHashMap.put(key2, loadNullHostile);
                }
            }
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }
    
    private static ListenableFuture loadNullHostile(final AsyncCacheLoader asyncCacheLoader, final Object o) {
        try {
            return nullHostileFuture(asyncCacheLoader.load(o));
        }
        catch (RuntimeException ex) {
            return Futures.immediateFailedFuture(ex);
        }
    }
    
    private static Map loadAllNullHostile(final AsyncCacheLoader asyncCacheLoader, final Set set) {
        try {
            return Maps.transformValues(asyncCacheLoader.loadAll(set), new ShimAsyncCache$1());
        }
        catch (RuntimeException ex) {
            return Maps.toMap(set, new ShimAsyncCache$2(ex));
        }
    }
    
    private static ListenableFuture nullHostileFuture(final ListenableFuture listenableFuture) {
        return Futures.transform(listenableFuture, new ShimAsyncCache$3());
    }
    
    private ShimAsyncCache$Entry makeEntry(final Object o) {
        final ShimAsyncCache$Entry shimAsyncCache$Entry = new ShimAsyncCache$Entry(this.cache, this.loader, this.batch, o);
        final ShimAsyncCache$Entry shimAsyncCache$Entry2 = this.cache.asMap().putIfAbsent(o, shimAsyncCache$Entry);
        return (shimAsyncCache$Entry2 != null) ? shimAsyncCache$Entry2 : shimAsyncCache$Entry;
    }
    
    @Nullable
    @Override
    public Object getIfPresent(final Object o) {
        final ShimAsyncCache$Entry shimAsyncCache$Entry = (ShimAsyncCache$Entry)this.cache.getIfPresent(o);
        return (shimAsyncCache$Entry != null) ? shimAsyncCache$Entry.getIfPresent() : null;
    }
    
    @Override
    public void invalidateAll() {
        this.cache.invalidateAll();
    }
    
    @Override
    public void invalidate(final Object o) {
        this.cache.invalidate(o);
    }
    
    @Override
    public void put(final Object o, final Object o2) {
        Preconditions.checkNotNull(o2);
        ShimAsyncCache$Entry entry = (ShimAsyncCache$Entry)this.cache.getIfPresent(o);
        if (entry == null) {
            entry = this.makeEntry(o);
        }
        entry.addFuture(Futures.immediateFuture(o2));
    }
    
    static ShimAsyncCache from(final CacheBuilder cacheBuilder, final AsyncCacheLoader asyncCacheLoader) {
        Preconditions.checkNotNull(asyncCacheLoader);
        final ThreadLocal threadLocal = new ThreadLocal();
        final ShimAsyncCache$CacheHolder shimAsyncCache$CacheHolder = new ShimAsyncCache$CacheHolder(null);
        shimAsyncCache$CacheHolder.cache = cacheBuilder.build(new ShimAsyncCache$4(shimAsyncCache$CacheHolder, asyncCacheLoader, threadLocal));
        return new ShimAsyncCache(shimAsyncCache$CacheHolder.cache, threadLocal, asyncCacheLoader);
    }
}
