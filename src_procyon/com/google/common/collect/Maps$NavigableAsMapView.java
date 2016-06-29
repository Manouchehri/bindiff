package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;

@GwtIncompatible("NavigableMap")
final class Maps$NavigableAsMapView extends AbstractNavigableMap
{
    private final NavigableSet set;
    private final Function function;
    
    Maps$NavigableAsMapView(final NavigableSet set, final Function function) {
        this.set = (NavigableSet)Preconditions.checkNotNull(set);
        this.function = (Function)Preconditions.checkNotNull(function);
    }
    
    @Override
    public NavigableMap subMap(final Object o, final boolean b, final Object o2, final boolean b2) {
        return Maps.asMap(this.set.subSet(o, b, o2, b2), this.function);
    }
    
    @Override
    public NavigableMap headMap(final Object o, final boolean b) {
        return Maps.asMap(this.set.headSet(o, b), this.function);
    }
    
    @Override
    public NavigableMap tailMap(final Object o, final boolean b) {
        return Maps.asMap(this.set.tailSet(o, b), this.function);
    }
    
    @Override
    public Comparator comparator() {
        return this.set.comparator();
    }
    
    @Nullable
    @Override
    public Object get(@Nullable final Object o) {
        if (Collections2.safeContains(this.set, o)) {
            return this.function.apply(o);
        }
        return null;
    }
    
    @Override
    public void clear() {
        this.set.clear();
    }
    
    @Override
    Iterator entryIterator() {
        return Maps.asMapEntryIterator(this.set, this.function);
    }
    
    @Override
    Iterator descendingEntryIterator() {
        return this.descendingMap().entrySet().iterator();
    }
    
    @Override
    public NavigableSet navigableKeySet() {
        return removeOnlyNavigableSet(this.set);
    }
    
    @Override
    public int size() {
        return this.set.size();
    }
    
    @Override
    public NavigableMap descendingMap() {
        return Maps.asMap(this.set.descendingSet(), this.function);
    }
}
