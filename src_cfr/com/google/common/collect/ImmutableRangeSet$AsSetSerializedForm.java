/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableSortedSet;
import java.io.Serializable;

class ImmutableRangeSet$AsSetSerializedForm
implements Serializable {
    private final ImmutableList ranges;
    private final DiscreteDomain domain;

    ImmutableRangeSet$AsSetSerializedForm(ImmutableList immutableList, DiscreteDomain discreteDomain) {
        this.ranges = immutableList;
        this.domain = discreteDomain;
    }

    Object readResolve() {
        return new ImmutableRangeSet(this.ranges).asSet(this.domain);
    }
}

