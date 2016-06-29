package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
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
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
class LocalCache extends AbstractMap implements ConcurrentMap {
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

   LocalCache(CacheBuilder var1, @Nullable CacheLoader var2) {
      this.concurrencyLevel = Math.min(var1.getConcurrencyLevel(), 65536);
      this.keyStrength = var1.getKeyStrength();
      this.valueStrength = var1.getValueStrength();
      this.keyEquivalence = var1.getKeyEquivalence();
      this.valueEquivalence = var1.getValueEquivalence();
      this.maxWeight = var1.getMaximumWeight();
      this.weigher = var1.getWeigher();
      this.expireAfterAccessNanos = var1.getExpireAfterAccessNanos();
      this.expireAfterWriteNanos = var1.getExpireAfterWriteNanos();
      this.refreshNanos = var1.getRefreshNanos();
      this.removalListener = var1.getRemovalListener();
      this.removalNotificationQueue = (Queue)(this.removalListener == CacheBuilder$NullListener.INSTANCE?discardingQueue():new ConcurrentLinkedQueue());
      this.ticker = var1.getTicker(this.recordsTime());
      this.entryFactory = LocalCache$EntryFactory.getFactory(this.keyStrength, this.usesAccessEntries(), this.usesWriteEntries());
      this.globalStatsCounter = (AbstractCache$StatsCounter)var1.getStatsCounterSupplier().get();
      this.defaultLoader = var2;
      int var3 = Math.min(var1.getInitialCapacity(), 1073741824);
      if(this.evictsBySize() && !this.customWeigher()) {
         var3 = Math.min(var3, (int)this.maxWeight);
      }

      int var4 = 0;

      int var5;
      for(var5 = 1; var5 < this.concurrencyLevel && (!this.evictsBySize() || (long)(var5 * 20) <= this.maxWeight); var5 <<= 1) {
         ++var4;
      }

      this.segmentShift = 32 - var4;
      this.segmentMask = var5 - 1;
      this.segments = this.newSegmentArray(var5);
      int var6 = var3 / var5;
      if(var6 * var5 < var3) {
         ++var6;
      }

      int var7;
      for(var7 = 1; var7 < var6; var7 <<= 1) {
         ;
      }

      if(this.evictsBySize()) {
         long var8 = this.maxWeight / (long)var5 + 1L;
         long var10 = this.maxWeight % (long)var5;

         for(int var12 = 0; var12 < this.segments.length; ++var12) {
            if((long)var12 == var10) {
               --var8;
            }

            this.segments[var12] = this.createSegment(var7, var8, (AbstractCache$StatsCounter)var1.getStatsCounterSupplier().get());
         }
      } else {
         for(int var13 = 0; var13 < this.segments.length; ++var13) {
            this.segments[var13] = this.createSegment(var7, -1L, (AbstractCache$StatsCounter)var1.getStatsCounterSupplier().get());
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
      return UNSET;
   }

   static LocalCache$ReferenceEntry nullEntry() {
      return LocalCache$NullEntry.INSTANCE;
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
   LocalCache$ReferenceEntry newEntry(Object var1, int var2, @Nullable LocalCache$ReferenceEntry var3) {
      LocalCache$Segment var4 = this.segmentFor(var2);
      var4.lock();

      LocalCache$ReferenceEntry var5;
      try {
         var5 = var4.newEntry(var1, var2, var3);
      } finally {
         var4.unlock();
      }

      return var5;
   }

   @VisibleForTesting
   LocalCache$ReferenceEntry copyEntry(LocalCache$ReferenceEntry var1, LocalCache$ReferenceEntry var2) {
      int var3 = var1.getHash();
      return this.segmentFor(var3).copyEntry(var1, var2);
   }

   @VisibleForTesting
   LocalCache$ValueReference newValueReference(LocalCache$ReferenceEntry var1, Object var2, int var3) {
      int var4 = var1.getHash();
      return this.valueStrength.referenceValue(this.segmentFor(var4), var1, Preconditions.checkNotNull(var2), var3);
   }

   int hash(@Nullable Object var1) {
      int var2 = this.keyEquivalence.hash(var1);
      return rehash(var2);
   }

   void reclaimValue(LocalCache$ValueReference var1) {
      LocalCache$ReferenceEntry var2 = var1.getEntry();
      int var3 = var2.getHash();
      this.segmentFor(var3).reclaimValue(var2.getKey(), var3, var1);
   }

   void reclaimKey(LocalCache$ReferenceEntry var1) {
      int var2 = var1.getHash();
      this.segmentFor(var2).reclaimKey(var1, var2);
   }

   @VisibleForTesting
   boolean isLive(LocalCache$ReferenceEntry var1, long var2) {
      return this.segmentFor(var1.getHash()).getLiveValue(var1, var2) != null;
   }

   LocalCache$Segment segmentFor(int var1) {
      return this.segments[var1 >>> this.segmentShift & this.segmentMask];
   }

   LocalCache$Segment createSegment(int var1, long var2, AbstractCache$StatsCounter var4) {
      return new LocalCache$Segment(this, var1, var2, var4);
   }

   @Nullable
   Object getLiveValue(LocalCache$ReferenceEntry var1, long var2) {
      if(var1.getKey() == null) {
         return null;
      } else {
         Object var4 = var1.getValueReference().get();
         return var4 == null?null:(this.isExpired(var1, var2)?null:var4);
      }
   }

   boolean isExpired(LocalCache$ReferenceEntry var1, long var2) {
      Preconditions.checkNotNull(var1);
      return this.expiresAfterAccess() && var2 - var1.getAccessTime() >= this.expireAfterAccessNanos?true:this.expiresAfterWrite() && var2 - var1.getWriteTime() >= this.expireAfterWriteNanos;
   }

   static void connectAccessOrder(LocalCache$ReferenceEntry var0, LocalCache$ReferenceEntry var1) {
      var0.setNextInAccessQueue(var1);
      var1.setPreviousInAccessQueue(var0);
   }

   static void nullifyAccessOrder(LocalCache$ReferenceEntry var0) {
      LocalCache$ReferenceEntry var1 = nullEntry();
      var0.setNextInAccessQueue(var1);
      var0.setPreviousInAccessQueue(var1);
   }

   static void connectWriteOrder(LocalCache$ReferenceEntry var0, LocalCache$ReferenceEntry var1) {
      var0.setNextInWriteQueue(var1);
      var1.setPreviousInWriteQueue(var0);
   }

   static void nullifyWriteOrder(LocalCache$ReferenceEntry var0) {
      LocalCache$ReferenceEntry var1 = nullEntry();
      var0.setNextInWriteQueue(var1);
      var0.setPreviousInWriteQueue(var1);
   }

   void processPendingNotifications() {
      RemovalNotification var1;
      while((var1 = (RemovalNotification)this.removalNotificationQueue.poll()) != null) {
         try {
            this.removalListener.onRemoval(var1);
         } catch (Throwable var3) {
            logger.log(Level.WARNING, "Exception thrown by removal listener", var3);
         }
      }

   }

   final LocalCache$Segment[] newSegmentArray(int var1) {
      return new LocalCache$Segment[var1];
   }

   public void cleanUp() {
      LocalCache$Segment[] var1 = this.segments;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         LocalCache$Segment var4 = var1[var3];
         var4.cleanUp();
      }

   }

   public boolean isEmpty() {
      long var1 = 0L;
      LocalCache$Segment[] var3 = this.segments;

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

   long longSize() {
      LocalCache$Segment[] var1 = this.segments;
      long var2 = 0L;

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var2 += (long)var1[var4].count;
      }

      return var2;
   }

   public int size() {
      return Ints.saturatedCast(this.longSize());
   }

   @Nullable
   public Object get(@Nullable Object var1) {
      if(var1 == null) {
         return null;
      } else {
         int var2 = this.hash(var1);
         return this.segmentFor(var2).get(var1, var2);
      }
   }

   @Nullable
   public Object getIfPresent(Object var1) {
      int var2 = this.hash(Preconditions.checkNotNull(var1));
      Object var3 = this.segmentFor(var2).get(var1, var2);
      if(var3 == null) {
         this.globalStatsCounter.recordMisses(1);
      } else {
         this.globalStatsCounter.recordHits(1);
      }

      return var3;
   }

   Object get(Object var1, CacheLoader var2) {
      int var3 = this.hash(Preconditions.checkNotNull(var1));
      return this.segmentFor(var3).get(var1, var3, var2);
   }

   Object getOrLoad(Object var1) {
      return this.get(var1, this.defaultLoader);
   }

   ImmutableMap getAllPresent(Iterable var1) {
      int var2 = 0;
      int var3 = 0;
      LinkedHashMap var4 = Maps.newLinkedHashMap();
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         Object var6 = var5.next();
         Object var7 = this.get(var6);
         if(var7 == null) {
            ++var3;
         } else {
            var4.put(var6, var7);
            ++var2;
         }
      }

      this.globalStatsCounter.recordHits(var2);
      this.globalStatsCounter.recordMisses(var3);
      return ImmutableMap.copyOf((Map)var4);
   }

   ImmutableMap getAll(Iterable var1) {
      int var2 = 0;
      int var3 = 0;
      LinkedHashMap var4 = Maps.newLinkedHashMap();
      LinkedHashSet var5 = Sets.newLinkedHashSet();
      Iterator var6 = var1.iterator();

      Object var8;
      while(var6.hasNext()) {
         Object var7 = var6.next();
         var8 = this.get(var7);
         if(!var4.containsKey(var7)) {
            var4.put(var7, var8);
            if(var8 == null) {
               ++var3;
               var5.add(var7);
            } else {
               ++var2;
            }
         }
      }

      ImmutableMap var17;
      try {
         if(!var5.isEmpty()) {
            Iterator var18;
            try {
               Map var16 = this.loadAll(var5, this.defaultLoader);
               var18 = var5.iterator();

               while(var18.hasNext()) {
                  var8 = var18.next();
                  Object var9 = var16.get(var8);
                  if(var9 == null) {
                     String var10 = String.valueOf(var8);
                     throw new CacheLoader$InvalidCacheLoadException((new StringBuilder(37 + String.valueOf(var10).length())).append("loadAll failed to return a value for ").append(var10).toString());
                  }

                  var4.put(var8, var9);
               }
            } catch (CacheLoader$UnsupportedLoadingOperationException var14) {
               var18 = var5.iterator();

               while(var18.hasNext()) {
                  var8 = var18.next();
                  --var3;
                  var4.put(var8, this.get(var8, this.defaultLoader));
               }
            }
         }

         var17 = ImmutableMap.copyOf((Map)var4);
      } finally {
         this.globalStatsCounter.recordHits(var2);
         this.globalStatsCounter.recordMisses(var3);
      }

      return var17;
   }

   @Nullable
   Map loadAll(Set var1, CacheLoader var2) {
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var1);
      Stopwatch var3 = Stopwatch.createStarted();
      boolean var5 = false;

      Map var4;
      try {
         Map var6 = var2.loadAll(var1);
         var4 = var6;
         var5 = true;
      } catch (CacheLoader$UnsupportedLoadingOperationException var17) {
         var5 = true;
         throw var17;
      } catch (InterruptedException var18) {
         Thread.currentThread().interrupt();
         throw new ExecutionException(var18);
      } catch (RuntimeException var19) {
         throw new UncheckedExecutionException(var19);
      } catch (Exception var20) {
         throw new ExecutionException(var20);
      } catch (Error var21) {
         throw new ExecutionError(var21);
      } finally {
         if(!var5) {
            this.globalStatsCounter.recordLoadException(var3.elapsed(TimeUnit.NANOSECONDS));
         }

      }

      if(var4 == null) {
         this.globalStatsCounter.recordLoadException(var3.elapsed(TimeUnit.NANOSECONDS));
         String var24 = String.valueOf(var2);
         throw new CacheLoader$InvalidCacheLoadException((new StringBuilder(31 + String.valueOf(var24).length())).append(var24).append(" returned null map from loadAll").toString());
      } else {
         var3.stop();
         boolean var23 = false;
         Iterator var7 = var4.entrySet().iterator();

         while(true) {
            while(var7.hasNext()) {
               Entry var8 = (Entry)var7.next();
               Object var9 = var8.getKey();
               Object var10 = var8.getValue();
               if(var9 != null && var10 != null) {
                  this.put(var9, var10);
               } else {
                  var23 = true;
               }
            }

            if(var23) {
               this.globalStatsCounter.recordLoadException(var3.elapsed(TimeUnit.NANOSECONDS));
               String var25 = String.valueOf(var2);
               throw new CacheLoader$InvalidCacheLoadException((new StringBuilder(42 + String.valueOf(var25).length())).append(var25).append(" returned null keys or values from loadAll").toString());
            }

            this.globalStatsCounter.recordLoadSuccess(var3.elapsed(TimeUnit.NANOSECONDS));
            return var4;
         }
      }
   }

