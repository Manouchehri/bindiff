/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.AbstractCache$SimpleStatsCounter;
import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class AbstractCache
implements Cache {
    protected AbstractCache() {
    }

    @Override
    public Object get(Object object, Callable callable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableMap getAllPresent(Iterable iterable) {
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            if (linkedHashMap.containsKey(t2)) continue;
            Object t3 = t2;
            Object object = this.getIfPresent(t2);
            if (object == null) continue;
            linkedHashMap.put(t3, object);
        }
        return ImmutableMap.copyOf(linkedHashMap);
    }

    @Override
    public void put(Object object, Object object2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
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
    public void invalidate(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void invalidateAll(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            this.invalidate(t2);
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
    public static /* varargs */ CacheStats aggregate(AbstractCache$StatsCounter ... arrabstractCache$StatsCounter) {
        AbstractCache$SimpleStatsCounter abstractCache$SimpleStatsCounter = new AbstractCache$SimpleStatsCounter();
        AbstractCache$StatsCounter[] arrabstractCache$StatsCounter2 = arrabstractCache$StatsCounter;
        int n2 = arrabstractCache$StatsCounter2.length;
        int n3 = 0;
        while (n3 < n2) {
            AbstractCache$StatsCounter abstractCache$StatsCounter = arrabstractCache$StatsCounter2[n3];
            abstractCache$SimpleStatsCounter.incrementBy(abstractCache$StatsCounter);
            ++n3;
        }
        return abstractCache$SimpleStatsCounter.snapshot();
    }
}

