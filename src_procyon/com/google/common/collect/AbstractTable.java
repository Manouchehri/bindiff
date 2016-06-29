package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtCompatible
abstract class AbstractTable implements Table
{
    private transient Set cellSet;
    private transient Collection values;
    
    @Override
    public boolean containsRow(@Nullable final Object o) {
        return Maps.safeContainsKey(this.rowMap(), o);
    }
    
    @Override
    public boolean containsColumn(@Nullable final Object o) {
        return Maps.safeContainsKey(this.columnMap(), o);
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
    public boolean containsValue(@Nullable final Object o) {
        final Iterator<Map> iterator = this.rowMap().values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().containsValue(o)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean contains(@Nullable final Object o, @Nullable final Object o2) {
        final Map map = (Map)Maps.safeGet(this.rowMap(), o);
        return map != null && Maps.safeContainsKey(map, o2);
    }
    
    @Override
    public Object get(@Nullable final Object o, @Nullable final Object o2) {
        final Map map = (Map)Maps.safeGet(this.rowMap(), o);
        return (map == null) ? null : Maps.safeGet(map, o2);
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public void clear() {
        Iterators.clear(this.cellSet().iterator());
    }
    
    @Override
    public Object remove(@Nullable final Object o, @Nullable final Object o2) {
        final Map map = (Map)Maps.safeGet(this.rowMap(), o);
        return (map == null) ? null : Maps.safeRemove(map, o2);
    }
    
    @Override
    public Object put(final Object o, final Object o2, final Object o3) {
        return this.row(o).put(o2, o3);
    }
    
    @Override
    public void putAll(final Table table) {
        for (final Table$Cell table$Cell : table.cellSet()) {
            this.put(table$Cell.getRowKey(), table$Cell.getColumnKey(), table$Cell.getValue());
        }
    }
    
    @Override
    public Set cellSet() {
        final Set cellSet = this.cellSet;
        return (cellSet == null) ? (this.cellSet = this.createCellSet()) : cellSet;
    }
    
    Set createCellSet() {
        return new AbstractTable$CellSet(this);
    }
    
    abstract Iterator cellIterator();
    
    @Override
    public Collection values() {
        final Collection values = this.values;
        return (values == null) ? (this.values = this.createValues()) : values;
    }
    
    Collection createValues() {
        return new AbstractTable$Values(this);
    }
    
    Iterator valuesIterator() {
        return new AbstractTable$1(this, this.cellSet().iterator());
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return Tables.equalsImpl(this, o);
    }
    
    @Override
    public int hashCode() {
        return this.cellSet().hashCode();
    }
    
    @Override
    public String toString() {
        return this.rowMap().toString();
    }
}
