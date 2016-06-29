package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

public class ImmutableRangeSet$Builder
{
    private final RangeSet rangeSet;
    
    public ImmutableRangeSet$Builder() {
        this.rangeSet = TreeRangeSet.create();
    }
    
    public ImmutableRangeSet$Builder add(final Range range) {
        if (range.isEmpty()) {
            final String value = String.valueOf(range);
            throw new IllegalArgumentException(new StringBuilder(33 + String.valueOf(value).length()).append("range must not be empty, but was ").append(value).toString());
        }
        if (!this.rangeSet.complement().encloses(range)) {
            for (final Range range2 : this.rangeSet.asRanges()) {
                Preconditions.checkArgument(!range2.isConnected(range) || range2.intersection(range).isEmpty(), "Ranges may not overlap, but received %s and %s", range2, range);
            }
            throw new AssertionError((Object)"should have thrown an IAE above");
        }
        this.rangeSet.add(range);
        return this;
    }
    
    public ImmutableRangeSet$Builder addAll(final RangeSet set) {
        final Iterator<Range> iterator = set.asRanges().iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return this;
    }
    
    public ImmutableRangeSet build() {
        return ImmutableRangeSet.copyOf(this.rangeSet);
    }
}
