package com.google.common.cache;

import java.lang.ref.*;

final class LocalCache$WeightedWeakValueReference extends LocalCache$WeakValueReference
{
    final int weight;
    
    LocalCache$WeightedWeakValueReference(final ReferenceQueue referenceQueue, final Object o, final LocalCache$ReferenceEntry localCache$ReferenceEntry, final int weight) {
        super(referenceQueue, o, localCache$ReferenceEntry);
        this.weight = weight;
    }
    
    @Override
    public int getWeight() {
        return this.weight;
    }
    
    @Override
    public LocalCache$ValueReference copyFor(final ReferenceQueue referenceQueue, final Object o, final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$WeightedWeakValueReference(referenceQueue, o, localCache$ReferenceEntry, this.weight);
    }
}
