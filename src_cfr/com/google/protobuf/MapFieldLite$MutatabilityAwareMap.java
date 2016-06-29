/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MapFieldLite$MutatabilityAwareCollection;
import com.google.protobuf.MapFieldLite$MutatabilityAwareSet;
import com.google.protobuf.MutabilityOracle;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class MapFieldLite$MutatabilityAwareMap
implements Map {
    private final MutabilityOracle mutabilityOracle;
    private final Map delegate;

    MapFieldLite$MutatabilityAwareMap(MutabilityOracle mutabilityOracle, Map map) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = map;
    }

    @Override
    public int size() {
        return this.delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object object) {
        return this.delegate.containsKey(object);
    }

    @Override
    public boolean containsValue(Object object) {
        return this.delegate.containsValue(object);
    }

    public Object get(Object object) {
        return this.delegate.get(object);
    }

    public Object put(Object object, Object object2) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.put(object, object2);
    }

    public Object remove(Object object) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(object);
    }

    public void putAll(Map map) {
        this.mutabilityOracle.ensureMutable();
        this.delegate.putAll(map);
    }

    @Override
    public void clear() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.clear();
    }

    public Set keySet() {
        return new MapFieldLite$MutatabilityAwareSet(this.mutabilityOracle, this.delegate.keySet());
    }

    public Collection values() {
        return new MapFieldLite$MutatabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
    }

    public Set entrySet() {
        return new MapFieldLite$MutatabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
    }

    @Override
    public boolean equals(Object object) {
        return this.delegate.equals(object);
    }

    @Override
    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return this.delegate.toString();
    }
}

