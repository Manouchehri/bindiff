package com.google.common.collect;

import java.util.*;
import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

final class Tables$UnmodifiableRowSortedMap extends Tables$UnmodifiableTable implements RowSortedTable
{
    private static final long serialVersionUID = 0L;
    
    public Tables$UnmodifiableRowSortedMap(final RowSortedTable rowSortedTable) {
        super(rowSortedTable);
    }
    
    @Override
    protected RowSortedTable delegate() {
        return (RowSortedTable)super.delegate();
    }
    
    @Override
    public SortedMap rowMap() {
        return Collections.unmodifiableSortedMap((SortedMap<Object, ?>)Maps.transformValues(this.delegate().rowMap(), unmodifiableWrapper()));
    }
    
    @Override
    public SortedSet rowKeySet() {
        return Collections.unmodifiableSortedSet((SortedSet<Object>)this.delegate().rowKeySet());
    }
}
