package com.google.common.collect;

import com.google.common.base.*;

enum MapMakerInternalMap$Strength
{
    STRONG("STRONG", 0), 
    SOFT("SOFT", 1), 
    WEAK("WEAK", 2);
    
    private MapMakerInternalMap$Strength(final String s, final int n) {
    }
    
    abstract MapMakerInternalMap$ValueReference referenceValue(final MapMakerInternalMap$Segment p0, final MapMakerInternalMap$ReferenceEntry p1, final Object p2);
    
    abstract Equivalence defaultEquivalence();
}
