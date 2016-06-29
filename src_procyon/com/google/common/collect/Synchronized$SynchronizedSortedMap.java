package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

class Synchronized$SynchronizedSortedMap extends Synchronized$SynchronizedMap implements SortedMap
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedSortedMap(final SortedMap sortedMap, @Nullable final Object o) {
        super(sortedMap, o);
    }
    
    @Override
    SortedMap delegate() {
        return (SortedMap)super.delegate();
    }
    
    @Override
    public Comparator comparator() {
        synchronized (this.mutex) {
            return this.delegate().comparator();
        }
    }
    
    @Override
    public Object firstKey() {
        synchronized (this.mutex) {
            return this.delegate().firstKey();
        }
    }
    
    @Override
    public SortedMap headMap(final Object o) {
        synchronized (this.mutex) {
            return Synchronized.sortedMap(this.delegate().headMap(o), this.mutex);
        }
    }
    
    @Override
    public Object lastKey() {
        synchronized (this.mutex) {
            return this.delegate().lastKey();
        }
    }
    
    @Override
    public SortedMap subMap(final Object o, final Object o2) {
        synchronized (this.mutex) {
            return Synchronized.sortedMap(this.delegate().subMap(o, o2), this.mutex);
        }
    }
    
    @Override
    public SortedMap tailMap(final Object o) {
        synchronized (this.mutex) {
            return Synchronized.sortedMap(this.delegate().tailMap(o), this.mutex);
        }
    }
}
