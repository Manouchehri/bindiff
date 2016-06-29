/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.DescendingMultiset$1EntrySetImpl;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets$NavigableElementSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible(emulated=1)
abstract class DescendingMultiset
extends ForwardingMultiset
implements SortedMultiset {
    private transient Comparator comparator;
    private transient NavigableSet elementSet;
    private transient Set entrySet;

    DescendingMultiset() {
    }

    abstract SortedMultiset forwardMultiset();

    @Override
    public Comparator comparator() {
        Comparator comparator = this.comparator;
        if (comparator != null) return comparator;
        this.comparator = Ordering.from(this.forwardMultiset().comparator()).reverse();
        return this.comparator;
    }

    @Override
    public NavigableSet elementSet() {
        NavigableSet navigableSet = this.elementSet;
        if (navigableSet != null) return navigableSet;
        this.elementSet = new SortedMultisets$NavigableElementSet(this);
        return this.elementSet;
    }

    @Override
    public Multiset$Entry pollFirstEntry() {
        return this.forwardMultiset().pollLastEntry();
    }

    @Override
    public Multiset$Entry pollLastEntry() {
        return this.forwardMultiset().pollFirstEntry();
    }

    @Override
    public SortedMultiset headMultiset(Object object, BoundType boundType) {
        return this.forwardMultiset().tailMultiset(object, boundType).descendingMultiset();
    }

    @Override
    public SortedMultiset subMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        return this.forwardMultiset().subMultiset(object2, boundType2, object, boundType).descendingMultiset();
    }

    @Override
    public SortedMultiset tailMultiset(Object object, BoundType boundType) {
        return this.forwardMultiset().headMultiset(object, boundType).descendingMultiset();
    }

    @Override
    protected Multiset delegate() {
        return this.forwardMultiset();
    }

    @Override
    public SortedMultiset descendingMultiset() {
        return this.forwardMultiset();
    }

    @Override
    public Multiset$Entry firstEntry() {
        return this.forwardMultiset().lastEntry();
    }

    @Override
    public Multiset$Entry lastEntry() {
        return this.forwardMultiset().firstEntry();
    }

    abstract Iterator entryIterator();

    @Override
    public Set entrySet() {
        Set set;
        Set set2 = this.entrySet;
        if (set2 == null) {
            set = this.entrySet = this.createEntrySet();
            return set;
        }
        set = set2;
        return set;
    }

    Set createEntrySet() {
        return new DescendingMultiset$1EntrySetImpl(this);
    }

    @Override
    public Iterator iterator() {
        return Multisets.iteratorImpl(this);
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
    public String toString() {
        return this.entrySet().toString();
    }
}

