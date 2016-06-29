package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ComputingConcurrentHashMap$ComputingValueReference;
import com.google.common.collect.MapMaker$RemovalCause;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

final class ComputingConcurrentHashMap$ComputingSegment extends MapMakerInternalMap$Segment {
   ComputingConcurrentHashMap$ComputingSegment(MapMakerInternalMap var1, int var2, int var3) {
      super(var1, var2, var3);
   }

   Object getOrCompute(Object var1, int var2, Function var3) {
      try {
         MapMakerInternalMap$ReferenceEntry var4;
         Object var5;
         Object var24;
         do {
            var4 = this.getEntry(var1, var2);
            if(var4 != null) {
               var5 = this.getLiveValue(var4);
               if(var5 != null) {
                  this.recordRead(var4);
                  var24 = var5;
                  return var24;
               }
            }

            if(var4 == null || !var4.getValueReference().isComputingReference()) {
               boolean var23 = true;
               ComputingConcurrentHashMap$ComputingValueReference var6 = null;
               this.lock();

               try {
                  this.preWriteCleanup();
                  int var7 = this.count - 1;
                  AtomicReferenceArray var8 = this.table;
                  int var9 = var2 & var8.length() - 1;
                  MapMakerInternalMap$ReferenceEntry var10 = (MapMakerInternalMap$ReferenceEntry)var8.get(var9);

                  for(var4 = var10; var4 != null; var4 = var4.getNext()) {
                     Object var11 = var4.getKey();
                     if(var4.getHash() == var2 && var11 != null && this.map.keyEquivalence.equivalent(var1, var11)) {
                        MapMakerInternalMap$ValueReference var12 = var4.getValueReference();
                        if(var12.isComputingReference()) {
                           var23 = false;
                           break;
                        }

                        Object var13 = var4.getValueReference().get();
                        if(var13 == null) {
                           this.enqueueNotification(var11, var2, var13, MapMaker$RemovalCause.COLLECTED);
                        } else {
                           if(!this.map.expires() || !this.map.isExpired(var4)) {
                              this.recordLockedRead(var4);
                              Object var14 = var13;
                              return var14;
                           }

                           this.enqueueNotification(var11, var2, var13, MapMaker$RemovalCause.EXPIRED);
                        }

                        this.evictionQueue.remove(var4);
                        this.expirationQueue.remove(var4);
                        this.count = var7;
                        break;
                     }
                  }

                  if(var23) {
                     var6 = new ComputingConcurrentHashMap$ComputingValueReference(var3);
                     if(var4 == null) {
                        var4 = this.newEntry(var1, var2, var10);
                        var4.setValueReference(var6);
                        var8.set(var9, var4);
                     } else {
                        var4.setValueReference(var6);
                     }
                  }
               } finally {
                  this.unlock();
                  this.postWriteCleanup();
               }

               if(var23) {
                  Object var25 = this.compute(var1, var2, var4, var6);
                  return var25;
               }
            }

            Preconditions.checkState(!Thread.holdsLock(var4), "Recursive computation");
            var5 = var4.getValueReference().waitForValue();
         } while(var5 == null);

         this.recordRead(var4);
         var24 = var5;
         return var24;
      } finally {
         this.postReadCleanup();
      }
   }

   Object compute(Object var1, int var2, MapMakerInternalMap$ReferenceEntry var3, ComputingConcurrentHashMap$ComputingValueReference var4) {
      Object var5 = null;
      long var6 = System.nanoTime();
      long var8 = 0L;

      Object var10;
      try {
         synchronized(var3) {
            var5 = var4.compute(var1, var2);
            var8 = System.nanoTime();
         }

         if(var5 != null) {
            var10 = this.put(var1, var2, var5, true);
            if(var10 != null) {
               this.enqueueNotification(var1, var2, var5, MapMaker$RemovalCause.REPLACED);
            }
         }

         var10 = var5;
      } finally {
         if(var8 == 0L) {
            var8 = System.nanoTime();
         }

         if(var5 == null) {
            this.clearValue(var1, var2, var4);
         }

      }

      return var10;
   }
}
