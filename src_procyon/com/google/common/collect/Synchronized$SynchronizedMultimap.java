package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedMultimap extends Synchronized$SynchronizedObject implements Multimap
{
    transient Set keySet;
    transient Collection valuesCollection;
    transient Collection entries;
    transient Map asMap;
    transient Multiset keys;
    private static final long serialVersionUID = 0L;
    
    @Override
    Multimap delegate() {
        return (Multimap)super.delegate();
    }
    
    Synchronized$SynchronizedMultimap(final Multimap multimap, @Nullable final Object o) {
        super(multimap, o);
    }
    
    @Override
    public int size() {
        synchronized (this.mutex) {
            return this.delegate().size();
        }
    }
    
    @Override
    public boolean isEmpty() {
        synchronized (this.mutex) {
            return this.delegate().isEmpty();
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
    public boolean containsEntry(final Object o, final Object o2) {
        synchronized (this.mutex) {
            return this.delegate().containsEntry(o, o2);
        }
    }
    
    @Override
    public Collection get(final Object o) {
        synchronized (this.mutex) {
            return typePreservingCollection(this.delegate().get(o), this.mutex);
        }
    }
    
    @Override
    public boolean put(final Object o, final Object o2) {
        synchronized (this.mutex) {
            return this.delegate().put(o, o2);
        }
    }
    
    @Override
    public boolean putAll(final Object o, final Iterable iterable) {
        synchronized (this.mutex) {
            return this.delegate().putAll(o, iterable);
        }
    }
    
    @Override
    public boolean putAll(final Multimap multimap) {
        synchronized (this.mutex) {
            return this.delegate().putAll(multimap);
        }
    }
    
    @Override
    public Collection replaceValues(final Object o, final Iterable iterable) {
        synchronized (this.mutex) {
            return this.delegate().replaceValues(o, iterable);
        }
    }
    
    @Override
    public boolean remove(final Object o, final Object o2) {
        synchronized (this.mutex) {
            return this.delegate().remove(o, o2);
        }
    }
    
    @Override
    public Collection removeAll(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().removeAll(o);
        }
    }
    
    @Override
    public void clear() {
        synchronized (this.mutex) {
            this.delegate().clear();
        }
    }
    
    @Override
    public Set keySet() {
        synchronized (this.mutex) {
            if (this.keySet == null) {
                this.keySet = typePreservingSet(this.delegate().keySet(), this.mutex);
            }
            return this.keySet;
        }
    }
    
    @Override
    public Collection values() {
        synchronized (this.mutex) {
            if (this.valuesCollection == null) {
                this.valuesCollection = collection(this.delegate().values(), this.mutex);
            }
            return this.valuesCollection;
        }
    }
    
    @Override
    public Collection entries() {
        synchronized (this.mutex) {
            if (this.entries == null) {
                this.entries = typePreservingCollection(this.delegate().entries(), this.mutex);
            }
            return this.entries;
        }
    }
    
    @Override
    public Map asMap() {
        synchronized (this.mutex) {
            if (this.asMap == null) {
                this.asMap = new Synchronized$SynchronizedAsMap(this.delegate().asMap(), this.mutex);
            }
            return this.asMap;
        }
    }
    
    @Override
    public Multiset keys() {
        synchronized (this.mutex) {
            if (this.keys == null) {
                this.keys = Synchronized.multiset(this.delegate().keys(), this.mutex);
            }
            return this.keys;
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
