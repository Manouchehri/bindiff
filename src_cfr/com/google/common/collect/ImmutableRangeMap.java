/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Cut;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap$1;
import com.google.common.collect.ImmutableRangeMap$2;
import com.google.common.collect.ImmutableRangeMap$Builder;
import com.google.common.collect.ImmutableRangeMap$SerializedForm;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedLists;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible(value="NavigableMap")
public class ImmutableRangeMap
implements RangeMap,
Serializable {
    private static final ImmutableRangeMap EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
    private final transient ImmutableList ranges;
    private final transient ImmutableList values;
    private static final long serialVersionUID = 0;

    public static ImmutableRangeMap of() {
        return EMPTY;
    }

    public static ImmutableRangeMap of(Range range, Object object) {
        return new ImmutableRangeMap(ImmutableList.of(range), ImmutableList.of(object));
    }

    public static ImmutableRangeMap copyOf(RangeMap rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap)rangeMap;
        }
        Map map = rangeMap.asMapOfRanges();
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

    public static ImmutableRangeMap$Builder builder() {
        return new ImmutableRangeMap$Builder();
    }

    ImmutableRangeMap(ImmutableList immutableList, ImmutableList immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    @Nullable
    @Override
    public Object get(Comparable comparable) {
        int n2 = SortedLists.binarySearch((List)this.ranges, Range.lowerBoundFn(), Cut.belowValue(comparable), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (n2 == -1) {
            return null;
        }
        Range range = (Range)this.ranges.get(n2);
        if (!range.contains(comparable)) return null;
        Object v0 = this.values.get(n2);
        return v0;
    }

    @Nullable
    @Override
    public Map.Entry getEntry(Comparable comparable) {
        int n2 = SortedLists.binarySearch((List)this.ranges, Range.lowerBoundFn(), Cut.belowValue(comparable), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (n2 == -1) {
            return null;
        }
        Range range = (Range)this.ranges.get(n2);
        if (!range.contains(comparable)) return null;
        Map.Entry entry = Maps.immutableEntry(range, this.values.get(n2));
        return entry;
    }

    @Override
    public Range span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        Range range = (Range)this.ranges.get(0);
        Range range2 = (Range)this.ranges.get(this.ranges.size() - 1);
        return Range.create(range.lowerBound, range2.upperBound);
    }

    @Override
    public void put(Range range, Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(RangeMap rangeMap) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Range range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableMap asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        RegularImmutableSortedSet regularImmutableSortedSet = new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING);
        return new ImmutableSortedMap(regularImmutableSortedSet, this.values);
    }

    @Override
    public ImmutableMap asDescendingMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        RegularImmutableSortedSet regularImmutableSortedSet = new RegularImmutableSortedSet(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse());
        return new ImmutableSortedMap(regularImmutableSortedSet, this.values.reverse());
    }

    @Override
    public ImmutableRangeMap subRangeMap(Range range) {
        int n2;
        if (((Range)Preconditions.checkNotNull(range)).isEmpty()) {
            return ImmutableRangeMap.of();
        }
        if (this.ranges.isEmpty()) return this;
        if (range.encloses(this.span())) {
            return this;
        }
        int n3 = SortedLists.binarySearch((List)this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
        if (n3 >= (n2 = SortedLists.binarySearch((List)this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER))) {
            return ImmutableRangeMap.of();
        }
        int n4 = n3;
        int n5 = n2 - n3;
        ImmutableRangeMap$1 immutableRangeMap$1 = new ImmutableRangeMap$1(this, n5, n4, range);
        ImmutableRangeMap immutableRangeMap = this;
        return new ImmutableRangeMap$2(this, immutableRangeMap$1, this.values.subList(n3, n2), range, immutableRangeMap);
    }

    @Override
    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof RangeMap)) return false;
        RangeMap rangeMap = (RangeMap)object;
        return this.asMapOfRanges().equals(rangeMap.asMapOfRanges());
    }

    @Override
    public String toString() {
        return this.asMapOfRanges().toString();
    }

    Object writeReplace() {
        return new ImmutableRangeMap$SerializedForm(this.asMapOfRanges());
    }

    static /* synthetic */ ImmutableList access$000(ImmutableRangeMap immutableRangeMap) {
        return immutableRangeMap.ranges;
    }
}

