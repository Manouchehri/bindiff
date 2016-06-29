package com.google.common.cache;

import java.util.concurrent.locks.*;
import javax.annotation.concurrent.*;
import java.util.concurrent.atomic.*;
import com.google.common.base.*;
import javax.annotation.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;
import java.lang.ref.*;
import java.util.logging.*;
import java.util.*;
import com.google.common.annotations.*;

class LocalCache$Segment extends ReentrantLock
{
    final LocalCache map;
    volatile int count;
    @GuardedBy("this")
    long totalWeight;
    int modCount;
    int threshold;
    volatile AtomicReferenceArray table;
    final long maxSegmentWeight;
    final ReferenceQueue keyReferenceQueue;
    final ReferenceQueue valueReferenceQueue;
    final Queue recencyQueue;
    final AtomicInteger readCount;
    @GuardedBy("this")
    final Queue writeQueue;
    @GuardedBy("this")
    final Queue accessQueue;
    final AbstractCache$StatsCounter statsCounter;
    
    LocalCache$Segment(final LocalCache map, final int n, final long maxSegmentWeight, final AbstractCache$StatsCounter abstractCache$StatsCounter) {
        this.readCount = new AtomicInteger();
        this.map = map;
        this.maxSegmentWeight = maxSegmentWeight;
        this.statsCounter = (AbstractCache$StatsCounter)Preconditions.checkNotNull(abstractCache$StatsCounter);
        this.initTable(this.newEntryArray(n));
        this.keyReferenceQueue = (map.usesKeyReferences() ? new ReferenceQueue() : null);
        this.valueReferenceQueue = (map.usesValueReferences() ? new ReferenceQueue() : null);
        this.recencyQueue = (map.usesAccessQueue() ? new ConcurrentLinkedQueue() : LocalCache.discardingQueue());
        this.writeQueue = (map.usesWriteQueue() ? new LocalCache$WriteQueue() : LocalCache.discardingQueue());
        this.accessQueue = (map.usesAccessQueue() ? new LocalCache$AccessQueue() : LocalCache.discardingQueue());
    }
    
    AtomicReferenceArray newEntryArray(final int n) {
        return new AtomicReferenceArray(n);
    }
    
    void initTable(final AtomicReferenceArray table) {
        this.threshold = table.length() * 3 / 4;
        if (!this.map.customWeigher() && this.threshold == this.maxSegmentWeight) {
            ++this.threshold;
        }
        this.table = table;
    }
    
