/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.ForwardingLoadingCache;
import com.google.common.cache.LoadingCache;

public abstract class ForwardingLoadingCache$SimpleForwardingLoadingCache
extends ForwardingLoadingCache {
    private final LoadingCache delegate;

    protected ForwardingLoadingCache$SimpleForwardingLoadingCache(LoadingCache loadingCache) {
        this.delegate = (LoadingCache)Preconditions.checkNotNull(loadingCache);
    }

    @Override
    protected final LoadingCache delegate() {
        return this.delegate;
    }
}

