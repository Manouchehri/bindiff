package com.google.common.collect;

import java.util.*;

final class MapMakerInternalMap$ExpirationQueue extends AbstractQueue
{
    final MapMakerInternalMap$ReferenceEntry head;
    
    MapMakerInternalMap$ExpirationQueue() {
        this.head = new MapMakerInternalMap$ExpirationQueue$1(this);
    }
    
    public boolean offer(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        MapMakerInternalMap.connectExpirables(mapMakerInternalMap$ReferenceEntry.getPreviousExpirable(), mapMakerInternalMap$ReferenceEntry.getNextExpirable());
        MapMakerInternalMap.connectExpirables(this.head.getPreviousExpirable(), mapMakerInternalMap$ReferenceEntry);
        MapMakerInternalMap.connectExpirables(mapMakerInternalMap$ReferenceEntry, this.head);
        return true;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry peek() {
        final MapMakerInternalMap$ReferenceEntry nextExpirable = this.head.getNextExpirable();
        return (nextExpirable == this.head) ? null : nextExpirable;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry poll() {
        final MapMakerInternalMap$ReferenceEntry nextExpirable = this.head.getNextExpirable();
        if (nextExpirable == this.head) {
            return null;
        }
        this.remove(nextExpirable);
        return nextExpirable;
    }
    
    @Override
    public boolean remove(final Object o) {
        final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)o;
        final MapMakerInternalMap$ReferenceEntry previousExpirable = mapMakerInternalMap$ReferenceEntry.getPreviousExpirable();
        final MapMakerInternalMap$ReferenceEntry nextExpirable = mapMakerInternalMap$ReferenceEntry.getNextExpirable();
        MapMakerInternalMap.connectExpirables(previousExpirable, nextExpirable);
        MapMakerInternalMap.nullifyExpirable(mapMakerInternalMap$ReferenceEntry);
        return nextExpirable != MapMakerInternalMap$NullEntry.INSTANCE;
    }
    
    @Override
    public boolean contains(final Object o) {
        return ((MapMakerInternalMap$ReferenceEntry)o).getNextExpirable() != MapMakerInternalMap$NullEntry.INSTANCE;
    }
    
    @Override
    public boolean isEmpty() {
        return this.head.getNextExpirable() == this.head;
    }
    
    @Override
    public int size() {
        int n = 0;
        for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextExpirable(); mapMakerInternalMap$ReferenceEntry != this.head; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNextExpirable()) {
            ++n;
        }
        return n;
    }
    
    @Override
    public void clear() {
        MapMakerInternalMap$ReferenceEntry nextExpirable2;
        for (MapMakerInternalMap$ReferenceEntry nextExpirable = this.head.getNextExpirable(); nextExpirable != this.head; nextExpirable = nextExpirable2) {
            nextExpirable2 = nextExpirable.getNextExpirable();
            MapMakerInternalMap.nullifyExpirable(nextExpirable);
        }
        this.head.setNextExpirable(this.head);
        this.head.setPreviousExpirable(this.head);
    }
    
    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$ExpirationQueue$2(this, this.peek());
    }
}
