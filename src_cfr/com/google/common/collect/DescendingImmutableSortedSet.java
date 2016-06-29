/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

class DescendingImmutableSortedSet
extends ImmutableSortedSet {
    private final ImmutableSortedSet forward;

    DescendingImmutableSortedSet(ImmutableSortedSet immutableSortedSet) {
        super(Ordering.from(immutableSortedSet.comparator()).reverse());
        this.forward = immutableSortedSet;
    }

    @Override
    public boolean contains(@Nullable Object object) {
        return this.forward.contains(object);
    }

    @Override
    public int size() {
        return this.forward.size();
    }

    @Override
    public UnmodifiableIterator iterator() {
        return this.forward.descendingIterator();
    }

    @Override
    ImmutableSortedSet headSetImpl(Object object, boolean bl2) {
        return this.forward.tailSet(object, bl2).descendingSet();
    }

    @Override
    ImmutableSortedSet subSetImpl(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.forward.subSet(object2, bl3, object, bl2).descendingSet();
    }

    @Override
    ImmutableSortedSet tailSetImpl(Object object, boolean bl2) {
        return this.forward.headSet(object, bl2).descendingSet();
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    public ImmutableSortedSet descendingSet() {
        return this.forward;
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    public UnmodifiableIterator descendingIterator() {
        return this.forward.iterator();
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    ImmutableSortedSet createDescendingSet() {
        throw new AssertionError((Object)"should never be called");
    }

    @Override
    public Object lower(Object object) {
        return this.forward.higher(object);
    }

    @Override
    public Object floor(Object object) {
        return this.forward.ceiling(object);
    }

    @Override
    public Object ceiling(Object object) {
        return this.forward.floor(object);
    }

    @Override
    public Object higher(Object object) {
        return this.forward.lower(object);
    }

    @Override
    int indexOf(@Nullable Object object) {
        int n2 = this.forward.indexOf(object);
        if (n2 != -1) return this.size() - 1 - n2;
        return n2;
    }

    @Override
    boolean isPartialView() {
        return this.forward.isPartialView();
    }
}

