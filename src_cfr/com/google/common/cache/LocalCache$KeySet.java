/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AbstractCacheSet;
import com.google.common.cache.LocalCache$KeyIterator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

final class LocalCache$KeySet
extends LocalCache$AbstractCacheSet {
    final /* synthetic */ LocalCache this$0;

    LocalCache$KeySet(LocalCache localCache, ConcurrentMap concurrentMap) {
        this.this$0 = localCache;
        super(localCache, concurrentMap);
    }

    @Override
    public Iterator iterator() {
        return new LocalCache$KeyIterator(this.this$0);
    }

    @Override
    public boolean contains(Object object) {
        return this.map.containsKey(object);
    }

    @Override
    public boolean remove(Object object) {
        if (this.map.remove(object) == null) return false;
        return true;
    }
}

