/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedMap;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedMap
extends Synchronized$SynchronizedMap
implements SortedMap {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedSortedMap(SortedMap sortedMap, @Nullable Object object) {
        super(sortedMap, object);
    }

    @Override
    SortedMap delegate() {
        return (SortedMap)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Comparator comparator() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().comparator();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object firstKey() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().firstKey();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SortedMap headMap(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.sortedMap(this.delegate().headMap(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object lastKey() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().lastKey();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SortedMap subMap(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return Synchronized.sortedMap(this.delegate().subMap(object, object2), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SortedMap tailMap(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.sortedMap(this.delegate().tailMap(object), this.mutex);
        }
    }
}

