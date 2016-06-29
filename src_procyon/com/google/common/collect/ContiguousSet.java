package com.google.common.collect;

import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

@Beta
@GwtCompatible(emulated = true)
public abstract class ContiguousSet extends ImmutableSortedSet
{
    final DiscreteDomain domain;
    
    public static ContiguousSet create(final Range range, final DiscreteDomain discreteDomain) {
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
        catch (NoSuchElementException ex) {
            throw new IllegalArgumentException(ex);
        }
        return (range2.isEmpty() || Range.compareOrThrow(range.lowerBound.leastValueAbove(discreteDomain), range.upperBound.greatestValueBelow(discreteDomain)) > 0) ? new EmptyContiguousSet(discreteDomain) : new RegularContiguousSet(range2, discreteDomain);
    }
    
    ContiguousSet(final DiscreteDomain domain) {
        super(Ordering.natural());
        this.domain = domain;
    }
    
    public ContiguousSet headSet(final Comparable comparable) {
        return this.headSetImpl((Comparable)Preconditions.checkNotNull(comparable), false);
    }
    
    @GwtIncompatible("NavigableSet")
    public ContiguousSet headSet(final Comparable comparable, final boolean b) {
        return this.headSetImpl((Comparable)Preconditions.checkNotNull(comparable), b);
    }
    
    public ContiguousSet subSet(final Comparable comparable, final Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        Preconditions.checkArgument(this.comparator().compare(comparable, comparable2) <= 0);
        return this.subSetImpl(comparable, true, comparable2, false);
    }
    
    @GwtIncompatible("NavigableSet")
    public ContiguousSet subSet(final Comparable comparable, final boolean b, final Comparable comparable2, final boolean b2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        Preconditions.checkArgument(this.comparator().compare(comparable, comparable2) <= 0);
        return this.subSetImpl(comparable, b, comparable2, b2);
    }
    
    public ContiguousSet tailSet(final Comparable comparable) {
        return this.tailSetImpl((Comparable)Preconditions.checkNotNull(comparable), true);
    }
    
    @GwtIncompatible("NavigableSet")
    public ContiguousSet tailSet(final Comparable comparable, final boolean b) {
        return this.tailSetImpl((Comparable)Preconditions.checkNotNull(comparable), b);
    }
    
    abstract ContiguousSet headSetImpl(final Comparable p0, final boolean p1);
    
    abstract ContiguousSet subSetImpl(final Comparable p0, final boolean p1, final Comparable p2, final boolean p3);
    
    abstract ContiguousSet tailSetImpl(final Comparable p0, final boolean p1);
    
    public abstract ContiguousSet intersection(final ContiguousSet p0);
    
    public abstract Range range();
    
    public abstract Range range(final BoundType p0, final BoundType p1);
    
    @Override
    public String toString() {
        return this.range().toString();
    }
    
    @Deprecated
    public static ImmutableSortedSet$Builder builder() {
        throw new UnsupportedOperationException();
    }
}
