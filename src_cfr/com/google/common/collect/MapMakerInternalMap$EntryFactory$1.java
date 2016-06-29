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
import com.google.common.collect.MapMakerInternalMap$StrongEntry;
import javax.annotation.Nullable;

final class MapMakerInternalMap$EntryFactory$1
extends MapMakerInternalMap$EntryFactory {
    MapMakerInternalMap$EntryFactory$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    MapMakerInternalMap$ReferenceEntry newEntry(MapMakerInternalMap$Segment mapMakerInternalMap$Segment, Object object, int n2, @Nullable MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return new MapMakerInternalMap$StrongEntry(object, n2, mapMakerInternalMap$ReferenceEntry);
    }
}

