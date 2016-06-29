package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.ComputingConcurrentHashMap$ComputationExceptionReference;
import com.google.common.collect.ComputingConcurrentHashMap$ComputedReference;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ComputingConcurrentHashMap$ComputingValueReference implements MapMakerInternalMap$ValueReference {
   final Function computingFunction;
   @GuardedBy("this")
   volatile MapMakerInternalMap$ValueReference computedReference = MapMakerInternalMap.unset();

   public ComputingConcurrentHashMap$ComputingValueReference(Function var1) {
      this.computingFunction = var1;
   }

   public Object get() {
      return null;
   }

   public MapMakerInternalMap$ReferenceEntry getEntry() {
      return null;
   }

   public MapMakerInternalMap$ValueReference copyFor(ReferenceQueue var1, @Nullable Object var2, MapMakerInternalMap$ReferenceEntry var3) {
      return this;
   }

   public boolean isComputingReference() {
      return true;
   }

   public Object waitForValue() {
      if(this.computedReference == MapMakerInternalMap.UNSET) {
         boolean var1 = false;

         try {
            synchronized(this) {
               while(this.computedReference == MapMakerInternalMap.UNSET) {
                  try {
                     this.wait();
                  } catch (InterruptedException var9) {
                     var1 = true;
                  }
               }
            }
         } finally {
            if(var1) {
               Thread.currentThread().interrupt();
            }

         }
      }

      return this.computedReference.waitForValue();
   }

   public void clear(MapMakerInternalMap$ValueReference var1) {
      this.setValueReference(var1);
   }

   Object compute(Object var1, int var2) {
      Object var3;
      try {
         var3 = this.computingFunction.apply(var1);
      } catch (Throwable var5) {
         this.setValueReference(new ComputingConcurrentHashMap$ComputationExceptionReference(var5));
         throw new ExecutionException(var5);
      }

      this.setValueReference(new ComputingConcurrentHashMap$ComputedReference(var3));
      return var3;
   }

   void setValueReference(MapMakerInternalMap$ValueReference var1) {
      synchronized(this) {
         if(this.computedReference == MapMakerInternalMap.UNSET) {
            this.computedReference = var1;
            this.notifyAll();
         }

      }
   }
}
