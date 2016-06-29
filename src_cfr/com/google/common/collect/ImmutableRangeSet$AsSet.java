/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.ImmutableRangeSet$AsSet$1;
import com.google.common.collect.ImmutableRangeSet$AsSet$2;
import com.google.common.collect.ImmutableRangeSet$AsSetSerializedForm;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.Nullable;

final class ImmutableRangeSet$AsSet
extends ImmutableSortedSet {
    private final DiscreteDomain domain;
    private transient Integer size;
    final /* synthetic */ ImmutableRangeSet this$0;

    ImmutableRangeSet$AsSet(ImmutableRangeSet immutableRangeSet, DiscreteDomain discreteDomain) {
        this.this$0 = immutableRangeSet;
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    @Override
    public int size() {
        Range range;
        Integer n2 = this.size;
        if (n2 != null) return n2;
        long l2 = 0;
        UnmodifiableIterator unmodifiableIterator = ImmutableRangeSet.access$000(this.this$0).iterator();
        while (unmodifiableIterator.hasNext() && (l2 += (long)ContiguousSet.create(range = (Range)unmodifiableIterator.next(), this.domain).size()) < Integer.MAX_VALUE) {
        }
        n2 = this.size = Integer.valueOf(Ints.saturatedCast(l2));
        return n2;
    }

    @Override
    public UnmodifiableIterator iterator() {
        return new ImmutableRangeSet$AsSet$1(this);
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    public UnmodifiableIterator descendingIterator() {
        return new ImmutableRangeSet$AsSet$2(this);
    }

    ImmutableSortedSet subSet(Range range) {
        return this.this$0.subRangeSet(range).asSet(this.domain);
    }

    ImmutableSortedSet headSetImpl(Comparable comparable, boolean bl2) {
        return this.subSet(Range.upTo(comparable, BoundType.forBoolean(bl2)));
    }

    ImmutableSortedSet subSetImpl(Comparable comparable, boolean bl2, Comparable comparable2, boolean bl3) {
        if (bl2) return this.subSet(Range.range(comparable, BoundType.forBoolean(bl2), comparable2, BoundType.forBoolean(bl3)));
        if (bl3) return this.subSet(Range.range(comparable, BoundType.forBoolean(bl2), comparable2, BoundType.forBoolean(bl3)));
        if (Range.compareOrThrow(comparable, comparable2) != 0) return this.subSet(Range.range(comparable, BoundType.forBoolean(bl2), comparable2, BoundType.forBoolean(bl3)));
        return ImmutableSortedSet.of();
    }

    ImmutableSortedSet tailSetImpl(Comparable comparable, boolean bl2) {
        return this.subSet(Range.downTo(comparable, BoundType.forBoolean(bl2)));
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        try {
            Comparable comparable = (Comparable)object;
            return this.this$0.contains(comparable);
        }
        catch (ClassCastException var2_3) {
            return false;
        }
    }

    @Override
    int indexOf(Object object) {
        if (!this.contains(object)) return -1;
        Comparable comparable = (Comparable)object;
        long l2 = 0;
        UnmodifiableIterator unmodifiableIterator = ImmutableRangeSet.access$000(this.this$0).iterator();
        while (unmodifiableIterator.hasNext()) {
            Range range = (Range)unmodifiableIterator.next();
            if (range.contains(comparable)) {
                return Ints.saturatedCast(l2 + (long)ContiguousSet.create(range, this.domain).indexOf(comparable));
            }
            l2 += (long)ContiguousSet.create(range, this.domain).size();
        }
        throw new AssertionError((Object)"impossible");
    }

    @Override
    boolean isPartialView() {
        return ImmutableRangeSet.access$000(this.this$0).isPartialView();
    }

    @Override
    public String toString() {
        return ImmutableRangeSet.access$000(this.this$0).toString();
    }

    @Override
    Object writeReplace() {
        return new ImmutableRangeSet$AsSetSerializedForm(ImmutableRangeSet.access$000(this.this$0), this.domain);
    }

    static /* synthetic */ DiscreteDomain access$100(ImmutableRangeSet$AsSet immutableRangeSet$AsSet) {
        return immutableRangeSet$AsSet.domain;
    }
}

