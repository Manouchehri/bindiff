/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$ElementSet$1;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

abstract class Multisets$ElementSet
extends Sets$ImprovedAbstractSet {
    Multisets$ElementSet() {
    }

    abstract Multiset multiset();

    @Override
    public void clear() {
        this.multiset().clear();
    }

    @Override
    public boolean contains(Object object) {
        return this.multiset().contains(object);
    }

    @Override
    public boolean containsAll(Collection collection) {
        return this.multiset().containsAll(collection);
    }

    @Override
    public boolean isEmpty() {
        return this.multiset().isEmpty();
    }

    @Override
    public Iterator iterator() {
        return new Multisets$ElementSet$1(this, this.multiset().entrySet().iterator());
    }

    @Override
    public boolean remove(Object object) {
        if (this.multiset().remove(object, Integer.MAX_VALUE) <= 0) return false;
        return true;
    }

    @Override
    public int size() {
        return this.multiset().entrySet().size();
    }
}

