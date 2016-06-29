/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class Collections2$FilteredCollection
extends AbstractCollection {
    final Collection unfiltered;
    final Predicate predicate;

    Collections2$FilteredCollection(Collection collection, Predicate predicate) {
        this.unfiltered = collection;
        this.predicate = predicate;
    }

    Collections2$FilteredCollection createCombined(Predicate predicate) {
        return new Collections2$FilteredCollection(this.unfiltered, Predicates.and(this.predicate, predicate));
    }

    @Override
    public boolean add(Object object) {
        Preconditions.checkArgument(this.predicate.apply(object));
        return this.unfiltered.add(object);
    }

    @Override
    public boolean addAll(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            Preconditions.checkArgument(this.predicate.apply(e2));
        }
        return this.unfiltered.addAll(collection);
    }

    @Override
    public void clear() {
        Iterables.removeIf(this.unfiltered, this.predicate);
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!Collections2.safeContains(this.unfiltered, object)) return false;
        Object object2 = object;
        return this.predicate.apply(object2);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return Collections2.containsAllImpl(this, collection);
    }

    @Override
    public boolean isEmpty() {
        if (Iterables.any(this.unfiltered, this.predicate)) return false;
        return true;
    }

    @Override
    public Iterator iterator() {
        return Iterators.filter(this.unfiltered.iterator(), this.predicate);
    }

    @Override
    public boolean remove(Object object) {
        if (!this.contains(object)) return false;
        if (!this.unfiltered.remove(object)) return false;
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.in(collection)));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return Iterables.removeIf(this.unfiltered, Predicates.and(this.predicate, Predicates.not(Predicates.in(collection))));
    }

    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }

    @Override
    public Object[] toArray() {
        return Lists.newArrayList(this.iterator()).toArray();
    }

    @Override
    public Object[] toArray(Object[] arrobject) {
        return Lists.newArrayList(this.iterator()).toArray(arrobject);
    }
}

