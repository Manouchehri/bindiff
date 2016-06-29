package com.google.common.collect;

import java.io.*;
import java.util.concurrent.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.logging.*;
import com.google.common.primitives.*;
import java.util.concurrent.atomic.*;
import com.google.common.base.*;
import java.util.*;

class MapMakerInternalMap extends AbstractMap implements Serializable, ConcurrentMap
{
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_THRESHOLD = 63;
    static final int DRAIN_MAX = 16;
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60L;
    private static final Logger logger;
    final transient int segmentMask;
    final transient int segmentShift;
    final transient MapMakerInternalMap$Segment[] segments;
    final int concurrencyLevel;
    final Equivalence keyEquivalence;
    final Equivalence valueEquivalence;
    final MapMakerInternalMap$Strength keyStrength;
    final MapMakerInternalMap$Strength valueStrength;
    final int maximumSize;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final Queue removalNotificationQueue;
    final MapMaker$RemovalListener removalListener;
    final transient MapMakerInternalMap$EntryFactory entryFactory;
    final Ticker ticker;
    static final MapMakerInternalMap$ValueReference UNSET;
    static final Queue DISCARDING_QUEUE;
    transient Set keySet;
    transient Collection values;
    transient Set entrySet;
    private static final long serialVersionUID = 5L;
    
    MapMakerInternalMap(final MapMaker mapMaker) {
        this.concurrencyLevel = Math.min(mapMaker.getConcurrencyLevel(), 65536);
        this.keyStrength = mapMaker.getKeyStrength();
        this.valueStrength = mapMaker.getValueStrength();
        this.keyEquivalence = mapMaker.getKeyEquivalence();
        this.valueEquivalence = this.valueStrength.defaultEquivalence();
        this.maximumSize = mapMaker.maximumSize;
        this.expireAfterAccessNanos = mapMaker.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = mapMaker.getExpireAfterWriteNanos();
        this.entryFactory = MapMakerInternalMap$EntryFactory.getFactory(this.keyStrength, this.expires(), this.evictsBySize());
        this.ticker = mapMaker.getTicker();
        this.removalListener = mapMaker.getRemovalListener();
        this.removalNotificationQueue = ((this.removalListener == GenericMapMaker$NullListener.INSTANCE) ? discardingQueue() : new ConcurrentLinkedQueue());
        int n = Math.min(mapMaker.getInitialCapacity(), 1073741824);
        if (this.evictsBySize()) {
            n = Math.min(n, this.maximumSize);
        }
        int n2 = 0;
        int n3;
        for (n3 = 1; n3 < this.concurrencyLevel && (!this.evictsBySize() || n3 * 2 <= this.maximumSize); n3 <<= 1) {
            ++n2;
        }
        this.segmentShift = 32 - n2;
        this.segmentMask = n3 - 1;
        this.segments = this.newSegmentArray(n3);
        int n4 = n / n3;
        if (n4 * n3 < n) {
            ++n4;
        }
        int i;
        for (i = 1; i < n4; i <<= 1) {}
        if (this.evictsBySize()) {
            int n5 = this.maximumSize / n3 + 1;
            final int n6 = this.maximumSize % n3;
            for (int j = 0; j < this.segments.length; ++j) {
                if (j == n6) {
                    --n5;
                }
                this.segments[j] = this.createSegment(i, n5);
            }
        }
        else {
            for (int k = 0; k < this.segments.length; ++k) {
                this.segments[k] = this.createSegment(i, -1);
            }
        }
    }
    
    boolean evictsBySize() {
        return this.maximumSize != -1;
    }
    
    boolean expires() {
        return this.expiresAfterWrite() || this.expiresAfterAccess();
    }
    
    boolean expiresAfterWrite() {
        return this.expireAfterWriteNanos > 0L;
    }
    
    boolean expiresAfterAccess() {
        return this.expireAfterAccessNanos > 0L;
    }
    
    boolean usesKeyReferences() {
        return this.keyStrength != MapMakerInternalMap$Strength.STRONG;
    }
    
    boolean usesValueReferences() {
        return this.valueStrength != MapMakerInternalMap$Strength.STRONG;
    }
    
    static MapMakerInternalMap$ValueReference unset() {
        return MapMakerInternalMap.UNSET;
    }
    
    static MapMakerInternalMap$ReferenceEntry nullEntry() {
        return MapMakerInternalMap$NullEntry.INSTANCE;
    }
    
    static Queue discardingQueue() {
        return MapMakerInternalMap.DISCARDING_QUEUE;
    }
    
    static int rehash(int n) {
        n += (n << 15 ^ 0xFFFFCD7D);
        n ^= n >>> 10;
        n += n << 3;
        n ^= n >>> 6;
        n += (n << 2) + (n << 14);
        return n ^ n >>> 16;
    }
    
