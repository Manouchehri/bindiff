/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.AbstractCache$SimpleStatsCounter;
import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$LocalManualCache$1;
import com.google.common.cache.LocalCache$ManualSerializationProxy;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

class LocalCache$LocalManualCache
implements Cache,
Serializable {
    final LocalCache localCache;
    private static final long serialVersionUID = 1;

    LocalCache$LocalManualCache(CacheBuilder cacheBuilder) {
        this(new LocalCache(cacheBuilder, null));
    }

    private LocalCache$LocalManualCache(LocalCache localCache) {
        this.localCache = localCache;
    }

    @Nullable
    @Override
    public Object getIfPresent(Object object) {
        return this.localCache.getIfPresent(object);
    }

    @Override
    public Object get(Object object, Callable callable) {
        Preconditions.checkNotNull(callable);
        return this.localCache.get(object, new LocalCache$LocalManualCache$1(this, callable));
    }

    @Override
    public ImmutableMap getAllPresent(Iterable iterable) {
        return this.localCache.getAllPresent(iterable);
    }

    @Override
    public void put(Object object, Object object2) {
        this.localCache.put(object, object2);
    }

    @Override
    public void putAll(Map map) {
        this.localCache.putAll(map);
    }

    @Override
    public void invalidate(Object object) {
        Preconditions.checkNotNull(object);
        this.localCache.remove(object);
    }

    @Override
    public void invalidateAll(Iterable iterable) {
        this.localCache.invalidateAll(iterable);
    }

    @Override
    public void invalidateAll() {
        this.localCache.clear();
    }

    @Override
    public long size() {
        return this.localCache.longSize();
    }

    @Override
    public ConcurrentMap asMap() {
        return this.localCache;
    }

    @Override
    public CacheStats stats() {
        AbstractCache$SimpleStatsCounter abstractCache$SimpleStatsCounter = new AbstractCache$SimpleStatsCounter();
        abstractCache$SimpleStatsCounter.incrementBy(this.localCache.globalStatsCounter);
        LocalCache$Segment[] arrlocalCache$Segment = this.localCache.segments;
        int n2 = arrlocalCache$Segment.length;
        int n3 = 0;
        while (n3 < n2) {
            LocalCache$Segment localCache$Segment = arrlocalCache$Segment[n3];
            abstractCache$SimpleStatsCounter.incrementBy(localCache$Segment.statsCounter);
            ++n3;
        }
        return abstractCache$SimpleStatsCounter.snapshot();
    }

    @Override
    public void cleanUp() {
        this.localCache.cleanUp();
    }

    Object writeReplace() {
        return new LocalCache$ManualSerializationProxy(this.localCache);
    }

    /* synthetic */ LocalCache$LocalManualCache(LocalCache localCache, LocalCache$1 localCache$1) {
        this(localCache);
    }
}

