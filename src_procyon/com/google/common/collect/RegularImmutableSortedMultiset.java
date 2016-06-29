package com.google.common.collect;

import javax.annotation.*;
import com.google.common.primitives.*;
import com.google.common.base.*;
import java.util.*;

final class RegularImmutableSortedMultiset extends ImmutableSortedMultiset
{
    private static final long[] ZERO_CUMULATIVE_COUNTS;
    private final transient RegularImmutableSortedSet elementSet;
    private final transient long[] cumulativeCounts;
    private final transient int offset;
    private final transient int length;
    
    RegularImmutableSortedMultiset(final Comparator comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = RegularImmutableSortedMultiset.ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }
    
    RegularImmutableSortedMultiset(final RegularImmutableSortedSet elementSet, final long[] cumulativeCounts, final int offset, final int length) {
        this.elementSet = elementSet;
        this.cumulativeCounts = cumulativeCounts;
        this.offset = offset;
        this.length = length;
    }
    
    private int getCount(final int n) {
        return (int)(this.cumulativeCounts[this.offset + n + 1] - this.cumulativeCounts[this.offset + n]);
    }
    
    @Override
    Multiset$Entry getEntry(final int n) {
        return Multisets.immutableEntry(this.elementSet.asList().get(n), this.getCount(n));
    }
    
    @Override
    public Multiset$Entry firstEntry() {
        return this.isEmpty() ? null : this.getEntry(0);
    }
    
    @Override
    public Multiset$Entry lastEntry() {
        return this.isEmpty() ? null : this.getEntry(this.length - 1);
    }
    
    @Override
    public int count(@Nullable final Object o) {
        final int index = this.elementSet.indexOf(o);
        return (index >= 0) ? this.getCount(index) : 0;
    }
    
    @Override
    public int size() {
        return Ints.saturatedCast(this.cumulativeCounts[this.offset + this.length] - this.cumulativeCounts[this.offset]);
    }
    
    @Override
    public ImmutableSortedSet elementSet() {
        return this.elementSet;
    }
    
    @Override
    public ImmutableSortedMultiset headMultiset(final Object o, final BoundType boundType) {
        return this.getSubMultiset(0, this.elementSet.headIndex(o, Preconditions.checkNotNull(boundType) == BoundType.CLOSED));
    }
    
    @Override
    public ImmutableSortedMultiset tailMultiset(final Object o, final BoundType boundType) {
        return this.getSubMultiset(this.elementSet.tailIndex(o, Preconditions.checkNotNull(boundType) == BoundType.CLOSED), this.length);
    }
    
    ImmutableSortedMultiset getSubMultiset(final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, this.length);
        if (n == n2) {
            return ImmutableSortedMultiset.emptyMultiset(this.comparator());
        }
        if (n == 0 && n2 == this.length) {
            return this;
        }
        return new RegularImmutableSortedMultiset(this.elementSet.getSubSet(n, n2), this.cumulativeCounts, this.offset + n, n2 - n);
    }
    
    @Override
    boolean isPartialView() {
        return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
    }
    
    static {
        ZERO_CUMULATIVE_COUNTS = new long[] { 0L };
    }
}
