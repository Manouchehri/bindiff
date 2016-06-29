/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class MapMakerInternalMap$WeakValueReference
extends WeakReference
implements MapMakerInternalMap$ValueReference {
    final MapMakerInternalMap$ReferenceEntry entry;

    MapMakerInternalMap$WeakValueReference(ReferenceQueue referenceQueue, Object object, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        super(object, referenceQueue);
        this.entry = mapMakerInternalMap$ReferenceEntry;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getEntry() {
        return this.entry;
    }

    @Override
    public void clear(MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        this.clear();
    }

    @Override
    public MapMakerInternalMap$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return new MapMakerInternalMap$WeakValueReference(referenceQueue, object, mapMakerInternalMap$ReferenceEntry);
    }

    @Override
    public boolean isComputingReference() {
        return false;
    }

    @Override
    public Object waitForValue() {
        return this.get();
    }
}

