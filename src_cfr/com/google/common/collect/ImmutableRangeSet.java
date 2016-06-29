/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractRangeSet;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet$1;
import com.google.common.collect.ImmutableRangeSet$AsSet;
import com.google.common.collect.ImmutableRangeSet$Builder;
import com.google.common.collect.ImmutableRangeSet$ComplementRanges;
import com.google.common.collect.ImmutableRangeSet$SerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedLists;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public final class ImmutableRangeSet
extends AbstractRangeSet
implements Serializable {
    private static final ImmutableRangeSet EMPTY = new ImmutableRangeSet(ImmutableList.of());
    private static final ImmutableRangeSet ALL = new ImmutableRangeSet(ImmutableList.of(Range.all()));
    private final transient ImmutableList ranges;
    @LazyInit
    private transient ImmutableRangeSet complement;

    public static ImmutableRangeSet of() {
        return EMPTY;
    }

    static ImmutableRangeSet all() {
        return ALL;
    }

    public static ImmutableRangeSet of(Range range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return ImmutableRangeSet.of();
        }
        if (!range.equals(Range.all())) return new ImmutableRangeSet(ImmutableList.of(range));
        return ImmutableRangeSet.all();
    }

    public static ImmutableRangeSet copyOf(RangeSet rangeSet) {
        Preconditions.checkNotNull(rangeSet);
        if (rangeSet.isEmpty()) {
            return ImmutableRangeSet.of();
        }
        if (rangeSet.encloses(Range.all())) {
            return ImmutableRangeSet.all();
        }
        if (!(rangeSet instanceof ImmutableRangeSet)) return new ImmutableRangeSet(ImmutableList.copyOf(rangeSet.asRanges()));
        ImmutableRangeSet immutableRangeSet = (ImmutableRangeSet)rangeSet;
        if (immutableRangeSet.isPartialView()) return new ImmutableRangeSet(ImmutableList.copyOf(rangeSet.asRanges()));
        return immutableRangeSet;
    }

    ImmutableRangeSet(ImmutableList immutableList) {
        this.ranges = immutableList;
    }

    private ImmutableRangeSet(ImmutableList immutableList, ImmutableRangeSet immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    @Override
    public boolean encloses(Range range) {
        int n2 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.lowerBound, Ordering.natural(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (n2 == -1) return false;
        if (!((Range)this.ranges.get(n2)).encloses(range)) return false;
        return true;
    }

    @Override
    public Range rangeContaining(Comparable comparable) {
        int n2 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(comparable), Ordering.natural(), SortedLists$KeyPresentBehavior.ANY_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_LOWER);
        if (n2 == -1) return null;
        Range range = (Range)this.ranges.get(n2);
        if (!range.contains(comparable)) return null;
        Range range2 = range;
        return range2;
    }

    @Override
    public Range span() {
        if (!this.ranges.isEmpty()) return Range.create(((Range)this.ranges.get((int)0)).lowerBound, ((Range)this.ranges.get((int)(this.ranges.size() - 1))).upperBound);
        throw new NoSuchElementException();
    }

    @Override
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    @Override
    public void add(Range range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addAll(RangeSet rangeSet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Range range) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeAll(RangeSet rangeSet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImmutableSet asRanges() {
        if (!this.ranges.isEmpty()) return new RegularImmutableSortedSet(this.ranges, Range.RANGE_LEX_ORDERING);
        return ImmutableSet.of();
    }

    @Override
    public ImmutableSet asDescendingSetOfRanges() {
        if (!this.ranges.isEmpty()) return new RegularImmutableSortedSet(this.ranges.reverse(), Range.RANGE_LEX_ORDERING.reverse());
        return ImmutableSet.of();
    }

    @Override
    public ImmutableRangeSet complement() {
        ImmutableRangeSet immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            this.complement = ImmutableRangeSet.all();
            return this.complement;
        }
        if (this.ranges.size() == 1 && ((Range)this.ranges.get(0)).equals(Range.all())) {
            this.complement = ImmutableRangeSet.of();
            return this.complement;
        }
        ImmutableRangeSet$ComplementRanges immutableRangeSet$ComplementRanges = new ImmutableRangeSet$ComplementRanges(this);
        this.complement = new ImmutableRangeSet(immutableRangeSet$ComplementRanges, this);
        return this.complement;
    }

    private ImmutableList intersectRanges(Range range) {
        if (this.ranges.isEmpty()) return ImmutableList.of();
        if (range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(this.span())) {
            return this.ranges;
        }
        int n2 = range.hasLowerBound() ? SortedLists.binarySearch((List)this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER) : 0;
        int n3 = range.hasUpperBound() ? SortedLists.binarySearch((List)this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists$KeyPresentBehavior.FIRST_PRESENT, SortedLists$KeyAbsentBehavior.NEXT_HIGHER) : this.ranges.size();
        int n4 = n3 - n2;
        if (n4 != 0) return new ImmutableRangeSet$1(this, n4, n2, range);
        return ImmutableList.of();
    }

    @Override
    public ImmutableRangeSet subRangeSet(Range range) {
        if (this.isEmpty()) return ImmutableRangeSet.of();
        Range range2 = this.span();
        if (range.encloses(range2)) {
            return this;
        }
        if (!range.isConnected(range2)) return ImmutableRangeSet.of();
        return new ImmutableRangeSet(this.intersectRanges(range));
    }

    public ImmutableSortedSet asSet(DiscreteDomain discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        if (this.isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range range = this.span().canonical(discreteDomain);
        if (!range.hasLowerBound()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (range.hasUpperBound()) return new ImmutableRangeSet$AsSet(this, discreteDomain);
        try {
            discreteDomain.maxValue();
            return new ImmutableRangeSet$AsSet(this, discreteDomain);
        }
        catch (NoSuchElementException var3_3) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
        }
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

    static /* synthetic */ ImmutableList access$000(ImmutableRangeSet immutableRangeSet) {
        return immutableRangeSet.ranges;
    }
}

