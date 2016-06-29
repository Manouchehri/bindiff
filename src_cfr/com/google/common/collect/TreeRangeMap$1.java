/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

final class TreeRangeMap$1
implements RangeMap {
    TreeRangeMap$1() {
    }

    @Nullable
    @Override
    public Object get(Comparable comparable) {
        return null;
    }

    @Nullable
    @Override
    public Map.Entry getEntry(Comparable comparable) {
        return null;
    }

    @Override
    public Range span() {
        throw new NoSuchElementException();
    }

    @Override
    public void put(Range range, Object object) {
        Preconditions.checkNotNull(range);
        String string = String.valueOf(range);
        throw new IllegalArgumentException(new StringBuilder(46 + String.valueOf(string).length()).append("Cannot insert range ").append(string).append(" into an empty subRangeMap").toString());
    }

    @Override
    public void putAll(RangeMap rangeMap) {
        if (rangeMap.asMapOfRanges().isEmpty()) return;
        throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
    }

    @Override
    public void clear() {
    }

    @Override
    public void remove(Range range) {
        Preconditions.checkNotNull(range);
    }

    @Override
    public Map asMapOfRanges() {
        return Collections.emptyMap();
    }

    @Override
    public Map asDescendingMapOfRanges() {
        return Collections.emptyMap();
    }

    @Override
    public RangeMap subRangeMap(Range range) {
        Preconditions.checkNotNull(range);
        return this;
    }
}

