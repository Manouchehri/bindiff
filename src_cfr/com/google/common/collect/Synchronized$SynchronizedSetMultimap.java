/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedMultimap;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSetMultimap
extends Synchronized$SynchronizedMultimap
implements SetMultimap {
    transient Set entrySet;
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedSetMultimap(SetMultimap setMultimap, @Nullable Object object) {
        super(setMultimap, object);
    }

    @Override
    SetMultimap delegate() {
        return (SetMultimap)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.set(this.delegate().get(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set removeAll(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().removeAll(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set replaceValues(Object object, Iterable iterable) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().replaceValues(object, iterable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set entries() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.entrySet != null) return this.entrySet;
            this.entrySet = Synchronized.set(this.delegate().entries(), this.mutex);
            return this.entrySet;
        }
    }
}

