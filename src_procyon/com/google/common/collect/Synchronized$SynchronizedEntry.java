package com.google.common.collect;

import java.util.*;
import com.google.common.annotations.*;
import javax.annotation.*;

@GwtIncompatible("works but is needed only for NavigableMap")
class Synchronized$SynchronizedEntry extends Synchronized$SynchronizedObject implements Entry
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedEntry(final Entry entry, @Nullable final Object o) {
        super(entry, o);
    }
    
    @Override
    Entry delegate() {
        return (Entry)super.delegate();
    }
    
    @Override
    public boolean equals(final Object o) {
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
    
    @Override
    public Object getKey() {
        synchronized (this.mutex) {
            return this.delegate().getKey();
        }
    }
    
    @Override
    public Object getValue() {
        synchronized (this.mutex) {
            return this.delegate().getValue();
        }
    }
    
    @Override
    public Object setValue(final Object value) {
        synchronized (this.mutex) {
            return this.delegate().setValue(value);
        }
    }
}
