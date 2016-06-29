package com.google.common.collect;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.*;

abstract class Maps$AbstractFilteredMap extends Maps$ViewCachingAbstractMap
{
    final Map unfiltered;
    final Predicate predicate;
    
    Maps$AbstractFilteredMap(final Map unfiltered, final Predicate predicate) {
        this.unfiltered = unfiltered;
        this.predicate = predicate;
    }
    
    boolean apply(@Nullable final Object o, @Nullable final Object o2) {
        return this.predicate.apply(Maps.immutableEntry(o, o2));
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        Preconditions.checkArgument(this.apply(o, o2));
        return this.unfiltered.put(o, o2);
    }
    
    @Override
    public void putAll(final Map map) {
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            Preconditions.checkArgument(this.apply(entry.getKey(), entry.getValue()));
        }
        this.unfiltered.putAll(map);
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.unfiltered.containsKey(o) && this.apply(o, this.unfiltered.get(o));
    }
    
    @Override
    public Object get(final Object o) {
        final Object value = this.unfiltered.get(o);
        return (value != null && this.apply(o, value)) ? value : null;
    }
    
    @Override
    public boolean isEmpty() {
        return this.entrySet().isEmpty();
    }
    
    @Override
    public Object remove(final Object o) {
        return this.containsKey(o) ? this.unfiltered.remove(o) : null;
    }
    
    @Override
    Collection createValues() {
        return new Maps$FilteredMapValues(this, this.unfiltered, this.predicate);
    }
}
