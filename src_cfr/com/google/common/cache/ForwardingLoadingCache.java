/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.ForwardingCache;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;

public abstract class ForwardingLoadingCache
extends ForwardingCache
implements LoadingCache {
    protected ForwardingLoadingCache() {
    }

    @Override
    protected abstract LoadingCache delegate();

    @Override
    public Object get(Object object) {
        return this.delegate().get(object);
    }

    @Override
    public Object getUnchecked(Object object) {
        return this.delegate().getUnchecked(object);
    }

    @Override
    public ImmutableMap getAll(Iterable iterable) {
        return this.delegate().getAll(iterable);
    }

    @Override
    public Object apply(Object object) {
        return this.delegate().apply(object);
    }

    @Override
    public void refresh(Object object) {
        this.delegate().refresh(object);
    }
}

