package com.google.common.cache;

import javax.annotation.*;
import java.util.logging.*;
import com.google.common.primitives.*;
import com.google.common.collect.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import com.google.common.annotations.*;

@GwtCompatible(emulated = true)
class LocalCache extends AbstractMap implements ConcurrentMap
{
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_THRESHOLD = 63;
    static final int DRAIN_MAX = 16;
    static final Logger logger;
    final int segmentMask;
    final int segmentShift;
    final LocalCache$Segment[] segments;
    final int concurrencyLevel;
    final Equivalence keyEquivalence;
    final Equivalence valueEquivalence;
    final LocalCache$Strength keyStrength;
    final LocalCache$Strength valueStrength;
    final long maxWeight;
    final Weigher weigher;
    final long expireAfterAccessNanos;
    final long expireAfterWriteNanos;
    final long refreshNanos;
    final Queue removalNotificationQueue;
    final RemovalListener removalListener;
    final Ticker ticker;
    final LocalCache$EntryFactory entryFactory;
    final AbstractCache$StatsCounter globalStatsCounter;
    @Nullable
    final CacheLoader defaultLoader;
    static final LocalCache$ValueReference UNSET;
    static final Queue DISCARDING_QUEUE;
    Set keySet;
    Collection values;
    Set entrySet;
    
    LocalCache(final CacheBuilder cacheBuilder, @Nullable final CacheLoader defaultLoader) {
        this.concurrencyLevel = Math.min(cacheBuilder.getConcurrencyLevel(), 65536);
        this.keyStrength = cacheBuilder.getKeyStrength();
        this.valueStrength = cacheBuilder.getValueStrength();
        this.keyEquivalence = cacheBuilder.getKeyEquivalence();
        this.valueEquivalence = cacheBuilder.getValueEquivalence();
        this.maxWeight = cacheBuilder.getMaximumWeight();
        this.weigher = cacheBuilder.getWeigher();
        this.expireAfterAccessNanos = cacheBuilder.getExpireAfterAccessNanos();
        this.expireAfterWriteNanos = cacheBuilder.getExpireAfterWriteNanos();
        this.refreshNanos = cacheBuilder.getRefreshNanos();
        this.removalListener = cacheBuilder.getRemovalListener();
        this.removalNotificationQueue = ((this.removalListener == CacheBuilder$NullListener.INSTANCE) ? discardingQueue() : new ConcurrentLinkedQueue());
        this.ticker = cacheBuilder.getTicker(this.recordsTime());
        this.entryFactory = LocalCache$EntryFactory.getFactory(this.keyStrength, this.usesAccessEntries(), this.usesWriteEntries());
        this.globalStatsCounter = (AbstractCache$StatsCounter)cacheBuilder.getStatsCounterSupplier().get();
        this.defaultLoader = defaultLoader;
        int n = Math.min(cacheBuilder.getInitialCapacity(), 1073741824);
        if (this.evictsBySize() && !this.customWeigher()) {
            n = Math.min(n, (int)this.maxWeight);
        }
        int n2 = 0;
        int n3;
        for (n3 = 1; n3 < this.concurrencyLevel && (!this.evictsBySize() || n3 * 20 <= this.maxWeight); n3 <<= 1) {
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
            long n5 = this.maxWeight / n3 + 1L;
            final long n6 = this.maxWeight % n3;
            for (int j = 0; j < this.segments.length; ++j) {
                if (j == n6) {
                    --n5;
                }
                this.segments[j] = this.createSegment(i, n5, (AbstractCache$StatsCounter)cacheBuilder.getStatsCounterSupplier().get());
            }
        }
        else {
            for (int k = 0; k < this.segments.length; ++k) {
                this.segments[k] = this.createSegment(i, -1L, (AbstractCache$StatsCounter)cacheBuilder.getStatsCounterSupplier().get());
            }
        }
    }
    
    boolean evictsBySize() {
        return this.maxWeight >= 0L;
    }
    
