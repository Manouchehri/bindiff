/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractTable$1;
import com.google.common.collect.AbstractTable$CellSet;
import com.google.common.collect.AbstractTable$Values;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractTable
implements Table {
    private transient Set cellSet;
    private transient Collection values;

    AbstractTable() {
    }

    @Override
    public boolean containsRow(@Nullable Object object) {
        return Maps.safeContainsKey(this.rowMap(), object);
    }

    @Override
    public boolean containsColumn(@Nullable Object object) {
        return Maps.safeContainsKey(this.columnMap(), object);
    }

    @Override
    public Set rowKeySet() {
        return this.rowMap().keySet();
    }

    @Override
    public Set columnKeySet() {
        return this.columnMap().keySet();
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        Map map;
        Iterator iterator = this.rowMap().values().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!(map = (Map)iterator.next()).containsValue(object));
        return true;
    }

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        Map map = (Map)Maps.safeGet(this.rowMap(), object);
        if (map == null) return false;
        if (!Maps.safeContainsKey(map, object2)) return false;
        return true;
    }

    @Override
    public Object get(@Nullable Object object, @Nullable Object object2) {
        Map map = (Map)Maps.safeGet(this.rowMap(), object);
        if (map == null) {
            return null;
        }
        Object object3 = Maps.safeGet(map, object2);
        return object3;
    }

    @Override
    public boolean isEmpty() {
        if (this.size() != 0) return false;
        return true;
    }

    @Override
    public void clear() {
        Iterators.clear(this.cellSet().iterator());
    }

    @Override
    public Object remove(@Nullable Object object, @Nullable Object object2) {
        Map map = (Map)Maps.safeGet(this.rowMap(), object);
        if (map == null) {
            return null;
        }
        Object object3 = Maps.safeRemove(map, object2);
        return object3;
    }

    @Override
    public Object put(Object object, Object object2, Object object3) {
        return this.row(object).put(object2, object3);
    }

    @Override
    public void putAll(Table table) {
        Iterator iterator = table.cellSet().iterator();
        while (iterator.hasNext()) {
            Table$Cell table$Cell = (Table$Cell)iterator.next();
            this.put(table$Cell.getRowKey(), table$Cell.getColumnKey(), table$Cell.getValue());
        }
    }

    @Override
    public Set cellSet() {
        Set set;
        Set set2 = this.cellSet;
        if (set2 == null) {
            set = this.cellSet = this.createCellSet();
            return set;
        }
        set = set2;
        return set;
    }

    Set createCellSet() {
        return new AbstractTable$CellSet(this);
    }

    abstract Iterator cellIterator();

    @Override
    public Collection values() {
        Collection collection;
        Collection collection2 = this.values;
        if (collection2 == null) {
            collection = this.values = this.createValues();
            return collection;
        }
        collection = collection2;
        return collection;
    }

    Collection createValues() {
        return new AbstractTable$Values(this);
    }

    Iterator valuesIterator() {
        return new AbstractTable$1(this, this.cellSet().iterator());
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Tables.equalsImpl(this, object);
    }

    @Override
    public int hashCode() {
        return this.cellSet().hashCode();
    }

    public String toString() {
        return this.rowMap().toString();
    }
}

