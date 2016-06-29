/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.MapConstraint;
import com.google.common.collect.MapConstraints$ConstrainedAsMapEntries$1;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

class MapConstraints$ConstrainedAsMapEntries
extends ForwardingSet {
    private final MapConstraint constraint;
    private final Set entries;

    MapConstraints$ConstrainedAsMapEntries(Set set, MapConstraint mapConstraint) {
        this.entries = set;
        this.constraint = mapConstraint;
    }

    @Override
    protected Set delegate() {
        return this.entries;
    }

    @Override
    public Iterator iterator() {
        return new MapConstraints$ConstrainedAsMapEntries$1(this, this.entries.iterator());
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
    public boolean equals(@Nullable Object object) {
        return this.standardEquals(object);
    }

    @Override
    public int hashCode() {
        return this.standardHashCode();
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

    static /* synthetic */ MapConstraint access$600(MapConstraints$ConstrainedAsMapEntries mapConstraints$ConstrainedAsMapEntries) {
        return mapConstraints$ConstrainedAsMapEntries.constraint;
    }
}

