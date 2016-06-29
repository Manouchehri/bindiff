package com.google.common.collect;

import java.io.*;
import com.google.common.base.*;
import java.util.*;

class Multimaps$MapMultimap extends AbstractMultimap implements SetMultimap, Serializable
{
    final Map map;
    private static final long serialVersionUID = 7845222491160860175L;
    
    Multimaps$MapMultimap(final Map map) {
        this.map = (Map)Preconditions.checkNotNull(map);
    }
    
    @Override
    public int size() {
        return this.map.size();
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.map.containsKey(o);
    }
    
    @Override
    public boolean containsValue(final Object o) {
        return this.map.containsValue(o);
    }
    
    @Override
    public boolean containsEntry(final Object o, final Object o2) {
        return this.map.entrySet().contains(Maps.immutableEntry(o, o2));
    }
    
    @Override
    public Set get(final Object o) {
        return new Multimaps$MapMultimap$1(this, o);
    }
    
    @Override
    public boolean put(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean putAll(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean putAll(final Multimap multimap) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Set replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean remove(final Object o, final Object o2) {
        return this.map.entrySet().remove(Maps.immutableEntry(o, o2));
    }
    
    @Override
    public Set removeAll(final Object o) {
        final HashSet<Object> set = new HashSet<Object>(2);
        if (!this.map.containsKey(o)) {
            return set;
        }
        set.add(this.map.remove(o));
        return set;
    }
    
    @Override
    public void clear() {
        this.map.clear();
    }
    
    @Override
    public Set keySet() {
        return this.map.keySet();
    }
    
    @Override
    public Collection values() {
        return this.map.values();
    }
    
    @Override
    public Set entries() {
        return this.map.entrySet();
    }
    
    @Override
    Iterator entryIterator() {
        return this.map.entrySet().iterator();
    }
    
    @Override
    Map createAsMap() {
        return new Multimaps$AsMap(this);
    }
    
    @Override
    public int hashCode() {
        return this.map.hashCode();
    }
}
