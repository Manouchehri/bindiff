/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.EmptyContiguousSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.ImmutableSortedSet$Builder;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RegularContiguousSet;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;

@Beta
@GwtCompatible(emulated=1)
public abstract class ContiguousSet
extends ImmutableSortedSet {
    final DiscreteDomain domain;

    public static ContiguousSet create(Range range, DiscreteDomain discreteDomain) {
        EmptyContiguousSet emptyContiguousSet /* !! */ ;
        boolean bl2;
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(discreteDomain);
        Range range2 = range;
        try {
            if (!range.hasLowerBound()) {
                range2 = range2.intersection(Range.atLeast(discreteDomain.minValue()));
            }
            if (!range.hasUpperBound()) {
                range2 = range2.intersection(Range.atMost(discreteDomain.maxValue()));
            }
        }
        catch (NoSuchElementException var3_3) {
            throw new IllegalArgumentException(var3_3);
        }
        boolean bl3 = bl2 = range2.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0;
        if (bl2) {
            emptyContiguousSet /* !! */  = new EmptyContiguousSet(discreteDomain);
            return emptyContiguousSet /* !! */ ;
        }
        emptyContiguousSet /* !! */  = new RegularContiguousSet(range2, discreteDomain);
        return emptyContiguousSet /* !! */ ;
    }

    ContiguousSet(DiscreteDomain discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    public ContiguousSet headSet(Comparable comparable) {
        return this.headSetImpl((Comparable)Preconditions.checkNotNull(comparable), false);
    }

    @GwtIncompatible(value="NavigableSet")
    public ContiguousSet headSet(Comparable comparable, boolean bl2) {
        return this.headSetImpl((Comparable)Preconditions.checkNotNull(comparable), bl2);
    }

    public ContiguousSet subSet(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        Preconditions.checkArgument(this.comparator().compare(comparable, comparable2) <= 0);
        return this.subSetImpl(comparable, true, comparable2, false);
    }

    @GwtIncompatible(value="NavigableSet")
    public ContiguousSet subSet(Comparable comparable, boolean bl2, Comparable comparable2, boolean bl3) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        Preconditions.checkArgument(this.comparator().compare(comparable, comparable2) <= 0);
        return this.subSetImpl(comparable, bl2, comparable2, bl3);
    }

    public ContiguousSet tailSet(Comparable comparable) {
        return this.tailSetImpl((Comparable)Preconditions.checkNotNull(comparable), true);
    }

    @GwtIncompatible(value="NavigableSet")
    public ContiguousSet tailSet(Comparable comparable, boolean bl2) {
        return this.tailSetImpl((Comparable)Preconditions.checkNotNull(comparable), bl2);
    }

    abstract ContiguousSet headSetImpl(Comparable var1, boolean var2);

    abstract ContiguousSet subSetImpl(Comparable var1, boolean var2, Comparable var3, boolean var4);

    abstract ContiguousSet tailSetImpl(Comparable var1, boolean var2);

    public abstract ContiguousSet intersection(ContiguousSet var1);

    public abstract Range range();

    public abstract Range range(BoundType var1, BoundType var2);

    @Override
    public String toString() {
        return this.range().toString();
    }

    @Deprecated
    public static ImmutableSortedSet.Builder builder() {
        throw new UnsupportedOperationException();
    }
}

