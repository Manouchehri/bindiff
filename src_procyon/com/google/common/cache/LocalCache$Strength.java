package com.google.common.cache;

import com.google.common.base.*;

enum LocalCache$Strength
{
    STRONG("STRONG", 0), 
    SOFT("SOFT", 1), 
    WEAK("WEAK", 2);
    
    private LocalCache$Strength(final String s, final int n) {
    }
    
    abstract LocalCache$ValueReference referenceValue(final LocalCache$Segment p0, final LocalCache$ReferenceEntry p1, final Object p2, final int p3);
    
    abstract Equivalence defaultEquivalence();
}
