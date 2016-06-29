package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtIncompatible("NavigableSet")
class Sets$DescendingSet extends ForwardingNavigableSet
{
    private final NavigableSet forward;
    
    Sets$DescendingSet(final NavigableSet forward) {
        this.forward = forward;
    }
    
    @Override
    protected NavigableSet delegate() {
        return this.forward;
    }
    
    @Override
    public Object lower(final Object o) {
        return this.forward.higher(o);
    }
    
    @Override
    public Object floor(final Object o) {
        return this.forward.ceiling(o);
    }
    
    @Override
    public Object ceiling(final Object o) {
        return this.forward.floor(o);
    }
    
    @Override
    public Object higher(final Object o) {
        return this.forward.lower(o);
    }
    
    @Override
    public Object pollFirst() {
        return this.forward.pollLast();
    }
    
    @Override
    public Object pollLast() {
        return this.forward.pollFirst();
    }
    
    @Override
    public NavigableSet descendingSet() {
        return this.forward;
    }
    
    @Override
    public Iterator descendingIterator() {
        return this.forward.iterator();
    }
    
    @Override
    public NavigableSet subSet(final Object o, final boolean b, final Object o2, final boolean b2) {
        return this.forward.subSet(o2, b2, o, b).descendingSet();
    }
    
    @Override
    public NavigableSet headSet(final Object o, final boolean b) {
        return this.forward.tailSet(o, b).descendingSet();
    }
    
    @Override
    public NavigableSet tailSet(final Object o, final boolean b) {
        return this.forward.headSet(o, b).descendingSet();
    }
    
    @Override
    public Comparator comparator() {
        final Comparator comparator = this.forward.comparator();
        if (comparator == null) {
            return Ordering.natural().reverse();
        }
        return reverse(comparator);
    }
    
    private static Ordering reverse(final Comparator comparator) {
        return Ordering.from(comparator).reverse();
    }
    
    @Override
    public Object first() {
        return this.forward.last();
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return this.standardHeadSet(o);
    }
    
    @Override
    public Object last() {
        return this.forward.first();
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return this.standardSubSet(o, o2);
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return this.standardTailSet(o);
    }
    
    @Override
    public Iterator iterator() {
        return this.forward.descendingIterator();
    }
    
    @Override
    public Object[] toArray() {
        return this.standardToArray();
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        return this.standardToArray(array);
    }
    
    @Override
    public String toString() {
        return this.standardToString();
    }
}
