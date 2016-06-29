/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$UnmodifiableMultiset;
import com.google.common.collect.Sets;
import com.google.common.collect.SortedMultiset;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible(emulated=1)
final class UnmodifiableSortedMultiset
extends Multisets$UnmodifiableMultiset
implements SortedMultiset {
    private transient UnmodifiableSortedMultiset descendingMultiset;
    private static final long serialVersionUID = 0;

    UnmodifiableSortedMultiset(SortedMultiset sortedMultiset) {
        super(sortedMultiset);
    }

    @Override
    protected SortedMultiset delegate() {
        return (SortedMultiset)super.delegate();
    }

    @Override
    public Comparator comparator() {
        return this.delegate().comparator();
    }

    @Override
    NavigableSet createElementSet() {
        return Sets.unmodifiableNavigableSet(this.delegate().elementSet());
    }

    @Override
    public NavigableSet elementSet() {
        return (NavigableSet)super.elementSet();
    }

    @Override
    public SortedMultiset descendingMultiset() {
        UnmodifiableSortedMultiset unmodifiableSortedMultiset = this.descendingMultiset;
        if (unmodifiableSortedMultiset != null) return unmodifiableSortedMultiset;
        unmodifiableSortedMultiset = new UnmodifiableSortedMultiset(this.delegate().descendingMultiset());
        unmodifiableSortedMultiset.descendingMultiset = this;
        this.descendingMultiset = unmodifiableSortedMultiset;
        return this.descendingMultiset;
    }

    @Override
    public Multiset$Entry firstEntry() {
        return this.delegate().firstEntry();
    }

    @Override
    public Multiset$Entry lastEntry() {
        return this.delegate().lastEntry();
    }

    @Override
    public Multiset$Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Multiset$Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override
    public SortedMultiset headMultiset(Object object, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(this.delegate().headMultiset(object, boundType));
    }

    @Override
    public SortedMultiset subMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        return Multisets.unmodifiableSortedMultiset(this.delegate().subMultiset(object, boundType, object2, boundType2));
    }

    @Override
    public SortedMultiset tailMultiset(Object object, BoundType boundType) {
        return Multisets.unmodifiableSortedMultiset(this.delegate().tailMultiset(object, boundType));
    }
}

