/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import java.io.Serializable;

class ImmutableSet$SerializedForm
implements Serializable {
    final Object[] elements;
    private static final long serialVersionUID = 0;

    ImmutableSet$SerializedForm(Object[] arrobject) {
        this.elements = arrobject;
    }

    Object readResolve() {
        return ImmutableSet.copyOf(this.elements);
    }
}

