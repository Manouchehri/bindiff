package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedMap extends Synchronized$SynchronizedObject implements Map
{
    transient Set keySet;
    transient Collection values;
    transient Set entrySet;
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedMap(final Map map, @Nullable final Object o) {
        super(map, o);
    }
    
    @Override
    Map delegate() {
        return (Map)super.delegate();
    }
    
    @Override
    public void clear() {
        synchronized (this.mutex) {
            this.delegate().clear();
        }
    }
    
    @Override
    public boolean containsKey(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().containsKey(o);
        }
    }
    
    @Override
    public boolean containsValue(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().containsValue(o);
        }
    }
    
    @Override
    public Set entrySet() {
        synchronized (this.mutex) {
            if (this.entrySet == null) {
                this.entrySet = Synchronized.set(this.delegate().entrySet(), this.mutex);
            }
            return this.entrySet;
        }
    }
    
    @Override
    public Object get(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().get(o);
        }
    }
    
    @Override
    public boolean isEmpty() {
        synchronized (this.mutex) {
            return this.delegate().isEmpty();
        }
    }
    
    @Override
    public Set keySet() {
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = Synchronized.set(this.delegate().keySet(), this.mutex);
            }
            return this.keySet;
        }
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        synchronized (this.mutex) {
            return this.delegate().put(o, o2);
        }
    }
    
    @Override
    public void putAll(final Map map) {
        synchronized (this.mutex) {
            this.delegate().putAll(map);
        }
    }
    
    @Override
    public Object remove(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().remove(o);
        }
    }
    
    @Override
    public int size() {
        synchronized (this.mutex) {
            return this.delegate().size();
        }
    }
    
    @Override
    public Collection values() {
        synchronized (this.mutex) {
            if (this.values == null) {
                this.values = collection(this.delegate().values(), this.mutex);
            }
            return this.values;
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        synchronized (this.mutex) {
            return this.delegate().equals(o);
        }
    }
    
    @Override
    public int hashCode() {
        synchronized (this.mutex) {
            return this.delegate().hashCode();
        }
    }
}
