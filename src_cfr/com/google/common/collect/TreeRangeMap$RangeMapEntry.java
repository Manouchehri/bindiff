/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;

final class TreeRangeMap$RangeMapEntry
extends AbstractMapEntry {
    private final Range range;
    private final Object value;

    TreeRangeMap$RangeMapEntry(Cut cut, Cut cut2, Object object) {
        this(Range.create(cut, cut2), object);
    }

    TreeRangeMap$RangeMapEntry(Range range, Object object) {
        this.range = range;
        this.value = object;
    }

    @Override
    public Range getKey() {
        return this.range;
    }

    @Override
    public Object getValue() {
        return this.value;
    }

    public boolean contains(Comparable comparable) {
        return this.range.contains(comparable);
    }

    Cut getLowerBound() {
        return this.range.lowerBound;
    }

    Cut getUpperBound() {
        return this.range.upperBound;
    }
}

