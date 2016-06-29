package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

@GwtIncompatible("NavigableMap")
abstract class Maps$DescendingMap extends ForwardingMap implements NavigableMap
{
    private transient Comparator comparator;
    private transient Set entrySet;
    private transient NavigableSet navigableKeySet;
    
    abstract NavigableMap forward();
    
    @Override
    protected final Map delegate() {
        return this.forward();
    }
    
    @Override
    public Comparator comparator() {
        Comparator comparator = this.comparator;
        if (comparator == null) {
            Comparator comparator2 = this.forward().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.natural();
            }
            final Ordering reverse = reverse(comparator2);
            this.comparator = reverse;
            comparator = reverse;
        }
        return comparator;
    }
    
    private static Ordering reverse(final Comparator comparator) {
        return Ordering.from(comparator).reverse();
    }
    
    @Override
    public Object firstKey() {
        return this.forward().lastKey();
    }
    
    @Override
    public Object lastKey() {
        return this.forward().firstKey();
    }
    
    @Override
    public Entry lowerEntry(final Object o) {
        return (Entry)this.forward().higherEntry(o);
    }
    
    @Override
    public Object lowerKey(final Object o) {
        return this.forward().higherKey(o);
    }
    
    @Override
    public Entry floorEntry(final Object o) {
        return (Entry)this.forward().ceilingEntry(o);
    }
    
    @Override
    public Object floorKey(final Object o) {
        return this.forward().ceilingKey(o);
    }
    
    @Override
    public Entry ceilingEntry(final Object o) {
        return (Entry)this.forward().floorEntry(o);
    }
    
    @Override
    public Object ceilingKey(final Object o) {
        return this.forward().floorKey(o);
    }
    
    @Override
    public Entry higherEntry(final Object o) {
        return (Entry)this.forward().lowerEntry(o);
    }
    
    @Override
    public Object higherKey(final Object o) {
        return this.forward().lowerKey(o);
    }
    
    @Override
    public Entry firstEntry() {
        return (Entry)this.forward().lastEntry();
    }
    
    @Override
    public Entry lastEntry() {
        return (Entry)this.forward().firstEntry();
    }
    
    @Override
    public Entry pollFirstEntry() {
        return (Entry)this.forward().pollLastEntry();
    }
    
    @Override
    public Entry pollLastEntry() {
        return (Entry)this.forward().pollFirstEntry();
    }
    
    @Override
    public NavigableMap descendingMap() {
        return this.forward();
    }
    
    @Override
    public Set entrySet() {
        final Set entrySet = this.entrySet;
        return (entrySet == null) ? (this.entrySet = this.createEntrySet()) : entrySet;
    }
    
    abstract Iterator entryIterator();
    
    Set createEntrySet() {
        return new Maps$DescendingMap$1EntrySetImpl(this);
    }
    
    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }
    
    @Override
    public NavigableSet navigableKeySet() {
        final NavigableSet navigableKeySet = this.navigableKeySet;
        return (navigableKeySet == null) ? (this.navigableKeySet = new Maps$NavigableKeySet(this)) : navigableKeySet;
    }
    
    @Override
    public NavigableSet descendingKeySet() {
        return this.forward().navigableKeySet();
    }
    
    @Override
    public NavigableMap subMap(final Object o, final boolean b, final Object o2, final boolean b2) {
        return this.forward().subMap(o2, b2, o, b).descendingMap();
    }
    
    @Override
    public NavigableMap headMap(final Object o, final boolean b) {
        return this.forward().tailMap(o, b).descendingMap();
    }
    
    @Override
    public NavigableMap tailMap(final Object o, final boolean b) {
        return this.forward().headMap(o, b).descendingMap();
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
    public Collection values() {
        return new Maps$Values(this);
    }
    
    @Override
    public String toString() {
        return this.standardToString();
    }
}
