/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingSortedMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

@GwtIncompatible(value="NavigableMap")
class Maps$UnmodifiableNavigableMap
extends ForwardingSortedMap
implements Serializable,
NavigableMap {
    private final NavigableMap delegate;
    private transient Maps$UnmodifiableNavigableMap descendingMap;

    Maps$UnmodifiableNavigableMap(NavigableMap navigableMap) {
        this.delegate = navigableMap;
    }

    Maps$UnmodifiableNavigableMap(NavigableMap navigableMap, Maps$UnmodifiableNavigableMap maps$UnmodifiableNavigableMap) {
        this.delegate = navigableMap;
        this.descendingMap = maps$UnmodifiableNavigableMap;
    }

    @Override
    protected SortedMap delegate() {
        return Collections.unmodifiableSortedMap(this.delegate);
    }

    public Map.Entry lowerEntry(Object object) {
        return Maps.access$800(this.delegate.lowerEntry(object));
    }

    public Object lowerKey(Object object) {
        return this.delegate.lowerKey(object);
    }

    public Map.Entry floorEntry(Object object) {
        return Maps.access$800(this.delegate.floorEntry(object));
    }

    public Object floorKey(Object object) {
        return this.delegate.floorKey(object);
    }

    public Map.Entry ceilingEntry(Object object) {
        return Maps.access$800(this.delegate.ceilingEntry(object));
    }

    public Object ceilingKey(Object object) {
        return this.delegate.ceilingKey(object);
    }

    public Map.Entry higherEntry(Object object) {
        return Maps.access$800(this.delegate.higherEntry(object));
    }

    public Object higherKey(Object object) {
        return this.delegate.higherKey(object);
    }

    public Map.Entry firstEntry() {
        return Maps.access$800(this.delegate.firstEntry());
    }

    public Map.Entry lastEntry() {
        return Maps.access$800(this.delegate.lastEntry());
    }

    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public NavigableMap descendingMap() {
        Maps$UnmodifiableNavigableMap maps$UnmodifiableNavigableMap;
        Maps$UnmodifiableNavigableMap maps$UnmodifiableNavigableMap2 = this.descendingMap;
        if (maps$UnmodifiableNavigableMap2 == null) {
            maps$UnmodifiableNavigableMap = this.descendingMap = new Maps$UnmodifiableNavigableMap(this.delegate.descendingMap(), this);
            return maps$UnmodifiableNavigableMap;
        }
        maps$UnmodifiableNavigableMap = maps$UnmodifiableNavigableMap2;
        return maps$UnmodifiableNavigableMap;
    }

    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }

    public NavigableSet navigableKeySet() {
        return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
    }

    public NavigableSet descendingKeySet() {
        return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
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

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return Maps.unmodifiableNavigableMap(this.delegate.subMap(object, bl2, object2, bl3));
    }

    public NavigableMap headMap(Object object, boolean bl2) {
        return Maps.unmodifiableNavigableMap(this.delegate.headMap(object, bl2));
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return Maps.unmodifiableNavigableMap(this.delegate.tailMap(object, bl2));
    }
}

