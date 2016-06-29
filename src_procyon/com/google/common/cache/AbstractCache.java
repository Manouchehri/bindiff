package com.google.common.cache;

import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;
import com.google.common.annotations.*;

@GwtCompatible
public abstract class AbstractCache implements Cache
{
    @Override
    public Object get(final Object o, final Callable callable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ImmutableMap getAllPresent(final Iterable iterable) {
        final LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        for (final Object next : iterable) {
            if (!linkedHashMap.containsKey(next)) {
                final Object o = next;
                final Object ifPresent = this.getIfPresent(next);
                if (ifPresent == null) {
                    continue;
                }
                linkedHashMap.put(o, ifPresent);
            }
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }
    
    @Override
    public void put(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void putAll(final Map map) {
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
    
    @Override
    public void cleanUp() {
    }
    
    @Override
    public long size() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void invalidate(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void invalidateAll(final Iterable iterable) {
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.invalidate(iterator.next());
        }
    }
    
    @Override
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public CacheStats stats() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ConcurrentMap asMap() {
        throw new UnsupportedOperationException();
    }
    
    @GoogleInternal
    public static CacheStats aggregate(final AbstractCache$StatsCounter... array) {
        final AbstractCache$SimpleStatsCounter abstractCache$SimpleStatsCounter = new AbstractCache$SimpleStatsCounter();
        for (int length = array.length, i = 0; i < length; ++i) {
            abstractCache$SimpleStatsCounter.incrementBy(array[i]);
        }
        return abstractCache$SimpleStatsCounter.snapshot();
    }
}
