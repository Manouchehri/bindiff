package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;
import javax.annotation.*;

@GwtIncompatible("NavigableMap")
class Maps$TransformedEntriesNavigableMap extends Maps$TransformedEntriesSortedMap implements NavigableMap
{
    Maps$TransformedEntriesNavigableMap(final NavigableMap navigableMap, final Maps$EntryTransformer maps$EntryTransformer) {
        super(navigableMap, maps$EntryTransformer);
    }
    
    @Override
    public Entry ceilingEntry(final Object o) {
        return this.transformEntry((Entry)this.fromMap().ceilingEntry(o));
    }
    
    @Override
    public Object ceilingKey(final Object o) {
        return this.fromMap().ceilingKey(o);
    }
    
    @Override
    public NavigableSet descendingKeySet() {
        return this.fromMap().descendingKeySet();
    }
    
    @Override
    public NavigableMap descendingMap() {
        return Maps.transformEntries(this.fromMap().descendingMap(), this.transformer);
    }
    
    @Override
    public Entry firstEntry() {
        return this.transformEntry((Entry)this.fromMap().firstEntry());
    }
    
    @Override
    public Entry floorEntry(final Object o) {
        return this.transformEntry((Entry)this.fromMap().floorEntry(o));
    }
    
    @Override
    public Object floorKey(final Object o) {
        return this.fromMap().floorKey(o);
    }
    
    @Override
    public NavigableMap headMap(final Object o) {
        return this.headMap(o, false);
    }
    
    @Override
    public NavigableMap headMap(final Object o, final boolean b) {
        return Maps.transformEntries(this.fromMap().headMap(o, b), this.transformer);
    }
    
    @Override
    public Entry higherEntry(final Object o) {
        return this.transformEntry((Entry)this.fromMap().higherEntry(o));
    }
    
    @Override
    public Object higherKey(final Object o) {
        return this.fromMap().higherKey(o);
    }
    
    @Override
    public Entry lastEntry() {
        return this.transformEntry((Entry)this.fromMap().lastEntry());
    }
    
    @Override
    public Entry lowerEntry(final Object o) {
        return this.transformEntry((Entry)this.fromMap().lowerEntry(o));
    }
    
    @Override
    public Object lowerKey(final Object o) {
        return this.fromMap().lowerKey(o);
    }
    
    @Override
    public NavigableSet navigableKeySet() {
        return this.fromMap().navigableKeySet();
    }
    
    @Override
    public Entry pollFirstEntry() {
        return this.transformEntry((Entry)this.fromMap().pollFirstEntry());
    }
    
    @Override
    public Entry pollLastEntry() {
        return this.transformEntry((Entry)this.fromMap().pollLastEntry());
    }
    
    @Override
    public NavigableMap subMap(final Object o, final boolean b, final Object o2, final boolean b2) {
        return Maps.transformEntries(this.fromMap().subMap(o, b, o2, b2), this.transformer);
    }
    
    @Override
    public NavigableMap subMap(final Object o, final Object o2) {
        return this.subMap(o, true, o2, false);
    }
    
    @Override
    public NavigableMap tailMap(final Object o) {
        return this.tailMap(o, true);
    }
    
    @Override
    public NavigableMap tailMap(final Object o, final boolean b) {
        return Maps.transformEntries(this.fromMap().tailMap(o, b), this.transformer);
    }
    
    @Nullable
    private Entry transformEntry(@Nullable final Entry entry) {
        return (entry == null) ? null : Maps.transformEntry(this.transformer, entry);
    }
    
    @Override
    protected NavigableMap fromMap() {
        return (NavigableMap)super.fromMap();
    }
}
