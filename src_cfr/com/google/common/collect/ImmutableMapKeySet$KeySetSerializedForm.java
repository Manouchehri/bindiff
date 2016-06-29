/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.Serializable;

@GwtIncompatible(value="serialization")
class ImmutableMapKeySet$KeySetSerializedForm
implements Serializable {
    final ImmutableMap map;
    private static final long serialVersionUID = 0;

    ImmutableMapKeySet$KeySetSerializedForm(ImmutableMap immutableMap) {
        this.map = immutableMap;
    }

    Object readResolve() {
        return this.map.keySet();
    }
}

