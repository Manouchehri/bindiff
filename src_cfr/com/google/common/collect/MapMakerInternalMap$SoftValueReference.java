/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

final class MapMakerInternalMap$SoftValueReference
extends SoftReference
implements MapMakerInternalMap$ValueReference {
    final MapMakerInternalMap$ReferenceEntry entry;

    MapMakerInternalMap$SoftValueReference(ReferenceQueue referenceQueue, Object object, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
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
        return new MapMakerInternalMap$SoftValueReference(referenceQueue, object, mapMakerInternalMap$ReferenceEntry);
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

