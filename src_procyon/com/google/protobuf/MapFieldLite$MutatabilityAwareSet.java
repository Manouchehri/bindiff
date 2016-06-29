package com.google.protobuf;

import java.util.*;

class MapFieldLite$MutatabilityAwareSet implements Set
{
    private final MutabilityOracle mutabilityOracle;
    private final Set delegate;
    
    MapFieldLite$MutatabilityAwareSet(final MutabilityOracle mutabilityOracle, final Set delegate) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = delegate;
    }
    
    public int size() {
        return this.delegate.size();
    }
    
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }
    
    public boolean contains(final Object o) {
        return this.delegate.contains(o);
    }
    
    public Iterator iterator() {
        return new MapFieldLite$MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
    }
    
    public Object[] toArray() {
        return this.delegate.toArray();
    }
    
    public Object[] toArray(final Object[] array) {
        return this.delegate.toArray(array);
    }
    
    public boolean add(final Object o) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.add(o);
    }
    
    public boolean remove(final Object o) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(o);
    }
    
    public boolean containsAll(final Collection collection) {
        return this.delegate.containsAll(collection);
    }
    
    public boolean addAll(final Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.addAll(collection);
    }
    
    public boolean retainAll(final Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.retainAll(collection);
    }
    
    public boolean removeAll(final Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.removeAll(collection);
    }
    
    public void clear() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.clear();
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
