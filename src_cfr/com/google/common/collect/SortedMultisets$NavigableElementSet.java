/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.SortedMultisets;
import com.google.common.collect.SortedMultisets$ElementSet;
import java.util.Iterator;
import java.util.NavigableSet;

@GwtIncompatible(value="Navigable")
class SortedMultisets$NavigableElementSet
extends SortedMultisets$ElementSet
implements NavigableSet {
    SortedMultisets$NavigableElementSet(SortedMultiset sortedMultiset) {
        super(sortedMultiset);
    }

    public Object lower(Object object) {
        return SortedMultisets.access$100(this.multiset().headMultiset(object, BoundType.OPEN).lastEntry());
    }

    public Object floor(Object object) {
        return SortedMultisets.access$100(this.multiset().headMultiset(object, BoundType.CLOSED).lastEntry());
    }

    public Object ceiling(Object object) {
        return SortedMultisets.access$100(this.multiset().tailMultiset(object, BoundType.CLOSED).firstEntry());
    }

    public Object higher(Object object) {
        return SortedMultisets.access$100(this.multiset().tailMultiset(object, BoundType.OPEN).firstEntry());
    }

    public NavigableSet descendingSet() {
        return new SortedMultisets$NavigableElementSet(this.multiset().descendingMultiset());
    }

    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }

    public Object pollFirst() {
        return SortedMultisets.access$100(this.multiset().pollFirstEntry());
    }

    public Object pollLast() {
        return SortedMultisets.access$100(this.multiset().pollLastEntry());
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return new SortedMultisets$NavigableElementSet(this.multiset().subMultiset(object, BoundType.forBoolean(bl2), object2, BoundType.forBoolean(bl3)));
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return new SortedMultisets$NavigableElementSet(this.multiset().headMultiset(object, BoundType.forBoolean(bl2)));
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return new SortedMultisets$NavigableElementSet(this.multiset().tailMultiset(object, BoundType.forBoolean(bl2)));
    }
}

