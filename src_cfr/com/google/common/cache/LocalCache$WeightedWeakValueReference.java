/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeakValueReference;
import java.lang.ref.ReferenceQueue;

final class LocalCache$WeightedWeakValueReference
extends LocalCache$WeakValueReference {
    final int weight;

    LocalCache$WeightedWeakValueReference(ReferenceQueue referenceQueue, Object object, LocalCache$ReferenceEntry localCache$ReferenceEntry, int n2) {
        super(referenceQueue, object, localCache$ReferenceEntry);
        this.weight = n2;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$WeightedWeakValueReference(referenceQueue, object, localCache$ReferenceEntry, this.weight);
    }
}

