/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractNavigableMap$1;
import com.google.common.collect.AbstractNavigableMap$DescendingMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Maps$NavigableKeySet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

abstract class AbstractNavigableMap
extends Maps$IteratorBasedAbstractMap
implements NavigableMap {
    AbstractNavigableMap() {
    }

    @Nullable
    @Override
    public abstract Object get(@Nullable Object var1);

    @Nullable
    public Map.Entry firstEntry() {
        return (Map.Entry)Iterators.getNext(this.entryIterator(), null);
    }

    @Nullable
    public Map.Entry lastEntry() {
        return (Map.Entry)Iterators.getNext(this.descendingEntryIterator(), null);
    }

    @Nullable
    public Map.Entry pollFirstEntry() {
        return (Map.Entry)Iterators.pollNext(this.entryIterator());
    }

    @Nullable
    public Map.Entry pollLastEntry() {
        return (Map.Entry)Iterators.pollNext(this.descendingEntryIterator());
    }

    @Override
    public Object firstKey() {
        Map.Entry entry = this.firstEntry();
        if (entry != null) return entry.getKey();
        throw new NoSuchElementException();
    }

    @Override
    public Object lastKey() {
        Map.Entry entry = this.lastEntry();
        if (entry != null) return entry.getKey();
        throw new NoSuchElementException();
    }

    @Nullable
    public Map.Entry lowerEntry(Object object) {
        return this.headMap(object, false).lastEntry();
    }

    @Nullable
    public Map.Entry floorEntry(Object object) {
        return this.headMap(object, true).lastEntry();
    }

    @Nullable
    public Map.Entry ceilingEntry(Object object) {
        return this.tailMap(object, true).firstEntry();
    }

    @Nullable
    public Map.Entry higherEntry(Object object) {
        return this.tailMap(object, false).firstEntry();
    }

    public Object lowerKey(Object object) {
        return Maps.keyOrNull(this.lowerEntry(object));
    }

    public Object floorKey(Object object) {
        return Maps.keyOrNull(this.floorEntry(object));
    }

    public Object ceilingKey(Object object) {
        return Maps.keyOrNull(this.ceilingEntry(object));
    }

    public Object higherKey(Object object) {
        return Maps.keyOrNull(this.higherEntry(object));
    }

    abstract Iterator descendingEntryIterator();

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

    public NavigableSet navigableKeySet() {
        return new Maps$NavigableKeySet(this);
    }

    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }

    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    public NavigableMap descendingMap() {
        return new AbstractNavigableMap$DescendingMap(this, null);
    }
}

