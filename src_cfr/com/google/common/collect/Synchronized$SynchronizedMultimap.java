/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMap;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMultimap
extends Synchronized$SynchronizedObject
implements Multimap {
    transient Set keySet;
    transient Collection valuesCollection;
    transient Collection entries;
    transient Map asMap;
    transient Multiset keys;
    private static final long serialVersionUID = 0;

    @Override
    Multimap delegate() {
        return (Multimap)super.delegate();
    }

    Synchronized$SynchronizedMultimap(Multimap multimap, @Nullable Object object) {
        super(multimap, object);
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
    @Override
    public boolean containsEntry(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.delegate().containsEntry(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return Synchronized.access$400(this.delegate().get(object), this.mutex);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean put(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.delegate().put(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean putAll(Object object, Iterable iterable) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().putAll(object, iterable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean putAll(Multimap multimap) {
        Object object = this.mutex;
        synchronized (object) {
            return this.delegate().putAll(multimap);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection replaceValues(Object object, Iterable iterable) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().replaceValues(object, iterable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            return this.delegate().remove(object, object2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection removeAll(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            return this.delegate().removeAll(object);
        }
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
    public Set keySet() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.keySet != null) return this.keySet;
            this.keySet = Synchronized.access$300(this.delegate().keySet(), this.mutex);
            return this.keySet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection values() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.valuesCollection != null) return this.valuesCollection;
            this.valuesCollection = Synchronized.access$500(this.delegate().values(), this.mutex);
            return this.valuesCollection;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection entries() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.entries != null) return this.entries;
            this.entries = Synchronized.access$400(this.delegate().entries(), this.mutex);
            return this.entries;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Map asMap() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.asMap != null) return this.asMap;
            this.asMap = new Synchronized$SynchronizedAsMap(this.delegate().asMap(), this.mutex);
            return this.asMap;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Multiset keys() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.keys != null) return this.keys;
            this.keys = Synchronized.multiset(this.delegate().keys(), this.mutex);
            return this.keys;
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

