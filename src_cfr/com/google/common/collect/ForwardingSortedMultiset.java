/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.SortedMultiset;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@Beta
@GwtCompatible(emulated=1)
public abstract class ForwardingSortedMultiset
extends ForwardingMultiset
implements SortedMultiset {
    protected ForwardingSortedMultiset() {
    }

    @Override
    protected abstract SortedMultiset delegate();

    @Override
    public NavigableSet elementSet() {
        return (NavigableSet)super.elementSet();
    }

    @Override
    public Comparator comparator() {
        return this.delegate().comparator();
    }

    @Override
    public SortedMultiset descendingMultiset() {
        return this.delegate().descendingMultiset();
    }

    @Override
    public Multiset$Entry firstEntry() {
        return this.delegate().firstEntry();
    }

    protected Multiset$Entry standardFirstEntry() {
        Iterator<E> iterator = this.entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
        return Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
    }

    @Override
    public Multiset$Entry lastEntry() {
        return this.delegate().lastEntry();
    }

    protected Multiset$Entry standardLastEntry() {
        Iterator<E> iterator = this.descendingMultiset().entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
        return Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
    }

    @Override
    public Multiset$Entry pollFirstEntry() {
        return this.delegate().pollFirstEntry();
    }

    protected Multiset$Entry standardPollFirstEntry() {
        Iterator<E> iterator = this.entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
        multiset$Entry = Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
        iterator.remove();
        return multiset$Entry;
    }

    @Override
    public Multiset$Entry pollLastEntry() {
        return this.delegate().pollLastEntry();
    }

    protected Multiset$Entry standardPollLastEntry() {
        Iterator<E> iterator = this.descendingMultiset().entrySet().iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Multiset$Entry multiset$Entry = (Multiset$Entry)iterator.next();
        multiset$Entry = Multisets.immutableEntry(multiset$Entry.getElement(), multiset$Entry.getCount());
        iterator.remove();
        return multiset$Entry;
    }

    @Override
    public SortedMultiset headMultiset(Object object, BoundType boundType) {
        return this.delegate().headMultiset(object, boundType);
    }

    @Override
    public SortedMultiset subMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        return this.delegate().subMultiset(object, boundType, object2, boundType2);
    }

    protected SortedMultiset standardSubMultiset(Object object, BoundType boundType, Object object2, BoundType boundType2) {
        return this.tailMultiset(object, boundType).headMultiset(object2, boundType2);
    }

    @Override
    public SortedMultiset tailMultiset(Object object, BoundType boundType) {
        return this.delegate().tailMultiset(object, boundType);
    }
}

