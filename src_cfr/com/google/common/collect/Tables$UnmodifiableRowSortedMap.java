/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$UnmodifiableTable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

final class Tables$UnmodifiableRowSortedMap
extends Tables$UnmodifiableTable
implements RowSortedTable {
    private static final long serialVersionUID = 0;

    public Tables$UnmodifiableRowSortedMap(RowSortedTable rowSortedTable) {
        super(rowSortedTable);
    }

    @Override
    protected RowSortedTable delegate() {
        return (RowSortedTable)super.delegate();
    }

    @Override
    public SortedMap rowMap() {
        Function function = Tables.access$000();
        return Collections.unmodifiableSortedMap(Maps.transformValues(this.delegate().rowMap(), function));
    }

    @Override
    public SortedSet rowKeySet() {
        return Collections.unmodifiableSortedSet(this.delegate().rowKeySet());
    }
}

