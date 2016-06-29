/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table$Cell;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
class SingletonImmutableTable
extends ImmutableTable {
    final Object singleRowKey;
    final Object singleColumnKey;
    final Object singleValue;

    SingletonImmutableTable(Object object, Object object2, Object object3) {
        this.singleRowKey = Preconditions.checkNotNull(object);
        this.singleColumnKey = Preconditions.checkNotNull(object2);
        this.singleValue = Preconditions.checkNotNull(object3);
    }

    SingletonImmutableTable(Table$Cell table$Cell) {
        this(table$Cell.getRowKey(), table$Cell.getColumnKey(), table$Cell.getValue());
    }

    @Override
    public ImmutableMap column(Object object) {
        ImmutableMap immutableMap;
        Preconditions.checkNotNull(object);
        if (this.containsColumn(object)) {
            immutableMap = ImmutableMap.of(this.singleRowKey, this.singleValue);
            return immutableMap;
        }
        immutableMap = ImmutableMap.of();
        return immutableMap;
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
        return ImmutableSet.of(SingletonImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override
    ImmutableCollection createValues() {
        return ImmutableSet.of(this.singleValue);
    }
}

