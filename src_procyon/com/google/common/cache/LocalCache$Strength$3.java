package com.google.common.cache;

import com.google.common.base.*;

enum LocalCache$Strength$3
{
    LocalCache$Strength$3(final String s, final int n) {
    }
    
    @Override
    LocalCache$ValueReference referenceValue(final LocalCache$Segment localCache$Segment, final LocalCache$ReferenceEntry localCache$ReferenceEntry, final Object o, final int n) {
        return (n == 1) ? new LocalCache$WeakValueReference(localCache$Segment.valueReferenceQueue, o, localCache$ReferenceEntry) : new LocalCache$WeightedWeakValueReference(localCache$Segment.valueReferenceQueue, o, localCache$ReferenceEntry, n);
    }
    
    @Override
    Equivalence defaultEquivalence() {
        return Equivalence.identity();
    }
}
