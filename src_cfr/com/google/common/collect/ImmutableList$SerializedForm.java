/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;

class ImmutableList$SerializedForm
implements Serializable {
    final Object[] elements;
    private static final long serialVersionUID = 0;

    ImmutableList$SerializedForm(Object[] arrobject) {
        this.elements = arrobject;
    }

    Object readResolve() {
        return ImmutableList.copyOf(this.elements);
    }
}

