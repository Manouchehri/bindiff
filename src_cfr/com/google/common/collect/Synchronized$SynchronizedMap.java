/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMap
extends Synchronized$SynchronizedObject
implements Map {
    transient Set keySet;
    transient Collection values;
    transient Set entrySet;
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedMap(Map map, @Nullable Object object) {
        super(map, object);
    }

    @Override
    Map delegate() {
        return (Map)super.delegate();
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
    public boolean containsKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().containsKey(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean containsValue(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().containsValue(object);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Set entrySet() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.entrySet != null) return this.entrySet;
            this.entrySet = Synchronized.set(this.delegate().entrySet(), this.mutex);
            return this.entrySet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().get(object);
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Set keySet() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.keySet != null) return this.keySet;
            this.keySet = Synchronized.set(this.delegate().keySet(), this.mutex);
            return this.keySet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object put(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.delegate().put(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void putAll(Map map) {
        Object object = this.mutex;
        synchronized (object) {
            this.delegate().putAll(map);
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Object remove(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().remove(object);
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
    public Collection values() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.values != null) return this.values;
            this.values = Synchronized.access$500(this.delegate().values(), this.mutex);
            return this.values;
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

