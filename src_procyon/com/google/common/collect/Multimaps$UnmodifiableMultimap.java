package com.google.common.collect;

import java.io.*;
import java.util.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;

class Multimaps$UnmodifiableMultimap extends ForwardingMultimap implements Serializable
{
    final Multimap delegate;
    transient Collection entries;
    transient Multiset keys;
    transient Set keySet;
    transient Collection values;
    transient Map map;
    private static final long serialVersionUID = 0L;
    
    Multimaps$UnmodifiableMultimap(final Multimap multimap) {
        this.delegate = (Multimap)Preconditions.checkNotNull(multimap);
    }
    
    @Override
    protected Multimap delegate() {
        return this.delegate;
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Map asMap() {
        Map<Object, Object> map = (Map<Object, Object>)this.map;
        if (map == null) {
            final Map<Object, Object> unmodifiableMap = Collections.unmodifiableMap((Map<?, ?>)Maps.transformValues(this.delegate.asMap(), new Multimaps$UnmodifiableMultimap$1(this)));
            this.map = unmodifiableMap;
            map = unmodifiableMap;
        }
        return map;
    }
    
    @Override
    public Collection entries() {
        Collection entries = this.entries;
        if (entries == null) {
            entries = (this.entries = unmodifiableEntries(this.delegate.entries()));
        }
        return entries;
    }
    
    @Override
    public Collection get(final Object o) {
        return unmodifiableValueCollection(this.delegate.get(o));
    }
    
    @Override
    public Multiset keys() {
        Multiset keys = this.keys;
        if (keys == null) {
            keys = (this.keys = Multisets.unmodifiableMultiset(this.delegate.keys()));
        }
        return keys;
    }
    
    @Override
    public Set keySet() {
        Set keySet = this.keySet;
        if (keySet == null) {
            keySet = (this.keySet = Collections.unmodifiableSet((Set<?>)this.delegate.keySet()));
        }
        return keySet;
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
    public boolean remove(final Object o, final Object o2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Collection removeAll(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Collection replaceValues(final Object o, final Iterable iterable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Collection values() {
        Collection values = this.values;
        if (values == null) {
            values = (this.values = Collections.unmodifiableCollection((Collection<?>)this.delegate.values()));
        }
        return values;
    }
}
