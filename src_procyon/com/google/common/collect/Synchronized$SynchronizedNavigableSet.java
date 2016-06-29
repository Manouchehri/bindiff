package com.google.common.collect;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.*;

@GwtIncompatible("NavigableSet")
@VisibleForTesting
class Synchronized$SynchronizedNavigableSet extends Synchronized$SynchronizedSortedSet implements NavigableSet
{
    transient NavigableSet descendingSet;
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedNavigableSet(final NavigableSet set, @Nullable final Object o) {
        super(set, o);
    }
    
    @Override
    NavigableSet delegate() {
        return (NavigableSet)super.delegate();
    }
    
    @Override
    public Object ceiling(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().ceiling(o);
        }
    }
    
    @Override
    public Iterator descendingIterator() {
        return this.delegate().descendingIterator();
    }
    
    @Override
    public NavigableSet descendingSet() {
        synchronized (this.mutex) {
            if (this.descendingSet == null) {
                return this.descendingSet = Synchronized.navigableSet(this.delegate().descendingSet(), this.mutex);
            }
            return this.descendingSet;
        }
    }
    
    @Override
    public Object floor(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().floor(o);
        }
    }
    
    @Override
    public NavigableSet headSet(final Object o, final boolean b) {
        synchronized (this.mutex) {
            return Synchronized.navigableSet(this.delegate().headSet(o, b), this.mutex);
        }
    }
    
    @Override
    public Object higher(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().higher(o);
        }
    }
    
    @Override
    public Object lower(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().lower(o);
        }
    }
    
    @Override
    public Object pollFirst() {
        synchronized (this.mutex) {
            return this.delegate().pollFirst();
        }
    }
    
    @Override
    public Object pollLast() {
        synchronized (this.mutex) {
            return this.delegate().pollLast();
        }
    }
    
    @Override
    public NavigableSet subSet(final Object o, final boolean b, final Object o2, final boolean b2) {
        synchronized (this.mutex) {
            return Synchronized.navigableSet(this.delegate().subSet(o, b, o2, b2), this.mutex);
        }
    }
    
    @Override
    public NavigableSet tailSet(final Object o, final boolean b) {
        synchronized (this.mutex) {
            return Synchronized.navigableSet(this.delegate().tailSet(o, b), this.mutex);
        }
    }
    
    @Override
    public SortedSet headSet(final Object o) {
        return this.headSet(o, false);
    }
    
    @Override
    public SortedSet subSet(final Object o, final Object o2) {
        return this.subSet(o, true, o2, false);
    }
    
    @Override
    public SortedSet tailSet(final Object o) {
        return this.tailSet(o, true);
    }
}
