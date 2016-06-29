/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMultiset
extends Synchronized$SynchronizedCollection
implements Multiset {
    transient Set elementSet;
    transient Set entrySet;
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedMultiset(Multiset multiset, @Nullable Object object) {
        super(multiset, object, null);
    }

    @Override
    Multiset delegate() {
        return (Multiset)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int count(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().count(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int add(Object object, int n2) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().add(object, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int remove(Object object, int n2) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().remove(object, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int setCount(Object object, int n2) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().setCount(object, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean setCount(Object object, int n2, int n3) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().setCount(object, n2, n3);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set elementSet() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.elementSet != null) return this.elementSet;
            this.elementSet = Synchronized.access$300(this.delegate().elementSet(), this.mutex);
            return this.elementSet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set entrySet() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.entrySet != null) return this.entrySet;
            this.entrySet = Synchronized.access$300(this.delegate().entrySet(), this.mutex);
            return this.entrySet;
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

