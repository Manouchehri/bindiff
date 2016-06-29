/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap$1;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$StrongValueReference;
import com.google.common.collect.MapMakerInternalMap$ValueReference;

final class MapMakerInternalMap$Strength$1
extends MapMakerInternalMap$Strength {
    MapMakerInternalMap$Strength$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    MapMakerInternalMap$ValueReference referenceValue(MapMakerInternalMap$Segment mapMakerInternalMap$Segment, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, Object object) {
        return new MapMakerInternalMap$StrongValueReference(object);
    }

    @Override
    Equivalence defaultEquivalence() {
        return Equivalence.equals();
    }
}

