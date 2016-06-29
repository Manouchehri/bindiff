/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MapFieldLite$MutatabilityAwareIterator;
import com.google.protobuf.MutabilityOracle;
import java.util.Collection;
import java.util.Iterator;

class MapFieldLite$MutatabilityAwareCollection
implements Collection {
    private final MutabilityOracle mutabilityOracle;
    private final Collection delegate;

    MapFieldLite$MutatabilityAwareCollection(MutabilityOracle mutabilityOracle, Collection collection) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = collection;
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
    public boolean contains(Object object) {
        return this.delegate.contains(object);
    }

    @Override
    public Iterator iterator() {
        return new MapFieldLite$MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
    }

    @Override
    public Object[] toArray() {
        return this.delegate.toArray();
    }

    public Object[] toArray(Object[] arrobject) {
        return this.delegate.toArray(arrobject);
    }

    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object object) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(object);
    }

    public boolean containsAll(Collection collection) {
        return this.delegate.containsAll(collection);
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.retainAll(collection);
    }

    @Override
    public void clear() {
        this.mutabilityOracle.ensureMutable();
        this.delegate.clear();
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

