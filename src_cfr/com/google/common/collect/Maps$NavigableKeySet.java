/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$SortedKeySet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtIncompatible(value="NavigableMap")
class Maps$NavigableKeySet
extends Maps$SortedKeySet
implements NavigableSet {
    Maps$NavigableKeySet(NavigableMap navigableMap) {
        super(navigableMap);
    }

    @Override
    NavigableMap map() {
        return (NavigableMap)this.map;
    }

    public Object lower(Object object) {
        return this.map().lowerKey(object);
    }

    public Object floor(Object object) {
        return this.map().floorKey(object);
    }

    public Object ceiling(Object object) {
        return this.map().ceilingKey(object);
    }

    public Object higher(Object object) {
        return this.map().higherKey(object);
    }

    public Object pollFirst() {
        return Maps.keyOrNull(this.map().pollFirstEntry());
    }

    public Object pollLast() {
        return Maps.keyOrNull(this.map().pollLastEntry());
    }

    public NavigableSet descendingSet() {
        return this.map().descendingKeySet();
    }

    public Iterator descendingIterator() {
        return this.descendingSet().iterator();
    }

    public NavigableSet subSet(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.map().subMap(object, bl2, object2, bl3).navigableKeySet();
    }

    public NavigableSet headSet(Object object, boolean bl2) {
        return this.map().headMap(object, bl2).navigableKeySet();
    }

    public NavigableSet tailSet(Object object, boolean bl2) {
        return this.map().tailMap(object, bl2).navigableKeySet();
    }

    @Override
    public SortedSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    @Override
    public SortedSet headSet(Object object) {
        return this.headSet(object, false);
    }

    @Override
    public SortedSet tailSet(Object object) {
        return this.tailSet(object, true);
    }
}

