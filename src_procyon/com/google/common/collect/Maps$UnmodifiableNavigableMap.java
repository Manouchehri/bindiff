package com.google.common.collect;

import java.io.*;
import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.base.*;
import javax.annotation.*;
import java.util.*;

@GwtIncompatible("NavigableMap")
class Maps$UnmodifiableNavigableMap extends ForwardingSortedMap implements Serializable, NavigableMap
{
    private final NavigableMap delegate;
    private transient Maps$UnmodifiableNavigableMap descendingMap;
    
    Maps$UnmodifiableNavigableMap(final NavigableMap delegate) {
        this.delegate = delegate;
    }
    
    Maps$UnmodifiableNavigableMap(final NavigableMap delegate, final Maps$UnmodifiableNavigableMap descendingMap) {
        this.delegate = delegate;
        this.descendingMap = descendingMap;
    }
    
    @Override
    protected SortedMap delegate() {
        return Collections.unmodifiableSortedMap((SortedMap<Object, ?>)this.delegate);
    }
    
    @Override
    public Entry lowerEntry(final Object o) {
        return unmodifiableOrNull((Entry)this.delegate.lowerEntry(o));
    }
    
    @Override
    public Object lowerKey(final Object o) {
        return this.delegate.lowerKey(o);
    }
    
    @Override
    public Entry floorEntry(final Object o) {
        return unmodifiableOrNull((Entry)this.delegate.floorEntry(o));
    }
    
    @Override
    public Object floorKey(final Object o) {
        return this.delegate.floorKey(o);
    }
    
    @Override
    public Entry ceilingEntry(final Object o) {
        return unmodifiableOrNull((Entry)this.delegate.ceilingEntry(o));
    }
    
    @Override
    public Object ceilingKey(final Object o) {
        return this.delegate.ceilingKey(o);
    }
    
    @Override
    public Entry higherEntry(final Object o) {
        return unmodifiableOrNull((Entry)this.delegate.higherEntry(o));
    }
    
    @Override
    public Object higherKey(final Object o) {
        return this.delegate.higherKey(o);
    }
    
    @Override
    public Entry firstEntry() {
        return unmodifiableOrNull((Entry)this.delegate.firstEntry());
    }
    
    @Override
    public Entry lastEntry() {
        return unmodifiableOrNull((Entry)this.delegate.lastEntry());
    }
    
    @Override
    public final Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public final Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public NavigableMap descendingMap() {
        final Maps$UnmodifiableNavigableMap descendingMap = this.descendingMap;
        return (descendingMap == null) ? (this.descendingMap = new Maps$UnmodifiableNavigableMap(this.delegate.descendingMap(), this)) : descendingMap;
    }
    
    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }
    
    @Override
    public NavigableSet navigableKeySet() {
        return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
    }
    
    @Override
    public NavigableSet descendingKeySet() {
        return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
    }
    
    @Override
    public SortedMap subMap(final Object o, final Object o2) {
        return this.subMap(o, true, o2, false);
    }
    
    @Override
    public SortedMap headMap(final Object o) {
        return this.headMap(o, false);
    }
    
    @Override
    public SortedMap tailMap(final Object o) {
        return this.tailMap(o, true);
    }
    
    @Override
    public NavigableMap subMap(final Object o, final boolean b, final Object o2, final boolean b2) {
        return Maps.unmodifiableNavigableMap(this.delegate.subMap(o, b, o2, b2));
    }
    
    @Override
    public NavigableMap headMap(final Object o, final boolean b) {
        return Maps.unmodifiableNavigableMap(this.delegate.headMap(o, b));
    }
    
    @Override
    public NavigableMap tailMap(final Object o, final boolean b) {
        return Maps.unmodifiableNavigableMap(this.delegate.tailMap(o, b));
    }
}
