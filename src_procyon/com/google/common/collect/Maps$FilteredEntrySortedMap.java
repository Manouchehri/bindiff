package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Maps$FilteredEntrySortedMap extends Maps$FilteredEntryMap implements SortedMap
{
    Maps$FilteredEntrySortedMap(final SortedMap sortedMap, final Predicate predicate) {
        super(sortedMap, predicate);
    }
    
    SortedMap sortedMap() {
        return (SortedMap)this.unfiltered;
    }
    
    @Override
    public SortedSet keySet() {
        return (SortedSet)super.keySet();
    }
    
    @Override
    SortedSet createKeySet() {
        return new Maps$FilteredEntrySortedMap$SortedKeySet(this);
    }
    
    @Override
    public Comparator comparator() {
        return this.sortedMap().comparator();
    }
    
    @Override
    public Object firstKey() {
        return this.keySet().iterator().next();
    }
    
    @Override
    public Object lastKey() {
        SortedMap<Object, Object> sortedMap = (SortedMap<Object, Object>)this.sortedMap();
        Object lastKey;
        while (true) {
            lastKey = sortedMap.lastKey();
            if (this.apply(lastKey, this.unfiltered.get(lastKey))) {
                break;
            }
            sortedMap = this.sortedMap().headMap(lastKey);
        }
        return lastKey;
    }
    
    @Override
    public SortedMap headMap(final Object o) {
        return new Maps$FilteredEntrySortedMap(this.sortedMap().headMap(o), this.predicate);
    }
    
    @Override
    public SortedMap subMap(final Object o, final Object o2) {
        return new Maps$FilteredEntrySortedMap(this.sortedMap().subMap(o, o2), this.predicate);
    }
    
    @Override
    public SortedMap tailMap(final Object o) {
        return new Maps$FilteredEntrySortedMap(this.sortedMap().tailMap(o), this.predicate);
    }
}
