/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractTable;
import com.google.common.collect.GwtTransient;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$CellIterator;
import com.google.common.collect.StandardTable$Column;
import com.google.common.collect.StandardTable$ColumnKeyIterator;
import com.google.common.collect.StandardTable$ColumnKeySet;
import com.google.common.collect.StandardTable$ColumnMap;
import com.google.common.collect.StandardTable$Row;
import com.google.common.collect.StandardTable$RowMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class StandardTable
extends AbstractTable
implements Serializable {
    @GwtTransient
    final Map backingMap;
    @GwtTransient
    final Supplier factory;
    private transient Set columnKeySet;
    private transient Map rowMap;
    private transient StandardTable$ColumnMap columnMap;
    private static final long serialVersionUID = 0;

    StandardTable(Map map, Supplier supplier) {
        this.backingMap = map;
        this.factory = supplier;
    }

    @Override
    public boolean contains(@Nullable Object object, @Nullable Object object2) {
        if (object == null) return false;
        if (object2 == null) return false;
        if (!super.contains(object, object2)) return false;
        return true;
    }

    @Override
    public boolean containsColumn(@Nullable Object object) {
        Map map;
        if (object == null) {
            return false;
        }
        Iterator iterator = this.backingMap.values().iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!Maps.safeContainsKey(map = (Map)iterator.next(), object));
        return true;
    }

    @Override
    public boolean containsRow(@Nullable Object object) {
        if (object == null) return false;
        if (!Maps.safeContainsKey(this.backingMap, object)) return false;
        return true;
    }

    @Override
    public boolean containsValue(@Nullable Object object) {
        if (object == null) return false;
        if (!super.containsValue(object)) return false;
        return true;
    }

    @Override
    public Object get(@Nullable Object object, @Nullable Object object2) {
        if (object == null) return null;
        if (object2 == null) return null;
        Object object3 = super.get(object, object2);
        return object3;
    }

    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override
    public int size() {
        int n2 = 0;
        Iterator iterator = this.backingMap.values().iterator();
        while (iterator.hasNext()) {
            Map map = (Map)iterator.next();
            n2 += map.size();
        }
        return n2;
    }

    @Override
    public void clear() {
        this.backingMap.clear();
    }

    private Map getOrCreate(Object object) {
        Map map = (Map)this.backingMap.get(object);
        if (map != null) return map;
        map = (Map)this.factory.get();
        this.backingMap.put(object, map);
        return map;
    }

    @Override
    public Object put(Object object, Object object2, Object object3) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Preconditions.checkNotNull(object3);
        return this.getOrCreate(object).put(object2, object3);
    }

    @Override
    public Object remove(@Nullable Object object, @Nullable Object object2) {
        if (object == null) return null;
        if (object2 == null) {
            return null;
        }
        Map map = (Map)Maps.safeGet(this.backingMap, object);
        if (map == null) {
            return null;
        }
        Object v2 = map.remove(object2);
        if (!map.isEmpty()) return v2;
        this.backingMap.remove(object);
        return v2;
    }

    private Map removeColumn(Object object) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = this.backingMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            Object v2 = ((Map)entry.getValue()).remove(object);
            if (v2 == null) continue;
            linkedHashMap.put(entry.getKey(), v2);
            if (!((Map)entry.getValue()).isEmpty()) continue;
            iterator.remove();
        }
        return linkedHashMap;
    }

    private boolean containsMapping(Object object, Object object2, Object object3) {
        if (object3 == null) return false;
        if (!object3.equals(this.get(object, object2))) return false;
        return true;
    }

    private boolean removeMapping(Object object, Object object2, Object object3) {
        if (!this.containsMapping(object, object2, object3)) return false;
        this.remove(object, object2);
        return true;
    }

    @Override
    public Set cellSet() {
        return super.cellSet();
    }

    @Override
    Iterator cellIterator() {
        return new StandardTable$CellIterator(this, null);
    }

    @Override
    public Map row(Object object) {
        return new StandardTable$Row(this, object);
    }

    @Override
    public Map column(Object object) {
        return new StandardTable$Column(this, object);
    }

    @Override
    public Set rowKeySet() {
        return this.rowMap().keySet();
    }

    @Override
    public Set columnKeySet() {
        Set set;
        Set set2 = this.columnKeySet;
        if (set2 == null) {
            set = this.columnKeySet = new StandardTable$ColumnKeySet(this, null);
            return set;
        }
        set = set2;
        return set;
    }

    Iterator createColumnKeyIterator() {
        return new StandardTable$ColumnKeyIterator(this, null);
    }

    @Override
    public Collection values() {
        return super.values();
    }

    @Override
    public Map rowMap() {
        Map map;
        Map map2 = this.rowMap;
        if (map2 == null) {
            map = this.rowMap = this.createRowMap();
            return map;
        }
        map = map2;
        return map;
    }

    Map createRowMap() {
        return new StandardTable$RowMap(this);
    }

    @Override
    public Map columnMap() {
        StandardTable$ColumnMap standardTable$ColumnMap;
        StandardTable$ColumnMap standardTable$ColumnMap2 = this.columnMap;
        if (standardTable$ColumnMap2 == null) {
            standardTable$ColumnMap = this.columnMap = new StandardTable$ColumnMap(this, null);
            return standardTable$ColumnMap;
        }
        standardTable$ColumnMap = standardTable$ColumnMap2;
        return standardTable$ColumnMap;
    }

    static /* synthetic */ boolean access$300(StandardTable standardTable, Object object, Object object2, Object object3) {
        return standardTable.containsMapping(object, object2, object3);
    }

    static /* synthetic */ boolean access$400(StandardTable standardTable, Object object, Object object2, Object object3) {
        return standardTable.removeMapping(object, object2, object3);
    }

    static /* synthetic */ Map access$900(StandardTable standardTable, Object object) {
        return standardTable.removeColumn(object);
    }
}

