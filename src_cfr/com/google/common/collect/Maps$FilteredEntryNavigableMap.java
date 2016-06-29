/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryNavigableMap$1;
import com.google.common.collect.Maps$FilteredMapValues;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.Nullable;

@GwtIncompatible(value="NavigableMap")
class Maps$FilteredEntryNavigableMap
extends AbstractNavigableMap {
    private final NavigableMap unfiltered;
    private final Predicate entryPredicate;
    private final Map filteredDelegate;

    Maps$FilteredEntryNavigableMap(NavigableMap navigableMap, Predicate predicate) {
        this.unfiltered = (NavigableMap)Preconditions.checkNotNull(navigableMap);
        this.entryPredicate = predicate;
        this.filteredDelegate = new Maps$FilteredEntryMap(navigableMap, predicate);
    }

    @Override
    public Comparator comparator() {
        return this.unfiltered.comparator();
    }

    @Override
    public NavigableSet navigableKeySet() {
        return new Maps$FilteredEntryNavigableMap$1(this, this);
    }

    @Override
    public Collection values() {
        return new Maps$FilteredMapValues(this, this.unfiltered, this.entryPredicate);
    }

    @Override
    Iterator entryIterator() {
        return Iterators.filter(this.unfiltered.entrySet().iterator(), this.entryPredicate);
    }

    @Override
    Iterator descendingEntryIterator() {
        return Iterators.filter(this.unfiltered.descendingMap().entrySet().iterator(), this.entryPredicate);
    }

    @Override
    public int size() {
        return this.filteredDelegate.size();
    }

    @Override
    public boolean isEmpty() {
        if (Iterables.any(this.unfiltered.entrySet(), this.entryPredicate)) return false;
        return true;
    }

    @Nullable
    @Override
    public Object get(@Nullable Object object) {
        return this.filteredDelegate.get(object);
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        return this.filteredDelegate.containsKey(object);
    }

    @Override
    public Object put(Object object, Object object2) {
        return this.filteredDelegate.put(object, object2);
    }

    @Override
    public Object remove(@Nullable Object object) {
        return this.filteredDelegate.remove(object);
    }

    @Override
    public void putAll(Map map) {
        this.filteredDelegate.putAll(map);
    }

    @Override
    public void clear() {
        this.filteredDelegate.clear();
    }

    @Override
    public Set entrySet() {
        return this.filteredDelegate.entrySet();
    }

    @Override
    public Map.Entry pollFirstEntry() {
        return (Map.Entry)Iterables.removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
    }

    @Override
    public Map.Entry pollLastEntry() {
        return (Map.Entry)Iterables.removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
    }

    @Override
    public NavigableMap descendingMap() {
        return Maps.filterEntries(this.unfiltered.descendingMap(), this.entryPredicate);
    }

    public NavigableMap subMap(Object object, boolean bl2, Object object2, boolean bl3) {
        return Maps.filterEntries(this.unfiltered.subMap(object, bl2, object2, bl3), this.entryPredicate);
    }

    public NavigableMap headMap(Object object, boolean bl2) {
        return Maps.filterEntries(this.unfiltered.headMap(object, bl2), this.entryPredicate);
    }

    public NavigableMap tailMap(Object object, boolean bl2) {
        return Maps.filterEntries(this.unfiltered.tailMap(object, bl2), this.entryPredicate);
    }

    static /* synthetic */ Predicate access$600(Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap) {
        return maps$FilteredEntryNavigableMap.entryPredicate;
    }

    static /* synthetic */ NavigableMap access$700(Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap) {
        return maps$FilteredEntryNavigableMap.unfiltered;
    }
}

