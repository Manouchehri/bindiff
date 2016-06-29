/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.cache;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$InvalidCacheLoadException;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AccessQueue;
import com.google.common.cache.LocalCache$EntryFactory;
import com.google.common.cache.LocalCache$LoadingValueReference;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment$1;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeightedStrongValueReference;
import com.google.common.cache.LocalCache$WriteQueue;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class LocalCache$Segment
extends ReentrantLock {
    final LocalCache map;
    volatile int count;
    @GuardedBy(value="this")
    long totalWeight;
    int modCount;
    int threshold;
    volatile AtomicReferenceArray table;
    final long maxSegmentWeight;
    final ReferenceQueue keyReferenceQueue;
    final ReferenceQueue valueReferenceQueue;
    final Queue recencyQueue;
    final AtomicInteger readCount = new AtomicInteger();
    @GuardedBy(value="this")
    final Queue writeQueue;
    @GuardedBy(value="this")
    final Queue accessQueue;
    final AbstractCache$StatsCounter statsCounter;

    LocalCache$Segment(LocalCache localCache, int n2, long l2, AbstractCache$StatsCounter abstractCache$StatsCounter) {
        this.map = localCache;
        this.maxSegmentWeight = l2;
        this.statsCounter = (AbstractCache$StatsCounter)Preconditions.checkNotNull(abstractCache$StatsCounter);
        this.initTable(this.newEntryArray(n2));
        this.keyReferenceQueue = localCache.usesKeyReferences() ? new ReferenceQueue() : null;
        this.valueReferenceQueue = localCache.usesValueReferences() ? new ReferenceQueue() : null;
        this.recencyQueue = localCache.usesAccessQueue() ? new ConcurrentLinkedQueue() : LocalCache.discardingQueue();
        this.writeQueue = localCache.usesWriteQueue() ? new LocalCache$WriteQueue() : LocalCache.discardingQueue();
        this.accessQueue = localCache.usesAccessQueue() ? new LocalCache$AccessQueue() : LocalCache.discardingQueue();
    }

    AtomicReferenceArray newEntryArray(int n2) {
        return new AtomicReferenceArray(n2);
    }

    void initTable(AtomicReferenceArray atomicReferenceArray) {
        this.threshold = atomicReferenceArray.length() * 3 / 4;
        if (!this.map.customWeigher() && (long)this.threshold == this.maxSegmentWeight) {
            ++this.threshold;
        }
        this.table = atomicReferenceArray;
    }

    @GuardedBy(value="this")
    LocalCache$ReferenceEntry newEntry(Object object, int n2, @Nullable LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(object), n2, localCache$ReferenceEntry);
    }

    @GuardedBy(value="this")
    LocalCache$ReferenceEntry copyEntry(LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        if (localCache$ReferenceEntry.getKey() == null) {
            return null;
        }
        LocalCache$ValueReference localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
        Object object = localCache$ValueReference.get();
        if (object == null && localCache$ValueReference.isActive()) {
            return null;
        }
        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = this.map.entryFactory.copyEntry(this, localCache$ReferenceEntry, localCache$ReferenceEntry2);
        localCache$ReferenceEntry3.setValueReference(localCache$ValueReference.copyFor(this.valueReferenceQueue, object, localCache$ReferenceEntry3));
        return localCache$ReferenceEntry3;
    }

    @GuardedBy(value="this")
    void setValue(LocalCache$ReferenceEntry localCache$ReferenceEntry, Object object, Object object2, long l2) {
        LocalCache$ValueReference localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
        int n2 = this.map.weigher.weigh(object, object2);
        Preconditions.checkState(n2 >= 0, "Weights must be non-negative");
        LocalCache$ValueReference localCache$ValueReference2 = this.map.valueStrength.referenceValue(this, localCache$ReferenceEntry, object2, n2);
        localCache$ReferenceEntry.setValueReference(localCache$ValueReference2);
        this.recordWrite(localCache$ReferenceEntry, n2, l2);
        localCache$ValueReference.notifyNewValue(object2);
    }

    Object get(Object object, int n2, CacheLoader cacheLoader) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(cacheLoader);
        try {
            Object object2;
            if (this.count != 0 && (object2 = this.getEntry(object, n2)) != null) {
                long l2 = this.map.ticker.read();
                Object object3 = this.getLiveValue((LocalCache$ReferenceEntry)object2, l2);
                if (object3 != null) {
                    this.recordRead((LocalCache$ReferenceEntry)object2, l2);
                    this.statsCounter.recordHits(1);
                    Object object4 = this.scheduleRefresh((LocalCache$ReferenceEntry)object2, object, n2, object3, l2, cacheLoader);
                    return object4;
                }
                LocalCache$ValueReference localCache$ValueReference = object2.getValueReference();
                if (localCache$ValueReference.isLoading()) {
                    Object object5 = this.waitForLoadingValue((LocalCache$ReferenceEntry)object2, object, localCache$ValueReference);
                    return object5;
                }
            }
            object2 = this.lockedGetOrLoad(object, n2, cacheLoader);
            return object2;
        }
        catch (ExecutionException var4_5) {
            Throwable throwable = var4_5.getCause();
            if (throwable instanceof Error) {
                throw new ExecutionError((Error)throwable);
            }
            if (!(throwable instanceof RuntimeException)) throw var4_5;
            throw new UncheckedExecutionException(throwable);
        }
        finally {
            this.postReadCleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    Object lockedGetOrLoad(Object object, int n2, CacheLoader cacheLoader) {
        boolean bl2;
        LocalCache$ValueReference localCache$ValueReference;
        LocalCache$ReferenceEntry localCache$ReferenceEntry;
        LocalCache$LoadingValueReference localCache$LoadingValueReference;
        localCache$ValueReference = null;
        localCache$LoadingValueReference = null;
        bl2 = true;
        this.lock();
        try {
            long l2 = this.map.ticker.read();
            this.preWriteCleanup(l2);
            int n3 = this.count - 1;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n4 = n2 & atomicReferenceArray.length() - 1;
            for (localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n4); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                Object object2 = localCache$ReferenceEntry.getKey();
                if (localCache$ReferenceEntry.getHash() != n2 || object2 == null || !this.map.keyEquivalence.equivalent(object, object2)) continue;
                localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
                if (localCache$ValueReference.isLoading()) {
                    bl2 = false;
                    break;
                }
                Object object3 = localCache$ValueReference.get();
                if (object3 == null) {
                    this.enqueueNotification(object2, n2, localCache$ValueReference, RemovalCause.COLLECTED);
                } else {
                    if (!this.map.isExpired(localCache$ReferenceEntry, l2)) {
                        this.recordLockedRead(localCache$ReferenceEntry, l2);
                        this.statsCounter.recordHits(1);
                        Object object4 = object3;
                        return object4;
                    }
                    this.enqueueNotification(object2, n2, localCache$ValueReference, RemovalCause.EXPIRED);
                }
                this.writeQueue.remove(localCache$ReferenceEntry);
                this.accessQueue.remove(localCache$ReferenceEntry);
                this.count = n3;
                break;
            }
            if (bl2) {
                localCache$LoadingValueReference = new LocalCache$LoadingValueReference();
                if (localCache$ReferenceEntry == null) {
                    LocalCache$ReferenceEntry localCache$ReferenceEntry2;
                    localCache$ReferenceEntry = this.newEntry(object, n2, localCache$ReferenceEntry2);
                    localCache$ReferenceEntry.setValueReference(localCache$LoadingValueReference);
                    atomicReferenceArray.set(n4, localCache$ReferenceEntry);
                } else {
                    localCache$ReferenceEntry.setValueReference(localCache$LoadingValueReference);
                }
            }
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
        if (!bl2) return this.waitForLoadingValue(localCache$ReferenceEntry, object, localCache$ValueReference);
        try {
            LocalCache$ReferenceEntry localCache$ReferenceEntry3 = localCache$ReferenceEntry;
            synchronized (localCache$ReferenceEntry3) {
                Object object5 = this.loadSync(object, n2, localCache$LoadingValueReference, cacheLoader);
                return object5;
            }
        }
        finally {
            this.statsCounter.recordMisses(1);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object waitForLoadingValue(LocalCache$ReferenceEntry localCache$ReferenceEntry, Object object, LocalCache$ValueReference localCache$ValueReference) {
        if (!localCache$ValueReference.isLoading()) {
            throw new AssertionError();
        }
        Preconditions.checkState(!Thread.holdsLock(localCache$ReferenceEntry), "Recursive load of: %s", object);
        try {
            Object object2 = localCache$ValueReference.waitForValue();
            if (object2 == null) {
                String string = String.valueOf(object);
                throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(35 + String.valueOf(string).length()).append("CacheLoader returned null for key ").append(string).append(".").toString());
            }
            long l2 = this.map.ticker.read();
            this.recordRead(localCache$ReferenceEntry, l2);
            Object object3 = object2;
            return object3;
        }
        finally {
            this.statsCounter.recordMisses(1);
        }
    }

    Object loadSync(Object object, int n2, LocalCache$LoadingValueReference localCache$LoadingValueReference, CacheLoader cacheLoader) {
        ListenableFuture listenableFuture = localCache$LoadingValueReference.loadFuture(object, cacheLoader);
        return this.getAndRecordStats(object, n2, localCache$LoadingValueReference, listenableFuture);
    }

    ListenableFuture loadAsync(Object object, int n2, LocalCache$LoadingValueReference localCache$LoadingValueReference, CacheLoader cacheLoader) {
        ListenableFuture listenableFuture = localCache$LoadingValueReference.loadFuture(object, cacheLoader);
        listenableFuture.addListener(new LocalCache$Segment$1(this, object, n2, localCache$LoadingValueReference, listenableFuture), MoreExecutors.directExecutor());
        return listenableFuture;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Object getAndRecordStats(Object object, int n2, LocalCache$LoadingValueReference localCache$LoadingValueReference, ListenableFuture listenableFuture) {
        Object object2 = null;
        try {
            object2 = Uninterruptibles.getUninterruptibly(listenableFuture);
            if (object2 == null) {
                String string = String.valueOf(object);
                throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(35 + String.valueOf(string).length()).append("CacheLoader returned null for key ").append(string).append(".").toString());
            }
            this.statsCounter.recordLoadSuccess(localCache$LoadingValueReference.elapsedNanos());
            this.storeLoadedValue(object, n2, localCache$LoadingValueReference, object2);
            Object object3 = object2;
            return object3;
        }
        finally {
            if (object2 == null) {
                this.statsCounter.recordLoadException(localCache$LoadingValueReference.elapsedNanos());
                this.removeLoadingValue(object, n2, localCache$LoadingValueReference);
            }
        }
    }

    Object scheduleRefresh(LocalCache$ReferenceEntry localCache$ReferenceEntry, Object object, int n2, Object object2, long l2, CacheLoader cacheLoader) {
        if (!this.map.refreshes()) return object2;
        if (l2 - localCache$ReferenceEntry.getWriteTime() <= this.map.refreshNanos) return object2;
        if (localCache$ReferenceEntry.getValueReference().isLoading()) return object2;
        Object object3 = this.refresh(object, n2, cacheLoader, true);
        if (object3 == null) return object2;
        return object3;
    }

    @Nullable
    Object refresh(Object object, int n2, CacheLoader cacheLoader, boolean bl2) {
        LocalCache$LoadingValueReference localCache$LoadingValueReference = this.insertLoadingValueReference(object, n2, bl2);
        if (localCache$LoadingValueReference == null) {
            return null;
        }
        ListenableFuture listenableFuture = this.loadAsync(object, n2, localCache$LoadingValueReference, cacheLoader);
        if (!listenableFuture.isDone()) return null;
        try {
            return Uninterruptibles.getUninterruptibly(listenableFuture);
        }
        catch (Throwable var7_7) {
            // empty catch block
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    LocalCache$LoadingValueReference insertLoadingValueReference(Object object, int n2, boolean bl2) {
        LocalCache$ValueReference localCache$ValueReference;
        LocalCache$ReferenceEntry localCache$ReferenceEntry;
        block7 : {
            Object object2;
            LocalCache$ReferenceEntry localCache$ReferenceEntry2;
            localCache$ReferenceEntry = null;
            this.lock();
            long l2 = this.map.ticker.read();
            this.preWriteCleanup(l2);
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n3 = n2 & atomicReferenceArray.length() - 1;
            for (localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n3); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                object2 = localCache$ReferenceEntry.getKey();
                if (localCache$ReferenceEntry.getHash() != n2 || object2 == null || !this.map.keyEquivalence.equivalent(object, object2)) continue;
                localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
                if (localCache$ValueReference.isLoading() || bl2 && l2 - localCache$ReferenceEntry.getWriteTime() < this.map.refreshNanos) {
                    LocalCache$LoadingValueReference localCache$LoadingValueReference = null;
                    return localCache$LoadingValueReference;
                }
                break block7;
            }
            ++this.modCount;
            object2 = new LocalCache$LoadingValueReference();
            localCache$ReferenceEntry = this.newEntry(object, n2, localCache$ReferenceEntry2);
            localCache$ReferenceEntry.setValueReference((LocalCache$ValueReference)object2);
            atomicReferenceArray.set(n3, localCache$ReferenceEntry);
            Object object3 = object2;
            return object3;
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }
        ++this.modCount;
        LocalCache$LoadingValueReference localCache$LoadingValueReference = new LocalCache$LoadingValueReference(localCache$ValueReference);
        localCache$ReferenceEntry.setValueReference(localCache$LoadingValueReference);
        LocalCache$LoadingValueReference localCache$LoadingValueReference2 = localCache$LoadingValueReference;
        return localCache$LoadingValueReference2;
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
            LocalCache$ReferenceEntry localCache$ReferenceEntry = (LocalCache$ReferenceEntry)((Object)reference);
            this.map.reclaimKey(localCache$ReferenceEntry);
        } while (++n2 != 16);
    }

    @GuardedBy(value="this")
    void drainValueReferenceQueue() {
        int n2 = 0;
        do {
            Reference reference;
            if ((reference = this.valueReferenceQueue.poll()) == null) return;
            LocalCache$ValueReference localCache$ValueReference = (LocalCache$ValueReference)((Object)reference);
            this.map.reclaimValue(localCache$ValueReference);
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

    void recordRead(LocalCache$ReferenceEntry localCache$ReferenceEntry, long l2) {
        if (this.map.recordsAccess()) {
            localCache$ReferenceEntry.setAccessTime(l2);
        }
        this.recencyQueue.add(localCache$ReferenceEntry);
    }

    @GuardedBy(value="this")
    void recordLockedRead(LocalCache$ReferenceEntry localCache$ReferenceEntry, long l2) {
        if (this.map.recordsAccess()) {
            localCache$ReferenceEntry.setAccessTime(l2);
        }
        this.accessQueue.add(localCache$ReferenceEntry);
    }

    @GuardedBy(value="this")
    void recordWrite(LocalCache$ReferenceEntry localCache$ReferenceEntry, int n2, long l2) {
        this.drainRecencyQueue();
        this.totalWeight += (long)n2;
        if (this.map.recordsAccess()) {
            localCache$ReferenceEntry.setAccessTime(l2);
        }
        if (this.map.recordsWrite()) {
            localCache$ReferenceEntry.setWriteTime(l2);
        }
        this.accessQueue.add(localCache$ReferenceEntry);
        this.writeQueue.add(localCache$ReferenceEntry);
    }

    @GuardedBy(value="this")
    void drainRecencyQueue() {
        LocalCache$ReferenceEntry localCache$ReferenceEntry;
        while ((localCache$ReferenceEntry = (LocalCache$ReferenceEntry)this.recencyQueue.poll()) != null) {
            if (!this.accessQueue.contains(localCache$ReferenceEntry)) continue;
            this.accessQueue.add(localCache$ReferenceEntry);
        }
    }

    void tryExpireEntries(long l2) {
        if (!this.tryLock()) return;
        try {
            this.expireEntries(l2);
            return;
        }
        finally {
            this.unlock();
        }
    }

    @GuardedBy(value="this")
    void expireEntries(long l2) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry;
        this.drainRecencyQueue();
        while ((localCache$ReferenceEntry = (LocalCache$ReferenceEntry)this.writeQueue.peek()) != null && this.map.isExpired(localCache$ReferenceEntry, l2)) {
            if (!this.removeEntry(localCache$ReferenceEntry, localCache$ReferenceEntry.getHash(), RemovalCause.EXPIRED)) {
                throw new AssertionError();
            }
        }
        do {
            if ((localCache$ReferenceEntry = (LocalCache$ReferenceEntry)this.accessQueue.peek()) == null) return;
            if (!this.map.isExpired(localCache$ReferenceEntry, l2)) return;
        } while (this.removeEntry(localCache$ReferenceEntry, localCache$ReferenceEntry.getHash(), RemovalCause.EXPIRED));
        throw new AssertionError();
    }

    @GuardedBy(value="this")
    void enqueueNotification(LocalCache$ReferenceEntry localCache$ReferenceEntry, RemovalCause removalCause) {
        this.enqueueNotification(localCache$ReferenceEntry.getKey(), localCache$ReferenceEntry.getHash(), localCache$ReferenceEntry.getValueReference(), removalCause);
    }

    @GuardedBy(value="this")
    void enqueueNotification(@Nullable Object object, int n2, LocalCache$ValueReference localCache$ValueReference, RemovalCause removalCause) {
        Object object2;
        this.totalWeight -= (long)localCache$ValueReference.getWeight();
        if (removalCause.wasEvicted()) {
            this.statsCounter.recordEviction();
        }
        if (this.map.removalNotificationQueue == LocalCache.DISCARDING_QUEUE) return;
        Object object3 = localCache$ValueReference.get();
        if (object == null && !this.map.usesKeyReferences()) {
            String string = String.valueOf((Object)removalCause);
            object2 = new StringBuilder(55 + String.valueOf(string).length()).append("Unexpected null key during removal notification, cause=").append(string).toString();
            LocalCache.logger.log(Level.WARNING, (String)object2, (Throwable)((Object)new AssertionError()));
        } else if (object3 == null && !this.map.usesValueReferences()) {
            String string = String.valueOf((Object)removalCause);
            object2 = new StringBuilder(57 + String.valueOf(string).length()).append("Unexpected null value during removal notification, cause=").append(string).toString();
            LocalCache.logger.log(Level.WARNING, (String)object2, (Throwable)((Object)new AssertionError()));
        }
        object2 = RemovalNotification.create(object, object3, removalCause);
        this.map.removalNotificationQueue.offer(object2);
    }

    @GuardedBy(value="this")
    void evictEntries(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry2;
        if (!this.map.evictsBySize()) {
            return;
        }
        this.drainRecencyQueue();
        if ((long)localCache$ReferenceEntry.getValueReference().getWeight() > this.maxSegmentWeight && !this.removeEntry(localCache$ReferenceEntry, localCache$ReferenceEntry.getHash(), RemovalCause.SIZE)) {
            throw new AssertionError();
        }
        do {
            if (this.totalWeight <= this.maxSegmentWeight) return;
        } while (this.removeEntry(localCache$ReferenceEntry2 = this.getNextEvictable(), localCache$ReferenceEntry2.getHash(), RemovalCause.SIZE));
        throw new AssertionError();
    }

    @GuardedBy(value="this")
    LocalCache$ReferenceEntry getNextEvictable() {
        LocalCache$ReferenceEntry localCache$ReferenceEntry;
        int n2;
        Iterator iterator = this.accessQueue.iterator();
        do {
            if (!iterator.hasNext()) throw new AssertionError();
        } while ((n2 = (localCache$ReferenceEntry = (LocalCache$ReferenceEntry)iterator.next()).getValueReference().getWeight()) <= 0);
        return localCache$ReferenceEntry;
    }

    LocalCache$ReferenceEntry getFirst(int n2) {
        AtomicReferenceArray atomicReferenceArray = this.table;
        return (LocalCache$ReferenceEntry)atomicReferenceArray.get(n2 & atomicReferenceArray.length() - 1);
    }

    @Nullable
    LocalCache$ReferenceEntry getEntry(Object object, int n2) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.getFirst(n2);
        while (localCache$ReferenceEntry != null) {
            if (localCache$ReferenceEntry.getHash() == n2) {
                Object object2 = localCache$ReferenceEntry.getKey();
                if (object2 == null) {
                    this.tryDrainReferenceQueues();
                } else if (this.map.keyEquivalence.equivalent(object, object2)) {
                    return localCache$ReferenceEntry;
                }
            }
            localCache$ReferenceEntry = localCache$ReferenceEntry.getNext();
        }
        return null;
    }

    @Nullable
    LocalCache$ReferenceEntry getLiveEntry(Object object, int n2, long l2) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = this.getEntry(object, n2);
        if (localCache$ReferenceEntry == null) {
            return null;
        }
        if (!this.map.isExpired(localCache$ReferenceEntry, l2)) return localCache$ReferenceEntry;
        this.tryExpireEntries(l2);
        return null;
    }

    Object getLiveValue(LocalCache$ReferenceEntry localCache$ReferenceEntry, long l2) {
        if (localCache$ReferenceEntry.getKey() == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        Object object = localCache$ReferenceEntry.getValueReference().get();
        if (object == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        if (!this.map.isExpired(localCache$ReferenceEntry, l2)) return object;
        this.tryExpireEntries(l2);
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    Object get(Object object, int n2) {
        try {
            if (this.count != 0) {
                long l2 = this.map.ticker.read();
                LocalCache$ReferenceEntry localCache$ReferenceEntry = this.getLiveEntry(object, n2, l2);
                if (localCache$ReferenceEntry == null) {
                    Object var6_6 = null;
                    return var6_6;
                }
                Object object2 = localCache$ReferenceEntry.getValueReference().get();
                if (object2 != null) {
                    this.recordRead(localCache$ReferenceEntry, l2);
                    Object object3 = this.scheduleRefresh(localCache$ReferenceEntry, localCache$ReferenceEntry.getKey(), n2, object2, l2, this.map.defaultLoader);
                    return object3;
                }
                this.tryDrainReferenceQueues();
            }
            Object var3_4 = null;
            return var3_4;
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
                long l2 = this.map.ticker.read();
                LocalCache$ReferenceEntry localCache$ReferenceEntry = this.getLiveEntry(object, n2, l2);
                if (localCache$ReferenceEntry == null) {
                    boolean bl2 = false;
                    return bl2;
                }
                boolean bl3 = localCache$ReferenceEntry.getValueReference().get() != null;
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
        var2_2 = this.map.ticker.read();
        var4_4 = this.table;
        var5_5 = var4_4.length();
        var6_6 = 0;
lbl7: // 2 sources:
        if (var6_6 < var5_5) {
        } else lbl-1000: // 2 sources:
        {
            var2_3 = false;
            return var2_3;
            finally {
                this.postReadCleanup();
            }
        }
        for (var7_7 = (LocalCache$ReferenceEntry)var4_4.get((int)var6_6); var7_7 != null; var7_7 = var7_7.getNext()) {
            var8_8 = this.getLiveValue(var7_7, var2_2);
            if (var8_8 == null || !this.map.valueEquivalence.equivalent(var1_1, var8_8)) continue;
            var9_9 = true;
            return var9_9;
        }
        ++var6_6;
        ** GOTO lbl7
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    Object put(Object object, int n2, Object object2, boolean bl2) {
        int n3;
        LocalCache$ReferenceEntry localCache$ReferenceEntry;
        block12 : {
            Object object3;
            LocalCache$ReferenceEntry localCache$ReferenceEntry2;
            this.lock();
            long l2 = this.map.ticker.read();
            this.preWriteCleanup(l2);
            n3 = this.count + 1;
            if (n3 > this.threshold) {
                this.expand();
                n3 = this.count + 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n4 = n2 & atomicReferenceArray.length() - 1;
            for (localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n4); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                object3 = localCache$ReferenceEntry.getKey();
                if (localCache$ReferenceEntry.getHash() != n2 || object3 == null || !this.map.keyEquivalence.equivalent(object, object3)) continue;
                LocalCache$ValueReference localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
                Object object4 = localCache$ValueReference.get();
                if (object4 == null) {
                    ++this.modCount;
                    if (localCache$ValueReference.isActive()) {
                        this.enqueueNotification(object, n2, localCache$ValueReference, RemovalCause.COLLECTED);
                        this.setValue(localCache$ReferenceEntry, object, object2, l2);
                        n3 = this.count;
                    } else {
                        this.setValue(localCache$ReferenceEntry, object, object2, l2);
                        n3 = this.count + 1;
                    }
                    break block12;
                }
                if (bl2) {
                    this.recordLockedRead(localCache$ReferenceEntry, l2);
                    Object object5 = object4;
                    return object5;
                }
                ++this.modCount;
                this.enqueueNotification(object, n2, localCache$ValueReference, RemovalCause.REPLACED);
                this.setValue(localCache$ReferenceEntry, object, object2, l2);
                this.evictEntries(localCache$ReferenceEntry);
                Object object6 = object4;
                return object6;
            }
            ++this.modCount;
            localCache$ReferenceEntry = this.newEntry(object, n2, localCache$ReferenceEntry2);
            this.setValue(localCache$ReferenceEntry, object, object2, l2);
            atomicReferenceArray.set(n4, localCache$ReferenceEntry);
            this.count = n3 = this.count + 1;
            this.evictEntries(localCache$ReferenceEntry);
            object3 = null;
            return object3;
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }
        this.count = n3;
        this.evictEntries(localCache$ReferenceEntry);
        Object var15_14 = null;
        return var15_14;
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
            LocalCache$ReferenceEntry localCache$ReferenceEntry = (LocalCache$ReferenceEntry)atomicReferenceArray.get(n5);
            if (localCache$ReferenceEntry != null) {
                LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry.getNext();
                int n6 = localCache$ReferenceEntry.getHash() & n4;
                if (localCache$ReferenceEntry2 == null) {
                    atomicReferenceArray2.set(n6, localCache$ReferenceEntry);
                } else {
                    int n7;
                    LocalCache$ReferenceEntry localCache$ReferenceEntry3;
                    LocalCache$ReferenceEntry localCache$ReferenceEntry4 = localCache$ReferenceEntry;
                    int n8 = n6;
                    for (localCache$ReferenceEntry3 = localCache$ReferenceEntry2; localCache$ReferenceEntry3 != null; localCache$ReferenceEntry3 = localCache$ReferenceEntry3.getNext()) {
                        n7 = localCache$ReferenceEntry3.getHash() & n4;
                        if (n7 == n8) continue;
                        n8 = n7;
                        localCache$ReferenceEntry4 = localCache$ReferenceEntry3;
                    }
                    atomicReferenceArray2.set(n8, localCache$ReferenceEntry4);
                    for (localCache$ReferenceEntry3 = localCache$ReferenceEntry; localCache$ReferenceEntry3 != localCache$ReferenceEntry4; localCache$ReferenceEntry3 = localCache$ReferenceEntry3.getNext()) {
                        n7 = localCache$ReferenceEntry3.getHash() & n4;
                        LocalCache$ReferenceEntry localCache$ReferenceEntry5 = (LocalCache$ReferenceEntry)atomicReferenceArray2.get(n7);
                        LocalCache$ReferenceEntry localCache$ReferenceEntry6 = this.copyEntry(localCache$ReferenceEntry3, localCache$ReferenceEntry5);
                        if (localCache$ReferenceEntry6 != null) {
                            atomicReferenceArray2.set(n7, localCache$ReferenceEntry6);
                            continue;
                        }
                        this.removeCollectedEntry(localCache$ReferenceEntry3);
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
            long l2 = this.map.ticker.read();
            this.preWriteCleanup(l2);
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n3 = n2 & atomicReferenceArray.length() - 1;
            for (LocalCache$ReferenceEntry localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n3); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                Object object4 = localCache$ReferenceEntry.getKey();
                if (localCache$ReferenceEntry.getHash() != n2 || object4 == null || !this.map.keyEquivalence.equivalent(object, object4)) continue;
                LocalCache$ValueReference localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
                Object object5 = localCache$ValueReference.get();
                if (object5 == null) {
                    int n4;
                    if (localCache$ValueReference.isActive()) {
                        LocalCache$ReferenceEntry localCache$ReferenceEntry2;
                        n4 = this.count - 1;
                        ++this.modCount;
                        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = this.removeValueFromChain(localCache$ReferenceEntry2, localCache$ReferenceEntry, object4, n2, localCache$ValueReference, RemovalCause.COLLECTED);
                        n4 = this.count - 1;
                        atomicReferenceArray.set(n3, localCache$ReferenceEntry3);
                        this.count = n4;
                    }
                    n4 = 0;
                    return (boolean)n4;
                }
                if (this.map.valueEquivalence.equivalent(object2, object5)) {
                    ++this.modCount;
                    this.enqueueNotification(object, n2, localCache$ValueReference, RemovalCause.REPLACED);
                    this.setValue(localCache$ReferenceEntry, object, object3, l2);
                    this.evictEntries(localCache$ReferenceEntry);
                    boolean bl2 = true;
                    return bl2;
                }
                this.recordLockedRead(localCache$ReferenceEntry, l2);
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
    @Nullable
    Object replace(Object object, int n2, Object object2) {
        this.lock();
        try {
            LocalCache$ReferenceEntry localCache$ReferenceEntry;
            long l2 = this.map.ticker.read();
            this.preWriteCleanup(l2);
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n3 = n2 & atomicReferenceArray.length() - 1;
            for (localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n3); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                Object object3 = localCache$ReferenceEntry.getKey();
                if (localCache$ReferenceEntry.getHash() != n2 || object3 == null || !this.map.keyEquivalence.equivalent(object, object3)) continue;
                LocalCache$ValueReference localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
                Object object4 = localCache$ValueReference.get();
                if (object4 != null) {
                    ++this.modCount;
                    this.enqueueNotification(object, n2, localCache$ValueReference, RemovalCause.REPLACED);
                    this.setValue(localCache$ReferenceEntry, object, object2, l2);
                    this.evictEntries(localCache$ReferenceEntry);
                    Object object5 = object4;
                    return object5;
                }
                if (localCache$ValueReference.isActive()) {
                    LocalCache$ReferenceEntry localCache$ReferenceEntry2;
                    int n4 = this.count - 1;
                    ++this.modCount;
                    LocalCache$ReferenceEntry localCache$ReferenceEntry3 = this.removeValueFromChain(localCache$ReferenceEntry2, localCache$ReferenceEntry, object3, n2, localCache$ValueReference, RemovalCause.COLLECTED);
                    n4 = this.count - 1;
                    atomicReferenceArray.set(n3, localCache$ReferenceEntry3);
                    this.count = n4;
                }
                Object var13_13 = null;
                return var13_13;
            }
            localCache$ReferenceEntry = null;
            return localCache$ReferenceEntry;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Nullable
    Object remove(Object object, int n2) {
        Object object2;
        RemovalCause removalCause;
        Object object3;
        int n3;
        int n4;
        LocalCache$ReferenceEntry localCache$ReferenceEntry;
        LocalCache$ReferenceEntry localCache$ReferenceEntry2;
        LocalCache$ValueReference localCache$ValueReference;
        AtomicReferenceArray atomicReferenceArray;
        block9 : {
            this.lock();
            long l2 = this.map.ticker.read();
            this.preWriteCleanup(l2);
            n3 = this.count - 1;
            atomicReferenceArray = this.table;
            n4 = n2 & atomicReferenceArray.length() - 1;
            for (localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n4); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                object3 = localCache$ReferenceEntry.getKey();
                if (localCache$ReferenceEntry.getHash() != n2 || object3 == null || !this.map.keyEquivalence.equivalent(object, object3)) continue;
                localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
                object2 = localCache$ValueReference.get();
                if (object2 != null) {
                    removalCause = RemovalCause.EXPLICIT;
                } else {
                    if (!localCache$ValueReference.isActive()) {
                        Object var14_13 = null;
                        return var14_13;
                    }
                    removalCause = RemovalCause.COLLECTED;
                }
                break block9;
            }
            localCache$ReferenceEntry = null;
            return localCache$ReferenceEntry;
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }
        ++this.modCount;
        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = this.removeValueFromChain(localCache$ReferenceEntry2, localCache$ReferenceEntry, object3, n2, localCache$ValueReference, removalCause);
        n3 = this.count - 1;
        atomicReferenceArray.set(n4, localCache$ReferenceEntry3);
        this.count = n3;
        Object object4 = object2;
        return object4;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean storeLoadedValue(Object object, int n2, LocalCache$LoadingValueReference localCache$LoadingValueReference, Object object2) {
        LocalCache$ValueReference localCache$ValueReference;
        block8 : {
            int n3;
            long l2;
            LocalCache$ReferenceEntry localCache$ReferenceEntry;
            block9 : {
                LocalCache$ReferenceEntry localCache$ReferenceEntry2;
                this.lock();
                l2 = this.map.ticker.read();
                this.preWriteCleanup(l2);
                n3 = this.count + 1;
                if (n3 > this.threshold) {
                    this.expand();
                    n3 = this.count + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.table;
                int n4 = n2 & atomicReferenceArray.length() - 1;
                for (localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n4); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                    Object object3 = localCache$ReferenceEntry.getKey();
                    if (localCache$ReferenceEntry.getHash() != n2 || object3 == null || !this.map.keyEquivalence.equivalent(object, object3)) continue;
                    localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
                    Object object4 = localCache$ValueReference.get();
                    if (localCache$LoadingValueReference != localCache$ValueReference && (object4 != null || localCache$ValueReference == LocalCache.UNSET)) break block8;
                    ++this.modCount;
                    if (localCache$LoadingValueReference.isActive()) {
                        RemovalCause removalCause = object4 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED;
                        this.enqueueNotification(object, n2, localCache$LoadingValueReference, removalCause);
                        --n3;
                    }
                    break block9;
                }
                ++this.modCount;
                localCache$ReferenceEntry = this.newEntry(object, n2, localCache$ReferenceEntry2);
                this.setValue(localCache$ReferenceEntry, object, object2, l2);
                atomicReferenceArray.set(n4, localCache$ReferenceEntry);
                this.count = n3;
                this.evictEntries(localCache$ReferenceEntry);
                boolean bl2 = true;
                return bl2;
                finally {
                    this.unlock();
                    this.postWriteCleanup();
                }
            }
            this.setValue(localCache$ReferenceEntry, object, object2, l2);
            this.count = n3;
            this.evictEntries(localCache$ReferenceEntry);
            boolean bl3 = true;
            return bl3;
        }
        localCache$ValueReference = new LocalCache$WeightedStrongValueReference(object2, 0);
        this.enqueueNotification(object, n2, localCache$ValueReference, RemovalCause.REPLACED);
        boolean bl4 = false;
        return bl4;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean remove(Object object, int n2, Object object2) {
        this.lock();
        try {
            long l2 = this.map.ticker.read();
            this.preWriteCleanup(l2);
            int n3 = this.count - 1;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n4 = n2 & atomicReferenceArray.length() - 1;
            for (LocalCache$ReferenceEntry localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n4); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                RemovalCause removalCause;
                LocalCache$ReferenceEntry localCache$ReferenceEntry2;
                Object object3 = localCache$ReferenceEntry.getKey();
                if (localCache$ReferenceEntry.getHash() != n2 || object3 == null || !this.map.keyEquivalence.equivalent(object, object3)) continue;
                LocalCache$ValueReference localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
                Object object4 = localCache$ValueReference.get();
                if (this.map.valueEquivalence.equivalent(object2, object4)) {
                    removalCause = RemovalCause.EXPLICIT;
                } else if (object4 == null && localCache$ValueReference.isActive()) {
                    removalCause = RemovalCause.COLLECTED;
                } else {
                    boolean bl2 = false;
                    return bl2;
                }
                ++this.modCount;
                LocalCache$ReferenceEntry localCache$ReferenceEntry3 = this.removeValueFromChain(localCache$ReferenceEntry2, localCache$ReferenceEntry, object3, n2, localCache$ValueReference, removalCause);
                n3 = this.count - 1;
                atomicReferenceArray.set(n4, localCache$ReferenceEntry3);
                this.count = n3;
                boolean bl3 = removalCause == RemovalCause.EXPLICIT;
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
            for (n2 = 0; n2 < atomicReferenceArray.length(); ++n2) {
                for (LocalCache$ReferenceEntry localCache$ReferenceEntry = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n2); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                    if (!localCache$ReferenceEntry.getValueReference().isActive()) continue;
                    this.enqueueNotification(localCache$ReferenceEntry, RemovalCause.EXPLICIT);
                }
            }
            for (n2 = 0; n2 < atomicReferenceArray.length(); ++n2) {
                atomicReferenceArray.set(n2, null);
            }
            this.clearReferenceQueues();
            this.writeQueue.clear();
            this.accessQueue.clear();
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

    @Nullable
    @GuardedBy(value="this")
    LocalCache$ReferenceEntry removeValueFromChain(LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2, @Nullable Object object, int n2, LocalCache$ValueReference localCache$ValueReference, RemovalCause removalCause) {
        this.enqueueNotification(object, n2, localCache$ValueReference, removalCause);
        this.writeQueue.remove(localCache$ReferenceEntry2);
        this.accessQueue.remove(localCache$ReferenceEntry2);
        if (!localCache$ValueReference.isLoading()) return this.removeEntryFromChain(localCache$ReferenceEntry, localCache$ReferenceEntry2);
        localCache$ValueReference.notifyNewValue(null);
        return localCache$ReferenceEntry;
    }

    @Nullable
    @GuardedBy(value="this")
    LocalCache$ReferenceEntry removeEntryFromChain(LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        int n2 = this.count;
        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = localCache$ReferenceEntry2.getNext();
        LocalCache$ReferenceEntry localCache$ReferenceEntry4 = localCache$ReferenceEntry;
        do {
            if (localCache$ReferenceEntry4 == localCache$ReferenceEntry2) {
                this.count = n2;
                return localCache$ReferenceEntry3;
            }
            LocalCache$ReferenceEntry localCache$ReferenceEntry5 = this.copyEntry(localCache$ReferenceEntry4, localCache$ReferenceEntry3);
            if (localCache$ReferenceEntry5 != null) {
                localCache$ReferenceEntry3 = localCache$ReferenceEntry5;
            } else {
                this.removeCollectedEntry(localCache$ReferenceEntry4);
                --n2;
            }
            localCache$ReferenceEntry4 = localCache$ReferenceEntry4.getNext();
        } while (true);
    }

    @GuardedBy(value="this")
    void removeCollectedEntry(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.enqueueNotification(localCache$ReferenceEntry, RemovalCause.COLLECTED);
        this.writeQueue.remove(localCache$ReferenceEntry);
        this.accessQueue.remove(localCache$ReferenceEntry);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean reclaimKey(LocalCache$ReferenceEntry localCache$ReferenceEntry, int n2) {
        this.lock();
        try {
            int n3 = this.count - 1;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n4 = n2 & atomicReferenceArray.length() - 1;
            for (LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry3 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n4); localCache$ReferenceEntry2 != null; localCache$ReferenceEntry2 = localCache$ReferenceEntry2.getNext()) {
                LocalCache$ReferenceEntry localCache$ReferenceEntry3;
                if (localCache$ReferenceEntry2 != localCache$ReferenceEntry) continue;
                ++this.modCount;
                LocalCache$ReferenceEntry localCache$ReferenceEntry4 = this.removeValueFromChain(localCache$ReferenceEntry3, localCache$ReferenceEntry2, localCache$ReferenceEntry2.getKey(), n2, localCache$ReferenceEntry2.getValueReference(), RemovalCause.COLLECTED);
                n3 = this.count - 1;
                atomicReferenceArray.set(n4, localCache$ReferenceEntry4);
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
    boolean reclaimValue(Object object, int n2, LocalCache$ValueReference localCache$ValueReference) {
        block8 : {
            this.lock();
            int n3 = this.count - 1;
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n4 = n2 & atomicReferenceArray.length() - 1;
            for (LocalCache$ReferenceEntry localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n4); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                Object object2 = localCache$ReferenceEntry.getKey();
                if (localCache$ReferenceEntry.getHash() != n2 || object2 == null || !this.map.keyEquivalence.equivalent(object, object2)) continue;
                LocalCache$ValueReference localCache$ValueReference2 = localCache$ReferenceEntry.getValueReference();
                if (localCache$ValueReference2 == localCache$ValueReference) {
                    LocalCache$ReferenceEntry localCache$ReferenceEntry2;
                    ++this.modCount;
                    LocalCache$ReferenceEntry localCache$ReferenceEntry3 = this.removeValueFromChain(localCache$ReferenceEntry2, localCache$ReferenceEntry, object2, n2, localCache$ValueReference, RemovalCause.COLLECTED);
                    n3 = this.count - 1;
                    atomicReferenceArray.set(n4, localCache$ReferenceEntry3);
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
    boolean removeLoadingValue(Object object, int n2, LocalCache$LoadingValueReference localCache$LoadingValueReference) {
        block9 : {
            this.lock();
            AtomicReferenceArray atomicReferenceArray = this.table;
            int n3 = n2 & atomicReferenceArray.length() - 1;
            for (LocalCache$ReferenceEntry localCache$ReferenceEntry = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get((int)n3); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
                Object object2 = localCache$ReferenceEntry.getKey();
                if (localCache$ReferenceEntry.getHash() != n2 || object2 == null || !this.map.keyEquivalence.equivalent(object, object2)) continue;
                LocalCache$ValueReference localCache$ValueReference = localCache$ReferenceEntry.getValueReference();
                if (localCache$ValueReference != localCache$LoadingValueReference) {
                    boolean bl2 = false;
                    return bl2;
                }
                if (localCache$LoadingValueReference.isActive()) {
                    localCache$ReferenceEntry.setValueReference(localCache$LoadingValueReference.getOldValue());
                } else {
                    LocalCache$ReferenceEntry localCache$ReferenceEntry2;
                    LocalCache$ReferenceEntry localCache$ReferenceEntry3 = this.removeEntryFromChain(localCache$ReferenceEntry2, localCache$ReferenceEntry);
                    atomicReferenceArray.set(n3, localCache$ReferenceEntry3);
                }
                break block9;
            }
            boolean bl3 = false;
            return bl3;
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }
        boolean bl4 = true;
        return bl4;
    }

    @GuardedBy(value="this")
    boolean removeEntry(LocalCache$ReferenceEntry localCache$ReferenceEntry, int n2, RemovalCause removalCause) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry2;
        int n3 = this.count - 1;
        AtomicReferenceArray atomicReferenceArray = this.table;
        int n4 = n2 & atomicReferenceArray.length() - 1;
        LocalCache$ReferenceEntry localCache$ReferenceEntry3 = localCache$ReferenceEntry2 = (LocalCache$ReferenceEntry)atomicReferenceArray.get(n4);
        while (localCache$ReferenceEntry3 != null) {
            if (localCache$ReferenceEntry3 == localCache$ReferenceEntry) {
                ++this.modCount;
                LocalCache$ReferenceEntry localCache$ReferenceEntry4 = this.removeValueFromChain(localCache$ReferenceEntry2, localCache$ReferenceEntry3, localCache$ReferenceEntry3.getKey(), n2, localCache$ReferenceEntry3.getValueReference(), removalCause);
                n3 = this.count - 1;
                atomicReferenceArray.set(n4, localCache$ReferenceEntry4);
                this.count = n3;
                return true;
            }
            localCache$ReferenceEntry3 = localCache$ReferenceEntry3.getNext();
        }
        return false;
    }

    void postReadCleanup() {
        if ((this.readCount.incrementAndGet() & 63) != 0) return;
        this.cleanUp();
    }

    @GuardedBy(value="this")
    void preWriteCleanup(long l2) {
        this.runLockedCleanup(l2);
    }

    void postWriteCleanup() {
        this.runUnlockedCleanup();
    }

    void cleanUp() {
        long l2 = this.map.ticker.read();
        this.runLockedCleanup(l2);
        this.runUnlockedCleanup();
    }

    void runLockedCleanup(long l2) {
        if (!this.tryLock()) return;
        try {
            this.drainReferenceQueues();
            this.expireEntries(l2);
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

