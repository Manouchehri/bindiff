/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class MapMakerInternalMap$ExpirationQueue$2
extends AbstractSequentialIterator {
    final /* synthetic */ MapMakerInternalMap$ExpirationQueue this$0;

    MapMakerInternalMap$ExpirationQueue$2(MapMakerInternalMap$ExpirationQueue mapMakerInternalMap$ExpirationQueue, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.this$0 = mapMakerInternalMap$ExpirationQueue;
        super(mapMakerInternalMap$ReferenceEntry);
    }

    protected MapMakerInternalMap$ReferenceEntry computeNext(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry.getNextExpirable();
        if (mapMakerInternalMap$ReferenceEntry2 == this.this$0.head) {
            return null;
        }
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry2;
        return mapMakerInternalMap$ReferenceEntry3;
    }
}

