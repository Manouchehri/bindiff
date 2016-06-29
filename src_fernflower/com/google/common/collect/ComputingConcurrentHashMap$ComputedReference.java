package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class ComputingConcurrentHashMap$ComputedReference implements MapMakerInternalMap$ValueReference {
   final Object value;

   ComputingConcurrentHashMap$ComputedReference(@Nullable Object var1) {
      this.value = var1;
   }

   public Object get() {
      return this.value;
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
      return this.get();
   }

   public void clear(MapMakerInternalMap$ValueReference var1) {
   }
}
