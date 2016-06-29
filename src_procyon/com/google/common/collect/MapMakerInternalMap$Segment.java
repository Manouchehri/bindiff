package com.google.common.collect;

import java.util.concurrent.locks.*;
import com.google.j2objc.annotations.*;
import java.util.concurrent.atomic.*;
import javax.annotation.concurrent.*;
import javax.annotation.*;
import java.lang.ref.*;
import com.google.common.annotations.*;
import java.io.*;
import java.util.concurrent.*;
import java.util.logging.*;
import com.google.common.primitives.*;
import com.google.common.base.*;
import java.util.*;

class MapMakerInternalMap$Segment extends ReentrantLock
{
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
    final AtomicInteger readCount;
    @GuardedBy("this")
    final Queue evictionQueue;
    @GuardedBy("this")
    final Queue expirationQueue;
    
    MapMakerInternalMap$Segment(final MapMakerInternalMap map, final int n, final int maxSegmentSize) {
        this.readCount = new AtomicInteger();
        this.map = map;
        this.maxSegmentSize = maxSegmentSize;
        this.initTable(this.newEntryArray(n));
        this.keyReferenceQueue = (map.usesKeyReferences() ? new ReferenceQueue() : null);
        this.valueReferenceQueue = (map.usesValueReferences() ? new ReferenceQueue() : null);
        this.recencyQueue = ((map.evictsBySize() || map.expiresAfterAccess()) ? new ConcurrentLinkedQueue() : MapMakerInternalMap.discardingQueue());
        this.evictionQueue = (map.evictsBySize() ? new MapMakerInternalMap$EvictionQueue() : MapMakerInternalMap.discardingQueue());
        this.expirationQueue = (map.expires() ? new MapMakerInternalMap$ExpirationQueue() : MapMakerInternalMap.discardingQueue());
    }
    
    AtomicReferenceArray newEntryArray(final int n) {
        return new AtomicReferenceArray(n);
    }
    
    void initTable(final AtomicReferenceArray table) {
        this.threshold = table.length() * 3 / 4;
        if (this.threshold == this.maxSegmentSize) {
            ++this.threshold;
        }
        this.table = table;
    }
    
    @GuardedBy("this")
    MapMakerInternalMap$ReferenceEntry newEntry(final Object o, final int n, @Nullable final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this.map.entryFactory.newEntry(this, o, n, mapMakerInternalMap$ReferenceEntry);
    }
    
    @GuardedBy("this")
    MapMakerInternalMap$ReferenceEntry copyEntry(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        if (mapMakerInternalMap$ReferenceEntry.getKey() == null) {
            return null;
        }
        final MapMakerInternalMap$ValueReference valueReference = mapMakerInternalMap$ReferenceEntry.getValueReference();
        final Object value = valueReference.get();
        if (value == null && !valueReference.isComputingReference()) {
            return null;
        }
        final MapMakerInternalMap$ReferenceEntry copyEntry = this.map.entryFactory.copyEntry(this, mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry2);
        copyEntry.setValueReference(valueReference.copyFor(this.valueReferenceQueue, value, copyEntry));
        return copyEntry;
    }
    
