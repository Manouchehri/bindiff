/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$EntryIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class MapMakerInternalMap$EntrySet
extends AbstractSet {
    final /* synthetic */ MapMakerInternalMap this$0;

    MapMakerInternalMap$EntrySet(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
    }

    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$EntryIterator(this.this$0);
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

    @Override
    public int size() {
        return this.this$0.size();
    }

    @Override
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }
}

