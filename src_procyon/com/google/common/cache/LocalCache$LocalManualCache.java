package com.google.common.cache;

import java.io.*;
import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;

class LocalCache$LocalManualCache implements Cache, Serializable
{
    final LocalCache localCache;
    private static final long serialVersionUID = 1L;
    
    LocalCache$LocalManualCache(final CacheBuilder cacheBuilder) {
        this(new LocalCache(cacheBuilder, null));
    }
    
    private LocalCache$LocalManualCache(final LocalCache localCache) {
        this.localCache = localCache;
    }
    
    @Nullable
    @Override
    public Object getIfPresent(final Object o) {
        return this.localCache.getIfPresent(o);
    }
    
    @Override
    public Object get(final Object o, final Callable callable) {
        Preconditions.checkNotNull(callable);
        return this.localCache.get(o, new LocalCache$LocalManualCache$1(this, callable));
    }
    
    @Override
    public ImmutableMap getAllPresent(final Iterable iterable) {
        return this.localCache.getAllPresent(iterable);
    }
    
    @Override
    public void put(final Object o, final Object o2) {
        this.localCache.put(o, o2);
    }
    
    @Override
    public void putAll(final Map map) {
        this.localCache.putAll(map);
    }
    
    @Override
    public void invalidate(final Object o) {
        Preconditions.checkNotNull(o);
        this.localCache.remove(o);
    }
    
    @Override
    public void invalidateAll(final Iterable iterable) {
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
        final AbstractCache$SimpleStatsCounter abstractCache$SimpleStatsCounter = new AbstractCache$SimpleStatsCounter();
        abstractCache$SimpleStatsCounter.incrementBy(this.localCache.globalStatsCounter);
        final LocalCache$Segment[] segments = this.localCache.segments;
        for (int length = segments.length, i = 0; i < length; ++i) {
            abstractCache$SimpleStatsCounter.incrementBy(segments[i].statsCounter);
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
}
