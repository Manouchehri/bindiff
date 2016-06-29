package com.google.common.cache;

import javax.annotation.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;

public abstract class ForwardingCache extends ForwardingObject implements Cache
{
    @Override
    protected abstract Cache delegate();
    
    @Nullable
    @Override
    public Object getIfPresent(final Object o) {
        return this.delegate().getIfPresent(o);
    }
    
    @Override
    public Object get(final Object o, final Callable callable) {
        return this.delegate().get(o, callable);
    }
    
    @Override
    public ImmutableMap getAllPresent(final Iterable iterable) {
        return this.delegate().getAllPresent(iterable);
    }
    
    @Override
    public void put(final Object o, final Object o2) {
        this.delegate().put(o, o2);
    }
    
    @Override
    public void putAll(final Map map) {
        this.delegate().putAll(map);
    }
    
    @Override
    public void invalidate(final Object o) {
        this.delegate().invalidate(o);
    }
    
    @Override
    public void invalidateAll(final Iterable iterable) {
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
