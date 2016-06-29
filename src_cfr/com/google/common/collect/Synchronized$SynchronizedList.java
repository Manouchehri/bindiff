/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class Synchronized$SynchronizedList
extends Synchronized$SynchronizedCollection
implements List {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedList(List list, @Nullable Object object) {
        super(list, object, null);
    }

    @Override
    List delegate() {
        return (List)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void add(int n2, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            this.delegate().add(n2, object);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean addAll(int n2, Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().addAll(n2, collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object get(int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().get(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int indexOf(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().indexOf(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int lastIndexOf(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().lastIndexOf(object);
        }
    }

    public ListIterator listIterator() {
        return this.delegate().listIterator();
    }

    public ListIterator listIterator(int n2) {
        return this.delegate().listIterator(n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object remove(int n2) {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().remove(n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object set(int n2, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().set(n2, object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List subList(int n2, int n3) {
        Object object = this.mutex;
        synchronized (object) {
            return Synchronized.access$200(this.delegate().subList(n2, n3), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().equals(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int hashCode() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().hashCode();
        }
    }
}

