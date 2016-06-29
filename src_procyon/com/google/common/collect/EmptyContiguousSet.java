package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible(emulated = true)
final class EmptyContiguousSet extends ContiguousSet
{
    EmptyContiguousSet(final DiscreteDomain discreteDomain) {
        super(discreteDomain);
    }
    
    @Override
    public Comparable first() {
        throw new NoSuchElementException();
    }
    
    @Override
    public Comparable last() {
        throw new NoSuchElementException();
    }
    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public ContiguousSet intersection(final ContiguousSet set) {
        return this;
    }
    
    @Override
    public Range range() {
        throw new NoSuchElementException();
    }
    
    @Override
    public Range range(final BoundType boundType, final BoundType boundType2) {
        throw new NoSuchElementException();
    }
    
    @Override
    ContiguousSet headSetImpl(final Comparable comparable, final boolean b) {
        return this;
    }
    
    @Override
    ContiguousSet subSetImpl(final Comparable comparable, final boolean b, final Comparable comparable2, final boolean b2) {
        return this;
    }
    
    @Override
    ContiguousSet tailSetImpl(final Comparable comparable, final boolean b) {
        return this;
    }
    
    @Override
    public boolean contains(final Object o) {
        return false;
    }
    
    @GwtIncompatible("not used by GWT emulation")
    @Override
    int indexOf(final Object o) {
        return -1;
    }
    
    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.emptyIterator();
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    public UnmodifiableIterator descendingIterator() {
        return Iterators.emptyIterator();
    }
    
    @Override
    boolean isPartialView() {
        return false;
    }
    
    @Override
    public boolean isEmpty() {
        return true;
    }
    
    @Override
    public ImmutableList asList() {
        return ImmutableList.of();
    }
    
    @Override
    public String toString() {
        return "[]";
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Set && ((Set)o).isEmpty();
    }
    
    @GwtIncompatible("not used in GWT")
    @Override
    boolean isHashCodeFast() {
        return true;
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    @GwtIncompatible("serialization")
    @Override
    Object writeReplace() {
        return new EmptyContiguousSet$SerializedForm(this.domain, null);
    }
    
    @GwtIncompatible("NavigableSet")
    @Override
    ImmutableSortedSet createDescendingSet() {
        return ImmutableSortedSet.emptySet(Ordering.natural().reverse());
    }
}
