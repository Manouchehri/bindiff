package com.google.common.collect;

import com.google.common.annotations.*;
import java.util.*;

public abstract class ForwardingNavigableMap extends ForwardingSortedMap implements NavigableMap
{
    @Override
    protected abstract NavigableMap delegate();
    
    @Override
    public Entry lowerEntry(final Object o) {
        return (Entry)this.delegate().lowerEntry(o);
    }
    
    protected Entry standardLowerEntry(final Object o) {
        return (Entry)this.headMap(o, false).lastEntry();
    }
    
    @Override
    public Object lowerKey(final Object o) {
        return this.delegate().lowerKey(o);
    }
    
    protected Object standardLowerKey(final Object o) {
        return Maps.keyOrNull(this.lowerEntry(o));
    }
    
    @Override
    public Entry floorEntry(final Object o) {
        return (Entry)this.delegate().floorEntry(o);
    }
    
    protected Entry standardFloorEntry(final Object o) {
        return (Entry)this.headMap(o, true).lastEntry();
    }
    
    @Override
    public Object floorKey(final Object o) {
        return this.delegate().floorKey(o);
    }
    
    protected Object standardFloorKey(final Object o) {
        return Maps.keyOrNull(this.floorEntry(o));
    }
    
    @Override
    public Entry ceilingEntry(final Object o) {
        return (Entry)this.delegate().ceilingEntry(o);
    }
    
    protected Entry standardCeilingEntry(final Object o) {
        return (Entry)this.tailMap(o, true).firstEntry();
    }
    
    @Override
    public Object ceilingKey(final Object o) {
        return this.delegate().ceilingKey(o);
    }
    
    protected Object standardCeilingKey(final Object o) {
        return Maps.keyOrNull(this.ceilingEntry(o));
    }
    
    @Override
    public Entry higherEntry(final Object o) {
        return (Entry)this.delegate().higherEntry(o);
    }
    
    protected Entry standardHigherEntry(final Object o) {
        return (Entry)this.tailMap(o, false).firstEntry();
    }
    
    @Override
    public Object higherKey(final Object o) {
        return this.delegate().higherKey(o);
    }
    
    protected Object standardHigherKey(final Object o) {
        return Maps.keyOrNull(this.higherEntry(o));
    }
    
    @Override
    public Entry firstEntry() {
        return (Entry)this.delegate().firstEntry();
    }
    
    protected Entry standardFirstEntry() {
        return (Entry)Iterables.getFirst(this.entrySet(), null);
    }
    
    protected Object standardFirstKey() {
        final Entry firstEntry = this.firstEntry();
        if (firstEntry == null) {
            throw new NoSuchElementException();
        }
        return firstEntry.getKey();
    }
    
    @Override
    public Entry lastEntry() {
        return (Entry)this.delegate().lastEntry();
    }
    
    protected Entry standardLastEntry() {
        return (Entry)Iterables.getFirst(this.descendingMap().entrySet(), null);
    }
    
    protected Object standardLastKey() {
        final Entry lastEntry = this.lastEntry();
        if (lastEntry == null) {
            throw new NoSuchElementException();
        }
        return lastEntry.getKey();
    }
    
    @Override
    public Entry pollFirstEntry() {
        return (Entry)this.delegate().pollFirstEntry();
    }
    
    protected Entry standardPollFirstEntry() {
        return (Entry)Iterators.pollNext(this.entrySet().iterator());
    }
    
    @Override
    public Entry pollLastEntry() {
        return (Entry)this.delegate().pollLastEntry();
    }
    
    protected Entry standardPollLastEntry() {
        return (Entry)Iterators.pollNext(this.descendingMap().entrySet().iterator());
    }
    
    @Override
    public NavigableMap descendingMap() {
        return this.delegate().descendingMap();
    }
    
    @Override
    public NavigableSet navigableKeySet() {
        return this.delegate().navigableKeySet();
    }
    
    @Override
    public NavigableSet descendingKeySet() {
        return this.delegate().descendingKeySet();
    }
    
    @Beta
    protected NavigableSet standardDescendingKeySet() {
        return this.descendingMap().navigableKeySet();
    }
    
    @Override
    protected SortedMap standardSubMap(final Object o, final Object o2) {
        return this.subMap(o, true, o2, false);
    }
    
    @Override
    public NavigableMap subMap(final Object o, final boolean b, final Object o2, final boolean b2) {
        return this.delegate().subMap(o, b, o2, b2);
    }
    
    @Override
    public NavigableMap headMap(final Object o, final boolean b) {
        return this.delegate().headMap(o, b);
    }
    
    @Override
    public NavigableMap tailMap(final Object o, final boolean b) {
        return this.delegate().tailMap(o, b);
    }
    
    protected SortedMap standardHeadMap(final Object o) {
        return this.headMap(o, false);
    }
    
    protected SortedMap standardTailMap(final Object o) {
        return this.tailMap(o, true);
    }
}
