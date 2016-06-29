package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class Tables$TransformedTable extends AbstractTable
{
    final Table fromTable;
    final Function function;
    
    Tables$TransformedTable(final Table table, final Function function) {
        this.fromTable = (Table)Preconditions.checkNotNull(table);
        this.function = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    public boolean contains(final Object o, final Object o2) {
        return this.fromTable.contains(o, o2);
    }
    
    @Override
    public Object get(final Object o, final Object o2) {
        return this.contains(o, o2) ? this.function.apply(this.fromTable.get(o, o2)) : null;
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
    public Object put(final Object o, final Object o2, final Object o3) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void putAll(final Table table) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Object remove(final Object o, final Object o2) {
        return this.contains(o, o2) ? this.function.apply(this.fromTable.remove(o, o2)) : null;
    }
    
    @Override
    public Map row(final Object o) {
        return Maps.transformValues(this.fromTable.row(o), this.function);
    }
    
    @Override
    public Map column(final Object o) {
        return Maps.transformValues(this.fromTable.column(o), this.function);
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
        return Maps.transformValues(this.fromTable.rowMap(), new Tables$TransformedTable$2(this));
    }
    
    @Override
    public Map columnMap() {
        return Maps.transformValues(this.fromTable.columnMap(), new Tables$TransformedTable$3(this));
    }
}
