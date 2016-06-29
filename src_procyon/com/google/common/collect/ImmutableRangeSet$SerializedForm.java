package com.google.common.collect;

import java.io.*;

final class ImmutableRangeSet$SerializedForm implements Serializable
{
    private final ImmutableList ranges;
    
    ImmutableRangeSet$SerializedForm(final ImmutableList ranges) {
        this.ranges = ranges;
    }
    
    Object readResolve() {
        if (this.ranges.isEmpty()) {
            return ImmutableRangeSet.of();
        }
        if (this.ranges.equals(ImmutableList.of(Range.all()))) {
            return ImmutableRangeSet.all();
        }
        return new ImmutableRangeSet(this.ranges);
    }
}
