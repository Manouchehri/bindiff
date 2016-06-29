/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

public abstract class ForwardingCache
extends ForwardingObject
implements Cache {
    protected ForwardingCache() {
    }

    @Override
    protected abstract Cache delegate();

    @Nullable
    @Override
    public Object getIfPresent(Object object) {
        return this.delegate().getIfPresent(object);
    }

    @Override
    public Object get(Object object, Callable callable) {
        return this.delegate().get(object, callable);
    }

    @Override
    public ImmutableMap getAllPresent(Iterable iterable) {
        return this.delegate().getAllPresent(iterable);
    }

    @Override
    public void put(Object object, Object object2) {
        this.delegate().put(object, object2);
    }

    @Override
    public void putAll(Map map) {
        this.delegate().putAll(map);
    }

    @Override
    public void invalidate(Object object) {
        this.delegate().invalidate(object);
    }

    @Override
    public void invalidateAll(Iterable iterable) {
        this.delegate().invalidateAll(iterable);
    }

    @Override
    public void invalidateAll() {
        this.delegate().invalidateAll();
    }

    @Override
    public long size() {
        return this.delegate().size();
    }

    @Override
    public CacheStats stats() {
        return this.delegate().stats();
    }

    @Override
    public ConcurrentMap asMap() {
        return this.delegate().asMap();
    }

    @Override
    public void cleanUp() {
        this.delegate().cleanUp();
    }
}

