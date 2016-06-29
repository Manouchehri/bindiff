/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue$1;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue$2;
import com.google.common.collect.MapMakerInternalMap$NullEntry;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

final class MapMakerInternalMap$EvictionQueue
extends AbstractQueue {
    final MapMakerInternalMap$ReferenceEntry head;

    MapMakerInternalMap$EvictionQueue() {
        this.head = new MapMakerInternalMap$EvictionQueue$1(this);
    }

    @Override
    public boolean offer(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        MapMakerInternalMap.connectEvictables(mapMakerInternalMap$ReferenceEntry.getPreviousEvictable(), mapMakerInternalMap$ReferenceEntry.getNextEvictable());
        MapMakerInternalMap.connectEvictables(this.head.getPreviousEvictable(), mapMakerInternalMap$ReferenceEntry);
        MapMakerInternalMap.connectEvictables(mapMakerInternalMap$ReferenceEntry, this.head);
        return true;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry peek() {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextEvictable();
        if (mapMakerInternalMap$ReferenceEntry == this.head) {
            return null;
        }
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry;
        return mapMakerInternalMap$ReferenceEntry2;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry poll() {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextEvictable();
        if (mapMakerInternalMap$ReferenceEntry == this.head) {
            return null;
        }
        this.remove(mapMakerInternalMap$ReferenceEntry);
        return mapMakerInternalMap$ReferenceEntry;
    }

    @Override
    public boolean remove(Object object) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)object;
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry.getPreviousEvictable();
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry.getNextEvictable();
        MapMakerInternalMap.connectEvictables(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry3);
        MapMakerInternalMap.nullifyEvictable(mapMakerInternalMap$ReferenceEntry);
        if (mapMakerInternalMap$ReferenceEntry3 == MapMakerInternalMap$NullEntry.INSTANCE) return false;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)object;
        if (mapMakerInternalMap$ReferenceEntry.getNextEvictable() == MapMakerInternalMap$NullEntry.INSTANCE) return false;
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (this.head.getNextEvictable() != this.head) return false;
        return true;
    }

    @Override
    public int size() {
        int n2 = 0;
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextEvictable();
        while (mapMakerInternalMap$ReferenceEntry != this.head) {
            ++n2;
            mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNextEvictable();
        }
        return n2;
    }

    @Override
    public void clear() {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextEvictable();
        do {
            if (mapMakerInternalMap$ReferenceEntry == this.head) {
                this.head.setNextEvictable(this.head);
                this.head.setPreviousEvictable(this.head);
                return;
            }
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry.getNextEvictable();
            MapMakerInternalMap.nullifyEvictable(mapMakerInternalMap$ReferenceEntry);
            mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry2;
        } while (true);
    }

    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$EvictionQueue$2(this, this.peek());
    }
}

