package com.google.common.collect;

import com.google.common.base.*;
import java.util.concurrent.atomic.*;

final class ComputingConcurrentHashMap$ComputingSegment extends MapMakerInternalMap$Segment
{
    ComputingConcurrentHashMap$ComputingSegment(final MapMakerInternalMap mapMakerInternalMap, final int n, final int n2) {
        super(mapMakerInternalMap, n, n2);
    }
    
    Object getOrCompute(final Object o, final int n, final Function function) {
        try {
            Object waitForValue;
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
            do {
                mapMakerInternalMap$ReferenceEntry = this.getEntry(o, n);
                if (mapMakerInternalMap$ReferenceEntry != null) {
                    final Object liveValue = this.getLiveValue(mapMakerInternalMap$ReferenceEntry);
                    if (liveValue != null) {
                        this.recordRead(mapMakerInternalMap$ReferenceEntry);
                        return liveValue;
                    }
                }
                if (mapMakerInternalMap$ReferenceEntry == null || !mapMakerInternalMap$ReferenceEntry.getValueReference().isComputingReference()) {
                    boolean b = true;
                    ComputingConcurrentHashMap$ComputingValueReference computingConcurrentHashMap$ComputingValueReference = null;
                    this.lock();
                    try {
                        this.preWriteCleanup();
                        final int count = this.count - 1;
                        final AtomicReferenceArray table = this.table;
                        final int n2 = n & table.length() - 1;
                        final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry = table.get(n2);
                        while (mapMakerInternalMap$ReferenceEntry != null) {
                            final Object key = mapMakerInternalMap$ReferenceEntry.getKey();
                            if (mapMakerInternalMap$ReferenceEntry.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                                if (mapMakerInternalMap$ReferenceEntry.getValueReference().isComputingReference()) {
                                    b = false;
                                    break;
                                }
                                final Object value = mapMakerInternalMap$ReferenceEntry.getValueReference().get();
                                if (value == null) {
                                    this.enqueueNotification(key, n, value, MapMaker$RemovalCause.COLLECTED);
                                }
                                else {
                                    if (!this.map.expires() || !this.map.isExpired(mapMakerInternalMap$ReferenceEntry)) {
                                        this.recordLockedRead(mapMakerInternalMap$ReferenceEntry);
                                        return value;
                                    }
                                    this.enqueueNotification(key, n, value, MapMaker$RemovalCause.EXPIRED);
                                }
                                this.evictionQueue.remove(mapMakerInternalMap$ReferenceEntry);
                                this.expirationQueue.remove(mapMakerInternalMap$ReferenceEntry);
                                this.count = count;
                                break;
                            }
                            else {
                                mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext();
                            }
                        }
                        if (b) {
                            computingConcurrentHashMap$ComputingValueReference = new ComputingConcurrentHashMap$ComputingValueReference(function);
                            if (mapMakerInternalMap$ReferenceEntry == null) {
                                mapMakerInternalMap$ReferenceEntry = this.newEntry(o, n, mapMakerInternalMap$ReferenceEntry2);
                                mapMakerInternalMap$ReferenceEntry.setValueReference(computingConcurrentHashMap$ComputingValueReference);
                                table.set(n2, mapMakerInternalMap$ReferenceEntry);
                            }
                            else {
                                mapMakerInternalMap$ReferenceEntry.setValueReference(computingConcurrentHashMap$ComputingValueReference);
                            }
                        }
                    }
                    finally {
                        this.unlock();
                        this.postWriteCleanup();
                    }
                    if (b) {
                        return this.compute(o, n, mapMakerInternalMap$ReferenceEntry, computingConcurrentHashMap$ComputingValueReference);
                    }
                }
                Preconditions.checkState(!Thread.holdsLock(mapMakerInternalMap$ReferenceEntry), (Object)"Recursive computation");
                waitForValue = mapMakerInternalMap$ReferenceEntry.getValueReference().waitForValue();
            } while (waitForValue == null);
            this.recordRead(mapMakerInternalMap$ReferenceEntry);
            return waitForValue;
        }
        finally {
            this.postReadCleanup();
        }
    }
    
    Object compute(final Object o, final int n, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final ComputingConcurrentHashMap$ComputingValueReference computingConcurrentHashMap$ComputingValueReference) {
        Object compute = null;
        System.nanoTime();
        long nanoTime = 0L;
        try {
            synchronized (mapMakerInternalMap$ReferenceEntry) {
                compute = computingConcurrentHashMap$ComputingValueReference.compute(o, n);
                nanoTime = System.nanoTime();
            }
            if (compute != null && this.put(o, n, compute, true) != null) {
                this.enqueueNotification(o, n, compute, MapMaker$RemovalCause.REPLACED);
            }
            return compute;
        }
        finally {
            if (nanoTime == 0L) {
                System.nanoTime();
            }
            if (compute == null) {
                this.clearValue(o, n, computingConcurrentHashMap$ComputingValueReference);
            }
        }
    }
}
