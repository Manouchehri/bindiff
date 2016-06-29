package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class Synchronized$SynchronizedAsMapEntries extends Synchronized$SynchronizedSet
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedAsMapEntries(final Set set, @Nullable final Object o) {
        super(set, o);
    }
    
    @Override
    public Iterator iterator() {
        return new Synchronized$SynchronizedAsMapEntries$1(this, super.iterator());
    }
    
    @Override
    public Object[] toArray() {
        synchronized (this.mutex) {
            return ObjectArrays.toArrayImpl(this.delegate());
        }
    }
    
    @Override
    public Object[] toArray(final Object[] array) {
        synchronized (this.mutex) {
            return ObjectArrays.toArrayImpl(this.delegate(), array);
        }
    }
    
    @Override
    public boolean contains(final Object o) {
        synchronized (this.mutex) {
            return Maps.containsEntryImpl(this.delegate(), o);
        }
    }
    
    @Override
    public boolean containsAll(final Collection collection) {
        synchronized (this.mutex) {
            return Collections2.containsAllImpl(this.delegate(), collection);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        synchronized (this.mutex) {
            return Sets.equalsImpl(this.delegate(), o);
        }
    }
    
    @Override
    public boolean remove(final Object o) {
        synchronized (this.mutex) {
            return Maps.removeEntryImpl(this.delegate(), o);
        }
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        synchronized (this.mutex) {
            return Iterators.removeAll(this.delegate().iterator(), collection);
        }
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        synchronized (this.mutex) {
            return Iterators.retainAll(this.delegate().iterator(), collection);
        }
    }
}
