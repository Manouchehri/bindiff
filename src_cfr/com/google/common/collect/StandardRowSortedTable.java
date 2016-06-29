/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.StandardRowSortedTable$1;
import com.google.common.collect.StandardRowSortedTable$RowSortedMap;
import com.google.common.collect.StandardTable;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
class StandardRowSortedTable
extends StandardTable
implements RowSortedTable {
    private static final long serialVersionUID = 0;

    StandardRowSortedTable(SortedMap sortedMap, Supplier supplier) {
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

    static /* synthetic */ SortedMap access$100(StandardRowSortedTable standardRowSortedTable) {
        return standardRowSortedTable.sortedBackingMap();
    }
}

