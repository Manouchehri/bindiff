/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import java.io.Serializable;

final class ImmutableRangeSet$SerializedForm
implements Serializable {
    private final ImmutableList ranges;

    ImmutableRangeSet$SerializedForm(ImmutableList immutableList) {
        this.ranges = immutableList;
    }

    Object readResolve() {
        if (this.ranges.isEmpty()) {
            return ImmutableRangeSet.of();
        }
        if (!this.ranges.equals(ImmutableList.of(Range.all()))) return new ImmutableRangeSet(this.ranges);
        return ImmutableRangeSet.all();
    }
}

