/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.AbstractMultiset$ElementSet;
import com.google.common.collect.AbstractMultiset$EntrySet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractMultiset
extends AbstractCollection
implements Multiset {
    private transient Set elementSet;
    private transient Set entrySet;

    AbstractMultiset() {
    }

    @Override
    public int size() {
        return Multisets.sizeImpl(this);
    }

    @Override
    public boolean isEmpty() {
        return this.entrySet().isEmpty();
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (this.count(object) <= 0) return false;
        return true;
    }

    @Override
    public Iterator iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override
    public int count(@Nullable Object object) {
        Multiset$Entry multiset$Entry;
        Iterator iterator = this.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return 0;
        } while (!Objects.equal((multiset$Entry = (Multiset$Entry)iterator.next()).getElement(), object));
        return multiset$Entry.getCount();
    }

    @Override
    public boolean add(@Nullable Object object) {
        this.add(object, 1);
        return true;
    }

    @Override
    public int add(@Nullable Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(@Nullable Object object) {
        if (this.remove(object, 1) <= 0) return false;
        return true;
    }

    @Override
    public int remove(@Nullable Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int setCount(@Nullable Object object, int n2) {
        return Multisets.setCountImpl(this, object, n2);
    }

    @Override
    public boolean setCount(@Nullable Object object, int n2, int n3) {
        return Multisets.setCountImpl(this, object, n2, n3);
    }

    public boolean addAll(Collection collection) {
        return Multisets.addAllImpl(this, collection);
    }

    @Override
    public boolean removeAll(Collection collection) {
        return Multisets.removeAllImpl(this, collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        return Multisets.retainAllImpl(this, collection);
    }

    @Override
    public void clear() {
        Iterators.clear(this.entryIterator());
    }

    @Override
    public Set elementSet() {
        Set set = this.elementSet;
        if (set != null) return set;
        this.elementSet = set = this.createElementSet();
        return set;
    }

    Set createElementSet() {
        return new AbstractMultiset$ElementSet(this);
    }

    abstract Iterator entryIterator();

    abstract int distinctElements();

    @Override
    public Set entrySet() {
        Set set = this.entrySet;
        if (set != null) return set;
        this.entrySet = set = this.createEntrySet();
        return set;
    }

    Set createEntrySet() {
        return new AbstractMultiset$EntrySet(this);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        return Multisets.equalsImpl(this, object);
    }

    @Override
    public int hashCode() {
        return this.entrySet().hashCode();
    }

    @Override
    public String toString() {
        return this.entrySet().toString();
    }
}

