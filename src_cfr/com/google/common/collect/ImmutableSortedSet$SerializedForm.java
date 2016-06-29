/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet$Builder;
import java.io.Serializable;
import java.util.Comparator;

class ImmutableSortedSet$SerializedForm
implements Serializable {
    final Comparator comparator;
    final Object[] elements;
    private static final long serialVersionUID = 0;

    public ImmutableSortedSet$SerializedForm(Comparator comparator, Object[] arrobject) {
        this.comparator = comparator;
        this.elements = arrobject;
    }

    Object readResolve() {
        return new ImmutableSortedSet$Builder(this.comparator).add(this.elements).build();
    }
}

