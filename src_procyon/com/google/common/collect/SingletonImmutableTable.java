package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
class SingletonImmutableTable extends ImmutableTable
{
    final Object singleRowKey;
    final Object singleColumnKey;
    final Object singleValue;
    
    SingletonImmutableTable(final Object o, final Object o2, final Object o3) {
        this.singleRowKey = Preconditions.checkNotNull(o);
        this.singleColumnKey = Preconditions.checkNotNull(o2);
        this.singleValue = Preconditions.checkNotNull(o3);
    }
    
    SingletonImmutableTable(final Table$Cell table$Cell) {
        this(table$Cell.getRowKey(), table$Cell.getColumnKey(), table$Cell.getValue());
    }
    
    @Override
    public ImmutableMap column(final Object o) {
        Preconditions.checkNotNull(o);
        return this.containsColumn(o) ? ImmutableMap.of(this.singleRowKey, this.singleValue) : ImmutableMap.of();
    }
    
    @Override
    public ImmutableMap columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, this.singleValue));
    }
    
    @Override
    public ImmutableMap rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, this.singleValue));
    }
    
    @Override
    public int size() {
        return 1;
    }
    
    @Override
    ImmutableSet createCellSet() {
        return ImmutableSet.of(ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }
    
    @Override
    ImmutableCollection createValues() {
        return ImmutableSet.of(this.singleValue);
    }
}
