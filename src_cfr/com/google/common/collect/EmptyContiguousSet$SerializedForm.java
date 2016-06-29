/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.EmptyContiguousSet;
import com.google.common.collect.EmptyContiguousSet$1;
import java.io.Serializable;

@GwtIncompatible(value="serialization")
final class EmptyContiguousSet$SerializedForm
implements Serializable {
    private final DiscreteDomain domain;
    private static final long serialVersionUID = 0;

    private EmptyContiguousSet$SerializedForm(DiscreteDomain discreteDomain) {
        this.domain = discreteDomain;
    }

    private Object readResolve() {
        return new EmptyContiguousSet(this.domain);
    }

    /* synthetic */ EmptyContiguousSet$SerializedForm(DiscreteDomain discreteDomain, EmptyContiguousSet$1 emptyContiguousSet$1) {
        this(discreteDomain);
    }
}

