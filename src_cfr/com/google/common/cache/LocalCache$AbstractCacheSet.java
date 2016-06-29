/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.util.AbstractSet;
import java.util.concurrent.ConcurrentMap;

abstract class LocalCache$AbstractCacheSet
extends AbstractSet {
    final ConcurrentMap map;
    final /* synthetic */ LocalCache this$0;

    LocalCache$AbstractCacheSet(LocalCache localCache, ConcurrentMap concurrentMap) {
        this.this$0 = localCache;
        this.map = concurrentMap;
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public void clear() {
        this.map.clear();
    }
}

