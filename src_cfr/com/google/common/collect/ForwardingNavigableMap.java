/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingSortedMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

public abstract class ForwardingNavigableMap
extends ForwardingSortedMap
implements NavigableMap {
    protected ForwardingNavigableMap() {
    }

    @Override
    protected abstract NavigableMap delegate();

    public Map.Entry lowerEntry(Object object) {
        return this.delegate().lowerEntry(object);
    }

    protected Map.Entry standardLowerEntry(Object object) {
        return this.headMap(object, false).lastEntry();
    }

    public Object lowerKey(Object object) {
        return this.delegate().lowerKey(object);
    }

    protected Object standardLowerKey(Object object) {
        return Maps.keyOrNull(this.lowerEntry(object));
    }

    public Map.Entry floorEntry(Object object) {
        return this.delegate().floorEntry(object);
    }

    protected Map.Entry standardFloorEntry(Object object) {
        return this.headMap(object, true).lastEntry();
    }

    public Object floorKey(Object object) {
        return this.delegate().floorKey(object);
    }

    protected Object standardFloorKey(Object object) {
        return Maps.keyOrNull(this.floorEntry(object));
    }

    public Map.Entry ceilingEntry(Object object) {
        return this.delegate().ceilingEntry(object);
    }

    protected Map.Entry standardCeilingEntry(Object object) {
        return this.tailMap(object, true).firstEntry();
    }

    public Object ceilingKey(Object object) {
        return this.delegate().ceilingKey(object);
    }

    protected Object standardCeilingKey(Object object) {
        return Maps.keyOrNull(this.ceilingEntry(object));
    }

    public Map.Entry higherEntry(Object object) {
        return this.delegate().higherEntry(object);
    }

    protected Map.Entry standardHigherEntry(Object object) {
        return this.tailMap(object, false).firstEntry();
    }

    public Object higherKey(Object object) {
        return this.delegate().higherKey(object);
    }

    protected Object standardHigherKey(Object object) {
        return Maps.keyOrNull(this.higherEntry(object));
    }

    public Map.Entry firstEntry() {
        return this.delegate().firstEntry();
    }

    protected Map.Entry standardFirstEntry() {
        return (Map.Entry)Iterables.getFirst(this.entrySet(), null);
    }

    protected Object standardFirstKey() {
        Map.Entry entry = this.firstEntry();
        if (entry != null) return entry.getKey();
        throw new NoSuchElementException();
    }

    public Map.Entry lastEntry() {
        return this.delegate().lastEntry();
    }

    protected Map.Entry standardLastEntry() {
        return (Map.Entry)Iterables.getFirst(this.descendingMap().entrySet(), null);
    }

    protected Object standardLastKey() {
        Map.Entry entry = this.lastEntry();
        if (entry != null) return entry.getKey();
        throw new NoSuchElementException();
    }

    public Map.Entry pollFirstEntry() {
        return this.delegate().pollFirstEntry();
    }

    protected Map.Entry standardPollFirstEntry() {
        return (Map.Entry)Iterators.pollNext(this.entrySet().iterator());
    }

    public Map.Entry pollLastEntry() {
        return this.delegate().pollLastEntry();
    }

    protected Map.Entry standardPollLastEntry() {
        return (Map.Entry)Iterators.pollNext(this.descendingMap().entrySet().iterator());
    }

    public NavigableMap descendingMap() {
        return this.delegate().descendingMap();
    }

    public NavigableSet navigableKeySet() {
        return this.delegate().navigableKeySet();
    }

    public NavigableSet descendingKeySet() {
        return this.delegate().descendingKeySet();
    }

    @Beta
    protected NavigableSet standardDescendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }

    @Override
    protected SortedMap standardSubMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.delegate().subMap(object, bl2, object2, bl3);
    }

    public NavigableMap headMap(Object object, boolean bl2) {
        return this.delegate().headMap(object, bl2);
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return this.delegate().tailMap(object, bl2);
    }

    protected SortedMap standardHeadMap(Object object) {
        return this.headMap(object, false);
    }

    protected SortedMap standardTailMap(Object object) {
        return this.tailMap(object, true);
    }
}

