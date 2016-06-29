package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

public final class ImmutableRangeMap$Builder
{
    private final RangeSet keyRanges;
    private final RangeMap rangeMap;
    
    public ImmutableRangeMap$Builder() {
        this.keyRanges = TreeRangeSet.create();
        this.rangeMap = TreeRangeMap.create();
    }
    
    public ImmutableRangeMap$Builder put(final Range range, final Object o) {
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(o);
        Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", range);
        if (!this.keyRanges.complement().encloses(range)) {
            for (final Map.Entry<Range, V> entry : this.rangeMap.asMapOfRanges().entrySet()) {
                final Range range2 = entry.getKey();
                if (range2.isConnected(range) && !range2.intersection(range).isEmpty()) {
                    final String value = String.valueOf(range);
                    final String value2 = String.valueOf(entry);
                    throw new IllegalArgumentException(new StringBuilder(47 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Overlapping ranges: range ").append(value).append(" overlaps with entry ").append(value2).toString());
                }
            }
        }
        this.keyRanges.add(range);
        this.rangeMap.put(range, o);
        return this;
    }
    
    public ImmutableRangeMap$Builder putAll(final RangeMap rangeMap) {
        for (final Map.Entry<Range, V> entry : rangeMap.asMapOfRanges().entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
        return this;
    }
    
    public ImmutableRangeMap build() {
        final Map mapOfRanges = this.rangeMap.asMapOfRanges();
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(mapOfRanges.size());
        final ImmutableList$Builder immutableList$Builder2 = new ImmutableList$Builder(mapOfRanges.size());
        for (final Map.Entry<Object, V> entry : mapOfRanges.entrySet()) {
            immutableList$Builder.add(entry.getKey());
            immutableList$Builder2.add(entry.getValue());
        }
        return new ImmutableRangeMap(immutableList$Builder.build(), immutableList$Builder2.build());
    }
}
