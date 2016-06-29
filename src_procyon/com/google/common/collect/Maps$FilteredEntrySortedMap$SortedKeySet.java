package com.google.common.collect;

import java.util.*;

class Maps$FilteredEntrySortedMap$SortedKeySet extends Maps$FilteredEntryMap$KeySet implements SortedSet
{
    final /* synthetic */ Maps$FilteredEntrySortedMap this$0;
    
    Maps$FilteredEntrySortedMap$SortedKeySet(final Maps$FilteredEntrySortedMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Comparator comparator() {
        return this.this$0.sortedMap().comparator();
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return (SortedSet)this.this$0.subMap(o, o2).keySet();
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return (SortedSet)this.this$0.headMap(o).keySet();
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return (SortedSet)this.this$0.tailMap(o).keySet();
    }
    
    @Override
    public Object first() {
        return this.this$0.firstKey();
    }
    
    @Override
    public Object last() {
        return this.this$0.lastKey();
    }
}
