package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.MapMaker$RemovalCause;
import com.google.common.collect.MapMaker$RemovalNotification;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$EvictionQueue;
import com.google.common.collect.MapMakerInternalMap$ExpirationQueue;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import com.google.j2objc.annotations.Weak;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class MapMakerInternalMap$Segment extends ReentrantLock {
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
   final AtomicInteger readCount = new AtomicInteger();
   @GuardedBy("this")
   final Queue evictionQueue;
   @GuardedBy("this")
   final Queue expirationQueue;

   MapMakerInternalMap$Segment(MapMakerInternalMap var1, int var2, int var3) {
      this.map = var1;
      this.maxSegmentSize = var3;
      this.initTable(this.newEntryArray(var2));
      this.keyReferenceQueue = var1.usesKeyReferences()?new ReferenceQueue():null;
      this.valueReferenceQueue = var1.usesValueReferences()?new ReferenceQueue():null;
      this.recencyQueue = (Queue)(!var1.evictsBySize() && !var1.expiresAfterAccess()?MapMakerInternalMap.discardingQueue():new ConcurrentLinkedQueue());
      this.evictionQueue = (Queue)(var1.evictsBySize()?new MapMakerInternalMap$EvictionQueue():MapMakerInternalMap.discardingQueue());
      this.expirationQueue = (Queue)(var1.expires()?new MapMakerInternalMap$ExpirationQueue():MapMakerInternalMap.discardingQueue());
   }

   AtomicReferenceArray newEntryArray(int var1) {
      return new AtomicReferenceArray(var1);
   }

   void initTable(AtomicReferenceArray var1) {
      this.threshold = var1.length() * 3 / 4;
      if(this.threshold == this.maxSegmentSize) {
         ++this.threshold;
      }

      this.table = var1;
   }

   @GuardedBy("this")
   MapMakerInternalMap$ReferenceEntry newEntry(Object var1, int var2, @Nullable MapMakerInternalMap$ReferenceEntry var3) {
      return this.map.entryFactory.newEntry(this, var1, var2, var3);
   }

   @GuardedBy("this")
   MapMakerInternalMap$ReferenceEntry copyEntry(MapMakerInternalMap$ReferenceEntry var1, MapMakerInternalMap$ReferenceEntry var2) {
      if(var1.getKey() == null) {
         return null;
      } else {
         MapMakerInternalMap$ValueReference var3 = var1.getValueReference();
         Object var4 = var3.get();
         if(var4 == null && !var3.isComputingReference()) {
            return null;
         } else {
            MapMakerInternalMap$ReferenceEntry var5 = this.map.entryFactory.copyEntry(this, var1, var2);
            var5.setValueReference(var3.copyFor(this.valueReferenceQueue, var4, var5));
            return var5;
         }
      }
   }

   @GuardedBy("this")
   void setValue(MapMakerInternalMap$ReferenceEntry var1, Object var2) {
      MapMakerInternalMap$ValueReference var3 = this.map.valueStrength.referenceValue(this, var1, var2);
      var1.setValueReference(var3);
      this.recordWrite(var1);
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
         MapMakerInternalMap$ReferenceEntry var3 = (MapMakerInternalMap$ReferenceEntry)var1;
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
         MapMakerInternalMap$ValueReference var3 = (MapMakerInternalMap$ValueReference)var1;
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

   void recordRead(MapMakerInternalMap$ReferenceEntry var1) {
      if(this.map.expiresAfterAccess()) {
         this.recordExpirationTime(var1, this.map.expireAfterAccessNanos);
      }

      this.recencyQueue.add(var1);
   }

   @GuardedBy("this")
   void recordLockedRead(MapMakerInternalMap$ReferenceEntry var1) {
      this.evictionQueue.add(var1);
      if(this.map.expiresAfterAccess()) {
         this.recordExpirationTime(var1, this.map.expireAfterAccessNanos);
         this.expirationQueue.add(var1);
      }

   }

   @GuardedBy("this")
   void recordWrite(MapMakerInternalMap$ReferenceEntry var1) {
      this.drainRecencyQueue();
      this.evictionQueue.add(var1);
      if(this.map.expires()) {
         long var2 = this.map.expiresAfterAccess()?this.map.expireAfterAccessNanos:this.map.expireAfterWriteNanos;
         this.recordExpirationTime(var1, var2);
         this.expirationQueue.add(var1);
      }

   }

   @GuardedBy("this")
   void drainRecencyQueue() {
      MapMakerInternalMap$ReferenceEntry var1;
      while((var1 = (MapMakerInternalMap$ReferenceEntry)this.recencyQueue.poll()) != null) {
         if(this.evictionQueue.contains(var1)) {
            this.evictionQueue.add(var1);
         }

         if(this.map.expiresAfterAccess() && this.expirationQueue.contains(var1)) {
            this.expirationQueue.add(var1);
         }
      }

   }

   void recordExpirationTime(MapMakerInternalMap$ReferenceEntry var1, long var2) {
      var1.setExpirationTime(this.map.ticker.read() + var2);
   }

   void tryExpireEntries() {
      if(this.tryLock()) {
         try {
            this.expireEntries();
         } finally {
            this.unlock();
         }
      }

   }

   @GuardedBy("this")
   void expireEntries() {
      this.drainRecencyQueue();
      if(!this.expirationQueue.isEmpty()) {
         long var1 = this.map.ticker.read();

         MapMakerInternalMap$ReferenceEntry var3;
         while((var3 = (MapMakerInternalMap$ReferenceEntry)this.expirationQueue.peek()) != null && this.map.isExpired(var3, var1)) {
            if(!this.removeEntry(var3, var3.getHash(), MapMaker$RemovalCause.EXPIRED)) {
               throw new AssertionError();
            }
         }

      }
   }

   void enqueueNotification(MapMakerInternalMap$ReferenceEntry var1, MapMaker$RemovalCause var2) {
      this.enqueueNotification(var1.getKey(), var1.getHash(), var1.getValueReference().get(), var2);
   }

   void enqueueNotification(@Nullable Object var1, int var2, @Nullable Object var3, MapMaker$RemovalCause var4) {
      if(this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
         String var5;
         String var6;
         if(var1 == null && !this.map.usesKeyReferences()) {
            var6 = String.valueOf(var4);
            var5 = (new StringBuilder(55 + String.valueOf(var6).length())).append("Unexpected null key during removal notification, cause=").append(var6).toString();
            MapMakerInternalMap.access$200().log(Level.WARNING, var5, new AssertionError());
         } else if(var3 == null && !this.map.usesValueReferences()) {
            var6 = String.valueOf(var4);
            var5 = (new StringBuilder(57 + String.valueOf(var6).length())).append("Unexpected null value during removal notification, cause=").append(var6).toString();
            MapMakerInternalMap.access$200().log(Level.WARNING, var5, new AssertionError());
         }

         MapMaker$RemovalNotification var7 = new MapMaker$RemovalNotification(var1, var3, var4);
         this.map.removalNotificationQueue.offer(var7);
      }

   }

   @GuardedBy("this")
   boolean evictEntries() {
      if(this.map.evictsBySize() && this.count >= this.maxSegmentSize) {
         this.drainRecencyQueue();
         MapMakerInternalMap$ReferenceEntry var1 = (MapMakerInternalMap$ReferenceEntry)this.evictionQueue.remove();
         if(!this.removeEntry(var1, var1.getHash(), MapMaker$RemovalCause.SIZE)) {
            throw new AssertionError();
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   MapMakerInternalMap$ReferenceEntry getFirst(int var1) {
      AtomicReferenceArray var2 = this.table;
      return (MapMakerInternalMap$ReferenceEntry)var2.get(var1 & var2.length() - 1);
   }

   MapMakerInternalMap$ReferenceEntry getEntry(Object var1, int var2) {
      if(this.count != 0) {
         for(MapMakerInternalMap$ReferenceEntry var3 = this.getFirst(var2); var3 != null; var3 = var3.getNext()) {
            if(var3.getHash() == var2) {
               Object var4 = var3.getKey();
               if(var4 == null) {
                  this.tryDrainReferenceQueues();
               } else if(this.map.keyEquivalence.equivalent(var1, var4)) {
                  return var3;
               }
            }
         }
      }

      return null;
   }

   MapMakerInternalMap$ReferenceEntry getLiveEntry(Object var1, int var2) {
      MapMakerInternalMap$ReferenceEntry var3 = this.getEntry(var1, var2);
      if(var3 == null) {
         return null;
      } else if(this.map.expires() && this.map.isExpired(var3)) {
         this.tryExpireEntries();
         return null;
      } else {
         return var3;
      }
   }

   Object get(Object var1, int var2) {
      Object var4;
      try {
         MapMakerInternalMap$ReferenceEntry var3 = this.getLiveEntry(var1, var2);
         if(var3 != null) {
            var4 = var3.getValueReference().get();
            if(var4 != null) {
               this.recordRead(var3);
            } else {
               this.tryDrainReferenceQueues();
            }

            Object var5 = var4;
            return var5;
         }

         var4 = null;
      } finally {
         this.postReadCleanup();
      }

      return var4;
   }

   boolean containsKey(Object var1, int var2) {
      boolean var3;
      try {
         if(this.count != 0) {
            MapMakerInternalMap$ReferenceEntry var8 = this.getLiveEntry(var1, var2);
            boolean var4;
            if(var8 == null) {
               var4 = false;
               return var4;
            }

            var4 = var8.getValueReference().get() != null;
            return var4;
         }

         var3 = false;
      } finally {
         this.postReadCleanup();
      }

      return var3;
   }

   @VisibleForTesting
   boolean containsValue(Object var1) {
      boolean var11;
      try {
         if(this.count != 0) {
            AtomicReferenceArray var2 = this.table;
            int var3 = var2.length();

            for(int var4 = 0; var4 < var3; ++var4) {
               for(MapMakerInternalMap$ReferenceEntry var5 = (MapMakerInternalMap$ReferenceEntry)var2.get(var4); var5 != null; var5 = var5.getNext()) {
                  Object var6 = this.getLiveValue(var5);
                  if(var6 != null && this.map.valueEquivalence.equivalent(var1, var6)) {
                     boolean var7 = true;
                     return var7;
                  }
               }
            }
         }

         var11 = false;
      } finally {
         this.postReadCleanup();
      }

      return var11;
   }

   Object put(Object var1, int var2, Object var3, boolean var4) {
      this.lock();

      try {
         this.preWriteCleanup();
         int var5 = this.count + 1;
         if(var5 > this.threshold) {
            this.expand();
            var5 = this.count + 1;
         }

         AtomicReferenceArray var6 = this.table;
         int var7 = var2 & var6.length() - 1;
         MapMakerInternalMap$ReferenceEntry var8 = (MapMakerInternalMap$ReferenceEntry)var6.get(var7);

         MapMakerInternalMap$ReferenceEntry var9;
         Object var10;
         for(var9 = var8; var9 != null; var9 = var9.getNext()) {
            var10 = var9.getKey();
            if(var9.getHash() == var2 && var10 != null && this.map.keyEquivalence.equivalent(var1, var10)) {
               MapMakerInternalMap$ValueReference var11 = var9.getValueReference();
               Object var12 = var11.get();
               Object var13;
               if(var12 == null) {
                  ++this.modCount;
                  this.setValue(var9, var3);
                  if(!var11.isComputingReference()) {
                     this.enqueueNotification(var1, var2, var12, MapMaker$RemovalCause.COLLECTED);
                     var5 = this.count;
                  } else if(this.evictEntries()) {
                     var5 = this.count + 1;
                  }

                  this.count = var5;
                  var13 = null;
                  return var13;
               }

               if(var4) {
                  this.recordLockedRead(var9);
                  var13 = var12;
                  return var13;
               }

               ++this.modCount;
               this.enqueueNotification(var1, var2, var12, MapMaker$RemovalCause.REPLACED);
               this.setValue(var9, var3);
               var13 = var12;
               return var13;
            }
         }

         ++this.modCount;
         var9 = this.newEntry(var1, var2, var8);
         this.setValue(var9, var3);
         var6.set(var7, var9);
         if(this.evictEntries()) {
            var5 = this.count + 1;
         }

         this.count = var5;
         var10 = null;
         return var10;
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
            MapMakerInternalMap$ReferenceEntry var7 = (MapMakerInternalMap$ReferenceEntry)var1.get(var6);
            if(var7 != null) {
               MapMakerInternalMap$ReferenceEntry var8 = var7.getNext();
               int var9 = var7.getHash() & var5;
               if(var8 == null) {
                  var4.set(var9, var7);
               } else {
                  MapMakerInternalMap$ReferenceEntry var10 = var7;
                  int var11 = var9;

                  MapMakerInternalMap$ReferenceEntry var12;
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
                     MapMakerInternalMap$ReferenceEntry var14 = (MapMakerInternalMap$ReferenceEntry)var4.get(var13);
                     MapMakerInternalMap$ReferenceEntry var15 = this.copyEntry(var12, var14);
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
         this.preWriteCleanup();
         AtomicReferenceArray var5 = this.table;
         int var6 = var2 & var5.length() - 1;
         MapMakerInternalMap$ReferenceEntry var7 = (MapMakerInternalMap$ReferenceEntry)var5.get(var6);

         for(MapMakerInternalMap$ReferenceEntry var8 = var7; var8 != null; var8 = var8.getNext()) {
            Object var9 = var8.getKey();
            if(var8.getHash() == var2 && var9 != null && this.map.keyEquivalence.equivalent(var1, var9)) {
               MapMakerInternalMap$ValueReference var10 = var8.getValueReference();
               Object var11 = var10.get();
               boolean var12;
               if(var11 == null) {
                  if(this.isCollected(var10)) {
                     int var18 = this.count - 1;
                     ++this.modCount;
                     this.enqueueNotification(var9, var2, var11, MapMaker$RemovalCause.COLLECTED);
                     MapMakerInternalMap$ReferenceEntry var13 = this.removeFromChain(var7, var8);
                     var18 = this.count - 1;
                     var5.set(var6, var13);
                     this.count = var18;
                  }

                  var12 = false;
                  return var12;
               }

               if(!this.map.valueEquivalence.equivalent(var3, var11)) {
                  this.recordLockedRead(var8);
                  var12 = false;
                  return var12;
               }

               ++this.modCount;
               this.enqueueNotification(var1, var2, var11, MapMaker$RemovalCause.REPLACED);
               this.setValue(var8, var4);
               var12 = true;
               return var12;
            }
         }

         boolean var17 = false;
         return var17;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   Object replace(Object var1, int var2, Object var3) {
      this.lock();

      MapMakerInternalMap$ReferenceEntry var7;
      try {
         this.preWriteCleanup();
         AtomicReferenceArray var4 = this.table;
         int var5 = var2 & var4.length() - 1;
         MapMakerInternalMap$ReferenceEntry var6 = (MapMakerInternalMap$ReferenceEntry)var4.get(var5);

         for(var7 = var6; var7 != null; var7 = var7.getNext()) {
            Object var8 = var7.getKey();
            if(var7.getHash() == var2 && var8 != null && this.map.keyEquivalence.equivalent(var1, var8)) {
               MapMakerInternalMap$ValueReference var9 = var7.getValueReference();
               Object var10 = var9.get();
               Object var11;
               if(var10 == null) {
                  if(this.isCollected(var9)) {
                     int var16 = this.count - 1;
                     ++this.modCount;
                     this.enqueueNotification(var8, var2, var10, MapMaker$RemovalCause.COLLECTED);
                     MapMakerInternalMap$ReferenceEntry var12 = this.removeFromChain(var6, var7);
                     var16 = this.count - 1;
                     var4.set(var5, var12);
                     this.count = var16;
                  }

                  var11 = null;
                  return var11;
               }

               ++this.modCount;
               this.enqueueNotification(var1, var2, var10, MapMaker$RemovalCause.REPLACED);
               this.setValue(var7, var3);
               var11 = var10;
               return var11;
            }
         }

         var7 = null;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }

      return var7;
   }

   Object remove(Object var1, int var2) {
      this.lock();

      MapMakerInternalMap$ReferenceEntry var7;
      try {
         this.preWriteCleanup();
         int var3 = this.count - 1;
         AtomicReferenceArray var4 = this.table;
         int var5 = var2 & var4.length() - 1;
         MapMakerInternalMap$ReferenceEntry var6 = (MapMakerInternalMap$ReferenceEntry)var4.get(var5);

         for(var7 = var6; var7 != null; var7 = var7.getNext()) {
            Object var8 = var7.getKey();
            if(var7.getHash() == var2 && var8 != null && this.map.keyEquivalence.equivalent(var1, var8)) {
               MapMakerInternalMap$ValueReference var9 = var7.getValueReference();
               Object var10 = var9.get();
               MapMaker$RemovalCause var11;
               MapMakerInternalMap$ReferenceEntry var12;
               if(var10 != null) {
                  var11 = MapMaker$RemovalCause.EXPLICIT;
               } else {
                  if(!this.isCollected(var9)) {
                     var12 = null;
                     return var12;
                  }

                  var11 = MapMaker$RemovalCause.COLLECTED;
               }

               ++this.modCount;
               this.enqueueNotification(var8, var2, var10, var11);
               var12 = this.removeFromChain(var6, var7);
               var3 = this.count - 1;
               var4.set(var5, var12);
               this.count = var3;
               Object var13 = var10;
               return var13;
            }
         }

         var7 = null;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }

      return var7;
   }

   boolean remove(Object var1, int var2, Object var3) {
      this.lock();

      try {
         this.preWriteCleanup();
         int var4 = this.count - 1;
         AtomicReferenceArray var5 = this.table;
         int var6 = var2 & var5.length() - 1;
         MapMakerInternalMap$ReferenceEntry var7 = (MapMakerInternalMap$ReferenceEntry)var5.get(var6);

         for(MapMakerInternalMap$ReferenceEntry var8 = var7; var8 != null; var8 = var8.getNext()) {
            Object var9 = var8.getKey();
            if(var8.getHash() == var2 && var9 != null && this.map.keyEquivalence.equivalent(var1, var9)) {
               MapMakerInternalMap$ValueReference var10 = var8.getValueReference();
               Object var11 = var10.get();
               MapMaker$RemovalCause var12;
               if(this.map.valueEquivalence.equivalent(var3, var11)) {
                  var12 = MapMaker$RemovalCause.EXPLICIT;
               } else {
                  if(!this.isCollected(var10)) {
                     boolean var19 = false;
                     return var19;
                  }

                  var12 = MapMaker$RemovalCause.COLLECTED;
               }

               ++this.modCount;
               this.enqueueNotification(var9, var2, var11, var12);
               MapMakerInternalMap$ReferenceEntry var13 = this.removeFromChain(var7, var8);
               var4 = this.count - 1;
               var5.set(var6, var13);
               this.count = var4;
               boolean var14 = var12 == MapMaker$RemovalCause.EXPLICIT;
               return var14;
            }
         }

         boolean var18 = false;
         return var18;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   void clear() {
      if(this.count != 0) {
         this.lock();

         try {
            AtomicReferenceArray var1 = this.table;
            int var2;
            if(this.map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
               for(var2 = 0; var2 < var1.length(); ++var2) {
                  for(MapMakerInternalMap$ReferenceEntry var3 = (MapMakerInternalMap$ReferenceEntry)var1.get(var2); var3 != null; var3 = var3.getNext()) {
                     if(!var3.getValueReference().isComputingReference()) {
                        this.enqueueNotification(var3, MapMaker$RemovalCause.EXPLICIT);
                     }
                  }
               }
            }

            for(var2 = 0; var2 < var1.length(); ++var2) {
               var1.set(var2, (Object)null);
            }

            this.clearReferenceQueues();
            this.evictionQueue.clear();
            this.expirationQueue.clear();
            this.readCount.set(0);
            ++this.modCount;
            this.count = 0;
         } finally {
            this.unlock();
            this.postWriteCleanup();
         }
      }

   }

   @GuardedBy("this")
   MapMakerInternalMap$ReferenceEntry removeFromChain(MapMakerInternalMap$ReferenceEntry var1, MapMakerInternalMap$ReferenceEntry var2) {
      this.evictionQueue.remove(var2);
      this.expirationQueue.remove(var2);
      int var3 = this.count;
      MapMakerInternalMap$ReferenceEntry var4 = var2.getNext();

      for(MapMakerInternalMap$ReferenceEntry var5 = var1; var5 != var2; var5 = var5.getNext()) {
         MapMakerInternalMap$ReferenceEntry var6 = this.copyEntry(var5, var4);
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

   void removeCollectedEntry(MapMakerInternalMap$ReferenceEntry var1) {
      this.enqueueNotification(var1, MapMaker$RemovalCause.COLLECTED);
      this.evictionQueue.remove(var1);
      this.expirationQueue.remove(var1);
   }

   boolean reclaimKey(MapMakerInternalMap$ReferenceEntry var1, int var2) {
      this.lock();

      try {
         int var3 = this.count - 1;
         AtomicReferenceArray var4 = this.table;
         int var5 = var2 & var4.length() - 1;
         MapMakerInternalMap$ReferenceEntry var6 = (MapMakerInternalMap$ReferenceEntry)var4.get(var5);

         for(MapMakerInternalMap$ReferenceEntry var7 = var6; var7 != null; var7 = var7.getNext()) {
            if(var7 == var1) {
               ++this.modCount;
               this.enqueueNotification(var7.getKey(), var2, var7.getValueReference().get(), MapMaker$RemovalCause.COLLECTED);
               MapMakerInternalMap$ReferenceEntry var8 = this.removeFromChain(var6, var7);
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

   boolean reclaimValue(Object var1, int var2, MapMakerInternalMap$ValueReference var3) {
      this.lock();

      try {
         int var4 = this.count - 1;
         AtomicReferenceArray var5 = this.table;
         int var6 = var2 & var5.length() - 1;
         MapMakerInternalMap$ReferenceEntry var7 = (MapMakerInternalMap$ReferenceEntry)var5.get(var6);

         for(MapMakerInternalMap$ReferenceEntry var8 = var7; var8 != null; var8 = var8.getNext()) {
            Object var9 = var8.getKey();
            if(var8.getHash() == var2 && var9 != null && this.map.keyEquivalence.equivalent(var1, var9)) {
               MapMakerInternalMap$ValueReference var10 = var8.getValueReference();
               if(var10 != var3) {
                  boolean var17 = false;
                  return var17;
               }

               ++this.modCount;
               this.enqueueNotification(var1, var2, var3.get(), MapMaker$RemovalCause.COLLECTED);
               MapMakerInternalMap$ReferenceEntry var11 = this.removeFromChain(var7, var8);
               var4 = this.count - 1;
               var5.set(var6, var11);
               this.count = var4;
               boolean var12 = true;
               return var12;
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

   boolean clearValue(Object var1, int var2, MapMakerInternalMap$ValueReference var3) {
      this.lock();

      try {
         AtomicReferenceArray var4 = this.table;
         int var5 = var2 & var4.length() - 1;
         MapMakerInternalMap$ReferenceEntry var6 = (MapMakerInternalMap$ReferenceEntry)var4.get(var5);

         for(MapMakerInternalMap$ReferenceEntry var7 = var6; var7 != null; var7 = var7.getNext()) {
            Object var8 = var7.getKey();
            if(var7.getHash() == var2 && var8 != null && this.map.keyEquivalence.equivalent(var1, var8)) {
               MapMakerInternalMap$ValueReference var9 = var7.getValueReference();
               if(var9 != var3) {
                  boolean var15 = false;
                  return var15;
               }

               MapMakerInternalMap$ReferenceEntry var10 = this.removeFromChain(var6, var7);
               var4.set(var5, var10);
               boolean var11 = true;
               return var11;
            }
         }

         boolean var16 = false;
         return var16;
      } finally {
         this.unlock();
         this.postWriteCleanup();
      }
   }

   @GuardedBy("this")
   boolean removeEntry(MapMakerInternalMap$ReferenceEntry var1, int var2, MapMaker$RemovalCause var3) {
      int var4 = this.count - 1;
      AtomicReferenceArray var5 = this.table;
      int var6 = var2 & var5.length() - 1;
      MapMakerInternalMap$ReferenceEntry var7 = (MapMakerInternalMap$ReferenceEntry)var5.get(var6);

      for(MapMakerInternalMap$ReferenceEntry var8 = var7; var8 != null; var8 = var8.getNext()) {
         if(var8 == var1) {
            ++this.modCount;
            this.enqueueNotification(var8.getKey(), var2, var8.getValueReference().get(), var3);
            MapMakerInternalMap$ReferenceEntry var9 = this.removeFromChain(var7, var8);
            var4 = this.count - 1;
            var5.set(var6, var9);
            this.count = var4;
            return true;
         }
      }

      return false;
   }

   boolean isCollected(MapMakerInternalMap$ValueReference var1) {
      return var1.isComputingReference()?false:var1.get() == null;
   }

   Object getLiveValue(MapMakerInternalMap$ReferenceEntry var1) {
      if(var1.getKey() == null) {
         this.tryDrainReferenceQueues();
         return null;
      } else {
         Object var2 = var1.getValueReference().get();
         if(var2 == null) {
            this.tryDrainReferenceQueues();
            return null;
         } else if(this.map.expires() && this.map.isExpired(var1)) {
            this.tryExpireEntries();
            return null;
         } else {
            return var2;
         }
      }
   }

   void postReadCleanup() {
      if((this.readCount.incrementAndGet() & 63) == 0) {
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
      if(this.tryLock()) {
         try {
            this.drainReferenceQueues();
            this.expireEntries();
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
