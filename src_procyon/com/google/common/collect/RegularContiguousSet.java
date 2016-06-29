package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible(emulated = true)
final class RegularContiguousSet extends ContiguousSet
{
    private final Range range;
    private static final long serialVersionUID = 0L;
    
    RegularContiguousSet(final Range range, final DiscreteDomain discreteDomain) {
        super(discreteDomain);
        this.range = range;
    }
    
    private ContiguousSet intersectionInCurrentDomain(final Range range) {
        return this.range.isConnected(range) ? ContiguousSet.create(this.range.intersection(range), this.domain) : new EmptyContiguousSet(this.domain);
    }
    
    @Override
    ContiguousSet headSetImpl(final Comparable comparable, final boolean b) {
        return this.intersectionInCurrentDomain(Range.upTo(comparable, BoundType.forBoolean(b)));
    }
    
    @Override
    ContiguousSet subSetImpl(final Comparable comparable, final boolean b, final Comparable comparable2, final boolean b2) {
        if (comparable.compareTo(comparable2) == 0 && !b && !b2) {
            return new EmptyContiguousSet(this.domain);
        }
        return this.intersectionInCurrentDomain(Range.range(comparable, BoundType.forBoolean(b), comparable2, BoundType.forBoolean(b2)));
    }
    
    @Override
    ContiguousSet tailSetImpl(final Comparable comparable, final boolean b) {
        return this.intersectionInCurrentDomain(Range.downTo(comparable, BoundType.forBoolean(b)));
    }
    
    @GwtIncompatible("not used by GWT emulation")
    @Override
    int indexOf(final Object o) {
        return this.contains(o) ? ((int)this.domain.distance(this.first(), (Comparable)o)) : -1;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return new RegularContiguousSet$1(this, this.first());
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public UnmodifiableIterator descendingIterator() {
        return new RegularContiguousSet$2(this, this.last());
    }
    
    private static boolean equalsOrThrow(final Comparable comparable, @Nullable final Comparable comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
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
        final long distance = this.domain.distance(this.first(), this.last());
        return (distance >= 2147483647L) ? Integer.MAX_VALUE : ((int)distance + 1);
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        if (o == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable)o);
        }
        catch (ClassCastException ex) {
            return false;
        }
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        return Collections2.containsAllImpl(this, collection);
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public ContiguousSet intersection(final ContiguousSet set) {
        Preconditions.checkNotNull(set);
        Preconditions.checkArgument(this.domain.equals(set.domain));
        if (set.isEmpty()) {
            return set;
        }
        final Comparable comparable = (Comparable)Ordering.natural().max(this.first(), set.first());
        final Comparable comparable2 = (Comparable)Ordering.natural().min(this.last(), set.last());
        return (comparable.compareTo(comparable2) < 0) ? ContiguousSet.create(Range.closed(comparable, comparable2), this.domain) : new EmptyContiguousSet(this.domain);
    }
    
    @Override
    public Range range() {
        return this.range(BoundType.CLOSED, BoundType.CLOSED);
    }
    
    @Override
    public Range range(final BoundType boundType, final BoundType boundType2) {
        return Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof RegularContiguousSet) {
            final RegularContiguousSet set = (RegularContiguousSet)o;
            if (this.domain.equals(set.domain)) {
                return this.first().equals(set.first()) && this.last().equals(set.last());
            }
        }
        return super.equals(o);
    }
    
    @Override
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new RegularContiguousSet$SerializedForm(this.range, this.domain, null);
    }
}
