/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$ValueIterator;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

final class LocalCache$Values
extends AbstractCollection {
    private final ConcurrentMap map;
    final /* synthetic */ LocalCache this$0;

    LocalCache$Values(LocalCache localCache, ConcurrentMap concurrentMap) {
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

    @Override
    public Iterator iterator() {
        return new LocalCache$ValueIterator(this.this$0);
    }

    @Override
    public boolean contains(Object object) {
        return this.map.containsValue(object);
    }
}

