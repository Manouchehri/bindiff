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
import com.google.common.collect.Synchronized$SynchronizedSortedSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtIncompatible(value="NavigableSet")
@VisibleForTesting
class Synchronized$SynchronizedNavigableSet
extends Synchronized$SynchronizedSortedSet
implements NavigableSet {
    transient NavigableSet descendingSet;
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedNavigableSet(NavigableSet navigableSet, @Nullable Object object) {
        super(navigableSet, object);
    }

    @Override
    NavigableSet delegate() {
        return (NavigableSet)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object ceiling(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().ceiling(object);
        }
    }

    public Iterator descendingIterator() {
        return this.delegate().descendingIterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableSet descendingSet() {
        Object object = this.mutex;
        synchronized (object) {
            NavigableSet navigableSet;
            if (this.descendingSet != null) return this.descendingSet;
            this.descendingSet = navigableSet = Synchronized.navigableSet(this.delegate().descendingSet(), this.mutex);
            return navigableSet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object floor(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().floor(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableSet headSet(Object object, boolean bl2) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.navigableSet(this.delegate().headSet(object, bl2), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object higher(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().higher(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object lower(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().lower(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object pollFirst() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().pollFirst();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object pollLast() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().pollLast();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return Synchronized.navigableSet(this.delegate().subSet(object, bl2, object2, bl3), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NavigableSet tailSet(Object object, boolean bl2) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.navigableSet(this.delegate().tailSet(object, bl2), this.mutex);
        }
    }

    @Override
    public SortedSet headSet(Object object) {
        return this.headSet(object, false);
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    @Override
    public SortedSet tailSet(Object object) {
        return this.tailSet(object, true);
    }
}

