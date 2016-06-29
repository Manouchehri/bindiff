package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.*;
import java.util.*;

class ImmutableMapBuilder$ImmutableHashMap extends HashMap
{
    transient volatile Set keySet;
    transient volatile Collection values;
    transient volatile Set entrySet;
    @LazyInit
    transient Integer cachedHashCode;
    private static final long serialVersionUID = -5187626034923451074L;
    
    ImmutableMapBuilder$ImmutableHashMap(final int n) {
        super(n);
    }
    
    @Override
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = Collections.unmodifiableSet(super.keySet());
        }
        return this.keySet;
    }
    
    @Override
    public Collection values() {
        if (this.values == null) {
            this.values = Collections.unmodifiableCollection(super.values());
        }
        return this.values;
    }
    
    @Override
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = Maps.unmodifiableEntrySet(super.entrySet());
        }
        return this.entrySet;
    }
    
    @Override
    public int hashCode() {
        final Integer cachedHashCode = this.cachedHashCode;
        if (cachedHashCode == null) {
            final int hashCode = super.hashCode();
            this.cachedHashCode = hashCode;
            return hashCode;
        }
        return cachedHashCode;
    }
    
    private void secretPut(final Object o, final Object o2) {
        super.put(o, o2);
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        throw up();
    }
    
    @Override
    public void putAll(final Map map) {
        throw up();
    }
    
    @Override
    public Object remove(final Object o) {
        throw up();
    }
    
    @Override
    public void clear() {
        throw up();
    }
    
    static UnsupportedOperationException up() {
        return new UnsupportedOperationException();
    }
}
