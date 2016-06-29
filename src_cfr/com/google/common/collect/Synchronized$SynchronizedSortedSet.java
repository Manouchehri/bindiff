/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedSet
extends Synchronized$SynchronizedSet
implements SortedSet {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedSortedSet(SortedSet sortedSet, @Nullable Object object) {
        super(sortedSet, object);
    }

    @Override
    SortedSet delegate() {
        return (SortedSet)super.delegate();
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
    public SortedSet subSet(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return Synchronized.access$100(this.delegate().subSet(object, object2), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SortedSet headSet(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.access$100(this.delegate().headSet(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public SortedSet tailSet(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.access$100(this.delegate().tailSet(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object first() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().first();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object last() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().last();
        }
    }
}

