package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedMultiset extends Synchronized$SynchronizedCollection implements Multiset
{
    transient Set elementSet;
    transient Set entrySet;
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedMultiset(final Multiset multiset, @Nullable final Object o) {
        super(multiset, o, null);
    }
    
    @Override
    Multiset delegate() {
        return (Multiset)super.delegate();
    }
    
    @Override
    public int count(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().count(o);
        }
    }
    
    @Override
    public int add(final Object o, final int n) {
        synchronized (this.mutex) {
            return this.delegate().add(o, n);
        }
    }
    
    @Override
    public int remove(final Object o, final int n) {
        synchronized (this.mutex) {
            return this.delegate().remove(o, n);
        }
    }
    
    @Override
    public int setCount(final Object o, final int n) {
        synchronized (this.mutex) {
            return this.delegate().setCount(o, n);
        }
    }
    
    @Override
    public boolean setCount(final Object o, final int n, final int n2) {
        synchronized (this.mutex) {
            return this.delegate().setCount(o, n, n2);
        }
    }
    
    @Override
    public Set elementSet() {
        synchronized (this.mutex) {
            if (this.elementSet == null) {
                this.elementSet = typePreservingSet(this.delegate().elementSet(), this.mutex);
            }
            return this.elementSet;
        }
    }
    
    @Override
    public Set entrySet() {
        synchronized (this.mutex) {
            if (this.entrySet == null) {
                this.entrySet = typePreservingSet(this.delegate().entrySet(), this.mutex);
            }
            return this.entrySet;
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
