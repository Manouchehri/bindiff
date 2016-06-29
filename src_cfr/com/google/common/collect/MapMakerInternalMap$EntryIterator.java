/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$HashIterator;
import com.google.common.collect.MapMakerInternalMap$WriteThroughEntry;
import java.util.Map;

final class MapMakerInternalMap$EntryIterator
extends MapMakerInternalMap$HashIterator {
    final /* synthetic */ MapMakerInternalMap this$0;

    MapMakerInternalMap$EntryIterator(MapMakerInternalMap mapMakerInternalMap) {
        this.this$0 = mapMakerInternalMap;
        super(mapMakerInternalMap);
    }

    @Override
    public Map.Entry next() {
        return this.nextEntry();
    }
}

