/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AbstractCacheSet;
import com.google.common.cache.LocalCache$EntryIterator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

final class LocalCache$EntrySet
extends LocalCache$AbstractCacheSet {
    final /* synthetic */ LocalCache this$0;

    LocalCache$EntrySet(LocalCache localCache, ConcurrentMap concurrentMap) {
        this.this$0 = localCache;
        super(localCache, concurrentMap);
    }

    @Override
    public Iterator iterator() {
        return new LocalCache$EntryIterator(this.this$0);
    }

    @Override
    public boolean contains(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        Object k2 = entry.getKey();
        if (k2 == null) {
            return false;
        }
        Object object2 = this.this$0.get(k2);
        if (object2 == null) return false;
        if (!this.this$0.valueEquivalence.equivalent(entry.getValue(), object2)) return false;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry)object;
        Object k2 = entry.getKey();
        if (k2 == null) return false;
        if (!this.this$0.remove(k2, entry.getValue())) return false;
        return true;
    }
}

