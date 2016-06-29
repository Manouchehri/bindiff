package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@VisibleForTesting
class Synchronized$SynchronizedBiMap extends Synchronized$SynchronizedMap implements BiMap, Serializable
{
    private transient Set valueSet;
    private transient BiMap inverse;
    private static final long serialVersionUID = 0L;
    
    private Synchronized$SynchronizedBiMap(final BiMap biMap, @Nullable final Object o, @Nullable final BiMap inverse) {
        super(biMap, o);
        this.inverse = inverse;
    }
    
    @Override
    BiMap delegate() {
        return (BiMap)super.delegate();
    }
    
    @Override
    public Set values() {
        synchronized (this.mutex) {
            if (this.valueSet == null) {
                this.valueSet = Synchronized.set(this.delegate().values(), this.mutex);
            }
            return this.valueSet;
        }
    }
    
    @Override
    public Object forcePut(final Object o, final Object o2) {
        synchronized (this.mutex) {
            return this.delegate().forcePut(o, o2);
        }
    }
    
    @Override
    public BiMap inverse() {
        synchronized (this.mutex) {
            if (this.inverse == null) {
                this.inverse = new Synchronized$SynchronizedBiMap(this.delegate().inverse(), this.mutex, this);
            }
            return this.inverse;
        }
    }
}
