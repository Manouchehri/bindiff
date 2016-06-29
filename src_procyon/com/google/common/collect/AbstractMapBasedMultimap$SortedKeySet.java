package com.google.common.collect;

import java.util.*;

class AbstractMapBasedMultimap$SortedKeySet extends AbstractMapBasedMultimap$KeySet implements SortedSet
{
    final /* synthetic */ AbstractMapBasedMultimap this$0;
    
    AbstractMapBasedMultimap$SortedKeySet(final AbstractMapBasedMultimap this$0, final SortedMap sortedMap) {
        this.this$0 = this$0;
        super(this$0, sortedMap);
    }
    
    SortedMap sortedMap() {
        return (SortedMap)super.map();
    }
    
    @Override
    public Comparator comparator() {
        return this.sortedMap().comparator();
    }
    
    @Override
    public Object first() {
        return this.sortedMap().firstKey();
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap().headMap(o));
    }
    
    @Override
    public Object last() {
        return this.sortedMap().lastKey();
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap().subMap(o, o2));
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap().tailMap(o));
    }
}
