package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

@GwtIncompatible("Navigable")
class SortedMultisets$NavigableElementSet extends SortedMultisets$ElementSet implements NavigableSet
{
    SortedMultisets$NavigableElementSet(final SortedMultiset sortedMultiset) {
        super(sortedMultiset);
    }
    
    @Override
    public Object lower(final Object o) {
        return getElementOrNull(this.multiset().headMultiset(o, BoundType.OPEN).lastEntry());
    }
    
    @Override
    public Object floor(final Object o) {
        return getElementOrNull(this.multiset().headMultiset(o, BoundType.CLOSED).lastEntry());
    }
    
    @Override
    public Object ceiling(final Object o) {
        return getElementOrNull(this.multiset().tailMultiset(o, BoundType.CLOSED).firstEntry());
    }
    
    @Override
    public Object higher(final Object o) {
        return getElementOrNull(this.multiset().tailMultiset(o, BoundType.OPEN).firstEntry());
    }
    
    @Override
    public NavigableSet descendingSet() {
        return new SortedMultisets$NavigableElementSet(this.multiset().descendingMultiset());
    }
    
    @Override
    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }
    
    @Override
    public Object pollFirst() {
        return getElementOrNull(this.multiset().pollFirstEntry());
    }
    
    @Override
    public Object pollLast() {
        return getElementOrNull(this.multiset().pollLastEntry());
    }
    
    @Override
    public NavigableSet subSet(final Object o, final boolean b, final Object o2, final boolean b2) {
        return new SortedMultisets$NavigableElementSet(this.multiset().subMultiset(o, BoundType.forBoolean(b), o2, BoundType.forBoolean(b2)));
    }
    
    @Override
    public NavigableSet headSet(final Object o, final boolean b) {
        return new SortedMultisets$NavigableElementSet(this.multiset().headMultiset(o, BoundType.forBoolean(b)));
    }
    
    @Override
    public NavigableSet tailSet(final Object o, final boolean b) {
        return new SortedMultisets$NavigableElementSet(this.multiset().tailMultiset(o, BoundType.forBoolean(b)));
    }
}
