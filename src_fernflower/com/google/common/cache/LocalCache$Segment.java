package com.google.common.cache;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheLoader$InvalidCacheLoadException;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$AccessQueue;
import com.google.common.cache.LocalCache$LoadingValueReference;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment$1;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeightedStrongValueReference;
import com.google.common.cache.LocalCache$WriteQueue;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalNotification;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class LocalCache$Segment extends ReentrantLock {
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
   final AtomicInteger readCount = new AtomicInteger();
   @GuardedBy("this")
   final Queue writeQueue;
   @GuardedBy("this")
   final Queue accessQueue;
   final AbstractCache$StatsCounter statsCounter;

   LocalCache$Segment(LocalCache var1, int var2, long var3, AbstractCache$StatsCounter var5) {
      this.map = var1;
      this.maxSegmentWeight = var3;
      this.statsCounter = (AbstractCache$StatsCounter)Preconditions.checkNotNull(var5);
      this.initTable(this.newEntryArray(var2));
      this.keyReferenceQueue = var1.usesKeyReferences()?new ReferenceQueue():null;
      this.valueReferenceQueue = var1.usesValueReferences()?new ReferenceQueue():null;
      this.recencyQueue = (Queue)(var1.usesAccessQueue()?new ConcurrentLinkedQueue():LocalCache.discardingQueue());
      this.writeQueue = (Queue)(var1.usesWriteQueue()?new LocalCache$WriteQueue():LocalCache.discardingQueue());
      this.accessQueue = (Queue)(var1.usesAccessQueue()?new LocalCache$AccessQueue():LocalCache.discardingQueue());
   }

   AtomicReferenceArray newEntryArray(int var1) {
      return new AtomicReferenceArray(var1);
   }

   void initTable(AtomicReferenceArray var1) {
      this.threshold = var1.length() * 3 / 4;
      if(!this.map.customWeigher() && (long)this.threshold == this.maxSegmentWeight) {
         ++this.threshold;
      }

      this.table = var1;
   }

   @GuardedBy("this")
   LocalCache$ReferenceEntry newEntry(Object var1, int var2, @Nullable LocalCache$ReferenceEntry var3) {
      return this.map.entryFactory.newEntry(this, Preconditions.checkNotNull(var1), var2, var3);
   }

   @GuardedBy("this")
   LocalCache$ReferenceEntry copyEntry(LocalCache$ReferenceEntry var1, LocalCache$ReferenceEntry var2) {
      if(var1.getKey() == null) {
         return null;
      } else {
         LocalCache$ValueReference var3 = var1.getValueReference();
         Object var4 = var3.get();
         if(var4 == null && var3.isActive()) {
            return null;
         } else {
            LocalCache$ReferenceEntry var5 = this.map.entryFactory.copyEntry(this, var1, var2);
            var5.setValueReference(var3.copyFor(this.valueReferenceQueue, var4, var5));
            return var5;
         }
      }
   }

   @GuardedBy("this")
   void setValue(LocalCache$ReferenceEntry var1, Object var2, Object var3, long var4) {
      LocalCache$ValueReference var6 = var1.getValueReference();
      int var7 = this.map.weigher.weigh(var2, var3);
      Preconditions.checkState(var7 >= 0, "Weights must be non-negative");
      LocalCache$ValueReference var8 = this.map.valueStrength.referenceValue(this, var1, var3, var7);
      var1.setValueReference(var8);
      this.recordWrite(var1, var7, var4);
      var6.notifyNewValue(var3);
   }

   Object get(Object var1, int var2, CacheLoader var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var3);

      try {
         if(this.count != 0) {
            LocalCache$ReferenceEntry var4 = this.getEntry(var1, var2);
            if(var4 != null) {
               long var16 = this.map.ticker.read();
               Object var7 = this.getLiveValue(var4, var16);
               if(var7 != null) {
                  this.recordRead(var4, var16);
                  this.statsCounter.recordHits(1);
                  Object var17 = this.scheduleRefresh(var4, var1, var2, var7, var16, var3);
                  return var17;
               }

               LocalCache$ValueReference var8 = var4.getValueReference();
               if(var8.isLoading()) {
                  Object var9 = this.waitForLoadingValue(var4, var1, var8);
                  return var9;
               }
            }
         }

         Object var15 = this.lockedGetOrLoad(var1, var2, var3);
         return var15;
      } catch (ExecutionException var13) {
         Throwable var5 = var13.getCause();
         if(var5 instanceof Error) {
            throw new ExecutionError((Error)var5);
         } else if(var5 instanceof RuntimeException) {
            throw new UncheckedExecutionException(var5);
         } else {
            throw var13;
         }
      } finally {
         this.postReadCleanup();
      }
   }

   Object lockedGetOrLoad(Object var1, int var2, CacheLoader var3) {
      LocalCache$ValueReference var5 = null;
      LocalCache$LoadingValueReference var6 = null;
      boolean var7 = true;
      this.lock();

      LocalCache$ReferenceEntry var4;
      try {
         long var8 = this.map.ticker.read();
         this.preWriteCleanup(var8);
         int var10 = this.count - 1;
         AtomicReferenceArray var11 = this.table;
         int var12 = var2 & var11.length() - 1;
         LocalCache$ReferenceEntry var13 = (LocalCache$ReferenceEntry)var11.get(var12);

         for(var4 = var13; var4 != null; var4 = var4.getNext()) {
            Object var14 = var4.getKey();
            if(var4.getHash() == var2 && var14 != null && this.map.keyEquivalence.equivalent(var1, var14)) {
               var5 = var4.getValueReference();
               if(var5.isLoading()) {
                  var7 = false;
               } else {
                  Object var15 = var5.get();
                  if(var15 == null) {
                     this.enqueueNotification(var14, var2, var5, RemovalCause.COLLECTED);
                  } else {
                     if(!this.map.isExpired(var4, var8)) {
                        this.recordLockedRead(var4, var8);
                        this.statsCounter.recordHits(1);
                        Object var16 = var15;
                        return var16;
                     }

                     this.enqueueNotification(var14, var2, var5, RemovalCause.EXPIRED);
                  }

                  this.writeQueue.remove(var4);
                  this.accessQueue.remove(var4);
                  this.count = var10;
               }
               break;
            }
         }

         if(var7) {
            var6 = new LocalCache$LoadingValueReference();
            if(var4 == null) {
               var4 = this.newEntry(var1, var2, var13);
               var4.setValueReference(var6);
               var11.set(var12, var4);
            } else {
               var4.setValueReference(var6);
            }
         }
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }

      if(var7) {
         Object var9;
         try {
            synchronized(var4) {
               var9 = this.loadSync(var1, var2, var6, var3);
            }
         } finally {
            this.statsCounter.recordMisses(1);
         }

         return var9;
      } else {
         return this.waitForLoadingValue(var4, var1, var5);
      }
   }

   Object waitForLoadingValue(LocalCache$ReferenceEntry var1, Object var2, LocalCache$ValueReference var3) {
      if(!var3.isLoading()) {
         throw new AssertionError();
      } else {
         Preconditions.checkState(!Thread.holdsLock(var1), "Recursive load of: %s", new Object[]{var2});

         Object var7;
         try {
            Object var4 = var3.waitForValue();
            if(var4 == null) {
               String var11 = String.valueOf(var2);
               throw new CacheLoader$InvalidCacheLoadException((new StringBuilder(35 + String.valueOf(var11).length())).append("CacheLoader returned null for key ").append(var11).append(".").toString());
            }

            long var5 = this.map.ticker.read();
            this.recordRead(var1, var5);
            var7 = var4;
         } finally {
            this.statsCounter.recordMisses(1);
         }

         return var7;
      }
   }

   Object loadSync(Object var1, int var2, LocalCache$LoadingValueReference var3, CacheLoader var4) {
      ListenableFuture var5 = var3.loadFuture(var1, var4);
      return this.getAndRecordStats(var1, var2, var3, var5);
   }

   ListenableFuture loadAsync(Object var1, int var2, LocalCache$LoadingValueReference var3, CacheLoader var4) {
      ListenableFuture var5 = var3.loadFuture(var1, var4);
      var5.addListener(new LocalCache$Segment$1(this, var1, var2, var3, var5), MoreExecutors.directExecutor());
      return var5;
   }

   Object getAndRecordStats(Object var1, int var2, LocalCache$LoadingValueReference var3, ListenableFuture var4) {
      Object var5 = null;

      Object var6;
      try {
         var5 = Uninterruptibles.getUninterruptibly(var4);
         if(var5 == null) {
            String var10 = String.valueOf(var1);
            throw new CacheLoader$InvalidCacheLoadException((new StringBuilder(35 + String.valueOf(var10).length())).append("CacheLoader returned null for key ").append(var10).append(".").toString());
         }

         this.statsCounter.recordLoadSuccess(var3.elapsedNanos());
         this.storeLoadedValue(var1, var2, var3, var5);
         var6 = var5;
      } finally {
         if(var5 == null) {
            this.statsCounter.recordLoadException(var3.elapsedNanos());
            this.removeLoadingValue(var1, var2, var3);
         }

      }

      return var6;
   }

   Object scheduleRefresh(LocalCache$ReferenceEntry var1, Object var2, int var3, Object var4, long var5, CacheLoader var7) {
      if(this.map.refreshes() && var5 - var1.getWriteTime() > this.map.refreshNanos && !var1.getValueReference().isLoading()) {
         Object var8 = this.refresh(var2, var3, var7, true);
         if(var8 != null) {
            return var8;
         }
      }

      return var4;
   }

   @Nullable
   Object refresh(Object var1, int var2, CacheLoader var3, boolean var4) {
      LocalCache$LoadingValueReference var5 = this.insertLoadingValueReference(var1, var2, var4);
      if(var5 == null) {
         return null;
      } else {
         ListenableFuture var6 = this.loadAsync(var1, var2, var5, var3);
         if(var6.isDone()) {
            try {
               return Uninterruptibles.getUninterruptibly(var6);
            } catch (Throwable var8) {
               ;
            }
         }

         return null;
      }
   }

   @Nullable
   LocalCache$LoadingValueReference insertLoadingValueReference(Object var1, int var2, boolean var3) {
      LocalCache$ReferenceEntry var4 = null;
      this.lock();

      try {
         long var5 = this.map.ticker.read();
         this.preWriteCleanup(var5);
         AtomicReferenceArray var7 = this.table;
         int var8 = var2 & var7.length() - 1;
         LocalCache$ReferenceEntry var9 = (LocalCache$ReferenceEntry)var7.get(var8);

         for(var4 = var9; var4 != null; var4 = var4.getNext()) {
            Object var10 = var4.getKey();
            if(var4.getHash() == var2 && var10 != null && this.map.keyEquivalence.equivalent(var1, var10)) {
               LocalCache$ValueReference var11 = var4.getValueReference();
               LocalCache$LoadingValueReference var12;
               if(!var11.isLoading() && (!var3 || var5 - var4.getWriteTime() >= this.map.refreshNanos)) {
                  ++this.modCount;
                  var12 = new LocalCache$LoadingValueReference(var11);
                  var4.setValueReference(var12);
                  LocalCache$LoadingValueReference var13 = var12;
                  return var13;
               }

               var12 = null;
               return var12;
            }
         }

         ++this.modCount;
         LocalCache$LoadingValueReference var17 = new LocalCache$LoadingValueReference();
         var4 = this.newEntry(var1, var2, var9);
         var4.setValueReference(var17);
         var7.set(var8, var4);
         LocalCache$LoadingValueReference var18 = var17;
         return var18;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   void tryDrainReferenceQueues() {
      if(this.tryLock()) {
         try {
            this.drainReferenceQueues();
         } finally {
            this.unlock();
         }
      }

   }

   @GuardedBy("this")
   void drainReferenceQueues() {
      if(this.map.usesKeyReferences()) {
         this.drainKeyReferenceQueue();
      }

      if(this.map.usesValueReferences()) {
         this.drainValueReferenceQueue();
      }

   }

   @GuardedBy("this")
   void drainKeyReferenceQueue() {
      int var2 = 0;

      Reference var1;
      while((var1 = this.keyReferenceQueue.poll()) != null) {
         LocalCache$ReferenceEntry var3 = (LocalCache$ReferenceEntry)var1;
         this.map.reclaimKey(var3);
         ++var2;
         if(var2 == 16) {
            break;
         }
      }

   }

   @GuardedBy("this")
   void drainValueReferenceQueue() {
      int var2 = 0;

      Reference var1;
      while((var1 = this.valueReferenceQueue.poll()) != null) {
         LocalCache$ValueReference var3 = (LocalCache$ValueReference)var1;
         this.map.reclaimValue(var3);
         ++var2;
         if(var2 == 16) {
            break;
         }
      }

   }

   void clearReferenceQueues() {
      if(this.map.usesKeyReferences()) {
         this.clearKeyReferenceQueue();
      }

      if(this.map.usesValueReferences()) {
         this.clearValueReferenceQueue();
      }

   }

   void clearKeyReferenceQueue() {
      while(this.keyReferenceQueue.poll() != null) {
         ;
      }

   }

   void clearValueReferenceQueue() {
      while(this.valueReferenceQueue.poll() != null) {
         ;
      }

   }

   void recordRead(LocalCache$ReferenceEntry var1, long var2) {
      if(this.map.recordsAccess()) {
         var1.setAccessTime(var2);
      }

      this.recencyQueue.add(var1);
   }

   @GuardedBy("this")
   void recordLockedRead(LocalCache$ReferenceEntry var1, long var2) {
      if(this.map.recordsAccess()) {
         var1.setAccessTime(var2);
      }

      this.accessQueue.add(var1);
   }

   @GuardedBy("this")
   void recordWrite(LocalCache$ReferenceEntry var1, int var2, long var3) {
      this.drainRecencyQueue();
      this.totalWeight += (long)var2;
      if(this.map.recordsAccess()) {
         var1.setAccessTime(var3);
      }

      if(this.map.recordsWrite()) {
         var1.setWriteTime(var3);
      }

      this.accessQueue.add(var1);
      this.writeQueue.add(var1);
   }

   @GuardedBy("this")
   void drainRecencyQueue() {
      LocalCache$ReferenceEntry var1;
      while((var1 = (LocalCache$ReferenceEntry)this.recencyQueue.poll()) != null) {
         if(this.accessQueue.contains(var1)) {
            this.accessQueue.add(var1);
         }
      }

   }

   void tryExpireEntries(long var1) {
      if(this.tryLock()) {
         try {
            this.expireEntries(var1);
         } finally {
            this.unlock();
         }
      }

   }

   @GuardedBy("this")
   void expireEntries(long var1) {
      this.drainRecencyQueue();

      LocalCache$ReferenceEntry var3;
      while((var3 = (LocalCache$ReferenceEntry)this.writeQueue.peek()) != null && this.map.isExpired(var3, var1)) {
         if(!this.removeEntry(var3, var3.getHash(), RemovalCause.EXPIRED)) {
            throw new AssertionError();
         }
      }

      while((var3 = (LocalCache$ReferenceEntry)this.accessQueue.peek()) != null && this.map.isExpired(var3, var1)) {
         if(!this.removeEntry(var3, var3.getHash(), RemovalCause.EXPIRED)) {
            throw new AssertionError();
         }
      }

   }

   @GuardedBy("this")
   void enqueueNotification(LocalCache$ReferenceEntry var1, RemovalCause var2) {
      this.enqueueNotification(var1.getKey(), var1.getHash(), var1.getValueReference(), var2);
   }

   @GuardedBy("this")
   void enqueueNotification(@Nullable Object var1, int var2, LocalCache$ValueReference var3, RemovalCause var4) {
      this.totalWeight -= (long)var3.getWeight();
      if(var4.wasEvicted()) {
         this.statsCounter.recordEviction();
      }

      if(this.map.removalNotificationQueue != LocalCache.DISCARDING_QUEUE) {
         Object var5 = var3.get();
         String var6;
         String var7;
         if(var1 == null && !this.map.usesKeyReferences()) {
            var7 = String.valueOf(var4);
            var6 = (new StringBuilder(55 + String.valueOf(var7).length())).append("Unexpected null key during removal notification, cause=").append(var7).toString();
            LocalCache.logger.log(Level.WARNING, var6, new AssertionError());
         } else if(var5 == null && !this.map.usesValueReferences()) {
            var7 = String.valueOf(var4);
            var6 = (new StringBuilder(57 + String.valueOf(var7).length())).append("Unexpected null value during removal notification, cause=").append(var7).toString();
            LocalCache.logger.log(Level.WARNING, var6, new AssertionError());
         }

         RemovalNotification var8 = RemovalNotification.create(var1, var5, var4);
         this.map.removalNotificationQueue.offer(var8);
      }

   }

   @GuardedBy("this")
   void evictEntries(LocalCache$ReferenceEntry var1) {
      if(this.map.evictsBySize()) {
         this.drainRecencyQueue();
         if((long)var1.getValueReference().getWeight() > this.maxSegmentWeight && !this.removeEntry(var1, var1.getHash(), RemovalCause.SIZE)) {
            throw new AssertionError();
         } else {
            LocalCache$ReferenceEntry var2;
            do {
               if(this.totalWeight <= this.maxSegmentWeight) {
                  return;
               }

               var2 = this.getNextEvictable();
            } while(this.removeEntry(var2, var2.getHash(), RemovalCause.SIZE));

            throw new AssertionError();
         }
      }
   }

   @GuardedBy("this")
   LocalCache$ReferenceEntry getNextEvictable() {
      Iterator var1 = this.accessQueue.iterator();

      LocalCache$ReferenceEntry var2;
      int var3;
      do {
         if(!var1.hasNext()) {
            throw new AssertionError();
         }

         var2 = (LocalCache$ReferenceEntry)var1.next();
         var3 = var2.getValueReference().getWeight();
      } while(var3 <= 0);

      return var2;
   }

   LocalCache$ReferenceEntry getFirst(int var1) {
      AtomicReferenceArray var2 = this.table;
      return (LocalCache$ReferenceEntry)var2.get(var1 & var2.length() - 1);
   }

   @Nullable
   LocalCache$ReferenceEntry getEntry(Object var1, int var2) {
      for(LocalCache$ReferenceEntry var3 = this.getFirst(var2); var3 != null; var3 = var3.getNext()) {
         if(var3.getHash() == var2) {
            Object var4 = var3.getKey();
            if(var4 == null) {
               this.tryDrainReferenceQueues();
            } else if(this.map.keyEquivalence.equivalent(var1, var4)) {
               return var3;
            }
         }
      }

      return null;
   }

   @Nullable
   LocalCache$ReferenceEntry getLiveEntry(Object var1, int var2, long var3) {
      LocalCache$ReferenceEntry var5 = this.getEntry(var1, var2);
      if(var5 == null) {
         return null;
      } else if(this.map.isExpired(var5, var3)) {
         this.tryExpireEntries(var3);
         return null;
      } else {
         return var5;
      }
   }

   Object getLiveValue(LocalCache$ReferenceEntry var1, long var2) {
      if(var1.getKey() == null) {
         this.tryDrainReferenceQueues();
         return null;
      } else {
         Object var4 = var1.getValueReference().get();
         if(var4 == null) {
            this.tryDrainReferenceQueues();
            return null;
         } else if(this.map.isExpired(var1, var2)) {
            this.tryExpireEntries(var2);
            return null;
         } else {
            return var4;
         }
      }
   }

   @Nullable
   Object get(Object var1, int var2) {
      try {
         if(this.count != 0) {
            long var3 = this.map.ticker.read();
            LocalCache$ReferenceEntry var5 = this.getLiveEntry(var1, var2, var3);
            Object var6;
            if(var5 == null) {
               var6 = null;
               return var6;
            }

            var6 = var5.getValueReference().get();
            if(var6 != null) {
               this.recordRead(var5, var3);
               Object var7 = this.scheduleRefresh(var5, var5.getKey(), var2, var6, var3, this.map.defaultLoader);
               return var7;
            }

            this.tryDrainReferenceQueues();
         }

         Object var11 = null;
         return var11;
      } finally {
         this.postReadCleanup();
      }
   }

   boolean containsKey(Object var1, int var2) {
      boolean var6;
      try {
         if(this.count == 0) {
            boolean var10 = false;
            return var10;
         }

         long var3 = this.map.ticker.read();
         LocalCache$ReferenceEntry var5 = this.getLiveEntry(var1, var2, var3);
         if(var5 != null) {
            var6 = var5.getValueReference().get() != null;
            return var6;
         }

         var6 = false;
      } finally {
         this.postReadCleanup();
      }

      return var6;
   }

   @VisibleForTesting
   boolean containsValue(Object var1) {
      boolean var13;
      try {
         if(this.count != 0) {
            long var2 = this.map.ticker.read();
            AtomicReferenceArray var4 = this.table;
            int var5 = var4.length();

            for(int var6 = 0; var6 < var5; ++var6) {
               for(LocalCache$ReferenceEntry var7 = (LocalCache$ReferenceEntry)var4.get(var6); var7 != null; var7 = var7.getNext()) {
                  Object var8 = this.getLiveValue(var7, var2);
                  if(var8 != null && this.map.valueEquivalence.equivalent(var1, var8)) {
                     boolean var9 = true;
                     return var9;
                  }
               }
            }
         }

         var13 = false;
      } finally {
         this.postReadCleanup();
      }

      return var13;
   }

   @Nullable
   Object put(Object var1, int var2, Object var3, boolean var4) {
      this.lock();

      try {
         long var5 = this.map.ticker.read();
         this.preWriteCleanup(var5);
         int var7 = this.count + 1;
         if(var7 > this.threshold) {
            this.expand();
            var7 = this.count + 1;
         }

         AtomicReferenceArray var8 = this.table;
         int var9 = var2 & var8.length() - 1;
         LocalCache$ReferenceEntry var10 = (LocalCache$ReferenceEntry)var8.get(var9);

         LocalCache$ReferenceEntry var11;
         Object var12;
         for(var11 = var10; var11 != null; var11 = var11.getNext()) {
            var12 = var11.getKey();
            if(var11.getHash() == var2 && var12 != null && this.map.keyEquivalence.equivalent(var1, var12)) {
               LocalCache$ValueReference var13 = var11.getValueReference();
               Object var14 = var13.get();
               Object var15;
               if(var14 != null) {
                  if(var4) {
                     this.recordLockedRead(var11, var5);
                     var15 = var14;
                     return var15;
                  }

                  ++this.modCount;
                  this.enqueueNotification(var1, var2, var13, RemovalCause.REPLACED);
                  this.setValue(var11, var1, var3, var5);
                  this.evictEntries(var11);
                  var15 = var14;
                  return var15;
               }

               ++this.modCount;
               if(var13.isActive()) {
                  this.enqueueNotification(var1, var2, var13, RemovalCause.COLLECTED);
                  this.setValue(var11, var1, var3, var5);
                  var7 = this.count;
               } else {
                  this.setValue(var11, var1, var3, var5);
                  var7 = this.count + 1;
               }

               this.count = var7;
               this.evictEntries(var11);
               var15 = null;
               return var15;
            }
         }

         ++this.modCount;
         var11 = this.newEntry(var1, var2, var10);
         this.setValue(var11, var1, var3, var5);
         var8.set(var9, var11);
         var7 = this.count + 1;
         this.count = var7;
         this.evictEntries(var11);
         var12 = null;
         return var12;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   @GuardedBy("this")
   void expand() {
      AtomicReferenceArray var1 = this.table;
      int var2 = var1.length();
      if(var2 < 1073741824) {
         int var3 = this.count;
         AtomicReferenceArray var4 = this.newEntryArray(var2 << 1);
         this.threshold = var4.length() * 3 / 4;
         int var5 = var4.length() - 1;

         for(int var6 = 0; var6 < var2; ++var6) {
            LocalCache$ReferenceEntry var7 = (LocalCache$ReferenceEntry)var1.get(var6);
            if(var7 != null) {
               LocalCache$ReferenceEntry var8 = var7.getNext();
               int var9 = var7.getHash() & var5;
               if(var8 == null) {
                  var4.set(var9, var7);
               } else {
                  LocalCache$ReferenceEntry var10 = var7;
                  int var11 = var9;

                  LocalCache$ReferenceEntry var12;
                  int var13;
                  for(var12 = var8; var12 != null; var12 = var12.getNext()) {
                     var13 = var12.getHash() & var5;
                     if(var13 != var11) {
                        var11 = var13;
                        var10 = var12;
                     }
                  }

                  var4.set(var11, var10);

                  for(var12 = var7; var12 != var10; var12 = var12.getNext()) {
                     var13 = var12.getHash() & var5;
                     LocalCache$ReferenceEntry var14 = (LocalCache$ReferenceEntry)var4.get(var13);
                     LocalCache$ReferenceEntry var15 = this.copyEntry(var12, var14);
                     if(var15 != null) {
                        var4.set(var13, var15);
                     } else {
                        this.removeCollectedEntry(var12);
                        --var3;
                     }
                  }
               }
            }
         }

         this.table = var4;
         this.count = var3;
      }
   }

   boolean replace(Object var1, int var2, Object var3, Object var4) {
      this.lock();

      try {
         long var5 = this.map.ticker.read();
         this.preWriteCleanup(var5);
         AtomicReferenceArray var7 = this.table;
         int var8 = var2 & var7.length() - 1;
         LocalCache$ReferenceEntry var9 = (LocalCache$ReferenceEntry)var7.get(var8);

         for(LocalCache$ReferenceEntry var10 = var9; var10 != null; var10 = var10.getNext()) {
            Object var11 = var10.getKey();
            if(var10.getHash() == var2 && var11 != null && this.map.keyEquivalence.equivalent(var1, var11)) {
               LocalCache$ValueReference var12 = var10.getValueReference();
               Object var13 = var12.get();
               boolean var20;
               if(var13 != null) {
                  if(this.map.valueEquivalence.equivalent(var3, var13)) {
                     ++this.modCount;
                     this.enqueueNotification(var1, var2, var12, RemovalCause.REPLACED);
                     this.setValue(var10, var1, var4, var5);
                     this.evictEntries(var10);
                     var20 = true;
                     return var20;
                  }

                  this.recordLockedRead(var10, var5);
                  var20 = false;
                  return var20;
               }

               if(var12.isActive()) {
                  int var14 = this.count - 1;
                  ++this.modCount;
                  LocalCache$ReferenceEntry var15 = this.removeValueFromChain(var9, var10, var11, var2, var12, RemovalCause.COLLECTED);
                  var14 = this.count - 1;
                  var7.set(var8, var15);
                  this.count = var14;
               }

               var20 = false;
               return var20;
            }
         }

         boolean var19 = false;
         return var19;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   @Nullable
   Object replace(Object var1, int var2, Object var3) {
      this.lock();

      try {
         long var4 = this.map.ticker.read();
         this.preWriteCleanup(var4);
         AtomicReferenceArray var6 = this.table;
         int var7 = var2 & var6.length() - 1;
         LocalCache$ReferenceEntry var8 = (LocalCache$ReferenceEntry)var6.get(var7);

         LocalCache$ReferenceEntry var9;
         for(var9 = var8; var9 != null; var9 = var9.getNext()) {
            Object var10 = var9.getKey();
            if(var9.getHash() == var2 && var10 != null && this.map.keyEquivalence.equivalent(var1, var10)) {
               LocalCache$ValueReference var11 = var9.getValueReference();
               Object var12 = var11.get();
               Object var13;
               if(var12 == null) {
                  if(var11.isActive()) {
                     int var18 = this.count - 1;
                     ++this.modCount;
                     LocalCache$ReferenceEntry var14 = this.removeValueFromChain(var8, var9, var10, var2, var11, RemovalCause.COLLECTED);
                     var18 = this.count - 1;
                     var6.set(var7, var14);
                     this.count = var18;
                  }

                  var13 = null;
                  return var13;
               }

               ++this.modCount;
               this.enqueueNotification(var1, var2, var11, RemovalCause.REPLACED);
               this.setValue(var9, var1, var3, var4);
               this.evictEntries(var9);
               var13 = var12;
               return var13;
            }
         }

         var9 = null;
         return var9;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   @Nullable
   Object remove(Object var1, int var2) {
      this.lock();

      LocalCache$ReferenceEntry var9;
      try {
         long var3 = this.map.ticker.read();
         this.preWriteCleanup(var3);
         int var5 = this.count - 1;
         AtomicReferenceArray var6 = this.table;
         int var7 = var2 & var6.length() - 1;
         LocalCache$ReferenceEntry var8 = (LocalCache$ReferenceEntry)var6.get(var7);

         for(var9 = var8; var9 != null; var9 = var9.getNext()) {
            Object var10 = var9.getKey();
            if(var9.getHash() == var2 && var10 != null && this.map.keyEquivalence.equivalent(var1, var10)) {
               LocalCache$ValueReference var11 = var9.getValueReference();
               Object var12 = var11.get();
               RemovalCause var13;
               LocalCache$ReferenceEntry var14;
               if(var12 != null) {
                  var13 = RemovalCause.EXPLICIT;
               } else {
                  if(!var11.isActive()) {
                     var14 = null;
                     return var14;
                  }

                  var13 = RemovalCause.COLLECTED;
               }

               ++this.modCount;
               var14 = this.removeValueFromChain(var8, var9, var10, var2, var11, var13);
               var5 = this.count - 1;
               var6.set(var7, var14);
               this.count = var5;
               Object var15 = var12;
               return var15;
            }
         }

         var9 = null;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }

      return var9;
   }

   boolean storeLoadedValue(Object var1, int var2, LocalCache$LoadingValueReference var3, Object var4) {
      this.lock();

      try {
         long var5 = this.map.ticker.read();
         this.preWriteCleanup(var5);
         int var7 = this.count + 1;
         if(var7 > this.threshold) {
            this.expand();
            var7 = this.count + 1;
         }

         AtomicReferenceArray var8 = this.table;
         int var9 = var2 & var8.length() - 1;
         LocalCache$ReferenceEntry var10 = (LocalCache$ReferenceEntry)var8.get(var9);

         LocalCache$ReferenceEntry var11;
         for(var11 = var10; var11 != null; var11 = var11.getNext()) {
            Object var12 = var11.getKey();
            if(var11.getHash() == var2 && var12 != null && this.map.keyEquivalence.equivalent(var1, var12)) {
               LocalCache$ValueReference var13 = var11.getValueReference();
               Object var14 = var13.get();
               boolean var15;
               if(var3 == var13 || var14 == null && var13 != LocalCache.UNSET) {
                  ++this.modCount;
                  if(var3.isActive()) {
                     RemovalCause var21 = var14 == null?RemovalCause.COLLECTED:RemovalCause.REPLACED;
                     this.enqueueNotification(var1, var2, var3, var21);
                     --var7;
                  }

                  this.setValue(var11, var1, var4, var5);
                  this.count = var7;
                  this.evictEntries(var11);
                  var15 = true;
                  return var15;
               }

               LocalCache$WeightedStrongValueReference var20 = new LocalCache$WeightedStrongValueReference(var4, 0);
               this.enqueueNotification(var1, var2, var20, RemovalCause.REPLACED);
               var15 = false;
               return var15;
            }
         }

         ++this.modCount;
         var11 = this.newEntry(var1, var2, var10);
         this.setValue(var11, var1, var4, var5);
         var8.set(var9, var11);
         this.count = var7;
         this.evictEntries(var11);
         boolean var19 = true;
         return var19;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   boolean remove(Object var1, int var2, Object var3) {
      this.lock();

      boolean var20;
      try {
         long var4 = this.map.ticker.read();
         this.preWriteCleanup(var4);
         int var6 = this.count - 1;
         AtomicReferenceArray var7 = this.table;
         int var8 = var2 & var7.length() - 1;
         LocalCache$ReferenceEntry var9 = (LocalCache$ReferenceEntry)var7.get(var8);

         for(LocalCache$ReferenceEntry var10 = var9; var10 != null; var10 = var10.getNext()) {
            Object var11 = var10.getKey();
            if(var10.getHash() == var2 && var11 != null && this.map.keyEquivalence.equivalent(var1, var11)) {
               LocalCache$ValueReference var12 = var10.getValueReference();
               Object var13 = var12.get();
               RemovalCause var14;
               if(this.map.valueEquivalence.equivalent(var3, var13)) {
                  var14 = RemovalCause.EXPLICIT;
               } else {
                  if(var13 != null || !var12.isActive()) {
                     boolean var15 = false;
                     return var15;
                  }

                  var14 = RemovalCause.COLLECTED;
               }

               ++this.modCount;
               LocalCache$ReferenceEntry var21 = this.removeValueFromChain(var9, var10, var11, var2, var12, var14);
               var6 = this.count - 1;
               var7.set(var8, var21);
               this.count = var6;
               boolean var16 = var14 == RemovalCause.EXPLICIT;
               return var16;
            }
         }

         var20 = false;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }

      return var20;
   }

   void clear() {
      if(this.count != 0) {
         this.lock();

         try {
            AtomicReferenceArray var1 = this.table;

            int var2;
            for(var2 = 0; var2 < var1.length(); ++var2) {
               for(LocalCache$ReferenceEntry var3 = (LocalCache$ReferenceEntry)var1.get(var2); var3 != null; var3 = var3.getNext()) {
                  if(var3.getValueReference().isActive()) {
                     this.enqueueNotification(var3, RemovalCause.EXPLICIT);
                  }
               }
            }

            for(var2 = 0; var2 < var1.length(); ++var2) {
               var1.set(var2, (Object)null);
            }

            this.clearReferenceQueues();
            this.writeQueue.clear();
            this.accessQueue.clear();
            this.readCount.set(0);
            ++this.modCount;
            this.count = 0;
         } finally {
            this.unlock();
            this.postWriteCleanup();
         }
      }

   }

   @Nullable
   @GuardedBy("this")
   LocalCache$ReferenceEntry removeValueFromChain(LocalCache$ReferenceEntry var1, LocalCache$ReferenceEntry var2, @Nullable Object var3, int var4, LocalCache$ValueReference var5, RemovalCause var6) {
      this.enqueueNotification(var3, var4, var5, var6);
      this.writeQueue.remove(var2);
      this.accessQueue.remove(var2);
      if(var5.isLoading()) {
         var5.notifyNewValue((Object)null);
         return var1;
      } else {
         return this.removeEntryFromChain(var1, var2);
      }
   }

   @Nullable
   @GuardedBy("this")
   LocalCache$ReferenceEntry removeEntryFromChain(LocalCache$ReferenceEntry var1, LocalCache$ReferenceEntry var2) {
      int var3 = this.count;
      LocalCache$ReferenceEntry var4 = var2.getNext();

      for(LocalCache$ReferenceEntry var5 = var1; var5 != var2; var5 = var5.getNext()) {
         LocalCache$ReferenceEntry var6 = this.copyEntry(var5, var4);
         if(var6 != null) {
            var4 = var6;
         } else {
            this.removeCollectedEntry(var5);
            --var3;
         }
      }

      this.count = var3;
      return var4;
   }

   @GuardedBy("this")
   void removeCollectedEntry(LocalCache$ReferenceEntry var1) {
      this.enqueueNotification(var1, RemovalCause.COLLECTED);
      this.writeQueue.remove(var1);
      this.accessQueue.remove(var1);
   }

   boolean reclaimKey(LocalCache$ReferenceEntry var1, int var2) {
      this.lock();

      try {
         int var3 = this.count - 1;
         AtomicReferenceArray var4 = this.table;
         int var5 = var2 & var4.length() - 1;
         LocalCache$ReferenceEntry var6 = (LocalCache$ReferenceEntry)var4.get(var5);

         for(LocalCache$ReferenceEntry var7 = var6; var7 != null; var7 = var7.getNext()) {
            if(var7 == var1) {
               ++this.modCount;
               LocalCache$ReferenceEntry var8 = this.removeValueFromChain(var6, var7, var7.getKey(), var2, var7.getValueReference(), RemovalCause.COLLECTED);
               var3 = this.count - 1;
               var4.set(var5, var8);
               this.count = var3;
               boolean var9 = true;
               return var9;
            }
         }

         boolean var13 = false;
         return var13;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   boolean reclaimValue(Object var1, int var2, LocalCache$ValueReference var3) {
      this.lock();

      try {
         int var4 = this.count - 1;
         AtomicReferenceArray var5 = this.table;
         int var6 = var2 & var5.length() - 1;
         LocalCache$ReferenceEntry var7 = (LocalCache$ReferenceEntry)var5.get(var6);

         for(LocalCache$ReferenceEntry var8 = var7; var8 != null; var8 = var8.getNext()) {
            Object var9 = var8.getKey();
            if(var8.getHash() == var2 && var9 != null && this.map.keyEquivalence.equivalent(var1, var9)) {
               LocalCache$ValueReference var10 = var8.getValueReference();
               if(var10 == var3) {
                  ++this.modCount;
                  LocalCache$ReferenceEntry var17 = this.removeValueFromChain(var7, var8, var9, var2, var3, RemovalCause.COLLECTED);
                  var4 = this.count - 1;
                  var5.set(var6, var17);
                  this.count = var4;
                  boolean var12 = true;
                  return var12;
               }

               boolean var11 = false;
               return var11;
            }
         }

         boolean var16 = false;
         return var16;
      } finally {
         this.unlock();
         if(!this.isHeldByCurrentThread()) {
            this.postWriteCleanup();
         }

      }
   }

   boolean removeLoadingValue(Object var1, int var2, LocalCache$LoadingValueReference var3) {
      this.lock();

      try {
         AtomicReferenceArray var4 = this.table;
         int var5 = var2 & var4.length() - 1;
         LocalCache$ReferenceEntry var6 = (LocalCache$ReferenceEntry)var4.get(var5);

         for(LocalCache$ReferenceEntry var7 = var6; var7 != null; var7 = var7.getNext()) {
            Object var8 = var7.getKey();
            if(var7.getHash() == var2 && var8 != null && this.map.keyEquivalence.equivalent(var1, var8)) {
               LocalCache$ValueReference var9 = var7.getValueReference();
               boolean var10;
               if(var9 == var3) {
                  if(var3.isActive()) {
                     var7.setValueReference(var3.getOldValue());
                  } else {
                     LocalCache$ReferenceEntry var14 = this.removeEntryFromChain(var6, var7);
                     var4.set(var5, var14);
                  }

                  var10 = true;
                  return var10;
               }

               var10 = false;
               return var10;
            }
         }

         boolean var15 = false;
         return var15;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   @GuardedBy("this")
   boolean removeEntry(LocalCache$ReferenceEntry var1, int var2, RemovalCause var3) {
      int var4 = this.count - 1;
      AtomicReferenceArray var5 = this.table;
      int var6 = var2 & var5.length() - 1;
      LocalCache$ReferenceEntry var7 = (LocalCache$ReferenceEntry)var5.get(var6);

      for(LocalCache$ReferenceEntry var8 = var7; var8 != null; var8 = var8.getNext()) {
         if(var8 == var1) {
            ++this.modCount;
            LocalCache$ReferenceEntry var9 = this.removeValueFromChain(var7, var8, var8.getKey(), var2, var8.getValueReference(), var3);
            var4 = this.count - 1;
            var5.set(var6, var9);
            this.count = var4;
            return true;
         }
      }

      return false;
   }

   void postReadCleanup() {
      if((this.readCount.incrementAndGet() & 63) == 0) {
         this.cleanUp();
      }

   }

   @GuardedBy("this")
   void preWriteCleanup(long var1) {
      this.runLockedCleanup(var1);
   }

   void postWriteCleanup() {
      this.runUnlockedCleanup();
   }

   void cleanUp() {
      long var1 = this.map.ticker.read();
      this.runLockedCleanup(var1);
      this.runUnlockedCleanup();
   }

   void runLockedCleanup(long var1) {
      if(this.tryLock()) {
         try {
            this.drainReferenceQueues();
            this.expireEntries(var1);
            this.readCount.set(0);
         } finally {
            this.unlock();
         }
      }

   }

   void runUnlockedCleanup() {
      if(!this.isHeldByCurrentThread()) {
         this.map.processPendingNotifications();
      }

   }
}
