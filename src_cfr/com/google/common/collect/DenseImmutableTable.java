/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.Immutable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.DenseImmutableTable$1;
import com.google.common.collect.DenseImmutableTable$ColumnMap;
import com.google.common.collect.DenseImmutableTable$RowMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.Table$Cell;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class DenseImmutableTable
extends RegularImmutableTable {
    private final ImmutableMap rowKeyToIndex;
    private final ImmutableMap columnKeyToIndex;
    private final ImmutableMap rowMap;
    private final ImmutableMap columnMap;
    private final int[] rowCounts;
    private final int[] columnCounts;
    private final Object[][] values;
    private final int[] iterationOrderRow;
    private final int[] iterationOrderColumn;

    DenseImmutableTable(ImmutableList immutableList, ImmutableSet immutableSet, ImmutableSet immutableSet2) {
        Object[][] arrobject;
        this.values = arrobject = new Object[immutableSet.size()][immutableSet2.size()];
        this.rowKeyToIndex = Maps.indexMap(immutableSet);
        this.columnKeyToIndex = Maps.indexMap(immutableSet2);
        this.rowCounts = new int[this.rowKeyToIndex.size()];
        this.columnCounts = new int[this.columnKeyToIndex.size()];
        int[] arrn = new int[immutableList.size()];
        int[] arrn2 = new int[immutableList.size()];
        int n2 = 0;
        do {
            int n3;
            if (n2 >= immutableList.size()) {
                this.iterationOrderRow = arrn;
                this.iterationOrderColumn = arrn2;
                this.rowMap = new DenseImmutableTable$RowMap(this, null);
                this.columnMap = new DenseImmutableTable$ColumnMap(this, null);
                return;
            }
            Table$Cell table$Cell = (Table$Cell)immutableList.get(n2);
            Object object = table$Cell.getRowKey();
            Object object2 = table$Cell.getColumnKey();
            int n4 = (Integer)this.rowKeyToIndex.get(object);
            Object object3 = this.values[n4][n3 = ((Integer)this.columnKeyToIndex.get(object2)).intValue()];
            Preconditions.checkArgument(object3 == null, "duplicate key: (%s, %s)", object, object2);
            this.values[n4][n3] = table$Cell.getValue();
            int[] arrn3 = this.rowCounts;
            int n5 = n4;
            arrn3[n5] = arrn3[n5] + 1;
            int[] arrn4 = this.columnCounts;
            int n6 = n3;
            arrn4[n6] = arrn4[n6] + 1;
            arrn[n2] = n4;
            arrn2[n2] = n3;
            ++n2;
        } while (true);
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
    public Object get(@Nullable Object object, @Nullable Object object2) {
        Integer n2 = (Integer)this.rowKeyToIndex.get(object);
        Integer n3 = (Integer)this.columnKeyToIndex.get(object2);
        if (n2 == null) return null;
        if (n3 == null) return null;
        Object object3 = this.values[n2][n3];
        return object3;
    }

    @Override
    public int size() {
        return this.iterationOrderRow.length;
    }

    @Override
    Table$Cell getCell(int n2) {
        int n3 = this.iterationOrderRow[n2];
        int n4 = this.iterationOrderColumn[n2];
        Object e2 = this.rowKeySet().asList().get(n3);
        Object e3 = this.columnKeySet().asList().get(n4);
        Object object = this.values[n3][n4];
        return DenseImmutableTable.cellOf(e2, e3, object);
    }

    @Override
    Object getValue(int n2) {
        return this.values[this.iterationOrderRow[n2]][this.iterationOrderColumn[n2]];
    }

    static /* synthetic */ int[] access$200(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.rowCounts;
    }

    static /* synthetic */ ImmutableMap access$300(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.columnKeyToIndex;
    }

    static /* synthetic */ Object[][] access$400(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.values;
    }

    static /* synthetic */ int[] access$500(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.columnCounts;
    }

    static /* synthetic */ ImmutableMap access$600(DenseImmutableTable denseImmutableTable) {
        return denseImmutableTable.rowKeyToIndex;
    }
}

