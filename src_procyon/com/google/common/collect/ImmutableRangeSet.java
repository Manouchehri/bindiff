package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@Beta
public final class ImmutableRangeSet extends AbstractRangeSet implements Serializable
{
    private static final ImmutableRangeSet EMPTY;
    private static final ImmutableRangeSet ALL;
    private final transient ImmutableList ranges;
    @LazyInit
    private transient ImmutableRangeSet complement;
    
    public static ImmutableRangeSet of() {
        return ImmutableRangeSet.EMPTY;
    }
    
    static ImmutableRangeSet all() {
        return ImmutableRangeSet.ALL;
    }
    
    public static ImmutableRangeSet of(final Range range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return all();
        }
        return new ImmutableRangeSet(ImmutableList.of(range));
    }
    
    public static ImmutableRangeSet copyOf(final RangeSet set) {
        Preconditions.checkNotNull(set);
        if (set.isEmpty()) {
            return of();
        }
        if (set.encloses(Range.all())) {
            return all();
        }
        if (set instanceof ImmutableRangeSet) {
            final ImmutableRangeSet set2 = (ImmutableRangeSet)set;
            if (!set2.isPartialView()) {
                return set2;
            }
        }
        return new ImmutableRangeSet(ImmutableList.copyOf(set.asRanges()));
    }
    
    ImmutableRangeSet(final ImmutableList ranges) {
        this.ranges = ranges;
    }
    
    private ImmutableRangeSet(final ImmutableList ranges, final ImmutableRangeSet complement) {
        this.ranges = ranges;
        this.complement = complement;
    }
    
    @Override
    public boolean encloses(final Range range) {
        final int binarySearch = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        return binarySearch != -1 && ((Range)this.ranges.get(binarySearch)).encloses(range);
    }
    
    @Override
    public Range rangeContaining(final Comparable comparable) {
        final int binarySearch = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(comparable), Ordering.natural(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch != -1) {
            final Range range = this.ranges.get(binarySearch);
            return range.contains(comparable) ? range : null;
        }
        return null;
    }
    
    @Override
    public Range span() {
        if (this.ranges.isEmpty()) {
            throw new NoSuchElementException();
        }
        return Range.create(this.ranges.get(0).lowerBound, this.ranges.get(this.ranges.size() - 1).upperBound);
    }
    
    @Override
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }
    
    @Override
    public void add(final Range range) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void addAll(final RangeSet set) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void remove(final Range range) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void removeAll(final RangeSet set) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ImmutableSet asRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING);
    }
    
    @Override
    public ImmutableSet asDescendingSetOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse());
    }
    
    @Override
    public ImmutableRangeSet complement() {
        final ImmutableRangeSet complement = this.complement;
        if (complement != null) {
            return complement;
        }
        if (this.ranges.isEmpty()) {
            return this.complement = all();
        }
        if (this.ranges.size() == 1 && this.ranges.get(0).equals(Range.all())) {
            return this.complement = of();
        }
        return this.complement = new ImmutableRangeSet(new ImmutableRangeSet$ComplementRanges(this), this);
    }
    
    private ImmutableList intersectRanges(final Range range) {
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(this.span())) {
            return this.ranges;
        }
        int binarySearch;
        if (range.hasLowerBound()) {
            binarySearch = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
        }
        else {
            binarySearch = 0;
        }
        int n;
        if (range.hasUpperBound()) {
            n = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists$KeyPresentBehavior.FIRST_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
        }
        else {
            n = this.ranges.size();
        }
        final int n2 = n - binarySearch;
        if (n2 == 0) {
            return ImmutableList.of();
        }
        return new ImmutableRangeSet$1(this, n2, binarySearch, range);
    }
    
    @Override
    public ImmutableRangeSet subRangeSet(final Range range) {
        if (!this.isEmpty()) {
            final Range span = this.span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet(this.intersectRanges(range));
            }
        }
        return of();
    }
    
    public ImmutableSortedSet asSet(final DiscreteDomain discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        if (this.isEmpty()) {
            return ImmutableSortedSet.of();
        }
        final Range canonical = this.span().canonical(discreteDomain);
        if (!canonical.hasLowerBound()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!canonical.hasUpperBound()) {
            try {
                discreteDomain.maxValue();
            }
            catch (NoSuchElementException ex) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new ImmutableRangeSet$AsSet(this, discreteDomain);
    }
    
    boolean isPartialView() {
        return this.ranges.isPartialView();
    }
    
    public static ImmutableRangeSet$Builder builder() {
        return new ImmutableRangeSet$Builder();
    }
    
    Object writeReplace() {
        return new ImmutableRangeSet$SerializedForm(this.ranges);
    }
    
    static {
        EMPTY = new ImmutableRangeSet(ImmutableList.of());
        ALL = new ImmutableRangeSet(ImmutableList.of(Range.all()));
    }
}
