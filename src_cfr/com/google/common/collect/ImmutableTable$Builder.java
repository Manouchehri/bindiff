/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.SingletonImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$ImmutableCell;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class ImmutableTable$Builder {
    private final List cells = Lists.newArrayList();
    private Comparator rowComparator;
    private Comparator columnComparator;

    public ImmutableTable$Builder orderRowsBy(Comparator comparator) {
        this.rowComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }

    public ImmutableTable$Builder orderColumnsBy(Comparator comparator) {
        this.columnComparator = (Comparator)Preconditions.checkNotNull(comparator);
        return this;
    }

    public ImmutableTable$Builder put(Object object, Object object2, Object object3) {
        this.cells.add(ImmutableTable.cellOf(object, object2, object3));
        return this;
    }

    public ImmutableTable$Builder put(Table$Cell table$Cell) {
        if (table$Cell instanceof Tables.ImmutableCell) {
            Preconditions.checkNotNull(table$Cell.getRowKey());
            Preconditions.checkNotNull(table$Cell.getColumnKey());
            Preconditions.checkNotNull(table$Cell.getValue());
            Table$Cell table$Cell2 = table$Cell;
            this.cells.add(table$Cell2);
            return this;
        }
        this.put(table$Cell.getRowKey(), table$Cell.getColumnKey(), table$Cell.getValue());
        return this;
    }

    public ImmutableTable$Builder putAll(Table table) {
        Iterator iterator = table.cellSet().iterator();
        while (iterator.hasNext()) {
            Table$Cell table$Cell = (Table$Cell)iterator.next();
            this.put(table$Cell);
        }
        return this;
    }

    public ImmutableTable build() {
        int n2 = this.cells.size();
        switch (n2) {
            case 0: {
                return ImmutableTable.of();
            }
            case 1: {
                return new SingletonImmutableTable((Table$Cell)Iterables.getOnlyElement(this.cells));
            }
        }
        return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
    }
}

