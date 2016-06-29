/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

public abstract class ForwardingNavigableSet
extends ForwardingSortedSet
implements NavigableSet {
    protected ForwardingNavigableSet() {
    }

    @Override
    protected abstract NavigableSet delegate();

    public Object lower(Object object) {
        return this.delegate().lower(object);
    }

    protected Object standardLower(Object object) {
        return Iterators.getNext(this.headSet(object, false).descendingIterator(), null);
    }

    public Object floor(Object object) {
        return this.delegate().floor(object);
    }

    protected Object standardFloor(Object object) {
        return Iterators.getNext(this.headSet(object, true).descendingIterator(), null);
    }

    public Object ceiling(Object object) {
        return this.delegate().ceiling(object);
    }

    protected Object standardCeiling(Object object) {
        return Iterators.getNext(this.tailSet(object, true).iterator(), null);
    }

    public Object higher(Object object) {
        return this.delegate().higher(object);
    }

    protected Object standardHigher(Object object) {
        return Iterators.getNext(this.tailSet(object, false).iterator(), null);
    }

    public Object pollFirst() {
        return this.delegate().pollFirst();
    }

    protected Object standardPollFirst() {
        return Iterators.pollNext(this.iterator());
    }

    public Object pollLast() {
        return this.delegate().pollLast();
    }

    protected Object standardPollLast() {
        return Iterators.pollNext(this.descendingIterator());
    }

    protected Object standardFirst() {
        return this.iterator().next();
    }

    protected Object standardLast() {
        return this.descendingIterator().next();
    }

    public NavigableSet descendingSet() {
        return this.delegate().descendingSet();
    }

    public Iterator descendingIterator() {
        return this.delegate().descendingIterator();
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.delegate().subSet(object, bl2, object2, bl3);
    }

    @Beta
    protected NavigableSet standardSubSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.tailSet(object, bl2).headSet(object2, bl3);
    }

    @Override
    protected SortedSet standardSubSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return this.delegate().headSet(object, bl2);
    }

    protected SortedSet standardHeadSet(Object object) {
        return this.headSet(object, false);
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return this.delegate().tailSet(object, bl2);
    }

    protected SortedSet standardTailSet(Object object) {
        return this.tailSet(object, true);
    }
}

