/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue$1;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue$2;
import com.google.common.collect.MapMakerInternalMap$NullEntry;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import java.util.AbstractQueue;
import java.util.Iterator;

final class MapMakerInternalMap$ExpirationQueue
extends AbstractQueue {
    final MapMakerInternalMap$ReferenceEntry head;

    MapMakerInternalMap$ExpirationQueue() {
        this.head = new MapMakerInternalMap$ExpirationQueue$1(this);
    }

    @Override
    public boolean offer(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        MapMakerInternalMap.connectExpirables(mapMakerInternalMap$ReferenceEntry.getPreviousExpirable(), mapMakerInternalMap$ReferenceEntry.getNextExpirable());
        MapMakerInternalMap.connectExpirables(this.head.getPreviousExpirable(), mapMakerInternalMap$ReferenceEntry);
        MapMakerInternalMap.connectExpirables(mapMakerInternalMap$ReferenceEntry, this.head);
        return true;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry peek() {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextExpirable();
        if (mapMakerInternalMap$ReferenceEntry == this.head) {
            return null;
        }
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry;
        return mapMakerInternalMap$ReferenceEntry2;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry poll() {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextExpirable();
        if (mapMakerInternalMap$ReferenceEntry == this.head) {
            return null;
        }
        this.remove(mapMakerInternalMap$ReferenceEntry);
        return mapMakerInternalMap$ReferenceEntry;
    }

    @Override
    public boolean remove(Object object) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)object;
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry.getPreviousExpirable();
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry.getNextExpirable();
        MapMakerInternalMap.connectExpirables(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry3);
        MapMakerInternalMap.nullifyExpirable(mapMakerInternalMap$ReferenceEntry);
        if (mapMakerInternalMap$ReferenceEntry3 == MapMakerInternalMap$NullEntry.INSTANCE) return false;
        return true;
    }

    @Override
    public boolean contains(Object object) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)object;
        if (mapMakerInternalMap$ReferenceEntry.getNextExpirable() == MapMakerInternalMap$NullEntry.INSTANCE) return false;
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (this.head.getNextExpirable() != this.head) return false;
        return true;
    }

    @Override
    public int size() {
        int n2 = 0;
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextExpirable();
        while (mapMakerInternalMap$ReferenceEntry != this.head) {
            ++n2;
            mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNextExpirable();
        }
        return n2;
    }

    @Override
    public void clear() {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.head.getNextExpirable();
        do {
            if (mapMakerInternalMap$ReferenceEntry == this.head) {
                this.head.setNextExpirable(this.head);
                this.head.setPreviousExpirable(this.head);
                return;
            }
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry.getNextExpirable();
            MapMakerInternalMap.nullifyExpirable(mapMakerInternalMap$ReferenceEntry);
            mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry2;
        } while (true);
    }

    @Override
    public Iterator iterator() {
        return new MapMakerInternalMap$ExpirationQueue$2(this, this.peek());
    }
}