    @VisibleForTesting
    MapMakerInternalMap$ReferenceEntry newEntry(final Object o, final int n, @Nullable final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this.segmentFor(n).newEntry(o, n, mapMakerInternalMap$ReferenceEntry);
    }
    
    @VisibleForTesting
    MapMakerInternalMap$ReferenceEntry copyEntry(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        return this.segmentFor(mapMakerInternalMap$ReferenceEntry.getHash()).copyEntry(mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry2);
    }
    
    @VisibleForTesting
    MapMakerInternalMap$ValueReference newValueReference(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final Object o) {
        return this.valueStrength.referenceValue(this.segmentFor(mapMakerInternalMap$ReferenceEntry.getHash()), mapMakerInternalMap$ReferenceEntry, o);
    }
    
    int hash(final Object o) {
        return rehash(this.keyEquivalence.hash(o));
    }
    
    void reclaimValue(final MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        final MapMakerInternalMap$ReferenceEntry entry = mapMakerInternalMap$ValueReference.getEntry();
        final int hash = entry.getHash();
        this.segmentFor(hash).reclaimValue(entry.getKey(), hash, mapMakerInternalMap$ValueReference);
    }
    
    void reclaimKey(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        final int hash = mapMakerInternalMap$ReferenceEntry.getHash();
        this.segmentFor(hash).reclaimKey(mapMakerInternalMap$ReferenceEntry, hash);
    }
    
    @VisibleForTesting
    boolean isLive(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this.segmentFor(mapMakerInternalMap$ReferenceEntry.getHash()).getLiveValue(mapMakerInternalMap$ReferenceEntry) != null;
    }
    
    MapMakerInternalMap$Segment segmentFor(final int n) {
        return this.segments[n >>> this.segmentShift & this.segmentMask];
    }
    
    MapMakerInternalMap$Segment createSegment(final int n, final int n2) {
        return new MapMakerInternalMap$Segment(this, n, n2);
    }
    
    Object getLiveValue(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        if (mapMakerInternalMap$ReferenceEntry.getKey() == null) {
            return null;
        }
        final Object value = mapMakerInternalMap$ReferenceEntry.getValueReference().get();
        if (value == null) {
            return null;
        }
        if (this.expires() && this.isExpired(mapMakerInternalMap$ReferenceEntry)) {
            return null;
        }
        return value;
    }
    
    boolean isExpired(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this.isExpired(mapMakerInternalMap$ReferenceEntry, this.ticker.read());
    }
    
    boolean isExpired(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, final long n) {
        return n - mapMakerInternalMap$ReferenceEntry.getExpirationTime() > 0L;
    }
    
    static void connectExpirables(final MapMakerInternalMap$ReferenceEntry previousExpirable, final MapMakerInternalMap$ReferenceEntry nextExpirable) {
        previousExpirable.setNextExpirable(nextExpirable);
        nextExpirable.setPreviousExpirable(previousExpirable);
    }
    
