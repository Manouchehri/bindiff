/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$SoftValueReference;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeightedSoftValueReference;
import java.lang.ref.ReferenceQueue;

final class LocalCache$Strength$2
extends LocalCache$Strength {
    LocalCache$Strength$2(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    LocalCache$ValueReference referenceValue(LocalCache$Segment localCache$Segment, LocalCache$ReferenceEntry localCache$ReferenceEntry, Object object, int n2) {
        LocalCache$SoftValueReference localCache$SoftValueReference;
        if (n2 == 1) {
            localCache$SoftValueReference = new LocalCache$SoftValueReference(localCache$Segment.valueReferenceQueue, object, localCache$ReferenceEntry);
            return localCache$SoftValueReference;
        }
        localCache$SoftValueReference = new LocalCache$WeightedSoftValueReference(localCache$Segment.valueReferenceQueue, object, localCache$ReferenceEntry, n2);
        return localCache$SoftValueReference;
    }

    @Override
    Equivalence defaultEquivalence() {
        return Equivalence.identity();
    }
}

