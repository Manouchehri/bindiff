/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class ImmutableMapBuilder$ImmutableHashMap
extends HashMap {
    volatile transient Set keySet;
    volatile transient Collection values;
    volatile transient Set entrySet;
    @LazyInit
    transient Integer cachedHashCode;
    private static final long serialVersionUID = -5187626034923451074L;

    ImmutableMapBuilder$ImmutableHashMap(int n2) {
        super(n2);
    }

    @Override
    public Set keySet() {
        if (this.keySet != null) return this.keySet;
        this.keySet = Collections.unmodifiableSet(super.keySet());
        return this.keySet;
    }

    @Override
    public Collection values() {
        if (this.values != null) return this.values;
        this.values = Collections.unmodifiableCollection(super.values());
        return this.values;
    }

    @Override
    public Set entrySet() {
        if (this.entrySet != null) return this.entrySet;
        this.entrySet = Maps.unmodifiableEntrySet(super.entrySet());
        return this.entrySet;
    }

    @Override
    public int hashCode() {
        Integer n2 = this.cachedHashCode;
        if (n2 != null) return n2;
        int n3 = super.hashCode();
        this.cachedHashCode = n3;
        return n3;
    }

    private void secretPut(Object object, Object object2) {
        super.put(object, object2);
    }

    @Override
    public Object put(Object object, Object object2) {
        throw ImmutableMapBuilder$ImmutableHashMap.up();
    }

    @Override
    public void putAll(Map map) {
        throw ImmutableMapBuilder$ImmutableHashMap.up();
    }

    @Override
    public Object remove(Object object) {
        throw ImmutableMapBuilder$ImmutableHashMap.up();
    }

    @Override
    public void clear() {
        throw ImmutableMapBuilder$ImmutableHashMap.up();
    }

    static UnsupportedOperationException up() {
        return new UnsupportedOperationException();
    }

    static /* synthetic */ void access$000(ImmutableMapBuilder$ImmutableHashMap immutableMapBuilder$ImmutableHashMap, Object object, Object object2) {
        immutableMapBuilder$ImmutableHashMap.secretPut(object, object2);
    }
}

