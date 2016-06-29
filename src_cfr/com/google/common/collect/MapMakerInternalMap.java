/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Ticker;
import com.google.common.collect.GenericMapMaker$NullListener;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMaker$RemovalNotification;
import com.google.common.collect.MapMakerInternalMap$1;
import com.google.common.collect.MapMakerInternalMap$2;
import com.google.common.collect.MapMakerInternalMap$EntryFactory;
import com.google.common.collect.MapMakerInternalMap$EntrySet;
import com.google.common.collect.MapMakerInternalMap$KeySet;
import com.google.common.collect.MapMakerInternalMap$NullEntry;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$SerializationProxy;
import com.google.common.collect.MapMakerInternalMap$Strength;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import com.google.common.collect.MapMakerInternalMap$Values;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

class MapMakerInternalMap
extends AbstractMap
implements Serializable,
ConcurrentMap {
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final int CONTAINS_VALUE_RETRIES = 3;
    static final int DRAIN_THRESHOLD = 63;
    static final int DRAIN_MAX = 16;
    static final long CLEANUP_EXECUTOR_DELAY_SECS = 60;
    private static final Logger logger = Logger.getLogger(MapMakerInternalMap.class.getName());
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
    static final MapMakerInternalMap$ValueReference UNSET = new MapMakerInternalMap$1();
    static final Queue DISCARDING_QUEUE = new MapMakerInternalMap$2();
    transient Set keySet;
    transient Collection values;
    transient Set entrySet;
    private static final long serialVersionUID = 5;

    MapMakerInternalMap(MapMaker mapMaker) {
        int n2;
        int n3;
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
        this.removalNotificationQueue = this.removalListener == GenericMapMaker$NullListener.INSTANCE ? MapMakerInternalMap.discardingQueue() : new ConcurrentLinkedQueue();
        int n4 = Math.min(mapMaker.getInitialCapacity(), 1073741824);
        if (this.evictsBySize()) {
            n4 = Math.min(n4, this.maximumSize);
        }
        int n5 = 0;
        for (n3 = 1; !(n3 >= this.concurrencyLevel || this.evictsBySize() && n3 * 2 > this.maximumSize); ++n5, n3 <<= 1) {
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
            int n7 = this.maximumSize / n3 + 1;
            int n8 = this.maximumSize % n3;
            int n9 = 0;
            while (n9 < this.segments.length) {
                if (n9 == n8) {
                    --n7;
                }
                this.segments[n9] = this.createSegment(n2, n7);
                ++n9;
            }
            return;
        }
        int n10 = 0;
        while (n10 < this.segments.length) {
            this.segments[n10] = this.createSegment(n2, -1);
            ++n10;
        }
    }

    boolean evictsBySize() {
        if (this.maximumSize == -1) return false;
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

    boolean usesKeyReferences() {
        if (this.keyStrength == MapMakerInternalMap$Strength.STRONG) return false;
        return true;
    }

    boolean usesValueReferences() {
        if (this.valueStrength == MapMakerInternalMap$Strength.STRONG) return false;
        return true;
    }

    static MapMakerInternalMap$ValueReference unset() {
        return UNSET;
    }

    static MapMakerInternalMap$ReferenceEntry nullEntry() {
        return MapMakerInternalMap$NullEntry.INSTANCE;
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

    @VisibleForTesting
    MapMakerInternalMap$ReferenceEntry newEntry(Object object, int n2, @Nullable MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this.segmentFor(n2).newEntry(object, n2, mapMakerInternalMap$ReferenceEntry);
    }

    @VisibleForTesting
    MapMakerInternalMap$ReferenceEntry copyEntry(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        int n2 = mapMakerInternalMap$ReferenceEntry.getHash();
        return this.segmentFor(n2).copyEntry(mapMakerInternalMap$ReferenceEntry, mapMakerInternalMap$ReferenceEntry2);
    }

    @VisibleForTesting
    MapMakerInternalMap$ValueReference newValueReference(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, Object object) {
        int n2 = mapMakerInternalMap$ReferenceEntry.getHash();
        return this.valueStrength.referenceValue(this.segmentFor(n2), mapMakerInternalMap$ReferenceEntry, object);
    }

    int hash(Object object) {
        int n2 = this.keyEquivalence.hash(object);
        return MapMakerInternalMap.rehash(n2);
    }

    void reclaimValue(MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry = mapMakerInternalMap$ValueReference.getEntry();
        int n2 = mapMakerInternalMap$ReferenceEntry.getHash();
        this.segmentFor(n2).reclaimValue(mapMakerInternalMap$ReferenceEntry.getKey(), n2, mapMakerInternalMap$ValueReference);
    }

    void reclaimKey(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        int n2 = mapMakerInternalMap$ReferenceEntry.getHash();
        this.segmentFor(n2).reclaimKey(mapMakerInternalMap$ReferenceEntry, n2);
    }

    @VisibleForTesting
    boolean isLive(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        if (this.segmentFor(mapMakerInternalMap$ReferenceEntry.getHash()).getLiveValue(mapMakerInternalMap$ReferenceEntry) == null) return false;
        return true;
    }

    MapMakerInternalMap$Segment segmentFor(int n2) {
        return this.segments[n2 >>> this.segmentShift & this.segmentMask];
    }

    MapMakerInternalMap$Segment createSegment(int n2, int n3) {
        return new MapMakerInternalMap$Segment(this, n2, n3);
    }

    Object getLiveValue(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        if (mapMakerInternalMap$ReferenceEntry.getKey() == null) {
            return null;
        }
        Object object = mapMakerInternalMap$ReferenceEntry.getValueReference().get();
        if (object == null) {
            return null;
        }
        if (!this.expires()) return object;
        if (!this.isExpired(mapMakerInternalMap$ReferenceEntry)) return object;
        return null;
    }

    boolean isExpired(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        return this.isExpired(mapMakerInternalMap$ReferenceEntry, this.ticker.read());
    }

    boolean isExpired(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, long l2) {
        if (l2 - mapMakerInternalMap$ReferenceEntry.getExpirationTime() <= 0) return false;
        return true;
    }

    static void connectExpirables(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        mapMakerInternalMap$ReferenceEntry.setNextExpirable(mapMakerInternalMap$ReferenceEntry2);
        mapMakerInternalMap$ReferenceEntry2.setPreviousExpirable(mapMakerInternalMap$ReferenceEntry);
    }

    static void nullifyExpirable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = MapMakerInternalMap.nullEntry();
        mapMakerInternalMap$ReferenceEntry.setNextExpirable(mapMakerInternalMap$ReferenceEntry2);
        mapMakerInternalMap$ReferenceEntry.setPreviousExpirable(mapMakerInternalMap$ReferenceEntry2);
    }

    void processPendingNotifications() {
        MapMaker$RemovalNotification mapMaker$RemovalNotification;
        while ((mapMaker$RemovalNotification = (MapMaker$RemovalNotification)this.removalNotificationQueue.poll()) != null) {
            try {
                this.removalListener.onRemoval(mapMaker$RemovalNotification);
            }
            catch (Exception var2_2) {
                logger.log(Level.WARNING, "Exception thrown by removal listener", var2_2);
                continue;
            }
        }
    }

    static void connectEvictables(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        mapMakerInternalMap$ReferenceEntry.setNextEvictable(mapMakerInternalMap$ReferenceEntry2);
        mapMakerInternalMap$ReferenceEntry2.setPreviousEvictable(mapMakerInternalMap$ReferenceEntry);
    }

    static void nullifyEvictable(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2 = MapMakerInternalMap.nullEntry();
        mapMakerInternalMap$ReferenceEntry.setNextEvictable(mapMakerInternalMap$ReferenceEntry2);
        mapMakerInternalMap$ReferenceEntry.setPreviousEvictable(mapMakerInternalMap$ReferenceEntry2);
    }

    final MapMakerInternalMap$Segment[] newSegmentArray(int n2) {
        return new MapMakerInternalMap$Segment[n2];
    }

    @Override
    public boolean isEmpty() {
        int n2;
        long l2 = 0;
        MapMakerInternalMap$Segment[] arrmapMakerInternalMap$Segment = this.segments;
        for (n2 = 0; n2 < arrmapMakerInternalMap$Segment.length; l2 += (long)arrmapMakerInternalMap$Segment[n2].modCount, ++n2) {
            if (arrmapMakerInternalMap$Segment[n2].count == 0) continue;
            return false;
        }
        if (l2 == 0) return true;
        n2 = 0;
        do {
            if (n2 >= arrmapMakerInternalMap$Segment.length) {
                if (l2 == 0) return true;
                return false;
            }
            if (arrmapMakerInternalMap$Segment[n2].count != 0) {
                return false;
            }
            l2 -= (long)arrmapMakerInternalMap$Segment[n2].modCount;
            ++n2;
        } while (true);
    }

    @Override
    public int size() {
        MapMakerInternalMap$Segment[] arrmapMakerInternalMap$Segment = this.segments;
        long l2 = 0;
        int n2 = 0;
        while (n2 < arrmapMakerInternalMap$Segment.length) {
            l2 += (long)arrmapMakerInternalMap$Segment[n2].count;
            ++n2;
        }
        return Ints.saturatedCast(l2);
    }

    @Override
    public Object get(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n2 = this.hash(object);
        return this.segmentFor(n2).get(object, n2);
    }

    MapMakerInternalMap$ReferenceEntry getEntry(@Nullable Object object) {
        if (object == null) {
            return null;
        }
        int n2 = this.hash(object);
        return this.segmentFor(n2).getEntry(object, n2);
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
        MapMakerInternalMap$Segment[] arrmapMakerInternalMap$Segment = this.segments;
        int n2 = arrmapMakerInternalMap$Segment.length;
        int n3 = 0;
        while (n3 < n2) {
            MapMakerInternalMap$Segment mapMakerInternalMap$Segment = arrmapMakerInternalMap$Segment[n3];
            mapMakerInternalMap$Segment.clear();
            ++n3;
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
        set = this.keySet = new MapMakerInternalMap$KeySet(this);
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
        collection = this.values = new MapMakerInternalMap$Values(this);
        return collection;
    }

    @Override
    public Set entrySet() {
        Set set;
        Set set2 = this.entrySet;
        if (set2 != null) {
            set = set2;
            return set;
        }
        set = this.entrySet = new MapMakerInternalMap$EntrySet(this);
        return set;
    }

    Object writeReplace() {
        return new MapMakerInternalMap$SerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
    }

    static /* synthetic */ Logger access$200() {
        return logger;
    }
}

