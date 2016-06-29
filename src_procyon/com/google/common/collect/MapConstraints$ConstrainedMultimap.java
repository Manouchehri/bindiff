package com.google.common.collect;

import java.io.*;
import com.google.errorprone.annotations.concurrent.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.*;

class MapConstraints$ConstrainedMultimap extends ForwardingMultimap implements Serializable
{
    final MapConstraint constraint;
    final Multimap delegate;
    @LazyInit
    transient Collection entries;
    @LazyInit
    transient Map asMap;
    
    public MapConstraints$ConstrainedMultimap(final Multimap multimap, final MapConstraint mapConstraint) {
        this.delegate = (Multimap)Preconditions.checkNotNull(multimap);
        this.constraint = (MapConstraint)Preconditions.checkNotNull(mapConstraint);
    }
    
    @Override
    protected Multimap delegate() {
        return this.delegate;
    }
    
    @Override
    public Map asMap() {
        Map asMap = this.asMap;
        if (asMap == null) {
            asMap = (this.asMap = new MapConstraints$ConstrainedMultimap$1AsMap(this, this.delegate.asMap()));
        }
        return asMap;
    }
    
    @Override
    public Collection entries() {
        Collection entries = this.entries;
        if (entries == null) {
            entries = (this.entries = constrainedEntries(this.delegate.entries(), this.constraint));
        }
        return entries;
    }
    
    @Override
    public Collection get(final Object o) {
        return Constraints.constrainedTypePreservingCollection(this.delegate.get(o), new MapConstraints$ConstrainedMultimap$1(this, o));
    }
    
    @Override
    public boolean put(final Object o, final Object o2) {
        this.constraint.checkKeyValue(o, o2);
        return this.delegate.put(o, o2);
    }
    
    @Override
    public boolean putAll(final Object o, final Iterable iterable) {
        return this.delegate.putAll(o, checkValues(o, iterable, this.constraint));
    }
    
    @Override
    public boolean putAll(final Multimap multimap) {
        boolean b = false;
        for (final Map.Entry<Object, V> entry : multimap.entries()) {
            b |= this.put(entry.getKey(), entry.getValue());
        }
        return b;
    }
    
    @Override
    public Collection replaceValues(final Object o, final Iterable iterable) {
        return this.delegate.replaceValues(o, checkValues(o, iterable, this.constraint));
    }
}
