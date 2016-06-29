/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;

@GwtIncompatible(value="serialization")
class ImmutableMapValues$SerializedForm
implements Serializable {
    final ImmutableMap map;
    private static final long serialVersionUID = 0;

    ImmutableMapValues$SerializedForm(ImmutableMap immutableMap) {
        this.map = immutableMap;
    }

    Object readResolve() {
        return this.map.values();
    }
}

