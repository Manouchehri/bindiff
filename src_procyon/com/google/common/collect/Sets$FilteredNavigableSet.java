package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

@GwtIncompatible("NavigableSet")
class Sets$FilteredNavigableSet extends Sets$FilteredSortedSet implements NavigableSet
{
    Sets$FilteredNavigableSet(final NavigableSet set, final Predicate predicate) {
        super(set, predicate);
    }
    
    NavigableSet unfiltered() {
        return (NavigableSet)this.unfiltered;
    }
    
    @Nullable
    @Override
    public Object lower(final Object o) {
        return Iterators.getNext(this.headSet(o, false).descendingIterator(), null);
    }
    
    @Nullable
    @Override
    public Object floor(final Object o) {
        return Iterators.getNext(this.headSet(o, true).descendingIterator(), null);
    }
    
    @Override
    public Object ceiling(final Object o) {
        return Iterables.getFirst(this.tailSet(o, true), null);
    }
    
    @Override
    public Object higher(final Object o) {
        return Iterables.getFirst(this.tailSet(o, false), null);
    }
    
    @Override
    public Object pollFirst() {
        return Iterables.removeFirstMatching(this.unfiltered(), this.predicate);
    }
    
    @Override
    public Object pollLast() {
        return Iterables.removeFirstMatching(this.unfiltered().descendingSet(), this.predicate);
    }
    
    @Override
    public NavigableSet descendingSet() {
        return Sets.filter(this.unfiltered().descendingSet(), this.predicate);
    }
    
    @Override
    public Iterator descendingIterator() {
        return Iterators.filter(this.unfiltered().descendingIterator(), this.predicate);
    }
    
    @Override
    public Object last() {
        return this.descendingIterator().next();
    }
    
    @Override
    public NavigableSet subSet(final Object o, final boolean b, final Object o2, final boolean b2) {
        return Sets.filter(this.unfiltered().subSet(o, b, o2, b2), this.predicate);
    }
    
    @Override
    public NavigableSet headSet(final Object o, final boolean b) {
        return Sets.filter(this.unfiltered().headSet(o, b), this.predicate);
    }
    
    @Override
    public NavigableSet tailSet(final Object o, final boolean b) {
        return Sets.filter(this.unfiltered().tailSet(o, b), this.predicate);
    }
}
