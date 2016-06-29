/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

class MapMakerInternalMap$WeakEntry
extends WeakReference
implements MapMakerInternalMap$ReferenceEntry {
    final int hash;
    final MapMakerInternalMap$ReferenceEntry next;
    volatile MapMakerInternalMap$ValueReference valueReference = MapMakerInternalMap.unset();

    MapMakerInternalMap$WeakEntry(ReferenceQueue referenceQueue, Object object, int n2, @Nullable MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        super(object, referenceQueue);
        this.hash = n2;
        this.next = mapMakerInternalMap$ReferenceEntry;
    }

    @Override
    public Object getKey() {
        return this.get();
    }

    @Override
    public long getExpirationTime() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setExpirationTime(long l2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextExpirable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPreviousExpirable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setNextEvictable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setPreviousEvictable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MapMakerInternalMap$ValueReference getValueReference() {
        return this.valueReference;
    }

    @Override
    public void setValueReference(MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference2 = this.valueReference;
        this.valueReference = mapMakerInternalMap$ValueReference;
        mapMakerInternalMap$ValueReference2.clear(mapMakerInternalMap$ValueReference);
    }

    @Override
    public int getHash() {
        return this.hash;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getNext() {
        return this.next;
    }
}