   LocalCache$ReferenceEntry getEntry(@Nullable Object var1) {
      if(var1 == null) {
         return null;
      } else {
         int var2 = this.hash(var1);
         return this.segmentFor(var2).getEntry(var1, var2);
      }
   }

   void refresh(Object var1) {
      int var2 = this.hash(Preconditions.checkNotNull(var1));
      this.segmentFor(var2).refresh(var1, var2, this.defaultLoader, false);
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
         long var2 = this.ticker.read();
         LocalCache$Segment[] var4 = this.segments;
         long var5 = -1L;

         for(int var7 = 0; var7 < 3; ++var7) {
            long var8 = 0L;
            LocalCache$Segment[] var10 = var4;
            int var11 = var4.length;

            for(int var12 = 0; var12 < var11; ++var12) {
               LocalCache$Segment var13 = var10[var12];
               int var14 = var13.count;
               AtomicReferenceArray var15 = var13.table;

               for(int var16 = 0; var16 < var15.length(); ++var16) {
                  for(LocalCache$ReferenceEntry var17 = (LocalCache$ReferenceEntry)var15.get(var16); var17 != null; var17 = var17.getNext()) {
                     Object var18 = var13.getLiveValue(var17, var2);
                     if(var18 != null && this.valueEquivalence.equivalent(var1, var18)) {
                        return true;
                     }
                  }
               }

               var8 += (long)var13.modCount;
            }

            if(var8 == var5) {
               break;
            }

            var5 = var8;
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
      LocalCache$Segment[] var1 = this.segments;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         LocalCache$Segment var4 = var1[var3];
         var4.clear();
      }

   }

   void invalidateAll(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         this.remove(var3);
      }

   }

   public Set keySet() {
      Set var1 = this.keySet;
      return var1 != null?var1:(this.keySet = new LocalCache$KeySet(this, this));
   }

   public Collection values() {
      Collection var1 = this.values;
      return var1 != null?var1:(this.values = new LocalCache$Values(this, this));
   }

   @GwtIncompatible("Not supported.")
   public Set entrySet() {
      Set var1 = this.entrySet;
      return var1 != null?var1:(this.entrySet = new LocalCache$EntrySet(this, this));
   }
}
