package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
class StandardRowSortedTable extends StandardTable implements RowSortedTable
{
    private static final long serialVersionUID = 0L;
    
    StandardRowSortedTable(final SortedMap sortedMap, final Supplier supplier) {
        super(sortedMap, supplier);
    }
    
    private SortedMap sortedBackingMap() {
        return (SortedMap)this.backingMap;
    }
    
    @Override
    public SortedSet rowKeySet() {
        return (SortedSet)this.rowMap().keySet();
    }
    
    @Override
    public SortedMap rowMap() {
        return (SortedMap)super.rowMap();
    }
    
    @Override
    SortedMap createRowMap() {
        return new StandardRowSortedTable$RowSortedMap(this, null);
    }
}
