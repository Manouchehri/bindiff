/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache$StrongValueReference;

final class LocalCache$WeightedStrongValueReference
extends LocalCache$StrongValueReference {
    final int weight;

    LocalCache$WeightedStrongValueReference(Object object, int n2) {
        super(object);
        this.weight = n2;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }
}

