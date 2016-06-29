/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.MapFieldLite$MutatabilityAwareIterator;
import com.google.protobuf.MutabilityOracle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class MapFieldLite$MutatabilityAwareSet
implements Set {
    private final MutabilityOracle mutabilityOracle;
    private final Set delegate;

    MapFieldLite$MutatabilityAwareSet(MutabilityOracle mutabilityOracle, Set set) {
        this.mutabilityOracle = mutabilityOracle;
        this.delegate = set;
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

    @Override
    public Object[] toArray(Object[] arrobject) {
        return this.delegate.toArray(arrobject);
    }

    @Override
    public boolean add(Object object) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.add(object);
    }

    @Override
    public boolean remove(Object object) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.remove(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.delegate.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.addAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.retainAll(collection);
    }

    @Override
    public boolean removeAll(Collection collection) {
        this.mutabilityOracle.ensureMutable();
        return this.delegate.removeAll(collection);
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

