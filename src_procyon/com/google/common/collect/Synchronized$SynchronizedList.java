package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedList extends Synchronized$SynchronizedCollection implements List
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedList(final List list, @Nullable final Object o) {
        super(list, o, null);
    }
    
    @Override
    List delegate() {
        return (List)super.delegate();
    }
    
    @Override
    public void add(final int n, final Object o) {
        synchronized (this.mutex) {
            this.delegate().add(n, o);
        }
    }
    
    @Override
    public boolean addAll(final int n, final Collection collection) {
        synchronized (this.mutex) {
            return this.delegate().addAll(n, collection);
        }
    }
    
    @Override
    public Object get(final int n) {
        synchronized (this.mutex) {
            return this.delegate().get(n);
        }
    }
    
    @Override
    public int indexOf(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().indexOf(o);
        }
    }
    
    @Override
    public int lastIndexOf(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().lastIndexOf(o);
        }
    }
    
    @Override
    public ListIterator listIterator() {
        return this.delegate().listIterator();
    }
    
    @Override
    public ListIterator listIterator(final int n) {
        return this.delegate().listIterator(n);
    }
    
    @Override
    public Object remove(final int n) {
        synchronized (this.mutex) {
            return this.delegate().remove(n);
        }
    }
    
    @Override
    public Object set(final int n, final Object o) {
        synchronized (this.mutex) {
            return this.delegate().set(n, o);
        }
    }
    
    @Override
    public List subList(final int n, final int n2) {
        synchronized (this.mutex) {
            return list(this.delegate().subList(n, n2), this.mutex);
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
