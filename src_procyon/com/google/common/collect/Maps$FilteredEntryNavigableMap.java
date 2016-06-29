package com.google.common.collect;

import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtIncompatible("NavigableMap")
class Maps$FilteredEntryNavigableMap extends AbstractNavigableMap
{
    private final NavigableMap unfiltered;
    private final Predicate entryPredicate;
    private final Map filteredDelegate;
    
    Maps$FilteredEntryNavigableMap(final NavigableMap navigableMap, final Predicate entryPredicate) {
        this.unfiltered = (NavigableMap)Preconditions.checkNotNull(navigableMap);
        this.entryPredicate = entryPredicate;
        this.filteredDelegate = new Maps$FilteredEntryMap(navigableMap, entryPredicate);
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
        return !Iterables.any(this.unfiltered.entrySet(), this.entryPredicate);
    }
    
    @Nullable
    @Override
    public Object get(@Nullable final Object o) {
        return this.filteredDelegate.get(o);
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        return this.filteredDelegate.containsKey(o);
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        return this.filteredDelegate.put(o, o2);
    }
    
    @Override
    public Object remove(@Nullable final Object o) {
        return this.filteredDelegate.remove(o);
    }
    
    @Override
    public void putAll(final Map map) {
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
    public Entry pollFirstEntry() {
        return (Entry)Iterables.removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
    }
    
    @Override
    public Entry pollLastEntry() {
        return (Entry)Iterables.removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
    }
    
    @Override
    public NavigableMap descendingMap() {
        return Maps.filterEntries(this.unfiltered.descendingMap(), this.entryPredicate);
    }
    
    @Override
    public NavigableMap subMap(final Object o, final boolean b, final Object o2, final boolean b2) {
        return Maps.filterEntries(this.unfiltered.subMap(o, b, o2, b2), this.entryPredicate);
    }
    
    @Override
    public NavigableMap headMap(final Object o, final boolean b) {
        return Maps.filterEntries(this.unfiltered.headMap(o, b), this.entryPredicate);
    }
    
    @Override
    public NavigableMap tailMap(final Object o, final boolean b) {
        return Maps.filterEntries(this.unfiltered.tailMap(o, b), this.entryPredicate);
    }
}
