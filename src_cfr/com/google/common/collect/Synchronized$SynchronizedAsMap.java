/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries;
import com.google.common.collect.Synchronized$SynchronizedAsMapValues;
import com.google.common.collect.Synchronized$SynchronizedMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMap
extends Synchronized$SynchronizedMap {
    transient Set asMapEntrySet;
    transient Collection asMapValues;
    private static final long serialVersionUID = 0;

    Synchronized$SynchronizedAsMap(Map map, @Nullable Object object) {
        super(map, object);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Collection collection = (Collection)super.get(object);
            if (collection == null) {
                return null;
            }
            Collection collection2 = Synchronized.access$400(collection, this.mutex);
            return collection2;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Set entrySet() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.asMapEntrySet != null) return this.asMapEntrySet;
            this.asMapEntrySet = new Synchronized$SynchronizedAsMapEntries(this.delegate().entrySet(), this.mutex);
            return this.asMapEntrySet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Collection values() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.asMapValues != null) return this.asMapValues;
            this.asMapValues = new Synchronized$SynchronizedAsMapValues(this.delegate().values(), this.mutex);
            return this.asMapValues;
        }
    }

    @Override
    public boolean containsValue(Object object) {
        return this.values().contains(object);
    }
}

