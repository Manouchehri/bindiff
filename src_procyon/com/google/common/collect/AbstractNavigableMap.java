package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

abstract class AbstractNavigableMap extends Maps$IteratorBasedAbstractMap implements NavigableMap
{
    @Nullable
    @Override
    public abstract Object get(@Nullable final Object p0);
    
    @Nullable
    @Override
    public Entry firstEntry() {
        return (Entry)Iterators.getNext(this.entryIterator(), null);
    }
    
    @Nullable
    @Override
    public Entry lastEntry() {
        return (Entry)Iterators.getNext(this.descendingEntryIterator(), null);
    }
    
    @Nullable
    @Override
    public Entry pollFirstEntry() {
        return (Entry)Iterators.pollNext(this.entryIterator());
    }
    
    @Nullable
    @Override
    public Entry pollLastEntry() {
        return (Entry)Iterators.pollNext(this.descendingEntryIterator());
    }
    
    @Override
    public Object firstKey() {
        final Entry firstEntry = this.firstEntry();
        if (firstEntry == null) {
            throw new NoSuchElementException();
        }
        return firstEntry.getKey();
    }
    
    @Override
    public Object lastKey() {
        final Entry lastEntry = this.lastEntry();
        if (lastEntry == null) {
            throw new NoSuchElementException();
        }
        return lastEntry.getKey();
    }
    
    @Nullable
    @Override
    public Entry lowerEntry(final Object o) {
        return (Entry)this.headMap(o, false).lastEntry();
    }
    
    @Nullable
    @Override
    public Entry floorEntry(final Object o) {
        return (Entry)this.headMap(o, true).lastEntry();
    }
    
    @Nullable
    @Override
    public Entry ceilingEntry(final Object o) {
        return (Entry)this.tailMap(o, true).firstEntry();
    }
    
    @Nullable
    @Override
    public Entry higherEntry(final Object o) {
        return (Entry)this.tailMap(o, false).firstEntry();
    }
    
    @Override
    public Object lowerKey(final Object o) {
        return Maps.keyOrNull(this.lowerEntry(o));
    }
    
    @Override
    public Object floorKey(final Object o) {
        return Maps.keyOrNull(this.floorEntry(o));
    }
    
    @Override
    public Object ceilingKey(final Object o) {
        return Maps.keyOrNull(this.ceilingEntry(o));
    }
    
    @Override
    public Object higherKey(final Object o) {
        return Maps.keyOrNull(this.higherEntry(o));
    }
    
    abstract Iterator descendingEntryIterator();
    
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
    public NavigableSet navigableKeySet() {
        return new Maps$NavigableKeySet(this);
    }
    
    @Override
    public Set keySet() {
        return this.navigableKeySet();
    }
    
    @Override
    public NavigableSet descendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }
    
    @Override
    public NavigableMap descendingMap() {
        return new AbstractNavigableMap$DescendingMap(this, null);
    }
}
