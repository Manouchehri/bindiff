/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.RegularContiguousSet;
import com.google.common.collect.RegularContiguousSet$1;
import java.io.Serializable;

@GwtIncompatible(value="serialization")
final class RegularContiguousSet$SerializedForm
implements Serializable {
    final Range range;
    final DiscreteDomain domain;

    private RegularContiguousSet$SerializedForm(Range range, DiscreteDomain discreteDomain) {
        this.range = range;
        this.domain = discreteDomain;
    }

    private Object readResolve() {
        return new RegularContiguousSet(this.range, this.domain);
    }

    /* synthetic */ RegularContiguousSet$SerializedForm(Range range, DiscreteDomain discreteDomain, RegularContiguousSet$1 regularContiguousSet$1) {
        this(range, discreteDomain);
    }
}

