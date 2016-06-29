package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible
class StandardTable extends AbstractTable implements Serializable
{
    @GwtTransient
    final Map backingMap;
    @GwtTransient
    final Supplier factory;
    private transient Set columnKeySet;
    private transient Map rowMap;
    private transient StandardTable$ColumnMap columnMap;
    private static final long serialVersionUID = 0L;
    
    StandardTable(final Map backingMap, final Supplier factory) {
        this.backingMap = backingMap;
        this.factory = factory;
    }
    
    @Override
    public boolean contains(@Nullable final Object o, @Nullable final Object o2) {
        return o != null && o2 != null && super.contains(o, o2);
    }
    
    @Override
    public boolean containsColumn(@Nullable final Object o) {
        if (o == null) {
            return false;
        }
        final Iterator<Map> iterator = this.backingMap.values().iterator();
        while (iterator.hasNext()) {
            if (Maps.safeContainsKey(iterator.next(), o)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean containsRow(@Nullable final Object o) {
        return o != null && Maps.safeContainsKey(this.backingMap, o);
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return o != null && super.containsValue(o);
    }
    
    @Override
    public Object get(@Nullable final Object o, @Nullable final Object o2) {
        return (o == null || o2 == null) ? null : super.get(o, o2);
    }
    
    @Override
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }
    
    @Override
    public int size() {
        int n = 0;
        final Iterator<Map> iterator = this.backingMap.values().iterator();
        while (iterator.hasNext()) {
            n += iterator.next().size();
        }
        return n;
    }
    
    @Override
    public void clear() {
        this.backingMap.clear();
    }
    
    private Map getOrCreate(final Object o) {
        Map map = this.backingMap.get(o);
        if (map == null) {
            map = (Map)this.factory.get();
            this.backingMap.put(o, map);
        }
        return map;
    }
    
    @Override
    public Object put(final Object o, final Object o2, final Object o3) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        Preconditions.checkNotNull(o3);
        return this.getOrCreate(o).put(o2, o3);
    }
    
    @Override
    public Object remove(@Nullable final Object o, @Nullable final Object o2) {
        if (o == null || o2 == null) {
            return null;
        }
        final Map map = (Map)Maps.safeGet(this.backingMap, o);
        if (map == null) {
            return null;
        }
        final Object remove = map.remove(o2);
        if (map.isEmpty()) {
            this.backingMap.remove(o);
        }
        return remove;
    }
    
    private Map removeColumn(final Object o) {
        final LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        final Iterator<Map.Entry<K, Map>> iterator = this.backingMap.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<K, Map> entry = iterator.next();
            final Object remove = entry.getValue().remove(o);
            if (remove != null) {
                linkedHashMap.put(entry.getKey(), remove);
                if (!entry.getValue().isEmpty()) {
                    continue;
                }
                iterator.remove();
            }
        }
        return linkedHashMap;
    }
    
    private boolean containsMapping(final Object o, final Object o2, final Object o3) {
        return o3 != null && o3.equals(this.get(o, o2));
    }
    
    private boolean removeMapping(final Object o, final Object o2, final Object o3) {
        if (this.containsMapping(o, o2, o3)) {
            this.remove(o, o2);
            return true;
        }
        return false;
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
    public Map row(final Object o) {
        return new StandardTable$Row(this, o);
    }
    
    @Override
    public Map column(final Object o) {
        return new StandardTable$Column(this, o);
    }
    
    @Override
    public Set rowKeySet() {
        return this.rowMap().keySet();
    }
    
    @Override
    public Set columnKeySet() {
        final Set columnKeySet = this.columnKeySet;
        return (columnKeySet == null) ? (this.columnKeySet = new StandardTable$ColumnKeySet(this, null)) : columnKeySet;
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
        final Map rowMap = this.rowMap;
        return (rowMap == null) ? (this.rowMap = this.createRowMap()) : rowMap;
    }
    
    Map createRowMap() {
        return new StandardTable$RowMap(this);
    }
    
    @Override
    public Map columnMap() {
        final StandardTable$ColumnMap columnMap = this.columnMap;
        return (columnMap == null) ? (this.columnMap = new StandardTable$ColumnMap(this, null)) : columnMap;
    }
}
