package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

@GwtCompatible(emulated = true)
abstract class AbstractBiMap extends ForwardingMap implements BiMap, Serializable
{
    private transient Map delegate;
    transient AbstractBiMap inverse;
    private transient Set keySet;
    private transient Set valueSet;
    private transient Set entrySet;
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    AbstractBiMap(final Map map, final Map map2) {
        this.setDelegates(map, map2);
    }
    
    private AbstractBiMap(final Map delegate, final AbstractBiMap inverse) {
        this.delegate = delegate;
        this.inverse = inverse;
    }
    
    @Override
    protected Map delegate() {
        return this.delegate;
    }
    
    Object checkKey(@Nullable final Object o) {
        return o;
    }
    
    Object checkValue(@Nullable final Object o) {
        return o;
    }
    
    void setDelegates(final Map delegate, final Map map) {
        Preconditions.checkState(this.delegate == null);
        Preconditions.checkState(this.inverse == null);
        Preconditions.checkArgument(delegate.isEmpty());
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(delegate != map);
        this.delegate = delegate;
        this.inverse = new AbstractBiMap$Inverse(map, this, null);
    }
    
    void setInverse(final AbstractBiMap inverse) {
        this.inverse = inverse;
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        return this.inverse.containsKey(o);
    }
    
    @Override
    public Object put(@Nullable final Object o, @Nullable final Object o2) {
        return this.putInBothMaps(o, o2, false);
    }
    
    @Override
    public Object forcePut(@Nullable final Object o, @Nullable final Object o2) {
        return this.putInBothMaps(o, o2, true);
    }
    
    private Object putInBothMaps(@Nullable final Object o, @Nullable final Object o2, final boolean b) {
        this.checkKey(o);
        this.checkValue(o2);
        final boolean containsKey = this.containsKey(o);
        if (containsKey && Objects.equal(o2, this.get(o))) {
            return o2;
        }
        if (b) {
            this.inverse().remove(o2);
        }
        else {
            Preconditions.checkArgument(!this.containsValue(o2), "value already present: %s", o2);
        }
        final Object put = this.delegate.put(o, o2);
        this.updateInverseMap(o, containsKey, put, o2);
        return put;
    }
    
    private void updateInverseMap(final Object o, final boolean b, final Object o2, final Object o3) {
        if (b) {
            this.removeFromInverseMap(o2);
        }
        this.inverse.delegate.put(o3, o);
    }
    
    @Override
    public Object remove(@Nullable final Object o) {
        return this.containsKey(o) ? this.removeFromBothMaps(o) : null;
    }
    
    private Object removeFromBothMaps(final Object o) {
        final Object remove = this.delegate.remove(o);
        this.removeFromInverseMap(remove);
        return remove;
    }
    
    private void removeFromInverseMap(final Object o) {
        this.inverse.delegate.remove(o);
    }
    
    @Override
    public void putAll(final Map map) {
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
    
    @Override
    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }
    
    @Override
    public BiMap inverse() {
        return this.inverse;
    }
    
    @Override
    public Set keySet() {
        final Set keySet = this.keySet;
        return (keySet == null) ? (this.keySet = new AbstractBiMap$KeySet(this, null)) : keySet;
    }
    
    @Override
    public Set values() {
        final Set valueSet = this.valueSet;
        return (valueSet == null) ? (this.valueSet = new AbstractBiMap$ValueSet(this, null)) : valueSet;
    }
    
    @Override
    public Set entrySet() {
        final Set entrySet = this.entrySet;
        return (entrySet == null) ? (this.entrySet = new AbstractBiMap$EntrySet(this, null)) : entrySet;
    }
}