    @GuardedBy("this")
    LocalCache$ReferenceEntry newEntry(final Object o, final int n, @Nullable final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(o), n, localCache$ReferenceEntry);
    }
    
    @GuardedBy("this")
    LocalCache$ReferenceEntry copyEntry(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        if (localCache$ReferenceEntry.getKey() == null) {
            return null;
        }
        final LocalCache$ValueReference valueReference = localCache$ReferenceEntry.getValueReference();
        final Object value = valueReference.get();
        if (value == null && valueReference.isActive()) {
            return null;
        }
        final LocalCache$ReferenceEntry copyEntry = this.map.entryFactory.copyEntry(this, localCache$ReferenceEntry, localCache$ReferenceEntry2);
        copyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, value, copyEntry));
        return copyEntry;
    }
    
    @GuardedBy("this")
    void setValue(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final Object o, final Object o2, final long n) {
        final LocalCache$ValueReference valueReference = localCache$ReferenceEntry.getValueReference();
        final int weigh = this.map.weigher.weigh(o, o2);
        Preconditions.checkState(weigh >= 0, (Object)"Weights must be non-negative");
        localCache$ReferenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, localCache$ReferenceEntry, o2, weigh));
        this.recordWrite(localCache$ReferenceEntry, weigh, n);
        valueReference.notifyNewValue(o2);
    }
    
    Object get(final Object o, final int n, final CacheLoader cacheLoader) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(cacheLoader);
        try {
            if (this.count != 0) {
                final LocalCache$ReferenceEntry entry = this.getEntry(o, n);
                if (entry != null) {
                    final long read = this.map.ticker.read();
                    final Object liveValue = this.getLiveValue(entry, read);
                    if (liveValue != null) {
                        this.recordRead(entry, read);
                        this.statsCounter.recordHits(1);
                        return this.scheduleRefresh(entry, o, n, liveValue, read, cacheLoader);
                    }
                    final LocalCache$ValueReference valueReference = entry.getValueReference();
                    if (valueReference.isLoading()) {
                        return this.waitForLoadingValue(entry, o, valueReference);
                    }
                }
            }
            return this.lockedGetOrLoad(o, n, cacheLoader);
        }
        catch (ExecutionException ex) {
            final Throwable cause = ex.getCause();
            if (cause instanceof Error) {
                throw new ExecutionError((Error)cause);
            }
            if (cause instanceof RuntimeException) {
                throw new UncheckedExecutionException(cause);
            }
            throw ex;
        }
        finally {
            this.postReadCleanup();
        }
    }
    
    Object lockedGetOrLoad(final Object o, final int n, final CacheLoader cacheLoader) {
        LocalCache$ValueReference valueReference = null;
        LocalCache$LoadingValueReference localCache$LoadingValueReference = null;
        boolean b = true;
        this.lock();
        LocalCache$ReferenceEntry localCache$ReferenceEntry2;
        try {
            final long read = this.map.ticker.read();
            this.preWriteCleanup(read);
            final int count = this.count - 1;
            final AtomicReferenceArray table = this.table;
            final int n2 = n & table.length() - 1;
            final LocalCache$ReferenceEntry localCache$ReferenceEntry = localCache$ReferenceEntry2 = table.get(n2);
            while (localCache$ReferenceEntry2 != null) {
                final Object key = localCache$ReferenceEntry2.getKey();
                if (localCache$ReferenceEntry2.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    valueReference = localCache$ReferenceEntry2.getValueReference();
                    if (valueReference.isLoading()) {
                        b = false;
                        break;
                    }
                    final Object value = valueReference.get();
                    if (value == null) {
                        this.enqueueNotification(key, n, valueReference, RemovalCause.COLLECTED);
                    }
                    else {
                        if (!this.map.isExpired(localCache$ReferenceEntry2, read)) {
                            this.recordLockedRead(localCache$ReferenceEntry2, read);
                            this.statsCounter.recordHits(1);
                            return value;
                        }
                        this.enqueueNotification(key, n, valueReference, RemovalCause.EXPIRED);
                    }
                    this.writeQueue.remove(localCache$ReferenceEntry2);
                    this.accessQueue.remove(localCache$ReferenceEntry2);
                    this.count = count;
                    break;
                }
                else {
                    localCache$ReferenceEntry2 = localCache$ReferenceEntry2.getNext();
                }
            }
            if (b) {
                localCache$LoadingValueReference = new LocalCache$LoadingValueReference();
                if (localCache$ReferenceEntry2 == null) {
                    localCache$ReferenceEntry2 = this.newEntry(o, n, localCache$ReferenceEntry);
                    localCache$ReferenceEntry2.setValueReference(localCache$LoadingValueReference);
                    table.set(n2, localCache$ReferenceEntry2);
                }
                else {
                    localCache$ReferenceEntry2.setValueReference(localCache$LoadingValueReference);
                }
            }
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
        if (b) {
            try {
                synchronized (localCache$ReferenceEntry2) {
                    return this.loadSync(o, n, localCache$LoadingValueReference, cacheLoader);
                }
            }
            finally {
                this.statsCounter.recordMisses(1);
            }
        }
        return this.waitForLoadingValue(localCache$ReferenceEntry2, o, valueReference);
    }
    
    Object waitForLoadingValue(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final Object o, final LocalCache$ValueReference localCache$ValueReference) {
        if (!localCache$ValueReference.isLoading()) {
            throw new AssertionError();
        }
        Preconditions.checkState(!Thread.holdsLock(localCache$ReferenceEntry), "Recursive load of: %s", o);
        try {
            final Object waitForValue = localCache$ValueReference.waitForValue();
            if (waitForValue == null) {
                final String value = String.valueOf(o);
                throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(35 + String.valueOf(value).length()).append("CacheLoader returned null for key ").append(value).append(".").toString());
            }
            this.recordRead(localCache$ReferenceEntry, this.map.ticker.read());
            return waitForValue;
        }
        finally {
            this.statsCounter.recordMisses(1);
        }
    }
    
    Object loadSync(final Object o, final int n, final LocalCache$LoadingValueReference localCache$LoadingValueReference, final CacheLoader cacheLoader) {
        return this.getAndRecordStats(o, n, localCache$LoadingValueReference, localCache$LoadingValueReference.loadFuture(o, cacheLoader));
    }
    
    ListenableFuture loadAsync(final Object o, final int n, final LocalCache$LoadingValueReference localCache$LoadingValueReference, final CacheLoader cacheLoader) {
        final ListenableFuture loadFuture = localCache$LoadingValueReference.loadFuture(o, cacheLoader);
        loadFuture.addListener(new LocalCache$Segment$1(this, o, n, localCache$LoadingValueReference, loadFuture), MoreExecutors.directExecutor());
        return loadFuture;
    }
    
    Object getAndRecordStats(final Object o, final int n, final LocalCache$LoadingValueReference localCache$LoadingValueReference, final ListenableFuture listenableFuture) {
        Object uninterruptibly = null;
        try {
            uninterruptibly = Uninterruptibles.getUninterruptibly(listenableFuture);
            if (uninterruptibly == null) {
                final String value = String.valueOf(o);
                throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(35 + String.valueOf(value).length()).append("CacheLoader returned null for key ").append(value).append(".").toString());
            }
            this.statsCounter.recordLoadSuccess(localCache$LoadingValueReference.elapsedNanos());
            this.storeLoadedValue(o, n, localCache$LoadingValueReference, uninterruptibly);
            return uninterruptibly;
        }
        finally {
            if (uninterruptibly == null) {
                this.statsCounter.recordLoadException(localCache$LoadingValueReference.elapsedNanos());
                this.removeLoadingValue(o, n, localCache$LoadingValueReference);
            }
        }
    }
    
    Object scheduleRefresh(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final Object o, final int n, final Object o2, final long n2, final CacheLoader cacheLoader) {
        if (this.map.refreshes() && n2 - localCache$ReferenceEntry.getWriteTime() > this.map.refreshNanos && !localCache$ReferenceEntry.getValueReference().isLoading()) {
            final Object refresh = this.refresh(o, n, cacheLoader, true);
            if (refresh != null) {
                return refresh;
            }
        }
        return o2;
    }
    
    @Nullable
    Object refresh(final Object o, final int n, final CacheLoader cacheLoader, final boolean b) {
        final LocalCache$LoadingValueReference insertLoadingValueReference = this.insertLoadingValueReference(o, n, b);
        if (insertLoadingValueReference == null) {
            return null;
        }
        final ListenableFuture loadAsync = this.loadAsync(o, n, insertLoadingValueReference, cacheLoader);
        if (loadAsync.isDone()) {
            try {
                return Uninterruptibles.getUninterruptibly(loadAsync);
            }
            catch (Throwable t) {}
        }
        return null;
    }
    
    @Nullable
    LocalCache$LoadingValueReference insertLoadingValueReference(final Object o, final int n, final boolean b) {
        this.lock();
        try {
            final long read = this.map.ticker.read();
            this.preWriteCleanup(read);
            final AtomicReferenceArray table = this.table;
            final int n2 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            final LocalCache$ReferenceEntry localCache$ReferenceEntry = next = table.get(n2);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final LocalCache$ValueReference valueReference = next.getValueReference();
                    if (valueReference.isLoading() || (b && read - next.getWriteTime() < this.map.refreshNanos)) {
                        return null;
                    }
                    ++this.modCount;
                    final LocalCache$LoadingValueReference valueReference2 = new LocalCache$LoadingValueReference(valueReference);
                    next.setValueReference(valueReference2);
                    return valueReference2;
                }
                else {
                    next = next.getNext();
                }
            }
            ++this.modCount;
            final LocalCache$LoadingValueReference valueReference3 = new LocalCache$LoadingValueReference();
            final LocalCache$ReferenceEntry entry = this.newEntry(o, n, localCache$ReferenceEntry);
            entry.setValueReference(valueReference3);
            table.set(n2, entry);
            return valueReference3;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }
    
    void tryDrainReferenceQueues() {
        if (this.tryLock()) {
            try {
                this.drainReferenceQueues();
            }
            finally {
                this.unlock();
            }
        }
    }
    
    @GuardedBy("this")
    void drainReferenceQueues() {
        if (this.map.usesKeyReferences()) {
            this.drainKeyReferenceQueue();
        }
        if (this.map.usesValueReferences()) {
            this.drainValueReferenceQueue();
        }
    }
    
    @GuardedBy("this")
    void drainKeyReferenceQueue() {
        int n = 0;
        Reference poll;
        while ((poll = this.keyReferenceQueue.poll()) != null) {
            this.map.reclaimKey((LocalCache$ReferenceEntry)poll);
            if (++n == 16) {
                break;
            }
        }
    }
    
    @GuardedBy("this")
    void drainValueReferenceQueue() {
        int n = 0;
        Reference poll;
        while ((poll = this.valueReferenceQueue.poll()) != null) {
            this.map.reclaimValue((LocalCache$ValueReference)poll);
            if (++n == 16) {
                break;
            }
        }
    }
    
    void clearReferenceQueues() {
        if (this.map.usesKeyReferences()) {
            this.clearKeyReferenceQueue();
        }
        if (this.map.usesValueReferences()) {
            this.clearValueReferenceQueue();
        }
    }
    
    void clearKeyReferenceQueue() {
        while (this.keyReferenceQueue.poll() != null) {}
    }
    
    void clearValueReferenceQueue() {
        while (this.valueReferenceQueue.poll() != null) {}
    }
    
    void recordRead(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final long accessTime) {
        if (this.map.recordsAccess()) {
            localCache$ReferenceEntry.setAccessTime(accessTime);
        }
        this.recencyQueue.add(localCache$ReferenceEntry);
    }
    
    @GuardedBy("this")
    void recordLockedRead(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final long accessTime) {
        if (this.map.recordsAccess()) {
            localCache$ReferenceEntry.setAccessTime(accessTime);
        }
        this.accessQueue.add(localCache$ReferenceEntry);
    }
    
    @GuardedBy("this")
    void recordWrite(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final int n, final long n2) {
        this.drainRecencyQueue();
        this.totalWeight += n;
        if (this.map.recordsAccess()) {
            localCache$ReferenceEntry.setAccessTime(n2);
        }
        if (this.map.recordsWrite()) {
            localCache$ReferenceEntry.setWriteTime(n2);
        }
        this.accessQueue.add(localCache$ReferenceEntry);
        this.writeQueue.add(localCache$ReferenceEntry);
    }
    
    @GuardedBy("this")
    void drainRecencyQueue() {
        LocalCache$ReferenceEntry localCache$ReferenceEntry;
        while ((localCache$ReferenceEntry = this.recencyQueue.poll()) != null) {
            if (this.accessQueue.contains(localCache$ReferenceEntry)) {
                this.accessQueue.add(localCache$ReferenceEntry);
            }
        }
    }
    
    void tryExpireEntries(final long n) {
        if (this.tryLock()) {
            try {
                this.expireEntries(n);
            }
            finally {
                this.unlock();
            }
        }
    }
    
    @GuardedBy("this")
    void expireEntries(final long n) {
        this.drainRecencyQueue();
        LocalCache$ReferenceEntry localCache$ReferenceEntry;
        while ((localCache$ReferenceEntry = this.writeQueue.peek()) != null && this.map.isExpired(localCache$ReferenceEntry, n)) {
            if (!this.removeEntry(localCache$ReferenceEntry, localCache$ReferenceEntry.getHash(), RemovalCause.EXPIRED)) {
                throw new AssertionError();
            }
        }
        LocalCache$ReferenceEntry localCache$ReferenceEntry2;
        while ((localCache$ReferenceEntry2 = this.accessQueue.peek()) != null && this.map.isExpired(localCache$ReferenceEntry2, n)) {
            if (!this.removeEntry(localCache$ReferenceEntry2, localCache$ReferenceEntry2.getHash(), RemovalCause.EXPIRED)) {
                throw new AssertionError();
            }
        }
    }
    
    @GuardedBy("this")
    void enqueueNotification(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final RemovalCause removalCause) {
        this.enqueueNotification(localCache$ReferenceEntry.getKey(), localCache$ReferenceEntry.getHash(), localCache$ReferenceEntry.getValueReference(), removalCause);
    }
    
    @GuardedBy("this")
    void enqueueNotification(@Nullable final Object o, final int n, final LocalCache$ValueReference localCache$ValueReference, final RemovalCause removalCause) {
        this.totalWeight -= localCache$ValueReference.getWeight();
        if (removalCause.wasEvicted()) {
            this.statsCounter.recordEviction();
        }
        if (this.map.removalNotificationQueue != LocalCache.DISCARDING_QUEUE) {
            final Object value = localCache$ValueReference.get();
            if (o == null && !this.map.usesKeyReferences()) {
                final String value2 = String.valueOf(removalCause);
                LocalCache.logger.log(Level.WARNING, new StringBuilder(55 + String.valueOf(value2).length()).append("Unexpected null key during removal notification, cause=").append(value2).toString(), new AssertionError());
            }
            else if (value == null && !this.map.usesValueReferences()) {
                final String value3 = String.valueOf(removalCause);
                LocalCache.logger.log(Level.WARNING, new StringBuilder(57 + String.valueOf(value3).length()).append("Unexpected null value during removal notification, cause=").append(value3).toString(), new AssertionError());
            }
            this.map.removalNotificationQueue.offer(RemovalNotification.create(o, value, removalCause));
        }
    }
    
    @GuardedBy("this")
    void evictEntries(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        if (!this.map.evictsBySize()) {
            return;
        }
        this.drainRecencyQueue();
        if (localCache$ReferenceEntry.getValueReference().getWeight() > this.maxSegmentWeight && !this.removeEntry(localCache$ReferenceEntry, localCache$ReferenceEntry.getHash(), RemovalCause.SIZE)) {
            throw new AssertionError();
        }
        while (this.totalWeight > this.maxSegmentWeight) {
            final LocalCache$ReferenceEntry nextEvictable = this.getNextEvictable();
            if (!this.removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                throw new AssertionError();
            }
        }
    }
    
    @GuardedBy("this")
    LocalCache$ReferenceEntry getNextEvictable() {
        for (final LocalCache$ReferenceEntry localCache$ReferenceEntry : this.accessQueue) {
            if (localCache$ReferenceEntry.getValueReference().getWeight() > 0) {
                return localCache$ReferenceEntry;
            }
        }
        throw new AssertionError();
    }
    
    LocalCache$ReferenceEntry getFirst(final int n) {
        final AtomicReferenceArray table = this.table;
        return table.get(n & table.length() - 1);
    }
    
    @Nullable
    LocalCache$ReferenceEntry getEntry(final Object o, final int n) {
        for (LocalCache$ReferenceEntry localCache$ReferenceEntry = this.getFirst(n); localCache$ReferenceEntry != null; localCache$ReferenceEntry = localCache$ReferenceEntry.getNext()) {
            if (localCache$ReferenceEntry.getHash() == n) {
                final Object key = localCache$ReferenceEntry.getKey();
                if (key == null) {
                    this.tryDrainReferenceQueues();
                }
                else if (this.map.keyEquivalence.equivalent(o, key)) {
                    return localCache$ReferenceEntry;
                }
            }
        }
        return null;
    }
    
    @Nullable
    LocalCache$ReferenceEntry getLiveEntry(final Object o, final int n, final long n2) {
        final LocalCache$ReferenceEntry entry = this.getEntry(o, n);
        if (entry == null) {
            return null;
        }
        if (this.map.isExpired(entry, n2)) {
            this.tryExpireEntries(n2);
            return null;
        }
        return entry;
    }
    
    Object getLiveValue(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final long n) {
        if (localCache$ReferenceEntry.getKey() == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        final Object value = localCache$ReferenceEntry.getValueReference().get();
        if (value == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        if (this.map.isExpired(localCache$ReferenceEntry, n)) {
            this.tryExpireEntries(n);
            return null;
        }
        return value;
    }
    
    @Nullable
    Object get(final Object o, final int n) {
        try {
            if (this.count != 0) {
                final long read = this.map.ticker.read();
                final LocalCache$ReferenceEntry liveEntry = this.getLiveEntry(o, n, read);
                if (liveEntry == null) {
                    return null;
                }
                final Object value = liveEntry.getValueReference().get();
                if (value != null) {
                    this.recordRead(liveEntry, read);
                    return this.scheduleRefresh(liveEntry, liveEntry.getKey(), n, value, read, this.map.defaultLoader);
                }
                this.tryDrainReferenceQueues();
            }
            return null;
        }
        finally {
            this.postReadCleanup();
        }
    }
    
    boolean containsKey(final Object o, final int n) {
        try {
            if (this.count != 0) {
                final LocalCache$ReferenceEntry liveEntry = this.getLiveEntry(o, n, this.map.ticker.read());
                return liveEntry != null && liveEntry.getValueReference().get() != null;
            }
            return false;
        }
        finally {
            this.postReadCleanup();
        }
    }
    
    @VisibleForTesting
    boolean containsValue(final Object o) {
        try {
            if (this.count != 0) {
                final long read = this.map.ticker.read();
                final AtomicReferenceArray table = this.table;
                for (int length = table.length(), i = 0; i < length; ++i) {
                    for (LocalCache$ReferenceEntry next = table.get(i); next != null; next = next.getNext()) {
                        final Object liveValue = this.getLiveValue(next, read);
                        if (liveValue != null) {
                            if (this.map.valueEquivalence.equivalent(o, liveValue)) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        finally {
            this.postReadCleanup();
        }
    }
    
    @Nullable
    Object put(final Object o, final int n, final Object o2, final boolean b) {
        this.lock();
        try {
            final long read = this.map.ticker.read();
            this.preWriteCleanup(read);
            if (this.count + 1 > this.threshold) {
                this.expand();
                final int n2 = this.count + 1;
            }
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            final LocalCache$ReferenceEntry localCache$ReferenceEntry = next = table.get(n3);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final LocalCache$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    if (value == null) {
                        ++this.modCount;
                        int count;
                        if (valueReference.isActive()) {
                            this.enqueueNotification(o, n, valueReference, RemovalCause.COLLECTED);
                            this.setValue(next, o, o2, read);
                            count = this.count;
                        }
                        else {
                            this.setValue(next, o, o2, read);
                            count = this.count + 1;
                        }
                        this.count = count;
                        this.evictEntries(next);
                        return null;
                    }
                    if (b) {
                        this.recordLockedRead(next, read);
                        return value;
                    }
                    ++this.modCount;
                    this.enqueueNotification(o, n, valueReference, RemovalCause.REPLACED);
                    this.setValue(next, o, o2, read);
                    this.evictEntries(next);
                    return value;
                }
                else {
                    next = next.getNext();
                }
            }
            ++this.modCount;
            final LocalCache$ReferenceEntry entry = this.newEntry(o, n, localCache$ReferenceEntry);
            this.setValue(entry, o, o2, read);
            table.set(n3, entry);
            ++this.count;
            this.evictEntries(entry);
            return null;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }
    
    @GuardedBy("this")
    void expand() {
        final AtomicReferenceArray table = this.table;
        final int length = table.length();
        if (length >= 1073741824) {
            return;
        }
        int count = this.count;
        final AtomicReferenceArray entryArray = this.newEntryArray(length << 1);
        this.threshold = entryArray.length() * 3 / 4;
        final int n = entryArray.length() - 1;
        for (int i = 0; i < length; ++i) {
            final LocalCache$ReferenceEntry localCache$ReferenceEntry = table.get(i);
            if (localCache$ReferenceEntry != null) {
                final LocalCache$ReferenceEntry next = localCache$ReferenceEntry.getNext();
                final int n2 = localCache$ReferenceEntry.getHash() & n;
                if (next == null) {
                    entryArray.set(n2, localCache$ReferenceEntry);
                }
                else {
                    LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$ReferenceEntry;
                    int n3 = n2;
                    for (LocalCache$ReferenceEntry next2 = next; next2 != null; next2 = next2.getNext()) {
                        final int n4 = next2.getHash() & n;
                        if (n4 != n3) {
                            n3 = n4;
                            localCache$ReferenceEntry2 = next2;
                        }
                    }
                    entryArray.set(n3, localCache$ReferenceEntry2);
                    for (LocalCache$ReferenceEntry next3 = localCache$ReferenceEntry; next3 != localCache$ReferenceEntry2; next3 = next3.getNext()) {
                        final int n5 = next3.getHash() & n;
                        final LocalCache$ReferenceEntry copyEntry = this.copyEntry(next3, entryArray.get(n5));
                        if (copyEntry != null) {
                            entryArray.set(n5, copyEntry);
                        }
                        else {
                            this.removeCollectedEntry(next3);
                            --count;
                        }
                    }
                }
            }
        }
        this.table = entryArray;
        this.count = count;
    }
    
    boolean replace(final Object o, final int n, final Object o2, final Object o3) {
        this.lock();
        try {
            final long read = this.map.ticker.read();
            this.preWriteCleanup(read);
            final AtomicReferenceArray table = this.table;
            final int n2 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            final LocalCache$ReferenceEntry localCache$ReferenceEntry = next = table.get(n2);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final LocalCache$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    if (value == null) {
                        if (valueReference.isActive()) {
                            final int n3 = this.count - 1;
                            ++this.modCount;
                            final LocalCache$ReferenceEntry removeValueFromChain = this.removeValueFromChain(localCache$ReferenceEntry, next, key, n, valueReference, RemovalCause.COLLECTED);
                            final int count = this.count - 1;
                            table.set(n2, removeValueFromChain);
                            this.count = count;
                        }
                        return false;
                    }
                    if (this.map.valueEquivalence.equivalent(o2, value)) {
                        ++this.modCount;
                        this.enqueueNotification(o, n, valueReference, RemovalCause.REPLACED);
                        this.setValue(next, o, o3, read);
                        this.evictEntries(next);
                        return true;
                    }
                    this.recordLockedRead(next, read);
                    return false;
                }
                else {
                    next = next.getNext();
                }
            }
            return false;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }
    
    @Nullable
    Object replace(final Object o, final int n, final Object o2) {
        this.lock();
        try {
            final long read = this.map.ticker.read();
            this.preWriteCleanup(read);
            final AtomicReferenceArray table = this.table;
            final int n2 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            final LocalCache$ReferenceEntry localCache$ReferenceEntry = next = table.get(n2);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final LocalCache$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    if (value == null) {
                        if (valueReference.isActive()) {
                            final int n3 = this.count - 1;
                            ++this.modCount;
                            final LocalCache$ReferenceEntry removeValueFromChain = this.removeValueFromChain(localCache$ReferenceEntry, next, key, n, valueReference, RemovalCause.COLLECTED);
                            final int count = this.count - 1;
                            table.set(n2, removeValueFromChain);
                            this.count = count;
                        }
                        return null;
                    }
                    ++this.modCount;
                    this.enqueueNotification(o, n, valueReference, RemovalCause.REPLACED);
                    this.setValue(next, o, o2, read);
                    this.evictEntries(next);
                    return value;
                }
                else {
                    next = next.getNext();
                }
            }
            return null;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }
    
    @Nullable
    Object remove(final Object o, final int n) {
        this.lock();
        try {
            this.preWriteCleanup(this.map.ticker.read());
            final int n2 = this.count - 1;
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            for (LocalCache$ReferenceEntry localCache$ReferenceEntry = next = table.get(n3); next != null; next = next.getNext()) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final LocalCache$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    RemovalCause removalCause;
                    if (value != null) {
                        removalCause = RemovalCause.EXPLICIT;
                    }
                    else {
                        if (!valueReference.isActive()) {
                            return null;
                        }
                        removalCause = RemovalCause.COLLECTED;
                    }
                    ++this.modCount;
                    final LocalCache$ReferenceEntry removeValueFromChain = this.removeValueFromChain(localCache$ReferenceEntry, next, key, n, valueReference, removalCause);
                    final int count = this.count - 1;
                    table.set(n3, removeValueFromChain);
                    this.count = count;
                    return value;
                }
            }
            return null;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }
    
    boolean storeLoadedValue(final Object o, final int n, final LocalCache$LoadingValueReference localCache$LoadingValueReference, final Object o2) {
        this.lock();
        try {
            final long read = this.map.ticker.read();
            this.preWriteCleanup(read);
            int n2 = this.count + 1;
            if (n2 > this.threshold) {
                this.expand();
                n2 = this.count + 1;
            }
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            final LocalCache$ReferenceEntry localCache$ReferenceEntry = next = table.get(n3);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final LocalCache$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    if (localCache$LoadingValueReference == valueReference || (value == null && valueReference != LocalCache.UNSET)) {
                        ++this.modCount;
                        if (localCache$LoadingValueReference.isActive()) {
                            this.enqueueNotification(o, n, localCache$LoadingValueReference, (value == null) ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            --n2;
                        }
                        this.setValue(next, o, o2, read);
                        this.count = n2;
                        this.evictEntries(next);
                        return true;
                    }
                    this.enqueueNotification(o, n, new LocalCache$WeightedStrongValueReference(o2, 0), RemovalCause.REPLACED);
                    return false;
                }
                else {
                    next = next.getNext();
                }
            }
            ++this.modCount;
            final LocalCache$ReferenceEntry entry = this.newEntry(o, n, localCache$ReferenceEntry);
            this.setValue(entry, o, o2, read);
            table.set(n3, entry);
            this.count = n2;
            this.evictEntries(entry);
            return true;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }
    
    boolean remove(final Object o, final int n, final Object o2) {
        this.lock();
        try {
            this.preWriteCleanup(this.map.ticker.read());
            final int n2 = this.count - 1;
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            for (LocalCache$ReferenceEntry localCache$ReferenceEntry = next = table.get(n3); next != null; next = next.getNext()) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final LocalCache$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    RemovalCause removalCause;
                    if (this.map.valueEquivalence.equivalent(o2, value)) {
                        removalCause = RemovalCause.EXPLICIT;
                    }
                    else {
                        if (value != null || !valueReference.isActive()) {
                            return false;
                        }
                        removalCause = RemovalCause.COLLECTED;
                    }
                    ++this.modCount;
                    final LocalCache$ReferenceEntry removeValueFromChain = this.removeValueFromChain(localCache$ReferenceEntry, next, key, n, valueReference, removalCause);
                    final int count = this.count - 1;
                    table.set(n3, removeValueFromChain);
                    this.count = count;
                    return removalCause == RemovalCause.EXPLICIT;
                }
            }
            return false;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }
    
    void clear() {
        if (this.count != 0) {
            this.lock();
            try {
                final AtomicReferenceArray table = this.table;
                for (int i = 0; i < table.length(); ++i) {
                    for (LocalCache$ReferenceEntry next = table.get(i); next != null; next = next.getNext()) {
                        if (next.getValueReference().isActive()) {
                            this.enqueueNotification(next, RemovalCause.EXPLICIT);
                        }
                    }
                }
                for (int j = 0; j < table.length(); ++j) {
                    table.set(j, null);
                }
                this.clearReferenceQueues();
                this.writeQueue.clear();
                this.accessQueue.clear();
                this.readCount.set(0);
                ++this.modCount;
                this.count = 0;
            }
            finally {
                this.unlock();
                this.postWriteCleanup();
            }
        }
    }
    
    @Nullable
    @GuardedBy("this")
    LocalCache$ReferenceEntry removeValueFromChain(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final LocalCache$ReferenceEntry localCache$ReferenceEntry2, @Nullable final Object o, final int n, final LocalCache$ValueReference localCache$ValueReference, final RemovalCause removalCause) {
        this.enqueueNotification(o, n, localCache$ValueReference, removalCause);
        this.writeQueue.remove(localCache$ReferenceEntry2);
        this.accessQueue.remove(localCache$ReferenceEntry2);
        if (localCache$ValueReference.isLoading()) {
            localCache$ValueReference.notifyNewValue(null);
            return localCache$ReferenceEntry;
        }
        return this.removeEntryFromChain(localCache$ReferenceEntry, localCache$ReferenceEntry2);
    }
    
    @Nullable
    @GuardedBy("this")
    LocalCache$ReferenceEntry removeEntryFromChain(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        int count = this.count;
        LocalCache$ReferenceEntry next = localCache$ReferenceEntry2.getNext();
        for (LocalCache$ReferenceEntry next2 = localCache$ReferenceEntry; next2 != localCache$ReferenceEntry2; next2 = next2.getNext()) {
            final LocalCache$ReferenceEntry copyEntry = this.copyEntry(next2, next);
            if (copyEntry != null) {
                next = copyEntry;
            }
            else {
                this.removeCollectedEntry(next2);
                --count;
            }
        }
        this.count = count;
        return next;
    }
    
    @GuardedBy("this")
    void removeCollectedEntry(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        this.enqueueNotification(localCache$ReferenceEntry, RemovalCause.COLLECTED);
        this.writeQueue.remove(localCache$ReferenceEntry);
        this.accessQueue.remove(localCache$ReferenceEntry);
    }
    
    boolean reclaimKey(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final int n) {
        this.lock();
        try {
            final int n2 = this.count - 1;
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            for (LocalCache$ReferenceEntry localCache$ReferenceEntry2 = next = table.get(n3); next != null; next = next.getNext()) {
                if (next == localCache$ReferenceEntry) {
                    ++this.modCount;
                    final LocalCache$ReferenceEntry removeValueFromChain = this.removeValueFromChain(localCache$ReferenceEntry2, next, next.getKey(), n, next.getValueReference(), RemovalCause.COLLECTED);
                    final int count = this.count - 1;
                    table.set(n3, removeValueFromChain);
                    this.count = count;
                    return true;
                }
            }
            return false;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }
    
    boolean reclaimValue(final Object o, final int n, final LocalCache$ValueReference localCache$ValueReference) {
        this.lock();
        try {
            final int n2 = this.count - 1;
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            final LocalCache$ReferenceEntry localCache$ReferenceEntry = next = table.get(n3);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    if (next.getValueReference() == localCache$ValueReference) {
                        ++this.modCount;
                        final LocalCache$ReferenceEntry removeValueFromChain = this.removeValueFromChain(localCache$ReferenceEntry, next, key, n, localCache$ValueReference, RemovalCause.COLLECTED);
                        final int count = this.count - 1;
                        table.set(n3, removeValueFromChain);
                        this.count = count;
                        return true;
                    }
                    return false;
                }
                else {
                    next = next.getNext();
                }
            }
            return false;
        }
        finally {
            this.unlock();
            if (!this.isHeldByCurrentThread()) {
                this.postWriteCleanup();
            }
        }
    }
    
    boolean removeLoadingValue(final Object o, final int n, final LocalCache$LoadingValueReference localCache$LoadingValueReference) {
        this.lock();
        try {
            final AtomicReferenceArray table = this.table;
            final int n2 = n & table.length() - 1;
            LocalCache$ReferenceEntry next;
            final LocalCache$ReferenceEntry localCache$ReferenceEntry = next = table.get(n2);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    if (next.getValueReference() == localCache$LoadingValueReference) {
                        if (localCache$LoadingValueReference.isActive()) {
                            next.setValueReference(localCache$LoadingValueReference.getOldValue());
                        }
                        else {
                            table.set(n2, this.removeEntryFromChain(localCache$ReferenceEntry, next));
                        }
                        return true;
                    }
                    return false;
                }
                else {
                    next = next.getNext();
                }
            }
            return false;
        }
        finally {
            this.unlock();
            this.postWriteCleanup();
        }
    }
    
    @GuardedBy("this")
    boolean removeEntry(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final int n, final RemovalCause removalCause) {
        final int n2 = this.count - 1;
        final AtomicReferenceArray table = this.table;
        final int n3 = n & table.length() - 1;
        LocalCache$ReferenceEntry next;
        for (LocalCache$ReferenceEntry localCache$ReferenceEntry2 = next = table.get(n3); next != null; next = next.getNext()) {
            if (next == localCache$ReferenceEntry) {
                ++this.modCount;
                final LocalCache$ReferenceEntry removeValueFromChain = this.removeValueFromChain(localCache$ReferenceEntry2, next, next.getKey(), n, next.getValueReference(), removalCause);
                final int count = this.count - 1;
                table.set(n3, removeValueFromChain);
                this.count = count;
                return true;
            }
        }
        return false;
    }
    
    void postReadCleanup() {
        if ((this.readCount.incrementAndGet() & 0x3F) == 0x0) {
            this.cleanUp();
        }
    }
    
    @GuardedBy("this")
    void preWriteCleanup(final long n) {
        this.runLockedCleanup(n);
    }
    
    void postWriteCleanup() {
        this.runUnlockedCleanup();
    }
    
    void cleanUp() {
        this.runLockedCleanup(this.map.ticker.read());
        this.runUnlockedCleanup();
    }
    
    void runLockedCleanup(final long n) {
        if (this.tryLock()) {
            try {
                this.drainReferenceQueues();
                this.expireEntries(n);
                this.readCount.set(0);
            }
            finally {
                this.unlock();
            }
        }
    }
    
    void runUnlockedCleanup() {
        if (!this.isHeldByCurrentThread()) {
            this.map.processPendingNotifications();
        }
    }
}
