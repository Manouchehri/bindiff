package com.google.protobuf;

import java.util.*;

class MapFieldLite$MutatabilityAwareMap implements Map
{
    private final MutabilityOracle mutabilityOracle;
    private final Map delegate;
    
    MapFieldLite$MutatabilityAwareMap(final MutabilityOracle mutabilityOracle, final Map delegate) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = delegate;
    }
    
    public int size() {
        return this.delegate.size();
    }
    
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }
    
    public boolean containsKey(final Object o) {
        return this.delegate.containsKey(o);
    }
    
    public boolean containsValue(final Object o) {
        return this.delegate.containsValue(o);
    }
    
    public Object get(final Object o) {
        return this.delegate.get(o);
    }
    
    public Object put(final Object o, final Object o2) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.put(o, o2);
    }
    
    public Object remove(final Object o) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(o);
    }
    
    public void putAll(final Map map) {
        this.mutabilityOracle.ensureMutable();
        this.delegate.putAll(map);
    }
    
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
    
    public boolean equals(final Object o) {
        return this.delegate.equals(o);
    }
    
    public int hashCode() {
        return this.delegate.hashCode();
    }
    
    public String toString() {
        return this.delegate.toString();
    }
}
