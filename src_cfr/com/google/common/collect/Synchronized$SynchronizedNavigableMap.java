/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSortedMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtIncompatible(value="NavigableMap")
@VisibleForTesting
class Synchronized$SynchronizedNavigableMap
extends Synchronized$SynchronizedSortedMap
implements NavigableMap {
    transient NavigableSet descendingKeySet;
    transient NavigableMap descendingMap;
    transient NavigableSet navigableKeySet;
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedNavigableMap(NavigableMap navigableMap, @Nullable Object object) {
        super(navigableMap, object);
    }

    @Override
    NavigableMap delegate() {
        return (NavigableMap)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map.Entry ceilingEntry(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.access$700(this.delegate().ceilingEntry(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object ceilingKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().ceilingKey(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableSet descendingKeySet() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.descendingKeySet != null) return this.descendingKeySet;
            this.descendingKeySet = Synchronized.navigableSet(this.delegate().descendingKeySet(), this.mutex);
            return this.descendingKeySet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableMap descendingMap() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.descendingMap != null) return this.descendingMap;
            this.descendingMap = Synchronized.navigableMap(this.delegate().descendingMap(), this.mutex);
            return this.descendingMap;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map.Entry firstEntry() {
        Object object = this.mutex;
        synchronized (object) {
            return Synchronized.access$700(this.delegate().firstEntry(), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map.Entry floorEntry(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.access$700(this.delegate().floorEntry(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object floorKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().floorKey(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableMap headMap(Object object, boolean bl2) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.navigableMap(this.delegate().headMap(object, bl2), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map.Entry higherEntry(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.access$700(this.delegate().higherEntry(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object higherKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().higherKey(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map.Entry lastEntry() {
        Object object = this.mutex;
        synchronized (object) {
            return Synchronized.access$700(this.delegate().lastEntry(), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map.Entry lowerEntry(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.access$700(this.delegate().lowerEntry(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object lowerKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().lowerKey(object);
        }
    }

    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableSet navigableKeySet() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.navigableKeySet != null) return this.navigableKeySet;
            this.navigableKeySet = Synchronized.navigableSet(this.delegate().navigableKeySet(), this.mutex);
            return this.navigableKeySet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map.Entry pollFirstEntry() {
        Object object = this.mutex;
        synchronized (object) {
            return Synchronized.access$700(this.delegate().pollFirstEntry(), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Map.Entry pollLastEntry() {
        Object object = this.mutex;
        synchronized (object) {
            return Synchronized.access$700(this.delegate().pollLastEntry(), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return Synchronized.navigableMap(this.delegate().subMap(object, bl2, object2, bl3), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableMap tailMap(Object object, boolean bl2) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.navigableMap(this.delegate().tailMap(object, bl2), this.mutex);
        }
    }

    @Override
    public SortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    @Override
    public SortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    @Override
    public SortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }
}

