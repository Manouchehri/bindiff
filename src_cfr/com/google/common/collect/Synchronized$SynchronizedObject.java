/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.annotation.Nullable;

class Synchronized$SynchronizedObject
implements Serializable {
    final Object delegate;
    final Object mutex;
    @GwtIncompatible(value="not needed in emulated source")
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedObject(Object object, @Nullable Object object2) {
        this.delegate = Preconditions.checkNotNull(object);
        this.mutex = object2 == null ? this : object2;
    }

    Object delegate() {
        return this.delegate;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate.toString();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GwtIncompatible(value="java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream objectOutputStream) {
        Object object = this.mutex;
        synchronized (object) {
            objectOutputStream.defaultWriteObject();
            return;
        }
    }
}