    boolean customWeigher() {
        return this.weigher != CacheBuilder$OneWeigher.INSTANCE;
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
    
    boolean refreshes() {
        return this.refreshNanos > 0L;
    }
    
    boolean usesAccessQueue() {
        return this.expiresAfterAccess() || this.evictsBySize();
    }
    
    boolean usesWriteQueue() {
        return this.expiresAfterWrite();
    }
    
    boolean recordsWrite() {
        return this.expiresAfterWrite() || this.refreshes();
    }
    
    boolean recordsAccess() {
        return this.expiresAfterAccess();
    }
    
    boolean recordsTime() {
        return this.recordsWrite() || this.recordsAccess();
    }
    
    boolean usesWriteEntries() {
        return this.usesWriteQueue() || this.recordsWrite();
    }
    
    boolean usesAccessEntries() {
        return this.usesAccessQueue() || this.recordsAccess();
    }
    
    boolean usesKeyReferences() {
        return this.keyStrength != LocalCache$Strength.STRONG;
    }
    
    boolean usesValueReferences() {
        return this.valueStrength != LocalCache$Strength.STRONG;
    }
    
    static LocalCache$ValueReference unset() {
        return LocalCache.UNSET;
    }
    
    static LocalCache$ReferenceEntry nullEntry() {
        return LocalCache$NullEntry.INSTANCE;
    }
    
    static Queue discardingQueue() {
        return LocalCache.DISCARDING_QUEUE;
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
    LocalCache$ReferenceEntry newEntry(final Object o, final int n, @Nullable final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        final LocalCache$Segment segment = this.segmentFor(n);
        segment.lock();
        try {
            return segment.newEntry(o, n, localCache$ReferenceEntry);
        }
        finally {
            segment.unlock();
        }
    }
    
    @VisibleForTesting
    LocalCache$ReferenceEntry copyEntry(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        return this.segmentFor(localCache$ReferenceEntry.getHash()).copyEntry(localCache$ReferenceEntry, localCache$ReferenceEntry2);
    }
    
    @VisibleForTesting
    LocalCache$ValueReference newValueReference(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final Object o, final int n) {
        return this.valueStrength.referenceValue(this.segmentFor(localCache$ReferenceEntry.getHash()), localCache$ReferenceEntry, Preconditions.checkNotNull(o), n);
    }
    
    int hash(@Nullable final Object o) {
        return rehash(this.keyEquivalence.hash(o));
    }
    
    void reclaimValue(final LocalCache$ValueReference localCache$ValueReference) {
        final LocalCache$ReferenceEntry entry = localCache$ValueReference.getEntry();
        final int hash = entry.getHash();
        this.segmentFor(hash).reclaimValue(entry.getKey(), hash, localCache$ValueReference);
    }
    
    void reclaimKey(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        final int hash = localCache$ReferenceEntry.getHash();
        this.segmentFor(hash).reclaimKey(localCache$ReferenceEntry, hash);
    }
    
    @VisibleForTesting
    boolean isLive(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final long n) {
        return this.segmentFor(localCache$ReferenceEntry.getHash()).getLiveValue(localCache$ReferenceEntry, n) != null;
    }
    
    LocalCache$Segment segmentFor(final int n) {
        return this.segments[n >>> this.segmentShift & this.segmentMask];
    }
    
    LocalCache$Segment createSegment(final int n, final long n2, final AbstractCache$StatsCounter abstractCache$StatsCounter) {
        return new LocalCache$Segment(this, n, n2, abstractCache$StatsCounter);
    }
    
    @Nullable
    Object getLiveValue(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final long n) {
        if (localCache$ReferenceEntry.getKey() == null) {
            return null;
        }
        final Object value = localCache$ReferenceEntry.getValueReference().get();
        if (value == null) {
            return null;
        }
        if (this.isExpired(localCache$ReferenceEntry, n)) {
            return null;
        }
        return value;
    }
    
    boolean isExpired(final LocalCache$ReferenceEntry localCache$ReferenceEntry, final long n) {
        Preconditions.checkNotNull(localCache$ReferenceEntry);
        return (this.expiresAfterAccess() && n - localCache$ReferenceEntry.getAccessTime() >= this.expireAfterAccessNanos) || (this.expiresAfterWrite() && n - localCache$ReferenceEntry.getWriteTime() >= this.expireAfterWriteNanos);
    }
    
    static void connectAccessOrder(final LocalCache$ReferenceEntry previousInAccessQueue, final LocalCache$ReferenceEntry nextInAccessQueue) {
        previousInAccessQueue.setNextInAccessQueue(nextInAccessQueue);
        nextInAccessQueue.setPreviousInAccessQueue(previousInAccessQueue);
    }
    
    static void nullifyAccessOrder(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        final LocalCache$ReferenceEntry nullEntry = nullEntry();
        localCache$ReferenceEntry.setNextInAccessQueue(nullEntry);
        localCache$ReferenceEntry.setPreviousInAccessQueue(nullEntry);
    }
    
    static void connectWriteOrder(final LocalCache$ReferenceEntry previousInWriteQueue, final LocalCache$ReferenceEntry nextInWriteQueue) {
        previousInWriteQueue.setNextInWriteQueue(nextInWriteQueue);
        nextInWriteQueue.setPreviousInWriteQueue(previousInWriteQueue);
    }
    
    static void nullifyWriteOrder(final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        final LocalCache$ReferenceEntry nullEntry = nullEntry();
        localCache$ReferenceEntry.setNextInWriteQueue(nullEntry);
        localCache$ReferenceEntry.setPreviousInWriteQueue(nullEntry);
    }
    
    void processPendingNotifications() {
        RemovalNotification removalNotification;
        while ((removalNotification = this.removalNotificationQueue.poll()) != null) {
            try {
                this.removalListener.onRemoval(removalNotification);
            }
            catch (Throwable t) {
                LocalCache.logger.log(Level.WARNING, "Exception thrown by removal listener", t);
            }
        }
    }
    
    final LocalCache$Segment[] newSegmentArray(final int n) {
        return new LocalCache$Segment[n];
    }
    
    public void cleanUp() {
        final LocalCache$Segment[] segments = this.segments;
        for (int length = segments.length, i = 0; i < length; ++i) {
            segments[i].cleanUp();
        }
    }
    
    @Override
    public boolean isEmpty() {
        long n = 0L;
        final LocalCache$Segment[] segments = this.segments;
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
    
    long longSize() {
        final LocalCache$Segment[] segments = this.segments;
        long n = 0L;
        for (int i = 0; i < segments.length; ++i) {
            n += segments[i].count;
        }
        return n;
    }
    
    @Override
    public int size() {
        return Ints.saturatedCast(this.longSize());
    }
    
    @Nullable
    @Override
    public Object get(@Nullable final Object o) {
        if (o == null) {
            return null;
        }
        final int hash = this.hash(o);
        return this.segmentFor(hash).get(o, hash);
    }
    
    @Nullable
    public Object getIfPresent(final Object o) {
        final int hash = this.hash(Preconditions.checkNotNull(o));
        final Object value = this.segmentFor(hash).get(o, hash);
        if (value == null) {
            this.globalStatsCounter.recordMisses(1);
        }
        else {
            this.globalStatsCounter.recordHits(1);
        }
        return value;
    }
    
    Object get(final Object o, final CacheLoader cacheLoader) {
        final int hash = this.hash(Preconditions.checkNotNull(o));
        return this.segmentFor(hash).get(o, hash, cacheLoader);
    }
    
    Object getOrLoad(final Object o) {
        return this.get(o, this.defaultLoader);
    }
    
    ImmutableMap getAllPresent(final Iterable iterable) {
        int n = 0;
        int n2 = 0;
        final LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        for (final Object next : iterable) {
            final Object value = this.get(next);
            if (value == null) {
                ++n2;
            }
            else {
                linkedHashMap.put(next, value);
                ++n;
            }
        }
        this.globalStatsCounter.recordHits(n);
        this.globalStatsCounter.recordMisses(n2);
        return ImmutableMap.copyOf(linkedHashMap);
    }
    
    ImmutableMap getAll(final Iterable iterable) {
        int n = 0;
        int n2 = 0;
        final LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        final LinkedHashSet linkedHashSet = Sets.newLinkedHashSet();
        for (final Object next : iterable) {
            final Object value = this.get(next);
            if (!linkedHashMap.containsKey(next)) {
                linkedHashMap.put(next, value);
                if (value == null) {
                    ++n2;
                    linkedHashSet.add(next);
                }
                else {
                    ++n;
                }
            }
        }
        try {
            if (!linkedHashSet.isEmpty()) {
                try {
                    final Map loadAll = this.loadAll(linkedHashSet, this.defaultLoader);
                    for (final Object next2 : linkedHashSet) {
                        final Object value2 = loadAll.get(next2);
                        if (value2 == null) {
                            final String value3 = String.valueOf(next2);
                            throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(37 + String.valueOf(value3).length()).append("loadAll failed to return a value for ").append(value3).toString());
                        }
                        linkedHashMap.put(next2, value2);
                    }
                }
                catch (CacheLoader$UnsupportedLoadingOperationException ex) {
                    for (final Object next3 : linkedHashSet) {
                        --n2;
                        linkedHashMap.put(next3, this.get(next3, this.defaultLoader));
                    }
                }
            }
            return ImmutableMap.copyOf(linkedHashMap);
        }
        finally {
            this.globalStatsCounter.recordHits(n);
            this.globalStatsCounter.recordMisses(n2);
        }
    }
    
    @Nullable
    Map loadAll(final Set set, final CacheLoader cacheLoader) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(set);
        final Stopwatch started = Stopwatch.createStarted();
        boolean b = false;
        Map loadAll;
        try {
            loadAll = cacheLoader.loadAll(set);
            b = true;
        }
        catch (CacheLoader$UnsupportedLoadingOperationException ex) {
            b = true;
            throw ex;
        }
        catch (InterruptedException ex2) {
            Thread.currentThread().interrupt();
            throw new ExecutionException(ex2);
        }
        catch (RuntimeException ex3) {
            throw new UncheckedExecutionException(ex3);
        }
        catch (Exception ex4) {
            throw new ExecutionException(ex4);
        }
        catch (Error error) {
            throw new ExecutionError(error);
        }
        finally {
            if (!b) {
                this.globalStatsCounter.recordLoadException(started.elapsed(TimeUnit.NANOSECONDS));
            }
        }
        if (loadAll == null) {
            this.globalStatsCounter.recordLoadException(started.elapsed(TimeUnit.NANOSECONDS));
            final String value = String.valueOf(cacheLoader);
            throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(31 + String.valueOf(value).length()).append(value).append(" returned null map from loadAll").toString());
        }
        started.stop();
        boolean b2 = false;
        for (final Map.Entry<Object, V> entry : loadAll.entrySet()) {
            final Object key = entry.getKey();
            final V value2 = entry.getValue();
            if (key == null || value2 == null) {
                b2 = true;
            }
            else {
                this.put(key, value2);
            }
        }
        if (b2) {
            this.globalStatsCounter.recordLoadException(started.elapsed(TimeUnit.NANOSECONDS));
            final String value3 = String.valueOf(cacheLoader);
            throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(42 + String.valueOf(value3).length()).append(value3).append(" returned null keys or values from loadAll").toString());
        }
        this.globalStatsCounter.recordLoadSuccess(started.elapsed(TimeUnit.NANOSECONDS));
        return loadAll;
    }
    
    LocalCache$ReferenceEntry getEntry(@Nullable final Object o) {
        if (o == null) {
            return null;
        }
        final int hash = this.hash(o);
        return this.segmentFor(hash).getEntry(o, hash);
    }
    
    void refresh(final Object o) {
        final int hash = this.hash(Preconditions.checkNotNull(o));
        this.segmentFor(hash).refresh(o, hash, this.defaultLoader, false);
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
        final long read = this.ticker.read();
        final LocalCache$Segment[] segments = this.segments;
        long n = -1L;
        for (int i = 0; i < 3; ++i) {
            long n2 = 0L;
            for (final LocalCache$Segment localCache$Segment : segments) {
                final int count = localCache$Segment.count;
                final AtomicReferenceArray table = localCache$Segment.table;
                for (int k = 0; k < table.length(); ++k) {
                    for (LocalCache$ReferenceEntry next = table.get(k); next != null; next = next.getNext()) {
                        final Object liveValue = localCache$Segment.getLiveValue(next, read);
                        if (liveValue != null && this.valueEquivalence.equivalent(o, liveValue)) {
                            return true;
                        }
                    }
                }
                n2 += localCache$Segment.modCount;
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
        final LocalCache$Segment[] segments = this.segments;
        for (int length = segments.length, i = 0; i < length; ++i) {
            segments[i].clear();
        }
    }
    
    void invalidateAll(final Iterable iterable) {
        final Iterator<Object> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.remove(iterator.next());
        }
    }
    
    @Override
    public Set keySet() {
        final Set keySet = this.keySet;
        return (keySet != null) ? keySet : (this.keySet = new LocalCache$KeySet(this, this));
    }
    
    @Override
    public Collection values() {
        final Collection values = this.values;
        return (values != null) ? values : (this.values = new LocalCache$Values(this, this));
    }
    
    @GwtIncompatible("Not supported.")
    @Override
    public Set entrySet() {
        final Set entrySet = this.entrySet;
        return (entrySet != null) ? entrySet : (this.entrySet = new LocalCache$EntrySet(this, this));
    }
    
    static {
        logger = Logger.getLogger(LocalCache.class.getName());
        UNSET = new LocalCache$1();
        DISCARDING_QUEUE = new LocalCache$2();
    }
}
