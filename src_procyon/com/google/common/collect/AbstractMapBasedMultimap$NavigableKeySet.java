package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtIncompatible("NavigableSet")
class AbstractMapBasedMultimap$NavigableKeySet extends AbstractMapBasedMultimap$SortedKeySet implements NavigableSet
{
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$NavigableKeySet(final AbstractMapBasedMultimap this$0, final NavigableMap navigableMap) {
        this.this$0 = this$0;
        super(this$0, navigableMap);
    }
    
    @Override
    NavigableMap sortedMap() {
        return (NavigableMap)super.sortedMap();
    }
    
    @Override
    public Object lower(final Object o) {
        return this.sortedMap().lowerKey(o);
    }
    
    @Override
    public Object floor(final Object o) {
        return this.sortedMap().floorKey(o);
    }
    
    @Override
    public Object ceiling(final Object o) {
        return this.sortedMap().ceilingKey(o);
    }
    
    @Override
    public Object higher(final Object o) {
        return this.sortedMap().higherKey(o);
    }
    
    @Override
    public Object pollFirst() {
        return Iterators.pollNext(this.iterator());
    }
    
    @Override
    public Object pollLast() {
        return Iterators.pollNext(this.descendingIterator());
    }
    
    @Override
    public NavigableSet descendingSet() {
        return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().descendingMap());
    }
    
    @Override
    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }
    
    @Override
    public NavigableSet headSet(final Object o) {
        return this.headSet(o, false);
    }
    
    @Override
    public NavigableSet headSet(final Object o, final boolean b) {
        return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().headMap(o, b));
    }
    
    @Override
    public NavigableSet subSet(final Object o, final Object o2) {
        return this.subSet(o, true, o2, false);
    }
    
    @Override
    public NavigableSet subSet(final Object o, final boolean b, final Object o2, final boolean b2) {
        return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().subMap(o, b, o2, b2));
    }
    
    @Override
    public NavigableSet tailSet(final Object o) {
        return this.tailSet(o, true);
    }
    
    @Override
    public NavigableSet tailSet(final Object o, final boolean b) {
        return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().tailMap(o, b));
    }
}
