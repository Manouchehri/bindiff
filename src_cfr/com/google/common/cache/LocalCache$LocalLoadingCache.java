/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$LoadingSerializationProxy;
import com.google.common.cache.LocalCache$LocalManualCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.concurrent.ExecutionException;

class LocalCache$LocalLoadingCache
extends LocalCache$LocalManualCache
implements LoadingCache {
    private static final long serialVersionUID = 1;

    LocalCache$LocalLoadingCache(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
        super(new LocalCache(cacheBuilder, (CacheLoader)Preconditions.checkNotNull(cacheLoader)), null);
    }

    @Override
    public Object get(Object object) {
        return this.localCache.getOrLoad(object);
    }

    @Override
    public Object getUnchecked(Object object) {
        try {
            return this.get(object);
        }
        catch (ExecutionException var2_2) {
            throw new UncheckedExecutionException(var2_2.getCause());
        }
    }

    @Override
    public ImmutableMap getAll(Iterable iterable) {
        return this.localCache.getAll(iterable);
    }

    @Override
    public void refresh(Object object) {
        this.localCache.refresh(object);
    }

    @Override
    public final Object apply(Object object) {
        return this.getUnchecked(object);
    }

    @Override
    Object writeReplace() {
        return new LocalCache$LoadingSerializationProxy(this.localCache);
    }
}

