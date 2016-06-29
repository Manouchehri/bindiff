package com.google.protobuf;

import java.util.*;

class MapFieldLite$MutatabilityAwareIterator implements Iterator
{
    private final MutabilityOracle mutabilityOracle;
    private final Iterator delegate;
    
    MapFieldLite$MutatabilityAwareIterator(final MutabilityOracle mutabilityOracle, final Iterator delegate) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = delegate;
    }
    
    public boolean hasNext() {
        return this.delegate.hasNext();
    }
    
    public Object next() {
        return this.delegate.next();
    }
    
    public void remove() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.remove();
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
