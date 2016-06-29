/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Ticker;
import com.google.common.collect.MapMaker$RemovalCause;
import com.google.common.collect.MapMaker$RemovalNotification;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$EntryFactory;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import com.google.j2objc.annotations.Weak;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class MapMakerInternalMap$Segment
extends ReentrantLock {
    @Weak
    final MapMakerInternalMap map;
    volatile int count;
    int modCount;
    int threshold;
    volatile AtomicReferenceArray table;
    final int maxSegmentSize;
    final ReferenceQueue keyReferenceQueue;
    final ReferenceQueue valueReferenceQueue;
    final Queue recencyQueue;
    final AtomicInteger readCount = new AtomicInteger();
    @GuardedBy(value="this")
    final Queue evictionQueue;
    @GuardedBy(value="this")
    final Queue expirationQueue;

    MapMakerInternalMap$Segment(MapMakerInternalMap mapMakerInternalMap, int n2, int n3) {
        this.map = mapMakerInternalMap;
        this.maxSegmentSize = n3;
        this.initTable(this.newEntryArray(n2));
        this.keyReferenceQueue = mapMakerInternalMap.usesKeyReferences() ? new ReferenceQueue() : null;
        this.valueReferenceQueue = mapMakerInternalMap.usesValueReferences() ? new ReferenceQueue() : null;
        this.recencyQueue = mapMakerInternalMap.evictsBySize() || mapMakerInternalMap.expiresAfterAccess() ? new ConcurrentLinkedQueue() : MapMakerInternalMap.discardingQueue();
        this.evictionQueue = mapMakerInternalMap.evictsBySize() ? new MapMakerInternalMap$EvictionQueue() : MapMakerInternalMap.discardingQueue();
        this.expirationQueue = mapMakerInternalMap.expires() ? new MapMakerInternalMap$ExpirationQueue() : MapMakerInternalMap.discardingQueue();
    }

    AtomicReferenceArray newEntryArray(int n2) {
        return new AtomicReferenceArray(n2);
    }

    void initTable(AtomicReferenceArray atomicReferenceArray) {
        this.threshold = atomicReferenceArray.length() * 3 / 4;
        if (this.threshold == this.maxSegmentSize) {
            ++this.threshold;
        }
        this.table = atomicReferenceArray;
    }

    @GuardedBy(value="this")
    MapMakerInternalMap$ReferenceEntry newEntry(Object object, int n2, @Nullable MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this.map.entryFactory.newEntry(this, object, n2, mapMakerInternalMap$ReferenceEntry);
    }

    @GuardedBy(value="this")
    MapMakerInternalMap$ReferenceEntry copyEntry(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        if (mapMakerInternalMap$ReferenceEntry.getKey() == null) {
            return null;
        }
        MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference = mapMakerInternalMap$ReferenceEntry.getValueReference();
        Object object = mapMakerInternalMap$ValueReference.get();
        if (object == null && !mapMakerInternalMap$ValueReference.isComputingReference()) {
            return null;
        }
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = this.map.entryFactory.copyEntry(this, mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry2);
        mapMakerInternalMap$ReferenceEntry3.setValueReference(mapMakerInternalMap$ValueReference.copyFor(this.valueReferenceQueue, object, mapMakerInternalMap$ReferenceEntry3));
        return mapMakerInternalMap$ReferenceEntry3;
    }

    @GuardedBy(value="this")
    void setValue(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, Object object) {
        MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference = this.map.valueStrength.referenceValue(this, mapMakerInternalMap$ReferenceEntry, object);
        mapMakerInternalMap$ReferenceEntry.setValueReference(mapMakerInternalMap$ValueReference);
        this.recordWrite(mapMakerInternalMap$ReferenceEntry);
    }

    void tryDrainReferenceQueues() {
        if (!this.tryLock()) return;
        try {
            this.drainReferenceQueues();
            return;
        }
        finally {
            this.unlock();
        }
    }

    @GuardedBy(value="this")
    void drainReferenceQueues() {
        if (this.map.usesKeyReferences()) {
            this.drainKeyReferenceQueue();
        }
        if (!this.map.usesValueReferences()) return;
        this.drainValueReferenceQueue();
    }

    @GuardedBy(value="this")
    void drainKeyReferenceQueue() {
        int n2 = 0;
        do {
            Reference reference;
            if ((reference = this.keyReferenceQueue.poll()) == null) return;
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)((Object)reference);
            this.map.reclaimKey(mapMakerInternalMap$ReferenceEntry);
        } while (++n2 != 16);
    }

    @GuardedBy(value="this")
    void drainValueReferenceQueue() {
        int n2 = 0;
        do {
            Reference reference;
            if ((reference = this.valueReferenceQueue.poll()) == null) return;
            MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference = (MapMakerInternalMap$ValueReference)((Object)reference);
            this.map.reclaimValue(mapMakerInternalMap$ValueReference);
        } while (++n2 != 16);
    }

    void clearReferenceQueues() {
        if (this.map.usesKeyReferences()) {
            this.clearKeyReferenceQueue();
        }
        if (!this.map.usesValueReferences()) return;
        this.clearValueReferenceQueue();
    }

    void clearKeyReferenceQueue() {
        while (this.keyReferenceQueue.poll() != null) {
        }
    }

    void clearValueReferenceQueue() {
        while (this.valueReferenceQueue.poll() != null) {
        }
    }

    void recordRead(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        if (this.map.expiresAfterAccess()) {
            this.recordExpirationTime(mapMakerInternalMap$ReferenceEntry, this.map.expireAfterAccessNanos);
        }
        this.recencyQueue.add(mapMakerInternalMap$ReferenceEntry);
    }

    @GuardedBy(value="this")
    void recordLockedRead(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.evictionQueue.add(mapMakerInternalMap$ReferenceEntry);
        if (!this.map.expiresAfterAccess()) return;
        this.recordExpirationTime(mapMakerInternalMap$ReferenceEntry, this.map.expireAfterAccessNanos);
        this.expirationQueue.add(mapMakerInternalMap$ReferenceEntry);
    }

    @GuardedBy(value="this")
    void recordWrite(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.drainRecencyQueue();
        this.evictionQueue.add(mapMakerInternalMap$ReferenceEntry);
        if (!this.map.expires()) return;
        long l2 = this.map.expiresAfterAccess() ? this.map.expireAfterAccessNanos : this.map.expireAfterWriteNanos;
        this.recordExpirationTime(mapMakerInternalMap$ReferenceEntry, l2);
        this.expirationQueue.add(mapMakerInternalMap$ReferenceEntry);
    }

    @GuardedBy(value="this")
    void drainRecencyQueue() {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
        while ((mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)this.recencyQueue.poll()) != null) {
            if (this.evictionQueue.contains(mapMakerInternalMap$ReferenceEntry)) {
                this.evictionQueue.add(mapMakerInternalMap$ReferenceEntry);
            }
            if (!this.map.expiresAfterAccess() || !this.expirationQueue.contains(mapMakerInternalMap$ReferenceEntry)) continue;
            this.expirationQueue.add(mapMakerInternalMap$ReferenceEntry);
        }
    }

    void recordExpirationTime(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, long l2) {
        mapMakerInternalMap$ReferenceEntry.setExpirationTime(this.map.ticker.read() + l2);
    }

    void tryExpireEntries() {
        if (!this.tryLock()) return;
        try {
            this.expireEntries();
            return;
        }
        finally {
            this.unlock();
        }
    }

    @GuardedBy(value="this")
    void expireEntries() {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
        this.drainRecencyQueue();
        if (this.expirationQueue.isEmpty()) {
            return;
        }
        long l2 = this.map.ticker.read();
        do {
            if ((mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)this.expirationQueue.peek()) == null) return;
            if (!this.map.isExpired(mapMakerInternalMap$ReferenceEntry, l2)) return;
        } while (this.removeEntry(mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry.getHash(), MapMaker$RemovalCause.EXPIRED));
        throw new AssertionError();
    }

    void enqueueNotification(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMaker$RemovalCause mapMaker$RemovalCause) {
        this.enqueueNotification(mapMakerInternalMap$ReferenceEntry.getKey(), mapMakerInternalMap$ReferenceEntry.getHash(), mapMakerInternalMap$ReferenceEntry.getValueReference().get(), mapMaker$RemovalCause);
    }

    void enqueueNotification(@Nullable Object object, int n2, @Nullable Object object2, MapMaker$RemovalCause mapMaker$RemovalCause) {
        Object object3;
        if (this.map.removalNotificationQueue == MapMakerInternalMap.DISCARDING_QUEUE) return;
        if (object == null && !this.map.usesKeyReferences()) {
            String string = String.valueOf((Object)mapMaker$RemovalCause);
            object3 = new StringBuilder(55 + String.valueOf(string).length()).append("Unexpected null key during removal notification, cause=").append(string).toString();
            MapMakerInternalMap.access$200().log(Level.WARNING, (String)object3, (Throwable)((Object)new AssertionError()));
        } else if (object2 == null && !this.map.usesValueReferences()) {
            String string = String.valueOf((Object)mapMaker$RemovalCause);
            object3 = new StringBuilder(57 + String.valueOf(string).length()).append("Unexpected null value during removal notification, cause=").append(string).toString();
            MapMakerInternalMap.access$200().log(Level.WARNING, (String)object3, (Throwable)((Object)new AssertionError()));
        }
        object3 = new MapMaker$RemovalNotification(object, object2, mapMaker$RemovalCause);
        this.map.removalNotificationQueue.offer(object3);
    }

    @GuardedBy(value="this")
    boolean evictEntries() {
        if (!this.map.evictsBySize()) return false;
        if (this.count < this.maxSegmentSize) return false;
        this.drainRecencyQueue();
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)this.evictionQueue.remove();
        if (this.removeEntry(mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry.getHash(), MapMaker$RemovalCause.SIZE)) return true;
        throw new AssertionError();
    }

    MapMakerInternalMap$ReferenceEntry getFirst(int n2) {
        AtomicReferenceArray atomicReferenceArray = this.table;
        return (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get(n2 & atomicReferenceArray.length() - 1);
    }

    MapMakerInternalMap$ReferenceEntry getEntry(Object object, int n2) {
        if (this.count == 0) return null;
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.getFirst(n2);
        while (mapMakerInternalMap$ReferenceEntry != null) {
            if (mapMakerInternalMap$ReferenceEntry.getHash() == n2) {
                Object object2 = mapMakerInternalMap$ReferenceEntry.getKey();
                if (object2 == null) {
                    this.tryDrainReferenceQueues();
                } else if (this.map.keyEquivalence.equivalent(object, object2)) {
                    return mapMakerInternalMap$ReferenceEntry;
                }
            }
            mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext();
        }
        return null;
    }

    MapMakerInternalMap$ReferenceEntry getLiveEntry(Object object, int n2) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.getEntry(object, n2);
        if (mapMakerInternalMap$ReferenceEntry == null) {
            return null;
        }
        if (!this.map.expires()) return mapMakerInternalMap$ReferenceEntry;
        if (!this.map.isExpired(mapMakerInternalMap$ReferenceEntry)) return mapMakerInternalMap$ReferenceEntry;
        this.tryExpireEntries();
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object get(Object object, int n2) {
        try {
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.getLiveEntry(object, n2);
            if (mapMakerInternalMap$ReferenceEntry == null) {
                Object var4_4 = null;
                return var4_4;
            }
            Object object2 = mapMakerInternalMap$ReferenceEntry.getValueReference().get();
            if (object2 != null) {
                this.recordRead(mapMakerInternalMap$ReferenceEntry);
            } else {
                this.tryDrainReferenceQueues();
            }
            Object object3 = object2;
            return object3;
        }
        finally {
            this.postReadCleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean containsKey(Object object, int n2) {
        try {
            if (this.count != 0) {
                MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.getLiveEntry(object, n2);
                if (mapMakerInternalMap$ReferenceEntry == null) {
                    boolean bl2 = false;
                    return bl2;
                }
                boolean bl3 = mapMakerInternalMap$ReferenceEntry.getValueReference().get() != null;
                return bl3;
            }
            boolean bl4 = false;
            return bl4;
        }
        finally {
            this.postReadCleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @VisibleForTesting
    boolean containsValue(Object var1_1) {
        if (this.count == 0) ** GOTO lbl-1000
        var2_2 = this.table;
        var3_4 = var2_2.length();
        var4_5 = 0;
lbl6: // 2 sources:
        if (var4_5 < var3_4) {
        } else lbl-1000: // 2 sources:
        {
            var2_3 = false;
            return var2_3;
            finally {
                this.postReadCleanup();
            }
        }
        for (var5_6 = (MapMakerInternalMap$ReferenceEntry)var2_2.get((int)var4_5); var5_6 != null; var5_6 = var5_6.getNext()) {
            var6_7 = this.getLiveValue(var5_6);
            if (var6_7 == null || !this.map.valueEquivalence.equivalent(var1_1, var6_7)) continue;
            var7_8 = true;
            return var7_8;
        }
        ++var4_5;
        ** GOTO lbl6
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object put(Object object, int n2, Object object2, boolean bl2) {
        int n3;
        block14 : {
            Object object3;
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2;
            this.lock();
            this.preWriteCleanup();
            n3 = this.count + 1;
            if (n3 > this.threshold) {
                this.expand();
                n3 = this.count + 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n4 = n2 & atomicReferenceArray.length() - 1;
            for (mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n4); mapMakerInternalMap$ReferenceEntry2 != null; mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry2.getNext()) {
                object3 = mapMakerInternalMap$ReferenceEntry2.getKey();
                if (mapMakerInternalMap$ReferenceEntry2.getHash() != n2 || object3 == null || !this.map.keyEquivalence.equivalent(object, object3)) continue;
                MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference = mapMakerInternalMap$ReferenceEntry2.getValueReference();
                Object object4 = mapMakerInternalMap$ValueReference.get();
                if (object4 == null) {
                    ++this.modCount;
                    this.setValue(mapMakerInternalMap$ReferenceEntry2, object2);
                    if (!mapMakerInternalMap$ValueReference.isComputingReference()) {
                        this.enqueueNotification(object, n2, object4, MapMaker$RemovalCause.COLLECTED);
                        n3 = this.count;
                    } else if (this.evictEntries()) {
                        n3 = this.count + 1;
                    }
                    break block14;
                }
                if (bl2) {
                    this.recordLockedRead(mapMakerInternalMap$ReferenceEntry2);
                    Object object5 = object4;
                    return object5;
                }
                ++this.modCount;
                this.enqueueNotification(object, n2, object4, MapMaker$RemovalCause.REPLACED);
                this.setValue(mapMakerInternalMap$ReferenceEntry2, object2);
                Object object6 = object4;
                return object6;
            }
            ++this.modCount;
            mapMakerInternalMap$ReferenceEntry2 = this.newEntry(object, n2, mapMakerInternalMap$ReferenceEntry);
            this.setValue(mapMakerInternalMap$ReferenceEntry2, object2);
            atomicReferenceArray.set(n4, mapMakerInternalMap$ReferenceEntry2);
            if (this.evictEntries()) {
                n3 = this.count + 1;
            }
            this.count = n3;
            object3 = null;
            return object3;
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }
        this.count = n3;
        Object var13_13 = null;
        return var13_13;
    }

    @GuardedBy(value="this")
    void expand() {
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n2 = atomicReferenceArray.length();
        if (n2 >= 1073741824) {
            return;
        }
        int n3 = this.count;
        AtomicReferenceArray atomicReferenceArray2 = this.newEntryArray(n2 << 1);
        this.threshold = atomicReferenceArray2.length() * 3 / 4;
        int n4 = atomicReferenceArray2.length() - 1;
        int n5 = 0;
        do {
            if (n5 >= n2) {
                this.table = atomicReferenceArray2;
                this.count = n3;
                return;
            }
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get(n5);
            if (mapMakerInternalMap$ReferenceEntry != null) {
                MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry.getNext();
                int n6 = mapMakerInternalMap$ReferenceEntry.getHash() & n4;
                if (mapMakerInternalMap$ReferenceEntry2 == null) {
                    atomicReferenceArray2.set(n6, mapMakerInternalMap$ReferenceEntry);
                } else {
                    int n7;
                    MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3;
                    MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry4 = mapMakerInternalMap$ReferenceEntry;
                    int n8 = n6;
                    for (mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry2; mapMakerInternalMap$ReferenceEntry3 != null; mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry3.getNext()) {
                        n7 = mapMakerInternalMap$ReferenceEntry3.getHash() & n4;
                        if (n7 == n8) continue;
                        n8 = n7;
                        mapMakerInternalMap$ReferenceEntry4 = mapMakerInternalMap$ReferenceEntry3;
                    }
                    atomicReferenceArray2.set(n8, mapMakerInternalMap$ReferenceEntry4);
                    for (mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry; mapMakerInternalMap$ReferenceEntry3 != mapMakerInternalMap$ReferenceEntry4; mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry3.getNext()) {
                        n7 = mapMakerInternalMap$ReferenceEntry3.getHash() & n4;
                        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry5 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray2.get(n7);
                        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry6 = this.copyEntry(mapMakerInternalMap$ReferenceEntry3, mapMakerInternalMap$ReferenceEntry5);
                        if (mapMakerInternalMap$ReferenceEntry6 != null) {
                            atomicReferenceArray2.set(n7, mapMakerInternalMap$ReferenceEntry6);
                            continue;
                        }
                        this.removeCollectedEntry(mapMakerInternalMap$ReferenceEntry3);
                        --n3;
                    }
                }
            }
            ++n5;
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean replace(Object object, int n2, Object object2, Object object3) {
        this.lock();
        try {
            this.preWriteCleanup();
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n3 = n2 & atomicReferenceArray.length() - 1;
            for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry2 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n3); mapMakerInternalMap$ReferenceEntry != null; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext()) {
                Object object4 = mapMakerInternalMap$ReferenceEntry.getKey();
                if (mapMakerInternalMap$ReferenceEntry.getHash() != n2 || object4 == null || !this.map.keyEquivalence.equivalent(object, object4)) continue;
                MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference = mapMakerInternalMap$ReferenceEntry.getValueReference();
                Object object5 = mapMakerInternalMap$ValueReference.get();
                if (object5 == null) {
                    int n4;
                    if (this.isCollected(mapMakerInternalMap$ValueReference)) {
                        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2;
                        n4 = this.count - 1;
                        ++this.modCount;
                        this.enqueueNotification(object4, n2, object5, MapMaker$RemovalCause.COLLECTED);
                        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = this.removeFromChain(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry);
                        n4 = this.count - 1;
                        atomicReferenceArray.set(n3, mapMakerInternalMap$ReferenceEntry3);
                        this.count = n4;
                    }
                    n4 = 0;
                    return (boolean)n4;
                }
                if (this.map.valueEquivalence.equivalent(object2, object5)) {
                    ++this.modCount;
                    this.enqueueNotification(object, n2, object5, MapMaker$RemovalCause.REPLACED);
                    this.setValue(mapMakerInternalMap$ReferenceEntry, object3);
                    boolean bl2 = true;
                    return bl2;
                }
                this.recordLockedRead(mapMakerInternalMap$ReferenceEntry);
                boolean bl3 = false;
                return bl3;
            }
            boolean bl4 = false;
            return bl4;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object replace(Object object, int n2, Object object2) {
        this.lock();
        try {
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
            this.preWriteCleanup();
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n3 = n2 & atomicReferenceArray.length() - 1;
            for (mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry2 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n3); mapMakerInternalMap$ReferenceEntry != null; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext()) {
                Object object3 = mapMakerInternalMap$ReferenceEntry.getKey();
                if (mapMakerInternalMap$ReferenceEntry.getHash() != n2 || object3 == null || !this.map.keyEquivalence.equivalent(object, object3)) continue;
                MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference = mapMakerInternalMap$ReferenceEntry.getValueReference();
                Object object4 = mapMakerInternalMap$ValueReference.get();
                if (object4 != null) {
                    ++this.modCount;
                    this.enqueueNotification(object, n2, object4, MapMaker$RemovalCause.REPLACED);
                    this.setValue(mapMakerInternalMap$ReferenceEntry, object2);
                    Object object5 = object4;
                    return object5;
                }
                if (this.isCollected(mapMakerInternalMap$ValueReference)) {
                    MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2;
                    int n4 = this.count - 1;
                    ++this.modCount;
                    this.enqueueNotification(object3, n2, object4, MapMaker$RemovalCause.COLLECTED);
                    MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = this.removeFromChain(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry);
                    n4 = this.count - 1;
                    atomicReferenceArray.set(n3, mapMakerInternalMap$ReferenceEntry3);
                    this.count = n4;
                }
                Object var11_12 = null;
                return var11_12;
            }
            mapMakerInternalMap$ReferenceEntry = null;
            return mapMakerInternalMap$ReferenceEntry;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object remove(Object object, int n2) {
        Object object2;
        AtomicReferenceArray atomicReferenceArray;
        MapMaker$RemovalCause mapMaker$RemovalCause;
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
        int n3;
        int n4;
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2;
        Object object3;
        block9 : {
            this.lock();
            this.preWriteCleanup();
            n4 = this.count - 1;
            atomicReferenceArray = this.table;
            n3 = n2 & atomicReferenceArray.length() - 1;
            for (mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry2 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n3); mapMakerInternalMap$ReferenceEntry != null; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext()) {
                object3 = mapMakerInternalMap$ReferenceEntry.getKey();
                if (mapMakerInternalMap$ReferenceEntry.getHash() != n2 || object3 == null || !this.map.keyEquivalence.equivalent(object, object3)) continue;
                MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference = mapMakerInternalMap$ReferenceEntry.getValueReference();
                object2 = mapMakerInternalMap$ValueReference.get();
                if (object2 != null) {
                    mapMaker$RemovalCause = MapMaker$RemovalCause.EXPLICIT;
                } else {
                    if (!this.isCollected(mapMakerInternalMap$ValueReference)) {
                        Object var12_12 = null;
                        return var12_12;
                    }
                    mapMaker$RemovalCause = MapMaker$RemovalCause.COLLECTED;
                }
                break block9;
            }
            mapMakerInternalMap$ReferenceEntry = null;
            return mapMakerInternalMap$ReferenceEntry;
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }
        ++this.modCount;
        this.enqueueNotification(object3, n2, object2, mapMaker$RemovalCause);
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = this.removeFromChain(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry);
        n4 = this.count - 1;
        atomicReferenceArray.set(n3, mapMakerInternalMap$ReferenceEntry3);
        this.count = n4;
        Object object4 = object2;
        return object4;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean remove(Object object, int n2, Object object2) {
        this.lock();
        try {
            this.preWriteCleanup();
            int n3 = this.count - 1;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n4 = n2 & atomicReferenceArray.length() - 1;
            for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry2 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n4); mapMakerInternalMap$ReferenceEntry != null; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext()) {
                MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2;
                MapMaker$RemovalCause mapMaker$RemovalCause;
                Object object3 = mapMakerInternalMap$ReferenceEntry.getKey();
                if (mapMakerInternalMap$ReferenceEntry.getHash() != n2 || object3 == null || !this.map.keyEquivalence.equivalent(object, object3)) continue;
                MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference = mapMakerInternalMap$ReferenceEntry.getValueReference();
                Object object4 = mapMakerInternalMap$ValueReference.get();
                if (this.map.valueEquivalence.equivalent(object2, object4)) {
                    mapMaker$RemovalCause = MapMaker$RemovalCause.EXPLICIT;
                } else {
                    if (!this.isCollected(mapMakerInternalMap$ValueReference)) {
                        boolean bl2 = false;
                        return bl2;
                    }
                    mapMaker$RemovalCause = MapMaker$RemovalCause.COLLECTED;
                }
                ++this.modCount;
                this.enqueueNotification(object3, n2, object4, mapMaker$RemovalCause);
                MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = this.removeFromChain(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry);
                n3 = this.count - 1;
                atomicReferenceArray.set(n4, mapMakerInternalMap$ReferenceEntry3);
                this.count = n3;
                boolean bl3 = mapMaker$RemovalCause == MapMaker$RemovalCause.EXPLICIT;
                return bl3;
            }
            boolean bl4 = false;
            return bl4;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void clear() {
        if (this.count == 0) return;
        this.lock();
        try {
            int n2;
            AtomicReferenceArray atomicReferenceArray = this.table;
            if (this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
                for (n2 = 0; n2 < atomicReferenceArray.length(); ++n2) {
                    for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n2); mapMakerInternalMap$ReferenceEntry != null; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext()) {
                        if (mapMakerInternalMap$ReferenceEntry.getValueReference().isComputingReference()) continue;
                        this.enqueueNotification(mapMakerInternalMap$ReferenceEntry, MapMaker$RemovalCause.EXPLICIT);
                    }
                }
            }
            for (n2 = 0; n2 < atomicReferenceArray.length(); ++n2) {
                atomicReferenceArray.set(n2, null);
            }
            this.clearReferenceQueues();
            this.evictionQueue.clear();
            this.expirationQueue.clear();
            this.readCount.set(0);
            ++this.modCount;
            this.count = 0;
            return;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    @GuardedBy(value="this")
    MapMakerInternalMap$ReferenceEntry removeFromChain(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        this.evictionQueue.remove(mapMakerInternalMap$ReferenceEntry2);
        this.expirationQueue.remove(mapMakerInternalMap$ReferenceEntry2);
        int n2 = this.count;
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry2.getNext();
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry4 = mapMakerInternalMap$ReferenceEntry;
        do {
            if (mapMakerInternalMap$ReferenceEntry4 == mapMakerInternalMap$ReferenceEntry2) {
                this.count = n2;
                return mapMakerInternalMap$ReferenceEntry3;
            }
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry5 = this.copyEntry(mapMakerInternalMap$ReferenceEntry4, mapMakerInternalMap$ReferenceEntry3);
            if (mapMakerInternalMap$ReferenceEntry5 != null) {
                mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry5;
            } else {
                this.removeCollectedEntry(mapMakerInternalMap$ReferenceEntry4);
                --n2;
            }
            mapMakerInternalMap$ReferenceEntry4 = mapMakerInternalMap$ReferenceEntry4.getNext();
        } while (true);
    }

    void removeCollectedEntry(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.enqueueNotification(mapMakerInternalMap$ReferenceEntry, MapMaker$RemovalCause.COLLECTED);
        this.evictionQueue.remove(mapMakerInternalMap$ReferenceEntry);
        this.expirationQueue.remove(mapMakerInternalMap$ReferenceEntry);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean reclaimKey(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, int n2) {
        this.lock();
        try {
            int n3 = this.count - 1;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n4 = n2 & atomicReferenceArray.length() - 1;
            for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry3 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n4); mapMakerInternalMap$ReferenceEntry2 != null; mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry2.getNext()) {
                MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3;
                if (mapMakerInternalMap$ReferenceEntry2 != mapMakerInternalMap$ReferenceEntry) continue;
                ++this.modCount;
                this.enqueueNotification(mapMakerInternalMap$ReferenceEntry2.getKey(), n2, mapMakerInternalMap$ReferenceEntry2.getValueReference().get(), MapMaker$RemovalCause.COLLECTED);
                MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry4 = this.removeFromChain(mapMakerInternalMap$ReferenceEntry3, mapMakerInternalMap$ReferenceEntry2);
                n3 = this.count - 1;
                atomicReferenceArray.set(n4, mapMakerInternalMap$ReferenceEntry4);
                this.count = n3;
                boolean bl2 = true;
                return bl2;
            }
            boolean bl3 = false;
            return bl3;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean reclaimValue(Object object, int n2, MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        block8 : {
            this.lock();
            int n3 = this.count - 1;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n4 = n2 & atomicReferenceArray.length() - 1;
            for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry2 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n4); mapMakerInternalMap$ReferenceEntry != null; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext()) {
                Object object2 = mapMakerInternalMap$ReferenceEntry.getKey();
                if (mapMakerInternalMap$ReferenceEntry.getHash() != n2 || object2 == null || !this.map.keyEquivalence.equivalent(object, object2)) continue;
                MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference2 = mapMakerInternalMap$ReferenceEntry.getValueReference();
                if (mapMakerInternalMap$ValueReference2 == mapMakerInternalMap$ValueReference) {
                    MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2;
                    ++this.modCount;
                    this.enqueueNotification(object, n2, mapMakerInternalMap$ValueReference.get(), MapMaker$RemovalCause.COLLECTED);
                    MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = this.removeFromChain(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry);
                    n3 = this.count - 1;
                    atomicReferenceArray.set(n4, mapMakerInternalMap$ReferenceEntry3);
                    this.count = n3;
                    boolean bl2 = true;
                    return bl2;
                }
                break block8;
            }
            boolean bl3 = false;
            return bl3;
            finally {
                this.unlock();
                if (!this.isHeldByCurrentThread()) {
                    this.postWriteCleanup();
                }
            }
        }
        boolean bl4 = false;
        return bl4;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean clearValue(Object object, int n2, MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        block7 : {
            this.lock();
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n3 = n2 & atomicReferenceArray.length() - 1;
            for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry2 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get((int)n3); mapMakerInternalMap$ReferenceEntry != null; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext()) {
                Object object2 = mapMakerInternalMap$ReferenceEntry.getKey();
                if (mapMakerInternalMap$ReferenceEntry.getHash() != n2 || object2 == null || !this.map.keyEquivalence.equivalent(object, object2)) continue;
                MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference2 = mapMakerInternalMap$ReferenceEntry.getValueReference();
                if (mapMakerInternalMap$ValueReference2 == mapMakerInternalMap$ValueReference) {
                    MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2;
                    MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = this.removeFromChain(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry);
                    atomicReferenceArray.set(n3, mapMakerInternalMap$ReferenceEntry3);
                    boolean bl2 = true;
                    return bl2;
                }
                break block7;
            }
            boolean bl3 = false;
            return bl3;
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }
        boolean bl4 = false;
        return bl4;
    }

    @GuardedBy(value="this")
    boolean removeEntry(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, int n2, MapMaker$RemovalCause mapMaker$RemovalCause) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2;
        int n3 = this.count - 1;
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n4 = n2 & atomicReferenceArray.length() - 1;
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry2 = (MapMakerInternalMap$ReferenceEntry)atomicReferenceArray.get(n4);
        while (mapMakerInternalMap$ReferenceEntry3 != null) {
            if (mapMakerInternalMap$ReferenceEntry3 == mapMakerInternalMap$ReferenceEntry) {
                ++this.modCount;
                this.enqueueNotification(mapMakerInternalMap$ReferenceEntry3.getKey(), n2, mapMakerInternalMap$ReferenceEntry3.getValueReference().get(), mapMaker$RemovalCause);
                MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry4 = this.removeFromChain(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry3);
                n3 = this.count - 1;
                atomicReferenceArray.set(n4, mapMakerInternalMap$ReferenceEntry4);
                this.count = n3;
                return true;
            }
            mapMakerInternalMap$ReferenceEntry3 = mapMakerInternalMap$ReferenceEntry3.getNext();
        }
        return false;
    }

    boolean isCollected(MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        if (mapMakerInternalMap$ValueReference.isComputingReference()) {
            return false;
        }
        if (mapMakerInternalMap$ValueReference.get() != null) return false;
        return true;
    }

    Object getLiveValue(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        if (mapMakerInternalMap$ReferenceEntry.getKey() == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        Object object = mapMakerInternalMap$ReferenceEntry.getValueReference().get();
        if (object == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        if (!this.map.expires()) return object;
        if (!this.map.isExpired(mapMakerInternalMap$ReferenceEntry)) return object;
        this.tryExpireEntries();
        return null;
    }

    void postReadCleanup() {
        if ((this.readCount.incrementAndGet() & 63) != 0) return;
        this.runCleanup();
    }

    @GuardedBy(value="this")
    void preWriteCleanup() {
        this.runLockedCleanup();
    }

    void postWriteCleanup() {
        this.runUnlockedCleanup();
    }

    void runCleanup() {
        this.runLockedCleanup();
        this.runUnlockedCleanup();
    }

    void runLockedCleanup() {
        if (!this.tryLock()) return;
        try {
            this.drainReferenceQueues();
            this.expireEntries();
            this.readCount.set(0);
            return;
        }
        finally {
            this.unlock();
        }
    }

    void runUnlockedCleanup() {
        if (this.isHeldByCurrentThread()) return;
        this.map.processPendingNotifications();
    }
}