    @GuardedBy("this")
    void setValue(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final Object o) {
        mapMakerInternalMap$ReferenceEntry.setValueReference(this.map.valueStrength.referenceValue(this, mapMakerInternalMap$ReferenceEntry, o));
        this.recordWrite(mapMakerInternalMap$ReferenceEntry);
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
            this.map.reclaimKey((MapMakerInternalMap$ReferenceEntry)poll);
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
            this.map.reclaimValue((MapMakerInternalMap$ValueReference)poll);
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
    
    void recordRead(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        if (this.map.expiresAfterAccess()) {
            this.recordExpirationTime(mapMakerInternalMap$ReferenceEntry, this.map.expireAfterAccessNanos);
        }
        this.recencyQueue.add(mapMakerInternalMap$ReferenceEntry);
    }
    
    @GuardedBy("this")
    void recordLockedRead(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.evictionQueue.add(mapMakerInternalMap$ReferenceEntry);
        if (this.map.expiresAfterAccess()) {
            this.recordExpirationTime(mapMakerInternalMap$ReferenceEntry, this.map.expireAfterAccessNanos);
            this.expirationQueue.add(mapMakerInternalMap$ReferenceEntry);
        }
    }
    
    @GuardedBy("this")
    void recordWrite(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.drainRecencyQueue();
        this.evictionQueue.add(mapMakerInternalMap$ReferenceEntry);
        if (this.map.expires()) {
            this.recordExpirationTime(mapMakerInternalMap$ReferenceEntry, this.map.expiresAfterAccess() ? this.map.expireAfterAccessNanos : this.map.expireAfterWriteNanos);
            this.expirationQueue.add(mapMakerInternalMap$ReferenceEntry);
        }
    }
    
    @GuardedBy("this")
    void drainRecencyQueue() {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
        while ((mapMakerInternalMap$ReferenceEntry = this.recencyQueue.poll()) != null) {
            if (this.evictionQueue.contains(mapMakerInternalMap$ReferenceEntry)) {
                this.evictionQueue.add(mapMakerInternalMap$ReferenceEntry);
            }
            if (this.map.expiresAfterAccess() && this.expirationQueue.contains(mapMakerInternalMap$ReferenceEntry)) {
                this.expirationQueue.add(mapMakerInternalMap$ReferenceEntry);
            }
        }
    }
    
    void recordExpirationTime(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final long n) {
        mapMakerInternalMap$ReferenceEntry.setExpirationTime(this.map.ticker.read() + n);
    }
    
    void tryExpireEntries() {
        if (this.tryLock()) {
            try {
                this.expireEntries();
            }
            finally {
                this.unlock();
            }
        }
    }
    
    @GuardedBy("this")
    void expireEntries() {
        this.drainRecencyQueue();
        if (this.expirationQueue.isEmpty()) {
            return;
        }
        final long read = this.map.ticker.read();
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
        while ((mapMakerInternalMap$ReferenceEntry = this.expirationQueue.peek()) != null && this.map.isExpired(mapMakerInternalMap$ReferenceEntry, read)) {
            if (!this.removeEntry(mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry.getHash(), MapMaker$RemovalCause.EXPIRED)) {
                throw new AssertionError();
            }
        }
    }
    
    void enqueueNotification(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final MapMaker$RemovalCause mapMaker$RemovalCause) {
        this.enqueueNotification(mapMakerInternalMap$ReferenceEntry.getKey(), mapMakerInternalMap$ReferenceEntry.getHash(), mapMakerInternalMap$ReferenceEntry.getValueReference().get(), mapMaker$RemovalCause);
    }
    
    void enqueueNotification(@Nullable final Object o, final int n, @Nullable final Object o2, final MapMaker$RemovalCause mapMaker$RemovalCause) {
        if (this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
            if (o == null && !this.map.usesKeyReferences()) {
                final String value = String.valueOf(mapMaker$RemovalCause);
                MapMakerInternalMap.logger.log(Level.WARNING, new StringBuilder(55 + String.valueOf(value).length()).append("Unexpected null key during removal notification, cause=").append(value).toString(), new AssertionError());
            }
            else if (o2 == null && !this.map.usesValueReferences()) {
                final String value2 = String.valueOf(mapMaker$RemovalCause);
                MapMakerInternalMap.logger.log(Level.WARNING, new StringBuilder(57 + String.valueOf(value2).length()).append("Unexpected null value during removal notification, cause=").append(value2).toString(), new AssertionError());
            }
            this.map.removalNotificationQueue.offer(new MapMaker$RemovalNotification(o, o2, mapMaker$RemovalCause));
        }
    }
    
    @GuardedBy("this")
    boolean evictEntries() {
        if (!this.map.evictsBySize() || this.count < this.maxSegmentSize) {
            return false;
        }
        this.drainRecencyQueue();
        final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.evictionQueue.remove();
        if (!this.removeEntry(mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry.getHash(), MapMaker$RemovalCause.SIZE)) {
            throw new AssertionError();
        }
        return true;
    }
    
    MapMakerInternalMap$ReferenceEntry getFirst(final int n) {
        final AtomicReferenceArray table = this.table;
        return table.get(n & table.length() - 1);
    }
    
    MapMakerInternalMap$ReferenceEntry getEntry(final Object o, final int n) {
        if (this.count != 0) {
            for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = this.getFirst(n); mapMakerInternalMap$ReferenceEntry != null; mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ReferenceEntry.getNext()) {
                if (mapMakerInternalMap$ReferenceEntry.getHash() == n) {
                    final Object key = mapMakerInternalMap$ReferenceEntry.getKey();
                    if (key == null) {
                        this.tryDrainReferenceQueues();
                    }
                    else if (this.map.keyEquivalence.equivalent(o, key)) {
                        return mapMakerInternalMap$ReferenceEntry;
                    }
                }
            }
        }
        return null;
    }
    
