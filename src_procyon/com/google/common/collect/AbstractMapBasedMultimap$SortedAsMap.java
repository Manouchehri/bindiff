package com.google.common.collect;

import java.util.*;

class AbstractMapBasedMultimap$SortedAsMap extends AbstractMapBasedMultimap$AsMap implements SortedMap
{
    SortedSet sortedKeySet;
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$SortedAsMap(final AbstractMapBasedMultimap this$0, final SortedMap sortedMap) {
        this.this$0 = this$0;
        super(this$0, sortedMap);
    }
    
    SortedMap sortedMap() {
        return (SortedMap)this.submap;
    }
    
    @Override
    public Comparator comparator() {
        return this.sortedMap().comparator();
    }
    
    @Override
    public Object firstKey() {
        return this.sortedMap().firstKey();
    }
    
    @Override
    public Object lastKey() {
        return this.sortedMap().lastKey();
    }
    
    @Override
    public SortedMap headMap(final Object o) {
        return new AbstractMapBasedMultimap$SortedAsMap(this.this$0, this.sortedMap().headMap(o));
    }
    
    @Override
    public SortedMap subMap(final Object o, final Object o2) {
        return new AbstractMapBasedMultimap$SortedAsMap(this.this$0, this.sortedMap().subMap(o, o2));
    }
    
    @Override
    public SortedMap tailMap(final Object o) {
        return new AbstractMapBasedMultimap$SortedAsMap(this.this$0, this.sortedMap().tailMap(o));
    }
    
    @Override
    public SortedSet keySet() {
        final SortedSet sortedKeySet = this.sortedKeySet;
        return (sortedKeySet == null) ? (this.sortedKeySet = this.createKeySet()) : sortedKeySet;
    }
    
    @Override
    SortedSet createKeySet() {
        return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap());
    }
}
