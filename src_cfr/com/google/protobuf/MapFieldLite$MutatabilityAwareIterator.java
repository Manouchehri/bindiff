/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MutabilityOracle;
import java.util.Iterator;

class MapFieldLite$MutatabilityAwareIterator
implements Iterator {
    private final MutabilityOracle mutabilityOracle;
    private final Iterator delegate;

    MapFieldLite$MutatabilityAwareIterator(MutabilityOracle mutabilityOracle, Iterator iterator) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = iterator;
    }

    @Override
    public boolean hasNext() {
        return this.delegate.hasNext();
    }

    public Object next() {
        return this.delegate.next();
    }

    @Override
    public void remove() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.remove();
    }

    public boolean equals(Object object) {
        return this.delegate.equals(object);
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return this.delegate.toString();
    }
}

