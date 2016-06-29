/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ManualSerializationProxy;
import com.google.common.collect.ImmutableMap;
import java.io.ObjectInputStream;
import java.io.Serializable;

final class LocalCache$LoadingSerializationProxy
extends LocalCache$ManualSerializationProxy
implements LoadingCache,
Serializable {
    private static final long serialVersionUID = 1;
    transient LoadingCache autoDelegate;

    LocalCache$LoadingSerializationProxy(LocalCache localCache) {
        super(localCache);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        CacheBuilder cacheBuilder = this.recreateCacheBuilder();
        this.autoDelegate = cacheBuilder.build(this.loader);
    }

    @Override
    public Object get(Object object) {
        return this.autoDelegate.get(object);
    }

    @Override
    public Object getUnchecked(Object object) {
        return this.autoDelegate.getUnchecked(object);
    }

    @Override
    public ImmutableMap getAll(Iterable iterable) {
        return this.autoDelegate.getAll(iterable);
    }

    @Override
    public final Object apply(Object object) {
        return this.autoDelegate.apply(object);
    }

    @Override
    public void refresh(Object object) {
        this.autoDelegate.refresh(object);
    }

    private Object readResolve() {
        return this.autoDelegate;
    }
}

