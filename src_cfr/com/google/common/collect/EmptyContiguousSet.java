/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.EmptyContiguousSet$1;
import com.google.common.collect.EmptyContiguousSet$SerializedForm;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
final class EmptyContiguousSet
extends ContiguousSet {
    EmptyContiguousSet(DiscreteDomain discreteDomain) {
        super(discreteDomain);
    }

    @Override
    public Comparable first() {
        throw new NoSuchElementException();
    }

    @Override
    public Comparable last() {
        throw new NoSuchElementException();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ContiguousSet intersection(ContiguousSet contiguousSet) {
        return this;
    }

    @Override
    public Range range() {
        throw new NoSuchElementException();
    }

    @Override
    public Range range(BoundType boundType, BoundType boundType2) {
        throw new NoSuchElementException();
    }

    @Override
    ContiguousSet headSetImpl(Comparable comparable, boolean bl2) {
        return this;
    }

    @Override
    ContiguousSet subSetImpl(Comparable comparable, boolean bl2, Comparable comparable2, boolean bl3) {
        return this;
    }

    @Override
    ContiguousSet tailSetImpl(Comparable comparable, boolean bl2) {
        return this;
    }

    @Override
    public boolean contains(Object object) {
        return false;
    }

    @GwtIncompatible(value="not used by GWT emulation")
    @Override
    int indexOf(Object object) {
        return -1;
    }

    @Override
    public UnmodifiableIterator iterator() {
        return Iterators.emptyIterator();
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    public UnmodifiableIterator descendingIterator() {
        return Iterators.emptyIterator();
    }

    @Override
    boolean isPartialView() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public ImmutableList asList() {
        return ImmutableList.of();
    }

    @Override
    public String toString() {
        return "[]";
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Set)) return false;
        Set set = (Set)object;
        return set.isEmpty();
    }

    @GwtIncompatible(value="not used in GWT")
    @Override
    boolean isHashCodeFast() {
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @GwtIncompatible(value="serialization")
    @Override
    Object writeReplace() {
        return new EmptyContiguousSet$SerializedForm(this.domain, null);
    }

    @GwtIncompatible(value="NavigableSet")
    @Override
    ImmutableSortedSet createDescendingSet() {
        return ImmutableSortedSet.emptySet(Ordering.natural().reverse());
    }
}

