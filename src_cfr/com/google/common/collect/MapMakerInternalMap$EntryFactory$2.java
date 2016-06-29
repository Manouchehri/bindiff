/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$1;
import com.google.common.collect.MapMakerInternalMap$EntryFactory;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$StrongExpirableEntry;
import javax.annotation.Nullable;

final class MapMakerInternalMap$EntryFactory$2
extends MapMakerInternalMap$EntryFactory {
    MapMakerInternalMap$EntryFactory$2(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    MapMakerInternalMap$ReferenceEntry newEntry(MapMakerInternalMap$Segment mapMakerInternalMap$Segment, Object object, int n2, @Nullable MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return new MapMakerInternalMap$StrongExpirableEntry(object, n2, mapMakerInternalMap$ReferenceEntry);
    }

    @Override
    MapMakerInternalMap$ReferenceEntry copyEntry(MapMakerInternalMap$Segment mapMakerInternalMap$Segment, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = super.copyEntry(mapMakerInternalMap$Segment, mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry2);
        this.copyExpirableEntry(mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry3);
        return mapMakerInternalMap$ReferenceEntry3;
    }
}

