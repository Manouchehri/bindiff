package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedSortedSet extends Synchronized$SynchronizedSet implements SortedSet
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedSortedSet(final SortedSet set, @Nullable final Object o) {
        super(set, o);
    }
    
    @Override
    SortedSet delegate() {
        return (SortedSet)super.delegate();
    }
    
    @Override
    public Comparator comparator() {
        synchronized (this.mutex) {
            return this.delegate().comparator();
        }
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        synchronized (this.mutex) {
            return sortedSet(this.delegate().subSet(o, o2), this.mutex);
        }
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        synchronized (this.mutex) {
            return sortedSet(this.delegate().headSet(o), this.mutex);
        }
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        synchronized (this.mutex) {
            return sortedSet(this.delegate().tailSet(o), this.mutex);
        }
    }
    
    @Override
    public Object first() {
        synchronized (this.mutex) {
            return this.delegate().first();
        }
    }
    
    @Override
    public Object last() {
        synchronized (this.mutex) {
            return this.delegate().last();
        }
    }
}
