/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSortedSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@GwtIncompatible(value="NavigableSet")
final class Sets$UnmodifiableNavigableSet
extends ForwardingSortedSet
implements Serializable,
NavigableSet {
    private final NavigableSet delegate;
    private transient Sets$UnmodifiableNavigableSet descendingSet;
    private static final long serialVersionUID = 0;

    Sets$UnmodifiableNavigableSet(NavigableSet navigableSet) {
        this.delegate = (NavigableSet)Preconditions.checkNotNull(navigableSet);
    }

    @Override
    protected SortedSet delegate() {
        return Collections.unmodifiableSortedSet(this.delegate);
    }

    public Object lower(Object object) {
        return this.delegate.lower(object);
    }

    public Object floor(Object object) {
        return this.delegate.floor(object);
    }

    public Object ceiling(Object object) {
        return this.delegate.ceiling(object);
    }

    public Object higher(Object object) {
        return this.delegate.higher(object);
    }

    public Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    public Object pollLast() {
        throw new UnsupportedOperationException();
    }

    public NavigableSet descendingSet() {
        Sets$UnmodifiableNavigableSet sets$UnmodifiableNavigableSet = this.descendingSet;
        if (sets$UnmodifiableNavigableSet != null) return sets$UnmodifiableNavigableSet;
        sets$UnmodifiableNavigableSet = this.descendingSet = new Sets$UnmodifiableNavigableSet(this.delegate.descendingSet());
        sets$UnmodifiableNavigableSet.descendingSet = this;
        return sets$UnmodifiableNavigableSet;
    }

    public Iterator descendingIterator() {
        return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return Sets.unmodifiableNavigableSet(this.delegate.subSet(object, bl2, object2, bl3));
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return Sets.unmodifiableNavigableSet(this.delegate.headSet(object, bl2));
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return Sets.unmodifiableNavigableSet(this.delegate.tailSet(object, bl2));
    }
}

