/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import com.google.common.collect.Collections2;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.EmptyContiguousSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.RegularContiguousSet$1;
import com.google.common.collect.RegularContiguousSet$2;
import com.google.common.collect.RegularContiguousSet$SerializedForm;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
final class RegularContiguousSet
extends ContiguousSet {
    private final Range range;
    private static final long serialVersionUID = 0;

    RegularContiguousSet(Range range, DiscreteDomain discreteDomain) {
        super(discreteDomain);
        this.range = range;
    }

    private ContiguousSet intersectionInCurrentDomain(Range range) {
        EmptyContiguousSet emptyContiguousSet /* !! */ ;
        if (this.range.isConnected(range)) {
            emptyContiguousSet /* !! */  = ContiguousSet.create(this.range.intersection(range), this.domain);
            return emptyContiguousSet /* !! */ ;
        }
        emptyContiguousSet /* !! */  = new EmptyContiguousSet(this.domain);
        return emptyContiguousSet /* !! */ ;
    }

    @Override
    ContiguousSet headSetImpl(Comparable comparable, boolean bl2) {
        return this.intersectionInCurrentDomain(Range.upTo(comparable, BoundType.forBoolean(bl2)));
    }

    @Override
    ContiguousSet subSetImpl(Comparable comparable, boolean bl2, Comparable comparable2, boolean bl3) {
        if (comparable.compareTo(comparable2) != 0) return this.intersectionInCurrentDomain(Range.range(comparable, BoundType.forBoolean(bl2), comparable2, BoundType.forBoolean(bl3)));
        if (bl2) return this.intersectionInCurrentDomain(Range.range(comparable, BoundType.forBoolean(bl2), comparable2, BoundType.forBoolean(bl3)));
        if (bl3) return this.intersectionInCurrentDomain(Range.range(comparable, BoundType.forBoolean(bl2), comparable2, BoundType.forBoolean(bl3)));
        return new EmptyContiguousSet(this.domain);
    }

    @Override
    ContiguousSet tailSetImpl(Comparable comparable, boolean bl2) {
        return this.intersectionInCurrentDomain(Range.downTo(comparable, BoundType.forBoolean(bl2)));
    }

    @GwtIncompatible(value="not used by GWT emulation")
    @Override
    int indexOf(Object object) {
        if (!this.contains(object)) return -1;
        int n2 = (int)this.domain.distance(this.first(), (Comparable)object);
        return n2;
    }

    @Override
    public UnmodifiableIterator iterator() {
        return new RegularContiguousSet$1(this, this.first());
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    public UnmodifiableIterator descendingIterator() {
        return new RegularContiguousSet$2(this, this.last());
    }

    private static boolean equalsOrThrow(Comparable comparable, @Nullable Comparable comparable2) {
        if (comparable2 == null) return false;
        if (Range.compareOrThrow(comparable, comparable2) != 0) return false;
        return true;
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    public Comparable first() {
        return this.range.lowerBound.leastValueAbove(this.domain);
    }

    @Override
    public Comparable last() {
        return this.range.upperBound.greatestValueBelow(this.domain);
    }

    @Override
    public int size() {
        long l2 = this.domain.distance(this.first(), this.last());
        if (l2 >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        int n2 = (int)l2 + 1;
        return n2;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable)object);
        }
        catch (ClassCastException var2_2) {
            return false;
        }
    }

    @Override
    public boolean containsAll(Collection collection) {
        return Collections2.containsAllImpl(this, collection);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ContiguousSet intersection(ContiguousSet contiguousSet) {
        EmptyContiguousSet emptyContiguousSet /* !! */ ;
        Comparable comparable;
        Preconditions.checkNotNull(contiguousSet);
        Preconditions.checkArgument(this.domain.equals(contiguousSet.domain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable2 = (Comparable)Ordering.natural().max(this.first(), contiguousSet.first());
        if (comparable2.compareTo(comparable = (Comparable)Ordering.natural().min(this.last(), contiguousSet.last())) < 0) {
            emptyContiguousSet /* !! */  = ContiguousSet.create(Range.closed(comparable2, comparable), this.domain);
            return emptyContiguousSet /* !! */ ;
        }
        emptyContiguousSet /* !! */  = new EmptyContiguousSet(this.domain);
        return emptyContiguousSet /* !! */ ;
    }

    @Override
    public Range range() {
        return this.range(BoundType.CLOSED, BoundType.CLOSED);
    }

    @Override
    public Range range(BoundType boundType, BoundType boundType2) {
        return Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof RegularContiguousSet)) return super.equals(object);
        RegularContiguousSet regularContiguousSet = (RegularContiguousSet)object;
        if (!this.domain.equals(regularContiguousSet.domain)) return super.equals(object);
        if (!this.first().equals(regularContiguousSet.first())) return false;
        if (!this.last().equals(regularContiguousSet.last())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @GwtIncompatible(value="serialization")
    @Override
    Object writeReplace() {
        return new RegularContiguousSet$SerializedForm(this.range, this.domain, null);
    }

    static /* synthetic */ boolean access$000(Comparable comparable, Comparable comparable2) {
        return RegularContiguousSet.equalsOrThrow(comparable, comparable2);
    }
}