    static void nullifyExpirable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        final MapMakerInternalMap$ReferenceEntry nullEntry = nullEntry();
        mapMakerInternalMap$ReferenceEntry.setNextExpirable(nullEntry);
        mapMakerInternalMap$ReferenceEntry.setPreviousExpirable(nullEntry);
    }
    
    void processPendingNotifications() {
        MapMaker$RemovalNotification mapMaker$RemovalNotification;
        while ((mapMaker$RemovalNotification = this.removalNotificationQueue.poll()) != null) {
            try {
                this.removalListener.onRemoval(mapMaker$RemovalNotification);
            }
            catch (Exception ex) {
                MapMakerInternalMap.logger.log(Level.WARNING, "Exception thrown by removal listener", ex);
            }
        }
    }
    
    static void connectEvictables(final MapMakerInternalMap$ReferenceEntry previousEvictable, final MapMakerInternalMap$ReferenceEntry nextEvictable) {
        previousEvictable.setNextEvictable(nextEvictable);
        nextEvictable.setPreviousEvictable(previousEvictable);
    }
    
    static void nullifyEvictable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        final MapMakerInternalMap$ReferenceEntry nullEntry = nullEntry();
        mapMakerInternalMap$ReferenceEntry.setNextEvictable(nullEntry);
        mapMakerInternalMap$ReferenceEntry.setPreviousEvictable(nullEntry);
    }
    
    final MapMakerInternalMap$Segment[] newSegmentArray(final int n) {
        return new MapMakerInternalMap$Segment[n];
    }
    
    @Override
    public boolean isEmpty() {
        long n = 0L;
        final MapMakerInternalMap$Segment[] segments = this.segments;
        for (int i = 0; i < segments.length; ++i) {
            if (segments[i].count != 0) {
                return false;
            }
            n += segments[i].modCount;
        }
        if (n != 0L) {
            for (int j = 0; j < segments.length; ++j) {
                if (segments[j].count != 0) {
                    return false;
                }
                n -= segments[j].modCount;
            }
            if (n != 0L) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int size() {
        final MapMakerInternalMap$Segment[] segments = this.segments;
        long n = 0L;
        for (int i = 0; i < segments.length; ++i) {
            n += segments[i].count;
        }
        return Ints.saturatedCast(n);
    }
    
    @Override
    public Object get(@Nullable final Object o) {
        if (o == null) {
            return null;
        }
        final int hash = this.hash(o);
        return this.segmentFor(hash).get(o, hash);
    }
    
    MapMakerInternalMap$ReferenceEntry getEntry(@Nullable final Object o) {
        if (o == null) {
            return null;
        }
        final int hash = this.hash(o);
        return this.segmentFor(hash).getEntry(o, hash);
    }
    
    @Override
    public boolean containsKey(@Nullable final Object o) {
        if (o == null) {
            return false;
        }
        final int hash = this.hash(o);
        return this.segmentFor(hash).containsKey(o, hash);
    }
    
    @Override
    public boolean containsValue(@Nullable final Object o) {
        if (o == null) {
            return false;
        }
        final MapMakerInternalMap$Segment[] segments = this.segments;
        long n = -1L;
        for (int i = 0; i < 3; ++i) {
            long n2 = 0L;
            for (final MapMakerInternalMap$Segment mapMakerInternalMap$Segment : segments) {
                final int count = mapMakerInternalMap$Segment.count;
                final AtomicReferenceArray table = mapMakerInternalMap$Segment.table;
                for (int k = 0; k < table.length(); ++k) {
                    for (MapMakerInternalMap$ReferenceEntry next = table.get(k); next != null; next = next.getNext()) {
                        final Object liveValue = mapMakerInternalMap$Segment.getLiveValue(next);
                        if (liveValue != null && this.valueEquivalence.equivalent(o, liveValue)) {
                            return true;
                        }
                    }
                }
                n2 += mapMakerInternalMap$Segment.modCount;
            }
            if (n2 == n) {
                break;
            }
            n = n2;
        }
        return false;
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        final int hash = this.hash(o);
        return this.segmentFor(hash).put(o, hash, o2, false);
    }
    
    @Override
    public Object putIfAbsent(final Object o, final Object o2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        final int hash = this.hash(o);
        return this.segmentFor(hash).put(o, hash, o2, true);
    }
    
    @Override
    public void putAll(final Map map) {
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
    
    @Override
    public Object remove(@Nullable final Object o) {
        if (o == null) {
            return null;
        }
        final int hash = this.hash(o);
        return this.segmentFor(hash).remove(o, hash);
    }
    
    @Override
    public boolean remove(@Nullable final Object o, @Nullable final Object o2) {
        if (o == null || o2 == null) {
            return false;
        }
        final int hash = this.hash(o);
        return this.segmentFor(hash).remove(o, hash, o2);
    }
    
    @Override
    public boolean replace(final Object o, @Nullable final Object o2, final Object o3) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o3);
        if (o2 == null) {
            return false;
        }
        final int hash = this.hash(o);
        return this.segmentFor(hash).replace(o, hash, o2, o3);
    }
    
    @Override
    public Object replace(final Object o, final Object o2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        final int hash = this.hash(o);
        return this.segmentFor(hash).replace(o, hash, o2);
    }
    
    @Override
    public void clear() {
        final MapMakerInternalMap$Segment[] segments = this.segments;
        for (int length = segments.length, i = 0; i < length; ++i) {
            segments[i].clear();
        }
    }
    
    @Override
    public Set keySet() {
        final Set keySet = this.keySet;
        return (keySet != null) ? keySet : (this.keySet = new MapMakerInternalMap$KeySet(this));
    }
    
    @Override
    public Collection values() {
        final Collection values = this.values;
        return (values != null) ? values : (this.values = new MapMakerInternalMap$Values(this));
    }
    
    @Override
    public Set entrySet() {
        final Set entrySet = this.entrySet;
        return (entrySet != null) ? entrySet : (this.entrySet = new MapMakerInternalMap$EntrySet(this));
    }
    
    Object writeReplace() {
        return new MapMakerInternalMap$SerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
    }
    
    static {
        logger = Logger.getLogger(MapMakerInternalMap.class.getName());
        UNSET = new MapMakerInternalMap$1();
        DISCARDING_QUEUE = new MapMakerInternalMap$2();
    }
}
