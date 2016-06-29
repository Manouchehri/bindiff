package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@VisibleForTesting
class Synchronized$SynchronizedCollection extends Synchronized$SynchronizedObject implements Collection
{
    private static final long serialVersionUID = 0L;
    
    private Synchronized$SynchronizedCollection(final Collection collection, @Nullable final Object o) {
        super(collection, o);
    }
    
    @Override
    Collection delegate() {
        return (Collection)super.delegate();
    }
    
    @Override
    public boolean add(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().add(o);
        }
    }
    
    @Override
    public boolean addAll(final Collection collection) {
        synchronized (this.mutex) {
            return this.delegate().addAll(collection);
        }
    }
    
    @Override
    public void clear() {
        synchronized (this.mutex) {
            this.delegate().clear();
        }
    }
    
    @Override
    public boolean contains(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().contains(o);
        }
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        synchronized (this.mutex) {
            return this.delegate().containsAll(collection);
        }
    }
    
    @Override
    public boolean isEmpty() {
        synchronized (this.mutex) {
            return this.delegate().isEmpty();
        }
    }
    
    @Override
    public Iterator iterator() {
        return this.delegate().iterator();
    }
    
    @Override
    public boolean remove(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().remove(o);
        }
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        synchronized (this.mutex) {
            return this.delegate().removeAll(collection);
        }
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        synchronized (this.mutex) {
            return this.delegate().retainAll(collection);
        }
    }
    
    @Override
    public int size() {
        synchronized (this.mutex) {
            return this.delegate().size();
        }
    }
    
    @Override
    public Object[] toArray() {
        synchronized (this.mutex) {
            return this.delegate().toArray();
        }
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        synchronized (this.mutex) {
            return this.delegate().toArray(array);
        }
    }
}
