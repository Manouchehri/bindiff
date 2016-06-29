/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@VisibleForTesting
class Synchronized$SynchronizedCollection
extends Synchronized$SynchronizedObject
implements Collection {
    private static final long serialVersionUID = 0;

    private Synchronized$SynchronizedCollection(Collection collection, @Nullable Object object) {
        super(collection, object);
    }

    @Override
    Collection delegate() {
        return (Collection)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean add(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().add(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().addAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            this.delegate().clear();
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().contains(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean containsAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().containsAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().isEmpty();
        }
    }

    @Override
    public Iterator iterator() {
        return this.delegate().iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().remove(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean removeAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().removeAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean retainAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().retainAll(collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int size() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().toArray();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object[] toArray(Object[] arrobject) {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().toArray(arrobject);
        }
    }

    /* synthetic */ Synchronized$SynchronizedCollection(Collection collection, Object object, Synchronized$1 synchronized$1) {
        this(collection, object);
    }
}

