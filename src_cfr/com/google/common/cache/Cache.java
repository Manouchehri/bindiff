/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GwtCompatible
public interface Cache {
    @Nullable
    public Object getIfPresent(Object var1);

    public Object get(Object var1, Callable var2);

    public ImmutableMap getAllPresent(Iterable var1);

    public void put(Object var1, Object var2);

    public void putAll(Map var1);

    public void invalidate(Object var1);

    public void invalidateAll(Iterable var1);

    public void invalidateAll();

    public long size();

    public CacheStats stats();

    public ConcurrentMap asMap();

    public void cleanUp();
}

