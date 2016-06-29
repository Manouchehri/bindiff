/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.BiMap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedMap;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
class Synchronized$SynchronizedBiMap
extends Synchronized$SynchronizedMap
implements BiMap,
Serializable {
    private transient Set valueSet;
    private transient BiMap inverse;
    private static final long serialVersionUID = 0;

    private Synchronized$SynchronizedBiMap(BiMap biMap, @Nullable Object object, @Nullable BiMap biMap2) {
        super(biMap, object);
        this.inverse = biMap2;
    }

    @Override
    BiMap delegate() {
        return (BiMap)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set values() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.valueSet != null) return this.valueSet;
            this.valueSet = Synchronized.set(this.delegate().values(), this.mutex);
            return this.valueSet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object forcePut(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.delegate().forcePut(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public BiMap inverse() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.inverse != null) return this.inverse;
            this.inverse = new Synchronized$SynchronizedBiMap(this.delegate().inverse(), this.mutex, this);
            return this.inverse;
        }
    }

    /* synthetic */ Synchronized$SynchronizedBiMap(BiMap biMap, Object object, BiMap biMap2, Synchronized$1 synchronized$1) {
        this(biMap, object, biMap2);
    }
}

