/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$SortedKeySet;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtIncompatible(value="NavigableSet")
class AbstractMapBasedMultimap$NavigableKeySet
extends AbstractMapBasedMultimap$SortedKeySet
implements NavigableSet {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$NavigableKeySet(AbstractMapBasedMultimap abstractMapBasedMultimap, NavigableMap navigableMap) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap, navigableMap);
    }

    @Override
    NavigableMap sortedMap() {
        return (NavigableMap)super.sortedMap();
    }

    public Object lower(Object object) {
        return this.sortedMap().lowerKey(object);
    }

    public Object floor(Object object) {
        return this.sortedMap().floorKey(object);
    }

    public Object ceiling(Object object) {
        return this.sortedMap().ceilingKey(object);
    }

    public Object higher(Object object) {
        return this.sortedMap().higherKey(object);
    }

    public Object pollFirst() {
        return Iterators.pollNext(this.iterator());
    }

    public Object pollLast() {
        return Iterators.pollNext(this.descendingIterator());
    }

    public NavigableSet descendingSet() {
        return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().descendingMap());
    }

    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }

    @Override
    public NavigableSet headSet(Object object) {
        return this.headSet(object, false);
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().headMap(object, bl2));
    }

    @Override
    public NavigableSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().subMap(object, bl2, object2, bl3));
    }

    @Override
    public NavigableSet tailSet(Object object) {
        return this.tailSet(object, true);
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().tailMap(object, bl2));
    }
}

