/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedMultimap;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

class Synchronized$SynchronizedListMultimap
extends Synchronized$SynchronizedMultimap
implements ListMultimap {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedListMultimap(ListMultimap listMultimap, @Nullable Object object) {
        super(listMultimap, object);
    }

    @Override
    ListMultimap delegate() {
        return (ListMultimap)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.access$200(this.delegate().get(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List removeAll(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().removeAll(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public List replaceValues(Object object, Iterable iterable) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().replaceValues(object, iterable);
        }
    }
}

