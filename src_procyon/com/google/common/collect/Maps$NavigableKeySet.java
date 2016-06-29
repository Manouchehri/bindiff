package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtIncompatible("NavigableMap")
class Maps$NavigableKeySet extends Maps$SortedKeySet implements NavigableSet
{
    Maps$NavigableKeySet(final NavigableMap navigableMap) {
        super(navigableMap);
    }
    
    @Override
    NavigableMap map() {
        return (NavigableMap)this.map;
    }
    
    @Override
    public Object lower(final Object o) {
        return this.map().lowerKey(o);
    }
    
    @Override
    public Object floor(final Object o) {
        return this.map().floorKey(o);
    }
    
    @Override
    public Object ceiling(final Object o) {
        return this.map().ceilingKey(o);
    }
    
    @Override
    public Object higher(final Object o) {
        return this.map().higherKey(o);
    }
    
    @Override
    public Object pollFirst() {
        return Maps.keyOrNull((Map.Entry)this.map().pollFirstEntry());
    }
    
    @Override
    public Object pollLast() {
        return Maps.keyOrNull((Map.Entry)this.map().pollLastEntry());
    }
    
    @Override
    public NavigableSet descendingSet() {
        return this.map().descendingKeySet();
    }
    
    @Override
    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }
    
    @Override
    public NavigableSet subSet(final Object o, final boolean b, final Object o2, final boolean b2) {
        return this.map().subMap(o, b, o2, b2).navigableKeySet();
    }
    
    @Override
    public NavigableSet headSet(final Object o, final boolean b) {
        return this.map().headMap(o, b).navigableKeySet();
    }
    
    @Override
    public NavigableSet tailSet(final Object o, final boolean b) {
        return this.map().tailMap(o, b).navigableKeySet();
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return this.subSet(o, true, o2, false);
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return this.headSet(o, false);
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return this.tailSet(o, true);
    }
}
