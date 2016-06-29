/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public interface LoadingCache
extends Function,
Cache {
    public Object get(Object var1);

    public Object getUnchecked(Object var1);

    public ImmutableMap getAll(Iterable var1);

    @Deprecated
    @Override
    public Object apply(Object var1);

    public void refresh(Object var1);

    @Override
    public ConcurrentMap asMap();
}

