/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSet
extends Synchronized$SynchronizedCollection
implements Set {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedSet(Set set, @Nullable Object object) {
        super(set, object, null);
    }

    @Override
    Set delegate() {
        return (Set)super.delegate();
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

