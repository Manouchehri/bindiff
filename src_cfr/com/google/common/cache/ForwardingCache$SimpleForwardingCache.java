/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.ForwardingCache;

public abstract class ForwardingCache$SimpleForwardingCache
extends ForwardingCache {
    private final Cache delegate;

    protected ForwardingCache$SimpleForwardingCache(Cache cache) {
        this.delegate = (Cache)Preconditions.checkNotNull(cache);
    }

    @Override
    protected final Cache delegate() {
        return this.delegate;
    }
}

