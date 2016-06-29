/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ValueIterator;
import java.util.AbstractCollection;
import java.util.Iterator;

final class MapMakerInternalMap$Values
extends AbstractCollection {
    final /* synthetic */ MapMakerInternalMap this$0;

    MapMakerInternalMap$Values(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
    }

    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$ValueIterator(this.this$0);
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
        return this.this$0.containsValue(object);
    }

    @Override
    public void clear() {
        this.this$0.clear();
    }
}

