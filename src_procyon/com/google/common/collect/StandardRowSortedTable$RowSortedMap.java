package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

class StandardRowSortedTable$RowSortedMap extends StandardTable$RowMap implements SortedMap
{
    final /* synthetic */ StandardRowSortedTable this$0;
    
    private StandardRowSortedTable$RowSortedMap(final StandardRowSortedTable this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public SortedSet keySet() {
        return (SortedSet)super.keySet();
    }
    
    @Override
    SortedSet createKeySet() {
        return new Maps$SortedKeySet(this);
    }
    
    @Override
    public Comparator comparator() {
        return this.this$0.sortedBackingMap().comparator();
    }
    
    @Override
    public Object firstKey() {
        return this.this$0.sortedBackingMap().firstKey();
    }
    
    @Override
    public Object lastKey() {
        return this.this$0.sortedBackingMap().lastKey();
    }
    
    @Override
    public SortedMap headMap(final Object o) {
        Preconditions.checkNotNull(o);
        return new StandardRowSortedTable(this.this$0.sortedBackingMap().headMap(o), this.this$0.factory).rowMap();
    }
    
    @Override
    public SortedMap subMap(final Object o, final Object o2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        return new StandardRowSortedTable(this.this$0.sortedBackingMap().subMap(o, o2), this.this$0.factory).rowMap();
    }
    
    @Override
    public SortedMap tailMap(final Object o) {
        Preconditions.checkNotNull(o);
        return new StandardRowSortedTable(this.this$0.sortedBackingMap().tailMap(o), this.this$0.factory).rowMap();
    }
}
