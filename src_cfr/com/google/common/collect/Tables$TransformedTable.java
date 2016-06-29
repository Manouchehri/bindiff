/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables$TransformedTable$1;
import com.google.common.collect.Tables$TransformedTable$2;
import com.google.common.collect.Tables$TransformedTable$3;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Tables$TransformedTable
extends AbstractTable {
    final Table fromTable;
    final Function function;

    Tables$TransformedTable(Table table, Function function) {
        this.fromTable = (Table)Preconditions.checkNotNull(table);
        this.function = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    public boolean contains(Object object, Object object2) {
        return this.fromTable.contains(object, object2);
    }

    @Override
    public Object get(Object object, Object object2) {
        if (!this.contains(object, object2)) return null;
        Object object3 = this.function.apply(this.fromTable.get(object, object2));
        return object3;
    }

    @Override
    public int size() {
        return this.fromTable.size();
    }

    @Override
    public void clear() {
        this.fromTable.clear();
    }

    @Override
    public Object put(Object object, Object object2, Object object3) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void putAll(Table table) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object object, Object object2) {
        if (!this.contains(object, object2)) return null;
        Object object3 = this.function.apply(this.fromTable.remove(object, object2));
        return object3;
    }

    @Override
    public Map row(Object object) {
        return Maps.transformValues(this.fromTable.row(object), this.function);
    }

    @Override
    public Map column(Object object) {
        return Maps.transformValues(this.fromTable.column(object), this.function);
    }

    Function cellFunction() {
        return new Tables$TransformedTable$1(this);
    }

    @Override
    Iterator cellIterator() {
        return Iterators.transform(this.fromTable.cellSet().iterator(), this.cellFunction());
    }

    @Override
    public Set rowKeySet() {
        return this.fromTable.rowKeySet();
    }

    @Override
    public Set columnKeySet() {
        return this.fromTable.columnKeySet();
    }

    @Override
    Collection createValues() {
        return Collections2.transform(this.fromTable.values(), this.function);
    }

    @Override
    public Map rowMap() {
        Tables$TransformedTable$2 tables$TransformedTable$2 = new Tables$TransformedTable$2(this);
        return Maps.transformValues(this.fromTable.rowMap(), (Function)tables$TransformedTable$2);
    }

    @Override
    public Map columnMap() {
        Tables$TransformedTable$3 tables$TransformedTable$3 = new Tables$TransformedTable$3(this);
        return Maps.transformValues(this.fromTable.columnMap(), (Function)tables$TransformedTable$3);
    }
}

