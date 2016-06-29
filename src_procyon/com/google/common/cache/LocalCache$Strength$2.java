package com.google.common.cache;

import com.google.common.base.*;

enum LocalCache$Strength$2
{
    LocalCache$Strength$2(final String s, final int n) {
    }
    
    @Override
    LocalCache$ValueReference referenceValue(final LocalCache$Segment localCache$Segment, final LocalCache$ReferenceEntry localCache$ReferenceEntry, final Object o, final int n) {
        return (n == 1) ? new LocalCache$SoftValueReference(localCache$Segment.valueReferenceQueue, o, localCache$ReferenceEntry) : new LocalCache$WeightedSoftValueReference(localCache$Segment.valueReferenceQueue, o, localCache$ReferenceEntry, n);
    }
    
    @Override
    Equivalence defaultEquivalence() {
        return Equivalence.identity();
    }
}
