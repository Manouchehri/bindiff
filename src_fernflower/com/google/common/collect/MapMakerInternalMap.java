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
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

class MapMakerInternalMap extends AbstractMap implements Serializable, ConcurrentMap {
   static final int MAXIMUM_CAPACITY = 1073741824;
   static final int MAX_SEGMENTS = 65536;
   static final int CONTAINS_VALUE_RETRIES = 3;
   static final int DRAIN_THRESHOLD = 63;
   static final int DRAIN_MAX = 16;
   static final long CLEANUP_EXECUTOR_DELAY_SECS = 60L;
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
   private static final long serialVersionUID = 5L;

   MapMakerInternalMap(MapMaker var1) {
      this.concurrencyLevel = Math.min(var1.getConcurrencyLevel(), 65536);
      this.keyStrength = var1.getKeyStrength();
      this.valueStrength = var1.getValueStrength();
      this.keyEquivalence = var1.getKeyEquivalence();
      this.valueEquivalence = this.valueStrength.defaultEquivalence();
      this.maximumSize = var1.maximumSize;
      this.expireAfterAccessNanos = var1.getExpireAfterAccessNanos();
      this.expireAfterWriteNanos = var1.getExpireAfterWriteNanos();
      this.entryFactory = MapMakerInternalMap$EntryFactory.getFactory(this.keyStrength, this.expires(), this.evictsBySize());
      this.ticker = var1.getTicker();
      this.removalListener = var1.getRemovalListener();
      this.removalNotificationQueue = (Queue)(this.removalListener == GenericMapMaker$NullListener.INSTANCE?discardingQueue():new ConcurrentLinkedQueue());
      int var2 = Math.min(var1.getInitialCapacity(), 1073741824);
      if(this.evictsBySize()) {
         var2 = Math.min(var2, this.maximumSize);
      }

      int var3 = 0;

      int var4;
      for(var4 = 1; var4 < this.concurrencyLevel && (!this.evictsBySize() || var4 * 2 <= this.maximumSize); var4 <<= 1) {
         ++var3;
      }

      this.segmentShift = 32 - var3;
      this.segmentMask = var4 - 1;
      this.segments = this.newSegmentArray(var4);
      int var5 = var2 / var4;
      if(var5 * var4 < var2) {
         ++var5;
      }

      int var6;
      for(var6 = 1; var6 < var5; var6 <<= 1) {
         ;
      }

      int var7;
      if(this.evictsBySize()) {
         var7 = this.maximumSize / var4 + 1;
         int var8 = this.maximumSize % var4;

         for(int var9 = 0; var9 < this.segments.length; ++var9) {
            if(var9 == var8) {
               --var7;
            }

            this.segments[var9] = this.createSegment(var6, var7);
         }
      } else {
         for(var7 = 0; var7 < this.segments.length; ++var7) {
            this.segments[var7] = this.createSegment(var6, -1);
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
      return UNSET;
   }

   static MapMakerInternalMap$ReferenceEntry nullEntry() {
      return MapMakerInternalMap$NullEntry.INSTANCE;
   }

   static Queue discardingQueue() {
      return DISCARDING_QUEUE;
   }

   static int rehash(int var0) {
      var0 += var0 << 15 ^ -12931;
      var0 ^= var0 >>> 10;
      var0 += var0 << 3;
      var0 ^= var0 >>> 6;
      var0 += (var0 << 2) + (var0 << 14);
      return var0 ^ var0 >>> 16;
   }

   @VisibleForTesting
   MapMakerInternalMap$ReferenceEntry newEntry(Object var1, int var2, @Nullable MapMakerInternalMap$ReferenceEntry var3) {
      return this.segmentFor(var2).newEntry(var1, var2, var3);
   }

   @VisibleForTesting
   MapMakerInternalMap$ReferenceEntry copyEntry(MapMakerInternalMap$ReferenceEntry var1, MapMakerInternalMap$ReferenceEntry var2) {
      int var3 = var1.getHash();
      return this.segmentFor(var3).copyEntry(var1, var2);
   }

   @VisibleForTesting
   MapMakerInternalMap$ValueReference newValueReference(MapMakerInternalMap$ReferenceEntry var1, Object var2) {
      int var3 = var1.getHash();
      return this.valueStrength.referenceValue(this.segmentFor(var3), var1, var2);
   }

   int hash(Object var1) {
      int var2 = this.keyEquivalence.hash(var1);
      return rehash(var2);
   }

   void reclaimValue(MapMakerInternalMap$ValueReference var1) {
      MapMakerInternalMap$ReferenceEntry var2 = var1.getEntry();
      int var3 = var2.getHash();
      this.segmentFor(var3).reclaimValue(var2.getKey(), var3, var1);
   }

   void reclaimKey(MapMakerInternalMap$ReferenceEntry var1) {
      int var2 = var1.getHash();
      this.segmentFor(var2).reclaimKey(var1, var2);
   }

   @VisibleForTesting
   boolean isLive(MapMakerInternalMap$ReferenceEntry var1) {
      return this.segmentFor(var1.getHash()).getLiveValue(var1) != null;
   }

   MapMakerInternalMap$Segment segmentFor(int var1) {
      return this.segments[var1 >>> this.segmentShift & this.segmentMask];
   }

   MapMakerInternalMap$Segment createSegment(int var1, int var2) {
      return new MapMakerInternalMap$Segment(this, var1, var2);
   }

   Object getLiveValue(MapMakerInternalMap$ReferenceEntry var1) {
      if(var1.getKey() == null) {
         return null;
      } else {
         Object var2 = var1.getValueReference().get();
         return var2 == null?null:(this.expires() && this.isExpired(var1)?null:var2);
      }
   }

   boolean isExpired(MapMakerInternalMap$ReferenceEntry var1) {
      return this.isExpired(var1, this.ticker.read());
   }

   boolean isExpired(MapMakerInternalMap$ReferenceEntry var1, long var2) {
      return var2 - var1.getExpirationTime() > 0L;
   }

   static void connectExpirables(MapMakerInternalMap$ReferenceEntry var0, MapMakerInternalMap$ReferenceEntry var1) {
      var0.setNextExpirable(var1);
      var1.setPreviousExpirable(var0);
   }

   static void nullifyExpirable(MapMakerInternalMap$ReferenceEntry var0) {
      MapMakerInternalMap$ReferenceEntry var1 = nullEntry();
      var0.setNextExpirable(var1);
      var0.setPreviousExpirable(var1);
   }

   void processPendingNotifications() {
      MapMaker$RemovalNotification var1;
      while((var1 = (MapMaker$RemovalNotification)this.removalNotificationQueue.poll()) != null) {
         try {
            this.removalListener.onRemoval(var1);
         } catch (Exception var3) {
            logger.log(Level.WARNING, "Exception thrown by removal listener", var3);
         }
      }

   }

   static void connectEvictables(MapMakerInternalMap$ReferenceEntry var0, MapMakerInternalMap$ReferenceEntry var1) {
      var0.setNextEvictable(var1);
      var1.setPreviousEvictable(var0);
   }

   static void nullifyEvictable(MapMakerInternalMap$ReferenceEntry var0) {
      MapMakerInternalMap$ReferenceEntry var1 = nullEntry();
      var0.setNextEvictable(var1);
      var0.setPreviousEvictable(var1);
   }

   final MapMakerInternalMap$Segment[] newSegmentArray(int var1) {
      return new MapMakerInternalMap$Segment[var1];
   }

   public boolean isEmpty() {
      long var1 = 0L;
      MapMakerInternalMap$Segment[] var3 = this.segments;

      int var4;
      for(var4 = 0; var4 < var3.length; ++var4) {
         if(var3[var4].count != 0) {
            return false;
         }

         var1 += (long)var3[var4].modCount;
      }

      if(var1 != 0L) {
         for(var4 = 0; var4 < var3.length; ++var4) {
            if(var3[var4].count != 0) {
               return false;
            }

            var1 -= (long)var3[var4].modCount;
         }

         if(var1 != 0L) {
            return false;
         }
      }

      return true;
   }

   public int size() {
      MapMakerInternalMap$Segment[] var1 = this.segments;
      long var2 = 0L;

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var2 += (long)var1[var4].count;
      }

      return Ints.saturatedCast(var2);
   }

   public Object get(@Nullable Object var1) {
      if(var1 == null) {
         return null;
      } else {
         int var2 = this.hash(var1);
         return this.segmentFor(var2).get(var1, var2);
      }
   }

   MapMakerInternalMap$ReferenceEntry getEntry(@Nullable Object var1) {
      if(var1 == null) {
         return null;
      } else {
         int var2 = this.hash(var1);
         return this.segmentFor(var2).getEntry(var1, var2);
      }
   }

   public boolean containsKey(@Nullable Object var1) {
      if(var1 == null) {
         return false;
      } else {
         int var2 = this.hash(var1);
         return this.segmentFor(var2).containsKey(var1, var2);
      }
   }

   public boolean containsValue(@Nullable Object var1) {
      if(var1 == null) {
         return false;
      } else {
         MapMakerInternalMap$Segment[] var2 = this.segments;
         long var3 = -1L;

         for(int var5 = 0; var5 < 3; ++var5) {
            long var6 = 0L;
            MapMakerInternalMap$Segment[] var8 = var2;
            int var9 = var2.length;

            for(int var10 = 0; var10 < var9; ++var10) {
               MapMakerInternalMap$Segment var11 = var8[var10];
               int var12 = var11.count;
               AtomicReferenceArray var13 = var11.table;

               for(int var14 = 0; var14 < var13.length(); ++var14) {
                  for(MapMakerInternalMap$ReferenceEntry var15 = (MapMakerInternalMap$ReferenceEntry)var13.get(var14); var15 != null; var15 = var15.getNext()) {
                     Object var16 = var11.getLiveValue(var15);
                     if(var16 != null && this.valueEquivalence.equivalent(var1, var16)) {
                        return true;
                     }
                  }
               }

               var6 += (long)var11.modCount;
            }

            if(var6 == var3) {
               break;
            }

            var3 = var6;
         }

         return false;
      }
   }

   public Object put(Object var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      int var3 = this.hash(var1);
      return this.segmentFor(var3).put(var1, var3, var2, false);
   }

   public Object putIfAbsent(Object var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      int var3 = this.hash(var1);
      return this.segmentFor(var3).put(var1, var3, var2, true);
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3.getKey(), var3.getValue());
      }

   }

   public Object remove(@Nullable Object var1) {
      if(var1 == null) {
         return null;
      } else {
         int var2 = this.hash(var1);
         return this.segmentFor(var2).remove(var1, var2);
      }
   }

   public boolean remove(@Nullable Object var1, @Nullable Object var2) {
      if(var1 != null && var2 != null) {
         int var3 = this.hash(var1);
         return this.segmentFor(var3).remove(var1, var3, var2);
      } else {
         return false;
      }
   }

   public boolean replace(Object var1, @Nullable Object var2, Object var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var3);
      if(var2 == null) {
         return false;
      } else {
         int var4 = this.hash(var1);
         return this.segmentFor(var4).replace(var1, var4, var2, var3);
      }
   }

   public Object replace(Object var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      int var3 = this.hash(var1);
      return this.segmentFor(var3).replace(var1, var3, var2);
   }

   public void clear() {
      MapMakerInternalMap$Segment[] var1 = this.segments;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         MapMakerInternalMap$Segment var4 = var1[var3];
         var4.clear();
      }

   }

   public Set keySet() {
      Set var1 = this.keySet;
      return var1 != null?var1:(this.keySet = new MapMakerInternalMap$KeySet(this));
   }

   public Collection values() {
      Collection var1 = this.values;
      return var1 != null?var1:(this.values = new MapMakerInternalMap$Values(this));
   }

   public Set entrySet() {
      Set var1 = this.entrySet;
      return var1 != null?var1:(this.entrySet = new MapMakerInternalMap$EntrySet(this));
   }

   Object writeReplace() {
      return new MapMakerInternalMap$SerializationProxy(this.keyStrength, this.valueStrength, this.keyEquivalence, this.valueEquivalence, this.expireAfterWriteNanos, this.expireAfterAccessNanos, this.maximumSize, this.concurrencyLevel, this.removalListener, this);
   }

   // $FF: synthetic method
   static Logger access$200() {
      return logger;
   }
}
