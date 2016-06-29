package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;

final class ComputingConcurrentHashMap$ComputationExceptionReference implements MapMakerInternalMap$ValueReference {
   final Throwable t;

   ComputingConcurrentHashMap$ComputationExceptionReference(Throwable var1) {
      this.t = var1;
   }

   public Object get() {
      return null;
   }

   public MapMakerInternalMap$ReferenceEntry getEntry() {
      return null;
   }

   public MapMakerInternalMap$ValueReference copyFor(ReferenceQueue var1, Object var2, MapMakerInternalMap$ReferenceEntry var3) {
      return this;
   }

   public boolean isComputingReference() {
      return false;
   }

   public Object waitForValue() {
      throw new ExecutionException(this.t);
   }

   public void clear(MapMakerInternalMap$ValueReference var1) {
   }
}
