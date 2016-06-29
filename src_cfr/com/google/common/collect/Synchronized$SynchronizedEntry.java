/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Map;
import javax.annotation.Nullable;

@GwtIncompatible(value="works but is needed only for NavigableMap")
class Synchronized$SynchronizedEntry
extends Synchronized$SynchronizedObject
implements Map.Entry {
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedEntry(Map.Entry entry, @Nullable Object object) {
        super(entry, object);
    }

    @Override
    Map.Entry delegate() {
        return (Map.Entry)super.delegate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean equals(Object object) {
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object getKey() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().getKey();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object getValue() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().getValue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object setValue(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().setValue(object);
        }
    }
}

