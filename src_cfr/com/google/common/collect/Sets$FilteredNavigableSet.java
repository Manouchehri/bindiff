/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets$FilteredSortedSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtIncompatible(value="NavigableSet")
class Sets$FilteredNavigableSet
extends Sets$FilteredSortedSet
implements NavigableSet {
    Sets$FilteredNavigableSet(NavigableSet navigableSet, Predicate predicate) {
        super(navigableSet, predicate);
    }

    NavigableSet unfiltered() {
        return (NavigableSet)this.unfiltered;
    }

    @Nullable
    public Object lower(Object object) {
        return Iterators.getNext(this.headSet(object, false).descendingIterator(), null);
    }

    @Nullable
    public Object floor(Object object) {
        return Iterators.getNext(this.headSet(object, true).descendingIterator(), null);
    }

    public Object ceiling(Object object) {
        return Iterables.getFirst(this.tailSet(object, true), null);
    }

    public Object higher(Object object) {
        return Iterables.getFirst(this.tailSet(object, false), null);
    }

    public Object pollFirst() {
        return Iterables.removeFirstMatching(this.unfiltered(), this.predicate);
    }

    public Object pollLast() {
        return Iterables.removeFirstMatching(this.unfiltered().descendingSet(), this.predicate);
    }

    public NavigableSet descendingSet() {
        return Sets.filter(this.unfiltered().descendingSet(), this.predicate);
    }

    public Iterator descendingIterator() {
        return Iterators.filter(this.unfiltered().descendingIterator(), this.predicate);
    }

    @Override
    public Object last() {
        return this.descendingIterator().next();
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return Sets.filter(this.unfiltered().subSet(object, bl2, object2, bl3), this.predicate);
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return Sets.filter(this.unfiltered().headSet(object, bl2), this.predicate);
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return Sets.filter(this.unfiltered().tailSet(object, bl2), this.predicate);
    }
}

