/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.collect.SortedMultiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

final class RegularImmutableSortedMultiset
extends ImmutableSortedMultiset {
    private static final long[] ZERO_CUMULATIVE_COUNTS = new long[]{0};
    private final transient RegularImmutableSortedSet elementSet;
    private final transient long[] cumulativeCounts;
    private final transient int offset;
    private final transient int length;

    RegularImmutableSortedMultiset(Comparator comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    RegularImmutableSortedMultiset(RegularImmutableSortedSet regularImmutableSortedSet, long[] arrl, int n2, int n3) {
        this.elementSet = regularImmutableSortedSet;
        this.cumulativeCounts = arrl;
        this.offset = n2;
        this.length = n3;
    }

    private int getCount(int n2) {
        return (int)(this.cumulativeCounts[this.offset + n2 + 1] - this.cumulativeCounts[this.offset + n2]);
    }

    @Override
    Multiset$Entry getEntry(int n2) {
        return Multisets.immutableEntry(this.elementSet.asList().get(n2), this.getCount(n2));
    }

    @Override
    public Multiset$Entry firstEntry() {
        if (this.isEmpty()) {
            return null;
        }
        Multiset$Entry multiset$Entry = this.getEntry(0);
        return multiset$Entry;
    }

    @Override
    public Multiset$Entry lastEntry() {
        if (this.isEmpty()) {
            return null;
        }
        Multiset$Entry multiset$Entry = this.getEntry(this.length - 1);
        return multiset$Entry;
    }

    @Override
    public int count(@Nullable Object object) {
        int n2 = this.elementSet.indexOf(object);
        if (n2 < 0) return 0;
        int n3 = this.getCount(n2);
        return n3;
    }

    @Override
    public int size() {
        long l2 = this.cumulativeCounts[this.offset + this.length] - this.cumulativeCounts[this.offset];
        return Ints.saturatedCast(l2);
    }

    @Override
    public ImmutableSortedSet elementSet() {
        return this.elementSet;
    }

    @Override
    public ImmutableSortedMultiset headMultiset(Object object, BoundType boundType) {
        boolean bl2;
        if (Preconditions.checkNotNull((Object)boundType) == BoundType.CLOSED) {
            bl2 = true;
            return this.getSubMultiset(0, this.elementSet.headIndex(object, bl2));
        }
        bl2 = false;
        return this.getSubMultiset(0, this.elementSet.headIndex(object, bl2));
    }

    @Override
    public ImmutableSortedMultiset tailMultiset(Object object, BoundType boundType) {
        boolean bl2;
        if (Preconditions.checkNotNull((Object)boundType) == BoundType.CLOSED) {
            bl2 = true;
            return this.getSubMultiset(this.elementSet.tailIndex(object, bl2), this.length);
        }
        bl2 = false;
        return this.getSubMultiset(this.elementSet.tailIndex(object, bl2), this.length);
    }

    ImmutableSortedMultiset getSubMultiset(int n2, int n3) {
        Preconditions.checkPositionIndexes(n2, n3, this.length);
        if (n2 == n3) {
            return RegularImmutableSortedMultiset.emptyMultiset(this.comparator());
        }
        if (n2 == 0 && n3 == this.length) {
            return this;
        }
        RegularImmutableSortedSet regularImmutableSortedSet = this.elementSet.getSubSet(n2, n3);
        return new RegularImmutableSortedMultiset(regularImmutableSortedSet, this.cumulativeCounts, this.offset + n2, n3 - n2);
    }

    @Override
    boolean isPartialView() {
        if (this.offset > 0) return true;
        if (this.length < this.cumulativeCounts.length - 1) return true;
        return false;
    }
}

