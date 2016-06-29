/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

class Multisets$UnmodifiableMultiset
extends ForwardingMultiset
implements Serializable {
    final Multiset delegate;
    transient Set elementSet;
    transient Set entrySet;
    private static final long serialVersionUID = 0;

    Multisets$UnmodifiableMultiset(Multiset multiset) {
        this.delegate = multiset;
    }

    @Override
    protected Multiset delegate() {
        return this.delegate;
    }

    Set createElementSet() {
        return Collections.unmodifiableSet(this.delegate.elementSet());
    }

    @Override
    public Set elementSet() {
        Set set;
        Set set2 = this.elementSet;
        if (set2 == null) {
            set = this.elementSet = this.createElementSet();
            return set;
        }
        set = set2;
        return set;
    }

    @Override
    public Set entrySet() {
        Set set;
        Set set2 = this.entrySet;
        if (set2 == null) {
            set = this.entrySet = Collections.unmodifiableSet(this.delegate.entrySet());
            return set;
        }
        set = set2;
        return set;
    }

    @Override
    public Iterator iterator() {
        return Iterators.unmodifiableIterator(this.delegate.iterator());
    }

    @Override
    public boolean add(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int add(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int remove(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int setCount(Object object, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setCount(Object object, int n2, int n3) {
        throw new UnsupportedOperationException();
    }
}

