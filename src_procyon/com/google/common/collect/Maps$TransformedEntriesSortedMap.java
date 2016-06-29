package com.google.common.collect;

import java.util.*;

class Maps$TransformedEntriesSortedMap extends Maps$TransformedEntriesMap implements SortedMap
{
    protected SortedMap fromMap() {
        return (SortedMap)this.fromMap;
    }
    
    Maps$TransformedEntriesSortedMap(final SortedMap sortedMap, final Maps$EntryTransformer maps$EntryTransformer) {
        super(sortedMap, maps$EntryTransformer);
    }
    
    @Override
    public Comparator comparator() {
        return this.fromMap().comparator();
    }
    
    @Override
    public Object firstKey() {
        return this.fromMap().firstKey();
    }
    
    @Override
    public SortedMap headMap(final Object o) {
        return Maps.transformEntries(this.fromMap().headMap(o), this.transformer);
    }
    
    @Override
    public Object lastKey() {
        return this.fromMap().lastKey();
    }
    
    @Override
    public SortedMap subMap(final Object o, final Object o2) {
        return Maps.transformEntries(this.fromMap().subMap(o, o2), this.transformer);
    }
    
    @Override
    public SortedMap tailMap(final Object o) {
        return Maps.transformEntries(this.fromMap().tailMap(o), this.transformer);
    }
}
