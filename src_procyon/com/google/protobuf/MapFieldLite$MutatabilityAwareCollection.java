package com.google.protobuf;

import java.util.*;

class MapFieldLite$MutatabilityAwareCollection implements Collection
{
    private final MutabilityOracle mutabilityOracle;
    private final Collection delegate;
    
    MapFieldLite$MutatabilityAwareCollection(final MutabilityOracle mutabilityOracle, final Collection delegate) {
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
        throw new UnsupportedOperationException();
    }
    
    public boolean remove(final Object o) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(o);
    }
    
    public boolean containsAll(final Collection collection) {
        return this.delegate.containsAll(collection);
    }
    
    public boolean addAll(final Collection collection) {
        throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(final Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.removeAll(collection);
    }
    
    public boolean retainAll(final Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.retainAll(collection);
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
