/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.AbstractSortedMultiset$1DescendingMultisetImpl;
import com.google.common.collect.BoundType;
import com.google.common.collect.GwtTransient;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets$NavigableElementSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
abstract class AbstractSortedMultiset
extends AbstractMultiset
implements SortedMultiset {
    @GwtTransient
    final Comparator comparator;
    private transient SortedMultiset descendingMultiset;

    AbstractSortedMultiset() {
        this(Ordering.natural());
    }

    AbstractSortedMultiset(Comparator comparator) {
        this.comparator = (Comparator)Preconditions.checkNotNull(comparator);
    }

    @Override
    public NavigableSet elementSet() {
        return (NavigableSet)super.elementSet();
    }

    @Override
    NavigableSet createElementSet() {
        return new SortedMultisets$NavigableElementSet(this);
    }

    @Override
    public Comparator comparator() {
        return this.comparator;
    }

    @Override
    public Multiset$Entry firstEntry() {
        Iterator iterator = this.entryIterator();
        if (!iterator.hasNext()) return null;
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
        return multiset$Entry;
    }

    @Override
    public Multiset$Entry lastEntry() {
        Iterator iterator = this.descendingEntryIterator();
        if (!iterator.hasNext()) return null;
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
        return multiset$Entry;
    }

    @Override
    public Multiset$Entry pollFirstEntry() {
        Iterator iterator = this.entryIterator();
        if (!iterator.hasNext()) return null;
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
        multiset$Entry = Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
        iterator.remove();
        return multiset$Entry;
    }

    @Override
    public Multiset$Entry pollLastEntry() {
        Iterator iterator = this.descendingEntryIterator();
        if (!iterator.hasNext()) return null;
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
        multiset$Entry = Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
        iterator.remove();
        return multiset$Entry;
    }

    @Override
    public SortedMultiset subMultiset(@Nullable Object object, BoundType boundType, @Nullable Object object2, BoundType boundType2) {
        Preconditions.checkNotNull((Object)boundType);
        Preconditions.checkNotNull((Object)boundType2);
        return this.tailMultiset(object, boundType).headMultiset(object2, boundType2);
    }

    abstract Iterator descendingEntryIterator();

    Iterator descendingIterator() {
        return Multisets.iteratorImpl(this.descendingMultiset());
    }

    @Override
    public SortedMultiset descendingMultiset() {
        SortedMultiset sortedMultiset;
        SortedMultiset sortedMultiset2 = this.descendingMultiset;
        if (sortedMultiset2 == null) {
            sortedMultiset = this.descendingMultiset = this.createDescendingMultiset();
            return sortedMultiset;
        }
        sortedMultiset = sortedMultiset2;
        return sortedMultiset;
    }

    SortedMultiset createDescendingMultiset() {
        return new AbstractSortedMultiset$1DescendingMultisetImpl(this);
    }
}

