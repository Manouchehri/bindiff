/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.LocalCache$StrongValueReference;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeightedStrongValueReference;

final class LocalCache$Strength$1
extends LocalCache$Strength {
    LocalCache$Strength$1(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    LocalCache$ValueReference referenceValue(LocalCache$Segment localCache$Segment, LocalCache$ReferenceEntry localCache$ReferenceEntry, Object object, int n2) {
        LocalCache$StrongValueReference localCache$StrongValueReference;
        if (n2 == 1) {
            localCache$StrongValueReference = new LocalCache$StrongValueReference(object);
            return localCache$StrongValueReference;
        }
        localCache$StrongValueReference = new LocalCache$WeightedStrongValueReference(object, n2);
        return localCache$StrongValueReference;
    }

    @Override
    Equivalence defaultEquivalence() {
        return Equivalence.equals();
    }
}

