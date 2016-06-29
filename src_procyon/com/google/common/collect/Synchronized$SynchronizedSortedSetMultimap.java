package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

class Synchronized$SynchronizedSortedSetMultimap extends Synchronized$SynchronizedSetMultimap implements SortedSetMultimap
{
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedSortedSetMultimap(final SortedSetMultimap sortedSetMultimap, @Nullable final Object o) {
        super(sortedSetMultimap, o);
    }
    
    @Override
    SortedSetMultimap delegate() {
        return (SortedSetMultimap)super.delegate();
    }
    
    @Override
    public SortedSet get(final Object o) {
        synchronized (this.mutex) {
            return sortedSet(this.delegate().get(o), this.mutex);
        }
    }
    
    @Override
    public SortedSet removeAll(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().removeAll(o);
        }
    }
    
    @Override
    public SortedSet replaceValues(final Object o, final Iterable iterable) {
        synchronized (this.mutex) {
            return this.delegate().replaceValues(o, iterable);
        }
    }
    
    @Override
    public Comparator valueComparator() {
        synchronized (this.mutex) {
            return this.delegate().valueComparator();
        }
    }
}
