/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;

final class MapMakerInternalMap$StrongValueReference
implements MapMakerInternalMap$ValueReference {
    final Object referent;

    MapMakerInternalMap$StrongValueReference(Object object) {
        this.referent = object;
    }

    @Override
    public Object get() {
        return this.referent;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getEntry() {
        return null;
    }

    @Override
    public MapMakerInternalMap$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this;
    }

    @Override
    public boolean isComputingReference() {
        return false;
    }

    @Override
    public Object waitForValue() {
        return this.get();
    }

    @Override
    public void clear(MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
    }
}

