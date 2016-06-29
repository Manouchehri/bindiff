/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1;
import com.google.common.collect.Synchronized$SynchronizedSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMapEntries
extends Synchronized$SynchronizedSet {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedAsMapEntries(Set set, @Nullable Object object) {
        super(set, object);
    }

    @Override
    public Iterator iterator() {
        return new Synchronized$SynchronizedAsMapEntries$1(this, super.iterator());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            return ObjectArrays.toArrayImpl(this.delegate());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object[] toArray(Object[] arrobject) {
        Object object = this.mutex;
        synchronized (object) {
            return ObjectArrays.toArrayImpl(this.delegate(), arrobject);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Maps.containsEntryImpl(this.delegate(), object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return Collections2.containsAllImpl(this.delegate(), collection);
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
            return Sets.equalsImpl(this.delegate(), object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Maps.removeEntryImpl(this.delegate(), object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean removeAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return Iterators.removeAll(this.delegate().iterator(), collection);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean retainAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            return Iterators.retainAll(this.delegate().iterator(), collection);
        }
    }
}

