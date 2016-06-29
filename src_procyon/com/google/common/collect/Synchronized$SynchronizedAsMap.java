package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedAsMap extends Synchronized$SynchronizedMap
{
    transient Set asMapEntrySet;
    transient Collection asMapValues;
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedAsMap(final Map map, @Nullable final Object o) {
        super(map, o);
    }
    
    @Override
    public Collection get(final Object o) {
        synchronized (this.mutex) {
            final Collection collection = (Collection)super.get(o);
            return (collection == null) ? null : typePreservingCollection(collection, this.mutex);
        }
    }
    
    @Override
    public Set entrySet() {
        synchronized (this.mutex) {
            if (this.asMapEntrySet == null) {
                this.asMapEntrySet = new Synchronized$SynchronizedAsMapEntries(this.delegate().entrySet(), this.mutex);
            }
            return this.asMapEntrySet;
        }
    }
    
    @Override
    public Collection values() {
        synchronized (this.mutex) {
            if (this.asMapValues == null) {
                this.asMapValues = new Synchronized$SynchronizedAsMapValues(this.delegate().values(), this.mutex);
            }
            return this.asMapValues;
        }
    }
    
    @Override
    public boolean containsValue(final Object o) {
        return this.values().contains(o);
    }
}
