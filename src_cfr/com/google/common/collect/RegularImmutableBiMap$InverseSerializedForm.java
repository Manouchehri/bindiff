/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import java.io.Serializable;

class RegularImmutableBiMap$InverseSerializedForm
implements Serializable {
    private final ImmutableBiMap forward;
    private static final long serialVersionUID = 1;

    RegularImmutableBiMap$InverseSerializedForm(ImmutableBiMap immutableBiMap) {
        this.forward = immutableBiMap;
    }

    Object readResolve() {
        return this.forward.inverse();
    }
}

