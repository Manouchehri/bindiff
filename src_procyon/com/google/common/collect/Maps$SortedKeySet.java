package com.google.common.collect;

import java.util.*;

class Maps$SortedKeySet extends Maps$KeySet implements SortedSet
{
    Maps$SortedKeySet(final SortedMap sortedMap) {
        super(sortedMap);
    }
    
    @Override
    SortedMap map() {
        return (SortedMap)super.map();
    }
    
    @Override
    public Comparator comparator() {
        return this.map().comparator();
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return new Maps$SortedKeySet(this.map().subMap(o, o2));
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return new Maps$SortedKeySet(this.map().headMap(o));
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return new Maps$SortedKeySet(this.map().tailMap(o));
    }
    
    @Override
    public Object first() {
        return this.map().firstKey();
    }
    
    @Override
    public Object last() {
        return this.map().lastKey();
    }
}
