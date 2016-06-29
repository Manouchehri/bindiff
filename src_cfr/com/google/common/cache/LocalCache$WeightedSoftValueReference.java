/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$SoftValueReference;
import com.google.common.cache.LocalCache$ValueReference;
import java.lang.ref.ReferenceQueue;

final class LocalCache$WeightedSoftValueReference
extends LocalCache$SoftValueReference {
    final int weight;

    LocalCache$WeightedSoftValueReference(ReferenceQueue referenceQueue, Object object, LocalCache$ReferenceEntry localCache$ReferenceEntry, int n2) {
        super(referenceQueue, object, localCache$ReferenceEntry);
        this.weight = n2;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    @Override
    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return new LocalCache$WeightedSoftValueReference(referenceQueue, object, localCache$ReferenceEntry, this.weight);
    }
}

