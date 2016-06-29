/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Supplier;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilder$NullListener;
import com.google.common.cache.CacheBuilder$OneWeigher;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$InvalidCacheLoadException;
import com.google.common.cache.CacheLoader$UnsupportedLoadingOperationException;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$2;
import com.google.common.cache.LocalCache$EntryFactory;
import com.google.common.cache.LocalCache$EntrySet;
import com.google.common.cache.LocalCache$KeySet;
import com.google.common.cache.LocalCache$NullEntry;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$Values;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible(emulated=1)
class LocalCache
extends AbstractMap
implements ConcurrentMap {
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_THRESHOLD = 63;
    static final int DRAIN_MAX = 16;
    static final Logger logger = Logger.getLogger(LocalCache.class.getName());
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
    static final LocalCache$ValueReference UNSET = new LocalCache$1();
    static final Queue DISCARDING_QUEUE = new LocalCache$2();
    Set keySet;
    Collection values;
    Set entrySet;

    LocalCache(CacheBuilder cacheBuilder, @Nullable CacheLoader cacheLoader) {
        int n2;
        int n3;
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
        this.removalNotificationQueue = this.removalListener == CacheBuilder$NullListener.INSTANCE ? LocalCache.discardingQueue() : new ConcurrentLinkedQueue();
        this.ticker = cacheBuilder.getTicker(this.recordsTime());
        this.entryFactory = LocalCache$EntryFactory.getFactory(this.keyStrength, this.usesAccessEntries(), this.usesWriteEntries());
        this.globalStatsCounter = (AbstractCache$StatsCounter)cacheBuilder.getStatsCounterSupplier().get();
        this.defaultLoader = cacheLoader;
        int n4 = Math.min(cacheBuilder.getInitialCapacity(), 1073741824);
        if (this.evictsBySize() && !this.customWeigher()) {
            n4 = Math.min(n4, (int)this.maxWeight);
        }
        int n5 = 0;
        for (n3 = 1; !(n3 >= this.concurrencyLevel || this.evictsBySize() && (long)(n3 * 20) > this.maxWeight); ++n5, n3 <<= 1) {
        }
        this.segmentShift = 32 - n5;
        this.segmentMask = n3 - 1;
        this.segments = this.newSegmentArray(n3);
        int n6 = n4 / n3;
        if (n6 * n3 < n4) {
            ++n6;
        }
        for (n2 = 1; n2 < n6; n2 <<= 1) {
        }
        if (this.evictsBySize()) {
            long l2 = this.maxWeight / (long)n3 + 1;
            long l3 = this.maxWeight % (long)n3;
            int n7 = 0;
            while (n7 < this.segments.length) {
                if ((long)n7 == l3) {
                    --l2;
                }
                this.segments[n7] = this.createSegment(n2, l2, (AbstractCache$StatsCounter)cacheBuilder.getStatsCounterSupplier().get());
                ++n7;
            }
            return;
        }
        int n8 = 0;
        while (n8 < this.segments.length) {
            this.segments[n8] = this.createSegment(n2, -1, (AbstractCache$StatsCounter)cacheBuilder.getStatsCounterSupplier().get());
            ++n8;
        }
    }

    boolean evictsBySize() {
        if (this.maxWeight < 0) return false;
        return true;
    }

    boolean customWeigher() {
        if (this.weigher == CacheBuilder$OneWeigher.INSTANCE) return false;
        return true;
    }

    boolean expires() {
        if (this.expiresAfterWrite()) return true;
        if (this.expiresAfterAccess()) return true;
        return false;
    }

    boolean expiresAfterWrite() {
        if (this.expireAfterWriteNanos <= 0) return false;
        return true;
    }

    boolean expiresAfterAccess() {
        if (this.expireAfterAccessNanos <= 0) return false;
        return true;
    }

    boolean refreshes() {
        if (this.refreshNanos <= 0) return false;
        return true;
    }

    boolean usesAccessQueue() {
        if (this.expiresAfterAccess()) return true;
        if (this.evictsBySize()) return true;
        return false;
    }

    boolean usesWriteQueue() {
        return this.expiresAfterWrite();
    }

    boolean recordsWrite() {
        if (this.expiresAfterWrite()) return true;
        if (this.refreshes()) return true;
        return false;
    }

    boolean recordsAccess() {
        return this.expiresAfterAccess();
    }

    boolean recordsTime() {
        if (this.recordsWrite()) return true;
        if (this.recordsAccess()) return true;
        return false;
    }

    boolean usesWriteEntries() {
        if (this.usesWriteQueue()) return true;
        if (this.recordsWrite()) return true;
        return false;
    }

    boolean usesAccessEntries() {
        if (this.usesAccessQueue()) return true;
        if (this.recordsAccess()) return true;
        return false;
    }

    boolean usesKeyReferences() {
        if (this.keyStrength == LocalCache$Strength.STRONG) return false;
        return true;
    }

    boolean usesValueReferences() {
        if (this.valueStrength == LocalCache$Strength.STRONG) return false;
        return true;
    }

    static LocalCache$ValueReference unset() {
        return UNSET;
    }

    static LocalCache$ReferenceEntry nullEntry() {
        return LocalCache$NullEntry.INSTANCE;
    }

    static Queue discardingQueue() {
        return DISCARDING_QUEUE;
    }

    static int rehash(int n2) {
        n2 += n2 << 15 ^ -12931;
        n2 ^= n2 >>> 10;
        n2 += n2 << 3;
        n2 ^= n2 >>> 6;
        n2 += (n2 << 2) + (n2 << 14);
        return n2 ^ n2 >>> 16;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @VisibleForTesting
    LocalCache$ReferenceEntry newEntry(Object object, int n2, @Nullable LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache$Segment localCache$Segment = this.segmentFor(n2);
        localCache$Segment.lock();
        try {
            LocalCache$ReferenceEntry localCache$ReferenceEntry2 = localCache$Segment.newEntry(object, n2, localCache$ReferenceEntry);
            return localCache$ReferenceEntry2;
        }
        finally {
            localCache$Segment.unlock();
        }
    }

    @VisibleForTesting
    LocalCache$ReferenceEntry copyEntry(LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        int n2 = localCache$ReferenceEntry.getHash();
        return this.segmentFor(n2).copyEntry(localCache$ReferenceEntry, localCache$ReferenceEntry2);
    }

    @VisibleForTesting
    LocalCache$ValueReference newValueReference(LocalCache$ReferenceEntry localCache$ReferenceEntry, Object object, int n2) {
        int n3 = localCache$ReferenceEntry.getHash();
        return this.valueStrength.referenceValue(this.segmentFor(n3), localCache$ReferenceEntry, Preconditions.checkNotNull(object), n2);
    }

    int hash(@Nullable Object object) {
        int n2 = this.keyEquivalence.hash(object);
        return LocalCache.rehash(n2);
    }

    void reclaimValue(LocalCache$ValueReference localCache$ValueReference) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry = localCache$ValueReference.getEntry();
        int n2 = localCache$ReferenceEntry.getHash();
        this.segmentFor(n2).reclaimValue(localCache$ReferenceEntry.getKey(), n2, localCache$ValueReference);
    }

    void reclaimKey(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        int n2 = localCache$ReferenceEntry.getHash();
        this.segmentFor(n2).reclaimKey(localCache$ReferenceEntry, n2);
    }

    @VisibleForTesting
    boolean isLive(LocalCache$ReferenceEntry localCache$ReferenceEntry, long l2) {
        if (this.segmentFor(localCache$ReferenceEntry.getHash()).getLiveValue(localCache$ReferenceEntry, l2) == null) return false;
        return true;
    }

    LocalCache$Segment segmentFor(int n2) {
        return this.segments[n2 >>> this.segmentShift & this.segmentMask];
    }

    LocalCache$Segment createSegment(int n2, long l2, AbstractCache$StatsCounter abstractCache$StatsCounter) {
        return new LocalCache$Segment(this, n2, l2, abstractCache$StatsCounter);
    }

    @Nullable
    Object getLiveValue(LocalCache$ReferenceEntry localCache$ReferenceEntry, long l2) {
        if (localCache$ReferenceEntry.getKey() == null) {
            return null;
        }
        Object object = localCache$ReferenceEntry.getValueReference().get();
        if (object == null) {
            return null;
        }
        if (!this.isExpired(localCache$ReferenceEntry, l2)) return object;
        return null;
    }

    boolean isExpired(LocalCache$ReferenceEntry localCache$ReferenceEntry, long l2) {
        Preconditions.checkNotNull(localCache$ReferenceEntry);
        if (this.expiresAfterAccess() && l2 - localCache$ReferenceEntry.getAccessTime() >= this.expireAfterAccessNanos) {
            return true;
        }
        if (!this.expiresAfterWrite()) return false;
        if (l2 - localCache$ReferenceEntry.getWriteTime() < this.expireAfterWriteNanos) return false;
        return true;
    }

    static void connectAccessOrder(LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        localCache$ReferenceEntry.setNextInAccessQueue(localCache$ReferenceEntry2);
        localCache$ReferenceEntry2.setPreviousInAccessQueue(localCache$ReferenceEntry);
    }

    static void nullifyAccessOrder(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry2 = LocalCache.nullEntry();
        localCache$ReferenceEntry.setNextInAccessQueue(localCache$ReferenceEntry2);
        localCache$ReferenceEntry.setPreviousInAccessQueue(localCache$ReferenceEntry2);
    }

    static void connectWriteOrder(LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        localCache$ReferenceEntry.setNextInWriteQueue(localCache$ReferenceEntry2);
        localCache$ReferenceEntry2.setPreviousInWriteQueue(localCache$ReferenceEntry);
    }

    static void nullifyWriteOrder(LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        LocalCache$ReferenceEntry localCache$ReferenceEntry2 = LocalCache.nullEntry();
        localCache$ReferenceEntry.setNextInWriteQueue(localCache$ReferenceEntry2);
        localCache$ReferenceEntry.setPreviousInWriteQueue(localCache$ReferenceEntry2);
    }

    void processPendingNotifications() {
        RemovalNotification removalNotification;
        while ((removalNotification = (RemovalNotification)this.removalNotificationQueue.poll()) != null) {
            try {
                this.removalListener.onRemoval(removalNotification);
            }
            catch (Throwable var2_2) {
                logger.log(Level.WARNING, "Exception thrown by removal listener", var2_2);
                continue;
            }
        }
    }

    final LocalCache$Segment[] newSegmentArray(int n2) {
        return new LocalCache$Segment[n2];
    }

    public void cleanUp() {
        LocalCache$Segment[] arrlocalCache$Segment = this.segments;
        int n2 = arrlocalCache$Segment.length;
        int n3 = 0;
        while (n3 < n2) {
            LocalCache$Segment localCache$Segment = arrlocalCache$Segment[n3];
            localCache$Segment.cleanUp();
            ++n3;
        }
    }

    @Override
    public boolean isEmpty() {
        int n2;
        long l2 = 0;
        LocalCache$Segment[] arrlocalCache$Segment = this.segments;
        for (n2 = 0; n2 < arrlocalCache$Segment.length; l2 += (long)arrlocalCache$Segment[n2].modCount, ++n2) {
            if (arrlocalCache$Segment[n2].count == 0) continue;
            return false;
        }
        if (l2 == 0) return true;
        n2 = 0;
        do {
            if (n2 >= arrlocalCache$Segment.length) {
                if (l2 == 0) return true;
                return false;
            }
            if (arrlocalCache$Segment[n2].count != 0) {
                return false;
            }
            l2 -= (long)arrlocalCache$Segment[n2].modCount;
            ++n2;
        } while (true);
    }

    long longSize() {
        LocalCache$Segment[] arrlocalCache$Segment = this.segments;
        long l2 = 0;
        int n2 = 0;
        while (n2 < arrlocalCache$Segment.length) {
            l2 += (long)arrlocalCache$Segment[n2].count;
            ++n2;
        }
        return l2;
    }

    @Override
    public int size() {
        return Ints.saturatedCast(this.longSize());
    }

    @Nullable
    @Override
    public Object get(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n2 = this.hash(object);
        return this.segmentFor(n2).get(object, n2);
    }

    @Nullable
    public Object getIfPresent(Object object) {
        int n2 = this.hash(Preconditions.checkNotNull(object));
        Object object2 = this.segmentFor(n2).get(object, n2);
        if (object2 == null) {
            this.globalStatsCounter.recordMisses(1);
            return object2;
        }
        this.globalStatsCounter.recordHits(1);
        return object2;
    }

    Object get(Object object, CacheLoader cacheLoader) {
        int n2 = this.hash(Preconditions.checkNotNull(object));
        return this.segmentFor(n2).get(object, n2, cacheLoader);
    }

    Object getOrLoad(Object object) {
        return this.get(object, this.defaultLoader);
    }

    ImmutableMap getAllPresent(Iterable iterable) {
        int n2 = 0;
        int n3 = 0;
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        Iterator iterator = iterable.iterator();
        do {
            if (!iterator.hasNext()) {
                this.globalStatsCounter.recordHits(n2);
                this.globalStatsCounter.recordMisses(n3);
                return ImmutableMap.copyOf(linkedHashMap);
            }
            Object t2 = iterator.next();
            Object object = this.get(t2);
            if (object == null) {
                ++n3;
                continue;
            }
            Object t3 = t2;
            linkedHashMap.put(t3, object);
            ++n2;
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    ImmutableMap getAll(Iterable iterable) {
        int n2 = 0;
        int n3 = 0;
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        LinkedHashSet linkedHashSet = Sets.newLinkedHashSet();
        for (Iterator iterator : iterable) {
            Object object2 = this.get(iterator);
            if (linkedHashMap.containsKey(iterator)) continue;
            linkedHashMap.put(iterator, object2);
            if (object2 == null) {
                ++n3;
                linkedHashSet.add(iterator);
                continue;
            }
            ++n2;
        }
        try {
            Object object;
            if (!linkedHashSet.isEmpty()) {
                try {
                    object = this.loadAll(linkedHashSet, this.defaultLoader);
                    for (Object object2 : linkedHashSet) {
                        Object v2 = object.get(object2);
                        if (v2 == null) {
                            String string = String.valueOf(object2);
                            throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(37 + String.valueOf(string).length()).append("loadAll failed to return a value for ").append(string).toString());
                        }
                        linkedHashMap.put(object2, v2);
                    }
                }
                catch (CacheLoader$UnsupportedLoadingOperationException var6_7) {
                    for (Object object2 : linkedHashSet) {
                        --n3;
                        linkedHashMap.put(object2, this.get(object2, this.defaultLoader));
                    }
                }
            }
            object = ImmutableMap.copyOf(linkedHashMap);
            return object;
        }
        finally {
            this.globalStatsCounter.recordHits(n2);
            this.globalStatsCounter.recordMisses(n3);
        }
    }

    @Nullable
    Map loadAll(Set set, CacheLoader cacheLoader) {
        Object object;
        Object object2;
        Stopwatch stopwatch;
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(set);
        stopwatch = Stopwatch.createStarted();
        boolean bl2 = false;
        try {
            object = object2 = cacheLoader.loadAll(set);
            bl2 = true;
        }
        catch (CacheLoader$UnsupportedLoadingOperationException var6_6) {
            bl2 = true;
            throw var6_6;
        }
        catch (InterruptedException var6_7) {
            Thread.currentThread().interrupt();
            throw new ExecutionException(var6_7);
        }
        catch (RuntimeException var6_8) {
            throw new UncheckedExecutionException(var6_8);
        }
        catch (Exception var6_9) {
            throw new ExecutionException(var6_9);
        }
        catch (Error var6_10) {
            throw new ExecutionError(var6_10);
        }
        finally {
            if (!bl2) {
                this.globalStatsCounter.recordLoadException(stopwatch.elapsed(TimeUnit.NANOSECONDS));
            }
        }
        if (object == null) {
            this.globalStatsCounter.recordLoadException(stopwatch.elapsed(TimeUnit.NANOSECONDS));
            object2 = String.valueOf(cacheLoader);
            throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(31 + String.valueOf(object2).length()).append((String)object2).append(" returned null map from loadAll").toString());
        }
        stopwatch.stop();
        boolean bl3 = false;
        Object object3 = object.entrySet().iterator();
        do {
            if (!object3.hasNext()) {
                this.globalStatsCounter.recordLoadException(stopwatch.elapsed(TimeUnit.NANOSECONDS));
                object3 = String.valueOf(cacheLoader);
                throw new CacheLoader$InvalidCacheLoadException(new StringBuilder(42 + String.valueOf(object3).length()).append((String)object3).append(" returned null keys or values from loadAll").toString());
            }
            Map.Entry entry = object3.next();
            Object k2 = entry.getKey();
            Object v2 = entry.getValue();
            if (k2 == null || v2 == null) {
                bl3 = true;
                continue;
            }
            this.put(k2, v2);
        } while (true);
    }

    LocalCache$ReferenceEntry getEntry(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n2 = this.hash(object);
        return this.segmentFor(n2).getEntry(object, n2);
    }

    void refresh(Object object) {
        int n2 = this.hash(Preconditions.checkNotNull(object));
        this.segmentFor(n2).refresh(object, n2, this.defaultLoader, false);
    }

    @Override
    public boolean containsKey(@Nullable Object object) {
        if (object == null) {
            return false;
        }
        int n2 = this.hash(object);
        return this.segmentFor(n2).containsKey(object, n2);
    }

    /*
     * Exception decompiling
     */
    @Override
    public boolean containsValue(@Nullable Object var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[UNCONDITIONALDOLOOP]], but top level block is 2[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public Object put(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        int n2 = this.hash(object);
        return this.segmentFor(n2).put(object, n2, object2, false);
    }

    @Override
    public Object putIfAbsent(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        int n2 = this.hash(object);
        return this.segmentFor(n2).put(object, n2, object2, true);
    }

    @Override
    public void putAll(Map map) {
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            this.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Object remove(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n2 = this.hash(object);
        return this.segmentFor(n2).remove(object, n2);
    }

    @Override
    public boolean remove(@Nullable Object object, @Nullable Object object2) {
        if (object == null) return false;
        if (object2 == null) {
            return false;
        }
        int n2 = this.hash(object);
        return this.segmentFor(n2).remove(object, n2, object2);
    }

    @Override
    public boolean replace(Object object, @Nullable Object object2, Object object3) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object3);
        if (object2 == null) {
            return false;
        }
        int n2 = this.hash(object);
        return this.segmentFor(n2).replace(object, n2, object2, object3);
    }

    @Override
    public Object replace(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        int n2 = this.hash(object);
        return this.segmentFor(n2).replace(object, n2, object2);
    }

    @Override
    public void clear() {
        LocalCache$Segment[] arrlocalCache$Segment = this.segments;
        int n2 = arrlocalCache$Segment.length;
        int n3 = 0;
        while (n3 < n2) {
            LocalCache$Segment localCache$Segment = arrlocalCache$Segment[n3];
            localCache$Segment.clear();
            ++n3;
        }
    }

    void invalidateAll(Iterable iterable) {
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object t2 = iterator.next();
            this.remove(t2);
        }
    }

    @Override
    public Set keySet() {
        Set set;
        Set set2 = this.keySet;
        if (set2 != null) {
            set = set2;
            return set;
        }
        set = this.keySet = new LocalCache$KeySet(this, this);
        return set;
    }

    @Override
    public Collection values() {
        Collection collection;
        Collection collection2 = this.values;
        if (collection2 != null) {
            collection = collection2;
            return collection;
        }
        collection = this.values = new LocalCache$Values(this, this);
        return collection;
    }

    @GwtIncompatible(value="Not supported.")
    @Override
    public Set entrySet() {
        Set set;
        Set set2 = this.entrySet;
        if (set2 != null) {
            set = set2;
            return set;
        }
        set = this.entrySet = new LocalCache$EntrySet(this, this);
        return set;
    }
}

