/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeakValueReference;
import com.google.common.cache.LocalCache$WeightedWeakValueReference;
import java.lang.ref.ReferenceQueue;

final class LocalCache$Strength$3
extends LocalCache$Strength {
    LocalCache$Strength$3(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    LocalCache$ValueReference referenceValue(LocalCache$Segment localCache$Segment, LocalCache$ReferenceEntry localCache$ReferenceEntry, Object object, int n2) {
        LocalCache$WeakValueReference localCache$WeakValueReference;
        if (n2 == 1) {
            localCache$WeakValueReference = new LocalCache$WeakValueReference(localCache$Segment.valueReferenceQueue, object, localCache$ReferenceEntry);
            return localCache$WeakValueReference;
        }
        localCache$WeakValueReference = new LocalCache$WeightedWeakValueReference(localCache$Segment.valueReferenceQueue, object, localCache$ReferenceEntry, n2);
        return localCache$WeakValueReference;
    }

    @Override
    Equivalence defaultEquivalence() {
        return Equivalence.identity();
    }
}

