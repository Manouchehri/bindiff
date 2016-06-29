package com.google.common.collect;

import java.util.concurrent.*;
import com.google.common.annotations.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

class Maps$SortedAsMapView extends Maps$AsMapView implements SortedMap
{
    Maps$SortedAsMapView(final SortedSet set, final Function function) {
        super(set, function);
    }
    
    @Override
    SortedSet backingSet() {
        return (SortedSet)super.backingSet();
    }
    
    @Override
    public Comparator comparator() {
        return this.backingSet().comparator();
    }
    
    @Override
    public Set keySet() {
        return removeOnlySortedSet(this.backingSet());
    }
    
    @Override
    public SortedMap subMap(final Object o, final Object o2) {
        return Maps.asMap(this.backingSet().subSet(o, o2), this.function);
    }
    
    @Override
    public SortedMap headMap(final Object o) {
        return Maps.asMap(this.backingSet().headSet(o), this.function);
    }
    
    @Override
    public SortedMap tailMap(final Object o) {
        return Maps.asMap(this.backingSet().tailSet(o), this.function);
    }
    
    @Override
    public Object firstKey() {
        return this.backingSet().first();
    }
    
    @Override
    public Object lastKey() {
        return this.backingSet().last();
    }
}
