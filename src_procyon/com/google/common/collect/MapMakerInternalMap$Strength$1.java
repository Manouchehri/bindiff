package com.google.common.collect;

import com.google.common.base.*;

enum MapMakerInternalMap$Strength$1
{
    MapMakerInternalMap$Strength$1(final String s, final int n) {
    }
    
    @Override
    MapMakerInternalMap$ValueReference referenceValue(final MapMakerInternalMap$Segment mapMakerInternalMap$Segment, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final Object o) {
        return new MapMakerInternalMap$StrongValueReference(o);
    }
    
    @Override
    Equivalence defaultEquivalence() {
        return Equivalence.equals();
    }
}
