/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import java.io.Serializable;

@GwtIncompatible(value="serialization")
class ImmutableAsList$SerializedForm
implements Serializable {
    final ImmutableCollection collection;
    private static final long serialVersionUID = 0;

    ImmutableAsList$SerializedForm(ImmutableCollection immutableCollection) {
        this.collection = immutableCollection;
    }

    Object readResolve() {
        return this.collection.asList();
    }
}

