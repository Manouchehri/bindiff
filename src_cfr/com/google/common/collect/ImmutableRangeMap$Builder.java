/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ImmutableRangeMap$Builder {
    private final RangeSet keyRanges = TreeRangeSet.create();
    private final RangeMap rangeMap = TreeRangeMap.create();

    public ImmutableRangeMap$Builder put(Range range, Object object) {
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(object);
        Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", range);
        if (!this.keyRanges.complement().encloses(range)) {
            for (Map.Entry entry : this.rangeMap.asMapOfRanges().entrySet()) {
                Range range2 = (Range)entry.getKey();
                if (!range2.isConnected(range) || range2.intersection(range).isEmpty()) continue;
                String string = String.valueOf(range);
                String string2 = String.valueOf(entry);
                throw new IllegalArgumentException(new StringBuilder(47 + String.valueOf(string).length() + String.valueOf(string2).length()).append("Overlapping ranges: range ").append(string).append(" overlaps with entry ").append(string2).toString());
            }
        }
        this.keyRanges.add(range);
        this.rangeMap.put(range, object);
        return this;
    }

    public ImmutableRangeMap$Builder putAll(RangeMap rangeMap) {
        Iterator iterator = rangeMap.asMapOfRanges().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            this.put((Range)entry.getKey(), entry.getValue());
        }
        return this;
    }

    public ImmutableRangeMap build() {
        Map map = this.rangeMap.asMapOfRanges();
        ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(map.size());
        ImmutableList$Builder immutableList$Builder2 = new ImmutableList$Builder(map.size());
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            immutableList$Builder.add(entry.getKey());
            immutableList$Builder2.add(entry.getValue());
        }
        return new ImmutableRangeMap(immutableList$Builder.build(), immutableList$Builder2.build());
    }
}

