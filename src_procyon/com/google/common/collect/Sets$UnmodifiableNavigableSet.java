package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@GwtIncompatible("NavigableSet")
final class Sets$UnmodifiableNavigableSet extends ForwardingSortedSet implements Serializable, NavigableSet
{
    private final NavigableSet delegate;
    private transient Sets$UnmodifiableNavigableSet descendingSet;
    private static final long serialVersionUID = 0L;
    
    Sets$UnmodifiableNavigableSet(final NavigableSet set) {
        this.delegate = (NavigableSet)Preconditions.checkNotNull(set);
    }
    
    @Override
    protected SortedSet delegate() {
        return Collections.unmodifiableSortedSet((SortedSet<Object>)this.delegate);
    }
    
    @Override
    public Object lower(final Object o) {
        return this.delegate.lower(o);
    }
    
    @Override
    public Object floor(final Object o) {
        return this.delegate.floor(o);
    }
    
    @Override
    public Object ceiling(final Object o) {
        return this.delegate.ceiling(o);
    }
    
    @Override
    public Object higher(final Object o) {
        return this.delegate.higher(o);
    }
    
    @Override
    public Object pollFirst() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Object pollLast() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public NavigableSet descendingSet() {
        Sets$UnmodifiableNavigableSet descendingSet = this.descendingSet;
        if (descendingSet == null) {
            final Sets$UnmodifiableNavigableSet descendingSet2 = new Sets$UnmodifiableNavigableSet(this.delegate.descendingSet());
            this.descendingSet = descendingSet2;
            descendingSet = descendingSet2;
            descendingSet.descendingSet = this;
        }
        return descendingSet;
    }
    
    @Override
    public Iterator descendingIterator() {
        return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
    }
    
    @Override
    public NavigableSet subSet(final Object o, final boolean b, final Object o2, final boolean b2) {
        return Sets.unmodifiableNavigableSet(this.delegate.subSet(o, b, o2, b2));
    }
    
    @Override
    public NavigableSet headSet(final Object o, final boolean b) {
        return Sets.unmodifiableNavigableSet(this.delegate.headSet(o, b));
    }
    
    @Override
    public NavigableSet tailSet(final Object o, final boolean b) {
        return Sets.unmodifiableNavigableSet(this.delegate.tailSet(o, b));
    }
}
