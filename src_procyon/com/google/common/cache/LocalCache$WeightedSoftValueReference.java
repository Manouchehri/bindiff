package com.google.common.cache;

import java.lang.ref.*;

final class LocalCache$WeightedSoftValueReference extends LocalCache$SoftValueReference
{
    final int weight;
    
    LocalCache$WeightedSoftValueReference(final ReferenceQueue referenceQueue, final Object o, final LocalCache$ReferenceEntry localCache$ReferenceEntry, final int weight) {
        super(referenceQueue, o, localCache$ReferenceEntry);
        this.weight = weight;
    }
    
    @Override
    public int getWeight() {
        return this.weight;
    }
    
    @Override
    public LocalCache$ValueReference copyFor(final ReferenceQueue referenceQueue, final Object o, final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$WeightedSoftValueReference(referenceQueue, o, localCache$ReferenceEntry, this.weight);
    }
}
