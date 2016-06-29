package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
@Immutable
final class DenseImmutableTable extends RegularImmutableTable
{
    private final ImmutableMap rowKeyToIndex;
    private final ImmutableMap columnKeyToIndex;
    private final ImmutableMap rowMap;
    private final ImmutableMap columnMap;
    private final int[] rowCounts;
    private final int[] columnCounts;
    private final Object[][] values;
    private final int[] iterationOrderRow;
    private final int[] iterationOrderColumn;
    
    DenseImmutableTable(final ImmutableList list, final ImmutableSet set, final ImmutableSet set2) {
        this.values = new Object[set.size()][set2.size()];
        this.rowKeyToIndex = Maps.indexMap(set);
        this.columnKeyToIndex = Maps.indexMap(set2);
        this.rowCounts = new int[this.rowKeyToIndex.size()];
        this.columnCounts = new int[this.columnKeyToIndex.size()];
        final int[] iterationOrderRow = new int[list.size()];
        final int[] iterationOrderColumn = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            final Table$Cell table$Cell = list.get(i);
            final Object rowKey = table$Cell.getRowKey();
            final Object columnKey = table$Cell.getColumnKey();
            final int intValue = (int)this.rowKeyToIndex.get(rowKey);
            final int intValue2 = (int)this.columnKeyToIndex.get(columnKey);
            Preconditions.checkArgument(this.values[intValue][intValue2] == null, "duplicate key: (%s, %s)", rowKey, columnKey);
            this.values[intValue][intValue2] = table$Cell.getValue();
            final int[] rowCounts = this.rowCounts;
            final int n = intValue;
            ++rowCounts[n];
            final int[] columnCounts = this.columnCounts;
            final int n2 = intValue2;
            ++columnCounts[n2];
            iterationOrderRow[i] = intValue;
            iterationOrderColumn[i] = intValue2;
        }
        this.iterationOrderRow = iterationOrderRow;
        this.iterationOrderColumn = iterationOrderColumn;
        this.rowMap = new DenseImmutableTable$RowMap(this, null);
        this.columnMap = new DenseImmutableTable$ColumnMap(this, null);
    }
    
    @Override
    public ImmutableMap columnMap() {
        return this.columnMap;
    }
    
    @Override
    public ImmutableMap rowMap() {
        return this.rowMap;
    }
    
    @Override
    public Object get(@Nullable final Object o, @Nullable final Object o2) {
        final Integer n = (Integer)this.rowKeyToIndex.get(o);
        final Integer n2 = (Integer)this.columnKeyToIndex.get(o2);
        return (n == null || n2 == null) ? null : this.values[n][n2];
    }
    
    @Override
    public int size() {
        return this.iterationOrderRow.length;
    }
    
    @Override
    Table$Cell getCell(final int n) {
        final int n2 = this.iterationOrderRow[n];
        final int n3 = this.iterationOrderColumn[n];
        return ImmutableTable.cellOf(this.rowKeySet().asList().get(n2), this.columnKeySet().asList().get(n3), this.values[n2][n3]);
    }
    
    @Override
    Object getValue(final int n) {
        return this.values[this.iterationOrderRow[n]][this.iterationOrderColumn[n]];
    }
}
