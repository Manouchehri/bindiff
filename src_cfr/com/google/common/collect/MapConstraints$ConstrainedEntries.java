/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedEntries$1;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;

class MapConstraints$ConstrainedEntries
extends ForwardingCollection {
    final MapConstraint constraint;
    final Collection entries;

    MapConstraints$ConstrainedEntries(Collection collection, MapConstraint mapConstraint) {
        this.entries = collection;
        this.constraint = mapConstraint;
    }

    @Override
    protected Collection delegate() {
        return this.entries;
    }

    @Override
    public Iterator iterator() {
        return new MapConstraints$ConstrainedEntries$1(this, this.entries.iterator());
    }

    @Override
    public Object[] toArray() {
        return this.standardToArray();
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return this.standardToArray(arrobject);
    }

    @Override
    public boolean contains(Object object) {
        return Maps.containsEntryImpl(this.delegate(), object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.standardContainsAll(collection);
    }

    @Override
    public boolean remove(Object object) {
        return Maps.removeEntryImpl(this.delegate(), object);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.standardRemoveAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.standardRetainAll(collection);
    }
}

