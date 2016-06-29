/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps$DescendingMap$1EntrySetImpl;
import com.google.common.collect.Maps$NavigableKeySet;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

@GwtIncompatible(value="NavigableMap")
abstract class Maps$DescendingMap
extends ForwardingMap
implements NavigableMap {
    private transient Comparator comparator;
    private transient Set entrySet;
    private transient NavigableSet navigableKeySet;

    Maps$DescendingMap() {
    }

    abstract NavigableMap forward();

    @Override
    protected final Map delegate() {
        return this.forward();
    }

    @Override
    public Comparator comparator() {
        Comparator comparator = this.comparator;
        if (comparator != null) return comparator;
        Ordering ordering = this.forward().comparator();
        if (ordering != null) return this.comparator;
        ordering = Ordering.natural();
        this.comparator = Maps$DescendingMap.reverse(ordering);
        return this.comparator;
    }

    private static Ordering reverse(Comparator comparator) {
        return Ordering.from(comparator).reverse();
    }

    @Override
    public Object firstKey() {
        return this.forward().lastKey();
    }

    @Override
    public Object lastKey() {
        return this.forward().firstKey();
    }

    public Map.Entry lowerEntry(Object object) {
        return this.forward().higherEntry(object);
    }

    public Object lowerKey(Object object) {
        return this.forward().higherKey(object);
    }

    public Map.Entry floorEntry(Object object) {
        return this.forward().ceilingEntry(object);
    }

    public Object floorKey(Object object) {
        return this.forward().ceilingKey(object);
    }

    public Map.Entry ceilingEntry(Object object) {
        return this.forward().floorEntry(object);
    }

    public Object ceilingKey(Object object) {
        return this.forward().floorKey(object);
    }

    public Map.Entry higherEntry(Object object) {
        return this.forward().lowerEntry(object);
    }

    public Object higherKey(Object object) {
        return this.forward().lowerKey(object);
    }

    public Map.Entry firstEntry() {
        return this.forward().lastEntry();
    }

    public Map.Entry lastEntry() {
        return this.forward().firstEntry();
    }

    public Map.Entry pollFirstEntry() {
        return this.forward().pollLastEntry();
    }

    public Map.Entry pollLastEntry() {
        return this.forward().pollFirstEntry();
    }

    public NavigableMap descendingMap() {
        return this.forward();
    }

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

    abstract Iterator entryIterator();

    Set createEntrySet() {
        return new Maps$DescendingMap$1EntrySetImpl(this);
    }

    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }

    public NavigableSet navigableKeySet() {
        NavigableSet navigableSet;
        NavigableSet navigableSet2 = this.navigableKeySet;
        if (navigableSet2 == null) {
            navigableSet = this.navigableKeySet = new Maps$NavigableKeySet(this);
            return navigableSet;
        }
        navigableSet = navigableSet2;
        return navigableSet;
    }

    public NavigableSet descendingKeySet() {
        return this.forward().navigableKeySet();
    }

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.forward().subMap(object2, bl3, object, bl2).descendingMap();
    }

    public NavigableMap headMap(Object object, boolean bl2) {
        return this.forward().tailMap(object, bl2).descendingMap();
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return this.forward().headMap(object, bl2).descendingMap();
    }

    @Override
    public SortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    @Override
    public SortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    @Override
    public SortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }

    @Override
    public Collection values() {
        return new Maps$Values(this);
    }

    @Override
    public String toString() {
        return this.standardToString();
    }
}

