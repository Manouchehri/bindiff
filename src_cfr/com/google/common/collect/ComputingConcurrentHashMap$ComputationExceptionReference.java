/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;

final class ComputingConcurrentHashMap$ComputationExceptionReference
implements MapMakerInternalMap$ValueReference {
    final Throwable t;

    ComputingConcurrentHashMap$ComputationExceptionReference(Throwable throwable) {
        this.t = throwable;
    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public MapMakerInternalMap.ReferenceEntry getEntry() {
        return null;
    }

    @Override
    public MapMakerInternalMap$ValueReference copyFor(ReferenceQueue referenceQueue, Object object, MapMakerInternalMap.ReferenceEntry referenceEntry) {
        return this;
    }

    @Override
    public boolean isComputingReference() {
        return false;
    }

    @Override
    public Object waitForValue() {
        throw new ExecutionException(this.t);
    }

    @Override
    public void clear(MapMakerInternalMap$ValueReference valueReference) {
    }
}

