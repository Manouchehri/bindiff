/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class ComputingConcurrentHashMap$ComputedReference
implements MapMakerInternalMap$ValueReference {
    final Object value;

    ComputingConcurrentHashMap$ComputedReference(@Nullable Object object) {
        this.value = object;
    }

    @Override
    public Object get() {
        return this.value;
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

