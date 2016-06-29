package com.google.common.collect;

import java.util.*;

final class MapMakerInternalMap$EvictionQueue extends AbstractQueue
{
    final MapMakerInternalMap$ReferenceEntry head;
    
    MapMakerInternalMap$EvictionQueue() {
        this.head = new MapMakerInternalMap$EvictionQueue$1(this);
    }
    
    public boolean offer(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        MapMakerInternalMap.connectEvictables(mapMakerInternalMap$ReferenceEntry.getPreviousEvictable(), mapMakerInternalMap$ReferenceEntry.getNextEvictable());
        MapMakerInternalMap.connectEvictables(this.head.getPreviousEvictable(), mapMakerInternalMap$ReferenceEntry);
        MapMakerInternalMap.connectEvictables(mapMakerInternalMap$ReferenceEntry, this.head);
        return true;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry peek() {
        final MapMakerInternalMap$ReferenceEntry nextEvictable = this.head.getNextEvictable();
        return (nextEvictable == this.head) ? null : nextEvictable;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry poll() {
        final MapMakerInternalMap$ReferenceEntry nextEvictable = this.head.getNextEvictable();
        if (nextEvictable == this.head) {
            return null;
        }
        this.remove(nextEvictable);
        return nextEvictable;
    }
    
    @Override
    public boolean remove(final Object o) {
        final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)o;
        final MapMakerInternalMap$ReferenceEntry previousEvictable = mapMakerInternalMap$ReferenceEntry.getPreviousEvictable();
        final MapMakerInternalMap$ReferenceEntry nextEvictable = mapMakerInternalMap$ReferenceEntry.getNextEvictable();
        MapMakerInternalMap.connectEvictables(previousEvictable, nextEvictable);
        MapMakerInternalMap.nullifyEvictable(mapMakerInternalMap$ReferenceEntry);
        return nextEvictable != MapMakerInternalMap$NullEntry.INSTANCE;
    }
    
    @Override
    public boolean contains(final Object o) {
        return ((MapMakerInternalMap$ReferenceEntry)o).getNextEvictable() != MapMakerInternalMap$NullEntry.INSTANCE;
    }
    
    @Override
    public boolean isEmpty() {
        return this.head.getNextEvictable() == this.head;
    }
    
    @Override
    public int size() {
        int n = 0;
        for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextEvictable(); mapMakerInternalMap$ReferenceEntry != this.head; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNextEvictable()) {
            ++n;
        }
        return n;
    }
    
    @Override
    public void clear() {
        MapMakerInternalMap$ReferenceEntry nextEvictable2;
        for (MapMakerInternalMap$ReferenceEntry nextEvictable = this.head.getNextEvictable(); nextEvictable != this.head; nextEvictable = nextEvictable2) {
            nextEvictable2 = nextEvictable.getNextEvictable();
            MapMakerInternalMap.nullifyEvictable(nextEvictable);
        }
        this.head.setNextEvictable(this.head);
        this.head.setPreviousEvictable(this.head);
    }
    
    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$EvictionQueue$2(this, this.peek());
    }
}
