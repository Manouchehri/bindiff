/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.MapConstraints$ConstrainedAsMapValues$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class MapConstraints$ConstrainedAsMapValues
extends ForwardingCollection {
    final Collection delegate;
    final Set entrySet;

    MapConstraints$ConstrainedAsMapValues(Collection collection, Set set) {
        this.delegate = collection;
        this.entrySet = set;
    }

    @Override
    protected Collection delegate() {
        return this.delegate;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = this.entrySet.iterator();
        return new MapConstraints$ConstrainedAsMapValues$1(this, iterator);
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
        return this.standardContains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.standardContainsAll(collection);
    }

    @Override
    public boolean remove(Object object) {
        return this.standardRemove(object);
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

