package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;

@Beta
@GwtIncompatible("NavigableMap")
public class ImmutableRangeMap implements RangeMap, Serializable
{
    private static final ImmutableRangeMap EMPTY;
    private final transient ImmutableList ranges;
    private final transient ImmutableList values;
    private static final long serialVersionUID = 0L;
    
    public static ImmutableRangeMap of() {
        return ImmutableRangeMap.EMPTY;
    }
    
    public static ImmutableRangeMap of(final Range range, final Object o) {
        return new ImmutableRangeMap(ImmutableList.of(range), ImmutableList.of(o));
    }
    
    public static ImmutableRangeMap copyOf(final RangeMap rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap)rangeMap;
        }
        final Map mapOfRanges = rangeMap.asMapOfRanges();
        final ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(mapOfRanges.size());
        final ImmutableList$Builder immutableList$Builder2 = new ImmutableList$Builder(mapOfRanges.size());
        for (final Map.Entry<Object, V> entry : mapOfRanges.entrySet()) {
            immutableList$Builder.add(entry.getKey());
            immutableList$Builder2.add(entry.getValue());
        }
        return new ImmutableRangeMap(immutableList$Builder.build(), immutableList$Builder2.build());
    }
    
    public static ImmutableRangeMap$Builder builder() {
        return new ImmutableRangeMap$Builder();
    }
    
    ImmutableRangeMap(final ImmutableList ranges, final ImmutableList values) {
        this.ranges = ranges;
        this.values = values;
    }
    
    @Nullable
    @Override
    public Object get(final Comparable comparable) {
        final int binarySearch = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(comparable), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch == -1) {
            return null;
        }
        return ((Range)this.ranges.get(binarySearch)).contains(comparable) ? this.values.get(binarySearch) : null;
    }
    
    @Nullable
    @Override
    public Map.Entry getEntry(final Comparable comparable) {
        final int binarySearch = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(comparable), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch == -1) {
            return null;
        }
        final Range range = this.ranges.get(binarySearch);
        return range.contains(comparable) ? Maps.immutableEntry(range, this.values.get(binarySearch)) : null;
    }
    
    @Override
    public Range span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(this.ranges.size() - 1).upperBound);
    }
    
    @Override
    public void put(final Range range, final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void putAll(final RangeMap rangeMap) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void remove(final Range range) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ImmutableMap asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING), this.values);
    }
    
    @Override
    public ImmutableMap asDescendingMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse()), this.values.reverse());
    }
    
    @Override
    public ImmutableRangeMap subRangeMap(final Range range) {
        if (((Range)Preconditions.checkNotNull(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(this.span())) {
            return this;
        }
        final int binarySearch = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
        final int binarySearch2 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
        if (binarySearch >= binarySearch2) {
            return of();
        }
        return new ImmutableRangeMap$2(this, new ImmutableRangeMap$1(this, binarySearch2 - binarySearch, binarySearch, range), this.values.subList(binarySearch, binarySearch2), range, this);
    }
    
    @Override
    public int hashCode() {
        return this.asMapOfRanges().hashCode();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof RangeMap && this.asMapOfRanges().equals(((RangeMap)o).asMapOfRanges());
    }
    
    @Override
    public String toString() {
        return this.asMapOfRanges().toString();
    }
    
    Object writeReplace() {
        return new ImmutableRangeMap$SerializedForm(this.asMapOfRanges());
    }
    
    static {
        EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
    }
}
