/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet;
import java.util.Iterator;
import java.util.Set;

public class ImmutableRangeSet$Builder {
    private final RangeSet rangeSet = TreeRangeSet.create();

    public ImmutableRangeSet$Builder add(Range range) {
        if (range.isEmpty()) {
            String string = String.valueOf(range);
            throw new IllegalArgumentException(new StringBuilder(33 + String.valueOf(string).length()).append("range must not be empty, but was ").append(string).toString());
        }
        if (this.rangeSet.complement().encloses(range)) {
            this.rangeSet.add(range);
            return this;
        }
        Iterator iterator = this.rangeSet.asRanges().iterator();
        while (iterator.hasNext()) {
            Range range2 = (Range)iterator.next();
            Preconditions.checkArgument(!range2.isConnected(range) || range2.intersection(range).isEmpty(), "Ranges may not overlap, but received %s and %s", range2, range);
        }
        throw new AssertionError((Object)"should have thrown an IAE above");
    }

    public ImmutableRangeSet$Builder addAll(RangeSet rangeSet) {
        Iterator iterator = rangeSet.asRanges().iterator();
        while (iterator.hasNext()) {
            Range range = (Range)iterator.next();
            this.add(range);
        }
        return this;
    }

    public ImmutableRangeSet build() {
        return ImmutableRangeSet.copyOf(this.rangeSet);
    }
}

