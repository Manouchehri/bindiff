package com.google.common.collect;

import java.io.*;
import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

class Tables$UnmodifiableTable extends ForwardingTable implements Serializable
{
    final Table delegate;
    private static final long serialVersionUID = 0L;
    
    Tables$UnmodifiableTable(final Table table) {
        this.delegate = (Table)Preconditions.checkNotNull(table);
    }
    
    @Override
    protected Table delegate() {
        return this.delegate;
    }
    
    @Override
    public Set cellSet() {
        return Collections.unmodifiableSet((Set<?>)super.cellSet());
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Map column(@Nullable final Object o) {
        return Collections.unmodifiableMap((Map<?, ?>)super.column(o));
    }
    
    @Override
    public Set columnKeySet() {
        return Collections.unmodifiableSet((Set<?>)super.columnKeySet());
    }
    
    @Override
    public Map columnMap() {
        return Collections.unmodifiableMap((Map<?, ?>)Maps.transformValues(super.columnMap(), unmodifiableWrapper()));
    }
    
    @Override
    public Object put(@Nullable final Object o, @Nullable final Object o2, @Nullable final Object o3) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void putAll(final Table table) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Object remove(@Nullable final Object o, @Nullable final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Map row(@Nullable final Object o) {
        return Collections.unmodifiableMap((Map<?, ?>)super.row(o));
    }
    
    @Override
    public Set rowKeySet() {
        return Collections.unmodifiableSet((Set<?>)super.rowKeySet());
    }
    
    @Override
    public Map rowMap() {
        return Collections.unmodifiableMap((Map<?, ?>)Maps.transformValues(super.rowMap(), unmodifiableWrapper()));
    }
    
    @Override
    public Collection values() {
        return Collections.unmodifiableCollection((Collection<?>)super.values());
    }
}
