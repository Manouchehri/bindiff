/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingNavigableSet;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@GwtIncompatible(value="NavigableSet")
class Sets$DescendingSet
extends ForwardingNavigableSet {
    private final NavigableSet forward;

    Sets$DescendingSet(NavigableSet navigableSet) {
        this.forward = navigableSet;
    }

    @Override
    protected NavigableSet delegate() {
        return this.forward;
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
    public Object pollFirst() {
        return this.forward.pollLast();
    }

    @Override
    public Object pollLast() {
        return this.forward.pollFirst();
    }

    @Override
    public NavigableSet descendingSet() {
        return this.forward;
    }

    @Override
    public Iterator descendingIterator() {
        return this.forward.iterator();
    }

    @Override
    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.forward.subSet(object2, bl3, object, bl2).descendingSet();
    }

    @Override
    public NavigableSet headSet(Object object, boolean bl2) {
        return this.forward.tailSet(object, bl2).descendingSet();
    }

    @Override
    public NavigableSet tailSet(Object object, boolean bl2) {
        return this.forward.headSet(object, bl2).descendingSet();
    }

    @Override
    public Comparator comparator() {
        Comparator comparator = this.forward.comparator();
        if (comparator != null) return Sets$DescendingSet.reverse(comparator);
        return Ordering.natural().reverse();
    }

    private static Ordering reverse(Comparator comparator) {
        return Ordering.from(comparator).reverse();
    }

    @Override
    public Object first() {
        return this.forward.last();
    }

    @Override
    public SortedSet headSet(Object object) {
        return this.standardHeadSet(object);
    }

    @Override
    public Object last() {
        return this.forward.first();
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return this.standardSubSet(object, object2);
    }

    @Override
    public SortedSet tailSet(Object object) {
        return this.standardTailSet(object);
    }

    @Override
    public Iterator iterator() {
        return this.forward.descendingIterator();
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
        return this.standardToString();
    }
}

