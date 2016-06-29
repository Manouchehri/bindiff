/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.ComputingConcurrentHashMap$ComputationExceptionReference;
import com.google.common.collect.ComputingConcurrentHashMap$ComputedReference;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ComputingConcurrentHashMap$ComputingValueReference
implements MapMakerInternalMap$ValueReference {
    final Function computingFunction;
    @GuardedBy(value="this")
    volatile MapMakerInternalMap$ValueReference computedReference = MapMakerInternalMap.unset();

    public ComputingConcurrentHashMap$ComputingValueReference(Function function) {
        this.computingFunction = function;
    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public MapMakerInternalMap$ReferenceEntry getEntry() {
        return null;
    }

    @Override
    public MapMakerInternalMap$ValueReference copyFor(ReferenceQueue referenceQueue, @Nullable Object object, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this;
    }

    @Override
    public boolean isComputingReference() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object waitForValue() {
        if (this.computedReference != MapMakerInternalMap.UNSET) return this.computedReference.waitForValue();
        boolean bl2 = false;
        try {
            ComputingConcurrentHashMap$ComputingValueReference computingConcurrentHashMap$ComputingValueReference = this;
            synchronized (computingConcurrentHashMap$ComputingValueReference) {
                while (this.computedReference == MapMakerInternalMap.UNSET) {
                    try {
                        this.wait();
                    }
                    catch (InterruptedException var3_3) {
                        bl2 = true;
                    }
                }
                return this.computedReference.waitForValue();
            }
        }
        finally {
            if (bl2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public void clear(MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        this.setValueReference(mapMakerInternalMap$ValueReference);
    }

    Object compute(Object object, int n2) {
        Object object2;
        try {
            object2 = this.computingFunction.apply(object);
        }
        catch (Throwable var4_4) {
            this.setValueReference(new ComputingConcurrentHashMap$ComputationExceptionReference(var4_4));
            throw new ExecutionException(var4_4);
        }
        this.setValueReference(new ComputingConcurrentHashMap$ComputedReference(object2));
        return object2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setValueReference(MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        ComputingConcurrentHashMap$ComputingValueReference computingConcurrentHashMap$ComputingValueReference = this;
        synchronized (computingConcurrentHashMap$ComputingValueReference) {
            if (this.computedReference != MapMakerInternalMap.UNSET) return;
            this.computedReference = mapMakerInternalMap$ValueReference;
            this.notifyAll();
            return;
        }
    }
}

