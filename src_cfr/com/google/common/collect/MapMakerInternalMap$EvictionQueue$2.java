/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class MapMakerInternalMap$EvictionQueue$2
extends AbstractSequentialIterator {
    final /* synthetic */ MapMakerInternalMap$EvictionQueue this$0;

    MapMakerInternalMap$EvictionQueue$2(MapMakerInternalMap$EvictionQueue mapMakerInternalMap$EvictionQueue, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.this$0 = mapMakerInternalMap$EvictionQueue;
        super(mapMakerInternalMap$ReferenceEntry);
    }

    protected MapMakerInternalMap$ReferenceEntry computeNext(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry.getNextEvictable();
        if (mapMakerInternalMap$ReferenceEntry2 == this.this$0.head) {
            return null;
        }
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry2;
        return mapMakerInternalMap$ReferenceEntry3;
    }
}