    MapMakerInternalMap$ReferenceEntry getLiveEntry(final Object o, final int n) {
        final MapMakerInternalMap$ReferenceEntry entry = this.getEntry(o, n);
        if (entry == null) {
            return null;
        }
        if (this.map.expires() && this.map.isExpired(entry)) {
            this.tryExpireEntries();
            return null;
        }
        return entry;
    }
    
    Object get(final Object o, final int n) {
        try {
            final MapMakerInternalMap$ReferenceEntry liveEntry = this.getLiveEntry(o, n);
            if (liveEntry == null) {
                return null;
            }
            final Object value = liveEntry.getValueReference().get();
            if (value != null) {
                this.recordRead(liveEntry);
            }
            else {
                this.tryDrainReferenceQueues();
            }
            return value;
        }
        finally {
            this.postReadCleanup();
        }
    }
    
    boolean containsKey(final Object o, final int n) {
        try {
            if (this.count != 0) {
                final MapMakerInternalMap$ReferenceEntry liveEntry = this.getLiveEntry(o, n);
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
                final AtomicReferenceArray table = this.table;
                for (int length = table.length(), i = 0; i < length; ++i) {
                    for (MapMakerInternalMap$ReferenceEntry next = table.get(i); next != null; next = next.getNext()) {
                        final Object liveValue = this.getLiveValue(next);
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
    
    Object put(final Object o, final int n, final Object o2, final boolean b) {
        this.lock();
        try {
            this.preWriteCleanup();
            int count = this.count + 1;
            if (count > this.threshold) {
                this.expand();
                count = this.count + 1;
            }
            final AtomicReferenceArray table = this.table;
            final int n2 = n & table.length() - 1;
            MapMakerInternalMap$ReferenceEntry next;
            final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = next = table.get(n2);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final MapMakerInternalMap$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    if (value == null) {
                        ++this.modCount;
                        this.setValue(next, o2);
                        if (!valueReference.isComputingReference()) {
                            this.enqueueNotification(o, n, value, MapMaker$RemovalCause.COLLECTED);
                            count = this.count;
                        }
                        else if (this.evictEntries()) {
                            count = this.count + 1;
                        }
                        this.count = count;
                        return null;
                    }
                    if (b) {
                        this.recordLockedRead(next);
                        return value;
                    }
                    ++this.modCount;
                    this.enqueueNotification(o, n, value, MapMaker$RemovalCause.REPLACED);
                    this.setValue(next, o2);
                    return value;
                }
                else {
                    next = next.getNext();
                }
            }
            ++this.modCount;
            final MapMakerInternalMap$ReferenceEntry entry = this.newEntry(o, n, mapMakerInternalMap$ReferenceEntry);
            this.setValue(entry, o2);
            table.set(n2, entry);
            if (this.evictEntries()) {
                count = this.count + 1;
            }
            this.count = count;
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
            final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = table.get(i);
            if (mapMakerInternalMap$ReferenceEntry != null) {
                final MapMakerInternalMap$ReferenceEntry next = mapMakerInternalMap$ReferenceEntry.getNext();
                final int n2 = mapMakerInternalMap$ReferenceEntry.getHash() & n;
                if (next == null) {
                    entryArray.set(n2, mapMakerInternalMap$ReferenceEntry);
                }
                else {
                    MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = mapMakerInternalMap$ReferenceEntry;
                    int n3 = n2;
                    for (MapMakerInternalMap$ReferenceEntry next2 = next; next2 != null; next2 = next2.getNext()) {
                        final int n4 = next2.getHash() & n;
                        if (n4 != n3) {
                            n3 = n4;
                            mapMakerInternalMap$ReferenceEntry2 = next2;
                        }
                    }
                    entryArray.set(n3, mapMakerInternalMap$ReferenceEntry2);
                    for (MapMakerInternalMap$ReferenceEntry next3 = mapMakerInternalMap$ReferenceEntry; next3 != mapMakerInternalMap$ReferenceEntry2; next3 = next3.getNext()) {
                        final int n5 = next3.getHash() & n;
                        final MapMakerInternalMap$ReferenceEntry copyEntry = this.copyEntry(next3, entryArray.get(n5));
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
            this.preWriteCleanup();
            final AtomicReferenceArray table = this.table;
            final int n2 = n & table.length() - 1;
            MapMakerInternalMap$ReferenceEntry next;
            final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = next = table.get(n2);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final MapMakerInternalMap$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    if (value == null) {
                        if (this.isCollected(valueReference)) {
                            final int n3 = this.count - 1;
                            ++this.modCount;
                            this.enqueueNotification(key, n, value, MapMaker$RemovalCause.COLLECTED);
                            final MapMakerInternalMap$ReferenceEntry removeFromChain = this.removeFromChain(mapMakerInternalMap$ReferenceEntry, next);
                            final int count = this.count - 1;
                            table.set(n2, removeFromChain);
                            this.count = count;
                        }
                        return false;
                    }
                    if (this.map.valueEquivalence.equivalent(o2, value)) {
                        ++this.modCount;
                        this.enqueueNotification(o, n, value, MapMaker$RemovalCause.REPLACED);
                        this.setValue(next, o3);
                        return true;
                    }
                    this.recordLockedRead(next);
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
    
    Object replace(final Object o, final int n, final Object o2) {
        this.lock();
        try {
            this.preWriteCleanup();
            final AtomicReferenceArray table = this.table;
            final int n2 = n & table.length() - 1;
            MapMakerInternalMap$ReferenceEntry next;
            final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = next = table.get(n2);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final MapMakerInternalMap$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    if (value == null) {
                        if (this.isCollected(valueReference)) {
                            final int n3 = this.count - 1;
                            ++this.modCount;
                            this.enqueueNotification(key, n, value, MapMaker$RemovalCause.COLLECTED);
                            final MapMakerInternalMap$ReferenceEntry removeFromChain = this.removeFromChain(mapMakerInternalMap$ReferenceEntry, next);
                            final int count = this.count - 1;
                            table.set(n2, removeFromChain);
                            this.count = count;
                        }
                        return null;
                    }
                    ++this.modCount;
                    this.enqueueNotification(o, n, value, MapMaker$RemovalCause.REPLACED);
                    this.setValue(next, o2);
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
    
    Object remove(final Object o, final int n) {
        this.lock();
        try {
            this.preWriteCleanup();
            final int n2 = this.count - 1;
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            MapMakerInternalMap$ReferenceEntry next;
            for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = next = table.get(n3); next != null; next = next.getNext()) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final MapMakerInternalMap$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    MapMaker$RemovalCause mapMaker$RemovalCause;
                    if (value != null) {
                        mapMaker$RemovalCause = MapMaker$RemovalCause.EXPLICIT;
                    }
                    else {
                        if (!this.isCollected(valueReference)) {
                            return null;
                        }
                        mapMaker$RemovalCause = MapMaker$RemovalCause.COLLECTED;
                    }
                    ++this.modCount;
                    this.enqueueNotification(key, n, value, mapMaker$RemovalCause);
                    final MapMakerInternalMap$ReferenceEntry removeFromChain = this.removeFromChain(mapMakerInternalMap$ReferenceEntry, next);
                    final int count = this.count - 1;
                    table.set(n3, removeFromChain);
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
    
    boolean remove(final Object o, final int n, final Object o2) {
        this.lock();
        try {
            this.preWriteCleanup();
            final int n2 = this.count - 1;
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            MapMakerInternalMap$ReferenceEntry next;
            for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = next = table.get(n3); next != null; next = next.getNext()) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    final MapMakerInternalMap$ValueReference valueReference = next.getValueReference();
                    final Object value = valueReference.get();
                    MapMaker$RemovalCause mapMaker$RemovalCause;
                    if (this.map.valueEquivalence.equivalent(o2, value)) {
                        mapMaker$RemovalCause = MapMaker$RemovalCause.EXPLICIT;
                    }
                    else {
                        if (!this.isCollected(valueReference)) {
                            return false;
                        }
                        mapMaker$RemovalCause = MapMaker$RemovalCause.COLLECTED;
                    }
                    ++this.modCount;
                    this.enqueueNotification(key, n, value, mapMaker$RemovalCause);
                    final MapMakerInternalMap$ReferenceEntry removeFromChain = this.removeFromChain(mapMakerInternalMap$ReferenceEntry, next);
                    final int count = this.count - 1;
                    table.set(n3, removeFromChain);
                    this.count = count;
                    return mapMaker$RemovalCause == MapMaker$RemovalCause.EXPLICIT;
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
                if (this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
                    for (int i = 0; i < table.length(); ++i) {
                        for (MapMakerInternalMap$ReferenceEntry next = table.get(i); next != null; next = next.getNext()) {
                            if (!next.getValueReference().isComputingReference()) {
                                this.enqueueNotification(next, MapMaker$RemovalCause.EXPLICIT);
                            }
                        }
                    }
                }
                for (int j = 0; j < table.length(); ++j) {
                    table.set(j, null);
                }
                this.clearReferenceQueues();
                this.evictionQueue.clear();
                this.expirationQueue.clear();
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
    
    @GuardedBy("this")
    MapMakerInternalMap$ReferenceEntry removeFromChain(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        this.evictionQueue.remove(mapMakerInternalMap$ReferenceEntry2);
        this.expirationQueue.remove(mapMakerInternalMap$ReferenceEntry2);
        int count = this.count;
        MapMakerInternalMap$ReferenceEntry next = mapMakerInternalMap$ReferenceEntry2.getNext();
        for (MapMakerInternalMap$ReferenceEntry next2 = mapMakerInternalMap$ReferenceEntry; next2 != mapMakerInternalMap$ReferenceEntry2; next2 = next2.getNext()) {
            final MapMakerInternalMap$ReferenceEntry copyEntry = this.copyEntry(next2, next);
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
    
    void removeCollectedEntry(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.enqueueNotification(mapMakerInternalMap$ReferenceEntry, MapMaker$RemovalCause.COLLECTED);
        this.evictionQueue.remove(mapMakerInternalMap$ReferenceEntry);
        this.expirationQueue.remove(mapMakerInternalMap$ReferenceEntry);
    }
    
    boolean reclaimKey(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final int n) {
        this.lock();
        try {
            final int n2 = this.count - 1;
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            MapMakerInternalMap$ReferenceEntry next;
            for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = next = table.get(n3); next != null; next = next.getNext()) {
                if (next == mapMakerInternalMap$ReferenceEntry) {
                    ++this.modCount;
                    this.enqueueNotification(next.getKey(), n, next.getValueReference().get(), MapMaker$RemovalCause.COLLECTED);
                    final MapMakerInternalMap$ReferenceEntry removeFromChain = this.removeFromChain(mapMakerInternalMap$ReferenceEntry2, next);
                    final int count = this.count - 1;
                    table.set(n3, removeFromChain);
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
    
    boolean reclaimValue(final Object o, final int n, final MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        this.lock();
        try {
            final int n2 = this.count - 1;
            final AtomicReferenceArray table = this.table;
            final int n3 = n & table.length() - 1;
            MapMakerInternalMap$ReferenceEntry next;
            final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = next = table.get(n3);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    if (next.getValueReference() == mapMakerInternalMap$ValueReference) {
                        ++this.modCount;
                        this.enqueueNotification(o, n, mapMakerInternalMap$ValueReference.get(), MapMaker$RemovalCause.COLLECTED);
                        final MapMakerInternalMap$ReferenceEntry removeFromChain = this.removeFromChain(mapMakerInternalMap$ReferenceEntry, next);
                        final int count = this.count - 1;
                        table.set(n3, removeFromChain);
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
    
    boolean clearValue(final Object o, final int n, final MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        this.lock();
        try {
            final AtomicReferenceArray table = this.table;
            final int n2 = n & table.length() - 1;
            MapMakerInternalMap$ReferenceEntry next;
            final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = next = table.get(n2);
            while (next != null) {
                final Object key = next.getKey();
                if (next.getHash() == n && key != null && this.map.keyEquivalence.equivalent(o, key)) {
                    if (next.getValueReference() == mapMakerInternalMap$ValueReference) {
                        table.set(n2, this.removeFromChain(mapMakerInternalMap$ReferenceEntry, next));
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
    boolean removeEntry(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final int n, final MapMaker$RemovalCause mapMaker$RemovalCause) {
        final int n2 = this.count - 1;
        final AtomicReferenceArray table = this.table;
        final int n3 = n & table.length() - 1;
        MapMakerInternalMap$ReferenceEntry next;
        for (MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = next = table.get(n3); next != null; next = next.getNext()) {
            if (next == mapMakerInternalMap$ReferenceEntry) {
                ++this.modCount;
                this.enqueueNotification(next.getKey(), n, next.getValueReference().get(), mapMaker$RemovalCause);
                final MapMakerInternalMap$ReferenceEntry removeFromChain = this.removeFromChain(mapMakerInternalMap$ReferenceEntry2, next);
                final int count = this.count - 1;
                table.set(n3, removeFromChain);
                this.count = count;
                return true;
            }
        }
        return false;
    }
    
    boolean isCollected(final MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        return !mapMakerInternalMap$ValueReference.isComputingReference() && mapMakerInternalMap$ValueReference.get() == null;
    }
    
    Object getLiveValue(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        if (mapMakerInternalMap$ReferenceEntry.getKey() == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        final Object value = mapMakerInternalMap$ReferenceEntry.getValueReference().get();
        if (value == null) {
            this.tryDrainReferenceQueues();
            return null;
        }
        if (this.map.expires() && this.map.isExpired(mapMakerInternalMap$ReferenceEntry)) {
            this.tryExpireEntries();
            return null;
        }
        return value;
    }
    
    void postReadCleanup() {
        if ((this.readCount.incrementAndGet() & 0x3F) == 0x0) {
            this.runCleanup();
        }
    }
    
    @GuardedBy("this")
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
        if (this.tryLock()) {
            try {
                this.drainReferenceQueues();
                this.expireEntries();
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
