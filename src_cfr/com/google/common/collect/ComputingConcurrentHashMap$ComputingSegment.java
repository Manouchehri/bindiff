/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComputingConcurrentHashMap$ComputingValueReference;
import com.google.common.collect.MapMaker$RemovalCause;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReferenceArray;

final class ComputingConcurrentHashMap$ComputingSegment
extends MapMakerInternalMap$Segment {
    ComputingConcurrentHashMap$ComputingSegment(MapMakerInternalMap mapMakerInternalMap, int n2, int n3) {
        super(mapMakerInternalMap, n2, n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object getOrCompute(Object object, int n2, Function function) {
        try {
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
            Object object2;
            Object object3;
            do {
                if ((mapMakerInternalMap$ReferenceEntry = this.getEntry(object, n2)) != null && (object3 = this.getLiveValue(mapMakerInternalMap$ReferenceEntry)) != null) {
                    this.recordRead(mapMakerInternalMap$ReferenceEntry);
                    object2 = object3;
                    return object2;
                }
                if (mapMakerInternalMap$ReferenceEntry == null || !mapMakerInternalMap$ReferenceEntry.getValueReference().isComputingReference()) {
                    boolean bl2;
                    bl2 = true;
                    object2 = null;
                    this.lock();
                    try {
                        this.preWriteCleanup();
                        int n3 = this.count - 1;
                        AtomicReferenceArray atomicReferenceArray = this.table;
                        int n4 = n2 & atomicReferenceArray.length() - 1;
                        for (mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry2 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n4); mapMakerInternalMap$ReferenceEntry != null; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext()) {
                            Object object4 = mapMakerInternalMap$ReferenceEntry.getKey();
                            if (mapMakerInternalMap$ReferenceEntry.getHash() != n2 || object4 == null || !this.map.keyEquivalence.equivalent(object, object4)) continue;
                            MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference = mapMakerInternalMap$ReferenceEntry.getValueReference();
                            if (mapMakerInternalMap$ValueReference.isComputingReference()) {
                                bl2 = false;
                                break;
                            }
                            Object object5 = mapMakerInternalMap$ReferenceEntry.getValueReference().get();
                            if (object5 == null) {
                                this.enqueueNotification(object4, n2, object5, MapMaker$RemovalCause.COLLECTED);
                            } else if (this.map.expires() && this.map.isExpired(mapMakerInternalMap$ReferenceEntry)) {
                                this.enqueueNotification(object4, n2, object5, MapMaker$RemovalCause.EXPIRED);
                            } else {
                                this.recordLockedRead(mapMakerInternalMap$ReferenceEntry);
                                Object object6 = object5;
                                return object6;
                            }
                            this.evictionQueue.remove(mapMakerInternalMap$ReferenceEntry);
                            this.expirationQueue.remove(mapMakerInternalMap$ReferenceEntry);
                            this.count = n3;
                            break;
                        }
                        if (bl2) {
                            object2 = new ComputingConcurrentHashMap$ComputingValueReference(function);
                            if (mapMakerInternalMap$ReferenceEntry == null) {
                                MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2;
                                mapMakerInternalMap$ReferenceEntry = this.newEntry(object, n2, mapMakerInternalMap$ReferenceEntry2);
                                mapMakerInternalMap$ReferenceEntry.setValueReference((MapMakerInternalMap$ValueReference)object2);
                                atomicReferenceArray.set(n4, mapMakerInternalMap$ReferenceEntry);
                            } else {
                                mapMakerInternalMap$ReferenceEntry.setValueReference((MapMakerInternalMap$ValueReference)object2);
                            }
                        }
                    }
                    finally {
                        this.unlock();
                        this.postWriteCleanup();
                    }
                    if (bl2) {
                        Object object7 = this.compute(object, n2, mapMakerInternalMap$ReferenceEntry, (ComputingConcurrentHashMap$ComputingValueReference)object2);
                        return object7;
                    }
                }
                Preconditions.checkState(!Thread.holdsLock(mapMakerInternalMap$ReferenceEntry), "Recursive computation");
            } while ((object3 = mapMakerInternalMap$ReferenceEntry.getValueReference().waitForValue()) == null);
            this.recordRead(mapMakerInternalMap$ReferenceEntry);
            object2 = object3;
            return object2;
        }
        finally {
            this.postReadCleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object compute(Object object, int n2, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, ComputingConcurrentHashMap$ComputingValueReference computingConcurrentHashMap$ComputingValueReference) {
        Object object2 = null;
        long l2 = System.nanoTime();
        long l3 = 0;
        try {
            Object object3 = mapMakerInternalMap$ReferenceEntry;
            synchronized (object3) {
                object2 = computingConcurrentHashMap$ComputingValueReference.compute(object, n2);
                l3 = System.nanoTime();
            }
            if (object2 != null && (object3 = this.put(object, n2, object2, true)) != null) {
                this.enqueueNotification(object, n2, object2, MapMaker$RemovalCause.REPLACED);
            }
            object3 = object2;
            return object3;
        }
        finally {
            if (l3 == 0) {
                l3 = System.nanoTime();
            }
            if (object2 == null) {
                this.clearValue(object, n2, computingConcurrentHashMap$ComputingValueReference);
            }
        }
    }
}

