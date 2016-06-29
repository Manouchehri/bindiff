/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.BoundType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.SortedMultiset;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

final class DescendingImmutableSortedMultiset
extends ImmutableSortedMultiset {
    private final transient ImmutableSortedMultiset forward;

    DescendingImmutableSortedMultiset(ImmutableSortedMultiset immutableSortedMultiset) {
        this.forward = immutableSortedMultiset;
    }

    @Override
    public int count(@Nullable Object object) {
        return this.forward.count(object);
    }

    @Override
    public Multiset$Entry firstEntry() {
        return this.forward.lastEntry();
    }

    @Override
    public Multiset$Entry lastEntry() {
        return this.forward.firstEntry();
    }

    @Override
    public int size() {
        return this.forward.size();
    }

    @Override
    public ImmutableSortedSet elementSet() {
        return this.forward.elementSet().descendingSet();
    }

    @Override
    Multiset$Entry getEntry(int n2) {
        return (Multiset$Entry)this.forward.entrySet().asList().reverse().get(n2);
    }

    @Override
    public ImmutableSortedMultiset descendingMultiset() {
        return this.forward;
    }

    @Override
    public ImmutableSortedMultiset headMultiset(Object object, BoundType boundType) {
        return this.forward.tailMultiset(object, boundType).descendingMultiset();
    }

    @Override
    public ImmutableSortedMultiset tailMultiset(Object object, BoundType boundType) {
        return this.forward.headMultiset(object, boundType).descendingMultiset();
    }

    @Override
    boolean isPartialView() {
        return this.forward.isPartialView();
    }
}

