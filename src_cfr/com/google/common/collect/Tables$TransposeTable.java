/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.Iterators;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$TransposeTable$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Tables$TransposeTable
extends AbstractTable {
    final Table original;
    private static final Function TRANSPOSE_CELL = new Tables$TransposeTable$1();

    Tables$TransposeTable(Table table) {
        this.original = (Table)Preconditions.checkNotNull(table);
    }

    @Override
    public void clear() {
        this.original.clear();
    }

    @Override
    public Map column(Object object) {
        return this.original.row(object);
    }

    @Override
    public Set columnKeySet() {
        return this.original.rowKeySet();
    }

    @Override
    public Map columnMap() {
        return this.original.rowMap();
    }

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        return this.original.contains(object2, object);
    }

    @Override
    public boolean containsColumn(@Nullable Object object) {
        return this.original.containsRow(object);
    }

    @Override
    public boolean containsRow(@Nullable Object object) {
        return this.original.containsColumn(object);
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        return this.original.containsValue(object);
    }

    @Override
    public Object get(@Nullable Object object, @Nullable Object object2) {
        return this.original.get(object2, object);
    }

    @Override
    public Object put(Object object, Object object2, Object object3) {
        return this.original.put(object2, object, object3);
    }

    @Override
    public void putAll(Table table) {
        this.original.putAll(Tables.transpose(table));
    }

    @Override
    public Object remove(@Nullable Object object, @Nullable Object object2) {
        return this.original.remove(object2, object);
    }

    @Override
    public Map row(Object object) {
        return this.original.column(object);
    }

    @Override
    public Set rowKeySet() {
        return this.original.columnKeySet();
    }

    @Override
    public Map rowMap() {
        return this.original.columnMap();
    }

    @Override
    public int size() {
        return this.original.size();
    }

    @Override
    public Collection values() {
        return this.original.values();
    }

    @Override
    Iterator cellIterator() {
        return Iterators.transform(this.original.cellSet().iterator(), TRANSPOSE_CELL);
    }
}

