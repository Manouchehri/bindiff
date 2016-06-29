package com.google.common.collect;

import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class Tables$TransposeTable extends AbstractTable
{
    final Table original;
    private static final Function TRANSPOSE_CELL;
    
    Tables$TransposeTable(final Table table) {
        this.original = (Table)Preconditions.checkNotNull(table);
    }
    
    @Override
    public void clear() {
        this.original.clear();
    }
    
    @Override
    public Map column(final Object o) {
        return this.original.row(o);
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
    public boolean contains(@Nullable final Object o, @Nullable final Object o2) {
        return this.original.contains(o2, o);
    }
    
    @Override
    public boolean containsColumn(@Nullable final Object o) {
        return this.original.containsRow(o);
    }
    
    @Override
    public boolean containsRow(@Nullable final Object o) {
        return this.original.containsColumn(o);
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return this.original.containsValue(o);
    }
    
    @Override
    public Object get(@Nullable final Object o, @Nullable final Object o2) {
        return this.original.get(o2, o);
    }
    
    @Override
    public Object put(final Object o, final Object o2, final Object o3) {
        return this.original.put(o2, o, o3);
    }
    
    @Override
    public void putAll(final Table table) {
        this.original.putAll(Tables.transpose(table));
    }
    
    @Override
    public Object remove(@Nullable final Object o, @Nullable final Object o2) {
        return this.original.remove(o2, o);
    }
    
    @Override
    public Map row(final Object o) {
        return this.original.column(o);
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
        return Iterators.transform(this.original.cellSet().iterator(), Tables$TransposeTable.TRANSPOSE_CELL);
    }
    
    static {
        TRANSPOSE_CELL = new Tables$TransposeTable$1();
    }
}
