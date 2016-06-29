package com.google.common.collect;

import com.google.common.primitives.*;
import javax.annotation.*;
import java.io.*;
import com.google.common.annotations.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import java.util.*;

final class ImmutableRangeSet$AsSet extends ImmutableSortedSet
{
    private final DiscreteDomain domain;
    private transient Integer size;
    final /* synthetic */ ImmutableRangeSet this$0;
    
    ImmutableRangeSet$AsSet(final ImmutableRangeSet this$0, final DiscreteDomain domain) {
        this.this$0 = this$0;
        super(Ordering.natural());
        this.domain = domain;
    }
    
    @Override
    public int size() {
        Integer size = this.size;
        if (size == null) {
            long n = 0L;
            final UnmodifiableIterator iterator = this.this$0.ranges.iterator();
            while (iterator.hasNext()) {
                n += ContiguousSet.create(iterator.next(), this.domain).size();
                if (n >= 2147483647L) {
                    break;
                }
            }
            final Integer value = Ints.saturatedCast(n);
            this.size = value;
            size = value;
        }
        return size;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return new ImmutableRangeSet$AsSet$1(this);
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public UnmodifiableIterator descendingIterator() {
        return new ImmutableRangeSet$AsSet$2(this);
    }
    
    ImmutableSortedSet subSet(final Range range) {
        return this.this$0.subRangeSet(range).asSet(this.domain);
    }
    
    ImmutableSortedSet headSetImpl(final Comparable comparable, final boolean b) {
        return this.subSet(Range.upTo(comparable, BoundType.forBoolean(b)));
    }
    
    ImmutableSortedSet subSetImpl(final Comparable comparable, final boolean b, final Comparable comparable2, final boolean b2) {
        if (!b && !b2 && Range.compareOrThrow(comparable, comparable2) == 0) {
            return ImmutableSortedSet.of();
        }
        return this.subSet(Range.range(comparable, BoundType.forBoolean(b), comparable2, BoundType.forBoolean(b2)));
    }
    
    ImmutableSortedSet tailSetImpl(final Comparable comparable, final boolean b) {
        return this.subSet(Range.downTo(comparable, BoundType.forBoolean(b)));
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o == null) {
            return false;
        }
        try {
            return this.this$0.contains((Comparable)o);
        }
        catch (ClassCastException ex) {
            return false;
        }
    }
    
    @Override
    int indexOf(final Object o) {
        if (this.contains(o)) {
            final Comparable comparable = (Comparable)o;
            long n = 0L;
            for (final Range range : this.this$0.ranges) {
                if (range.contains(comparable)) {
                    return Ints.saturatedCast(n + ContiguousSet.create(range, this.domain).indexOf(comparable));
                }
                n += ContiguousSet.create(range, this.domain).size();
            }
            throw new AssertionError((Object)"impossible");
        }
        return -1;
    }
    
    @Override
    boolean isPartialView() {
        return this.this$0.ranges.isPartialView();
    }
    
    @Override
    public String toString() {
        return this.this$0.ranges.toString();
    }
    
    @Override
    Object writeReplace() {
        return new ImmutableRangeSet$AsSetSerializedForm(this.this$0.ranges, this.domain);
    }
}
