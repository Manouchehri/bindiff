/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$KeyIterator;
import java.util.AbstractSet;
import java.util.Iterator;

final class MapMakerInternalMap$KeySet
extends AbstractSet {
    final /* synthetic */ MapMakerInternalMap this$0;

    MapMakerInternalMap$KeySet(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
    }

    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$KeyIterator(this.this$0);
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
    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    @Override
    public boolean remove(Object object) {
        if (this.this$0.remove(object) == null) return false;
        return true;
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }
}

