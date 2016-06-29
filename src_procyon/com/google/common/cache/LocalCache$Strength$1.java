package com.google.common.cache;

import com.google.common.base.*;

enum LocalCache$Strength$1
{
    LocalCache$Strength$1(final String s, final int n) {
    }
    
    @Override
    LocalCache$ValueReference referenceValue(final LocalCache$Segment localCache$Segment, final LocalCache$ReferenceEntry localCache$ReferenceEntry, final Object o, final int n) {
        return (n == 1) ? new LocalCache$StrongValueReference(o) : new LocalCache$WeightedStrongValueReference(o, n);
    }
    
    @Override
    Equivalence defaultEquivalence() {
        return Equivalence.equals();
    }
}
