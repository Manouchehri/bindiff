package com.google.common.collect;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;

@GwtIncompatible("NavigableMap")
@VisibleForTesting
class Synchronized$SynchronizedNavigableMap extends Synchronized$SynchronizedSortedMap implements NavigableMap
{
    transient NavigableSet descendingKeySet;
    transient NavigableMap descendingMap;
    transient NavigableSet navigableKeySet;
    private static final long serialVersionUID = 0L;
    
    Synchronized$SynchronizedNavigableMap(final NavigableMap navigableMap, @Nullable final Object o) {
        super(navigableMap, o);
    }
    
    @Override
    NavigableMap delegate() {
        return (NavigableMap)super.delegate();
    }
    
    @Override
    public Entry ceilingEntry(final Object o) {
        synchronized (this.mutex) {
            return nullableSynchronizedEntry((Entry)this.delegate().ceilingEntry(o), this.mutex);
        }
    }
    
    @Override
    public Object ceilingKey(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().ceilingKey(o);
        }
    }
    
    @Override
    public NavigableSet descendingKeySet() {
        synchronized (this.mutex) {
            if (this.descendingKeySet == null) {
                return this.descendingKeySet = Synchronized.navigableSet(this.delegate().descendingKeySet(), this.mutex);
            }
            return this.descendingKeySet;
        }
    }
    
    @Override
    public NavigableMap descendingMap() {
        synchronized (this.mutex) {
            if (this.descendingMap == null) {
                return this.descendingMap = Synchronized.navigableMap(this.delegate().descendingMap(), this.mutex);
            }
            return this.descendingMap;
        }
    }
    
    @Override
    public Entry firstEntry() {
        synchronized (this.mutex) {
            return nullableSynchronizedEntry((Entry)this.delegate().firstEntry(), this.mutex);
        }
    }
    
    @Override
    public Entry floorEntry(final Object o) {
        synchronized (this.mutex) {
            return nullableSynchronizedEntry((Entry)this.delegate().floorEntry(o), this.mutex);
        }
    }
    
    @Override
    public Object floorKey(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().floorKey(o);
        }
    }
    
    @Override
    public NavigableMap headMap(final Object o, final boolean b) {
        synchronized (this.mutex) {
            return Synchronized.navigableMap(this.delegate().headMap(o, b), this.mutex);
        }
    }
    
    @Override
    public Entry higherEntry(final Object o) {
        synchronized (this.mutex) {
            return nullableSynchronizedEntry((Entry)this.delegate().higherEntry(o), this.mutex);
        }
    }
    
    @Override
    public Object higherKey(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().higherKey(o);
        }
    }
    
    @Override
    public Entry lastEntry() {
        synchronized (this.mutex) {
            return nullableSynchronizedEntry((Entry)this.delegate().lastEntry(), this.mutex);
        }
    }
    
    @Override
    public Entry lowerEntry(final Object o) {
        synchronized (this.mutex) {
            return nullableSynchronizedEntry((Entry)this.delegate().lowerEntry(o), this.mutex);
        }
    }
    
    @Override
    public Object lowerKey(final Object o) {
        synchronized (this.mutex) {
            return this.delegate().lowerKey(o);
        }
    }
    
    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }
    
    @Override
    public NavigableSet navigableKeySet() {
        synchronized (this.mutex) {
            if (this.navigableKeySet == null) {
                return this.navigableKeySet = Synchronized.navigableSet(this.delegate().navigableKeySet(), this.mutex);
            }
            return this.navigableKeySet;
        }
    }
    
    @Override
    public Entry pollFirstEntry() {
        synchronized (this.mutex) {
            return nullableSynchronizedEntry((Entry)this.delegate().pollFirstEntry(), this.mutex);
        }
    }
    
    @Override
    public Entry pollLastEntry() {
        synchronized (this.mutex) {
            return nullableSynchronizedEntry((Entry)this.delegate().pollLastEntry(), this.mutex);
        }
    }
    
    @Override
    public NavigableMap subMap(final Object o, final boolean b, final Object o2, final boolean b2) {
        synchronized (this.mutex) {
            return Synchronized.navigableMap(this.delegate().subMap(o, b, o2, b2), this.mutex);
        }
    }
    
    @Override
    public NavigableMap tailMap(final Object o, final boolean b) {
        synchronized (this.mutex) {
            return Synchronized.navigableMap(this.delegate().tailMap(o, b), this.mutex);
        }
    }
    
    @Override
    public SortedMap headMap(final Object o) {
        return this.headMap(o, false);
    }
    
    @Override
    public SortedMap subMap(final Object o, final Object o2) {
        return this.subMap(o, true, o2, false);
    }
    
    @Override
    public SortedMap tailMap(final Object o) {
        return this.tailMap(o, true);
    }
}
