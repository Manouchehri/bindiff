package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class MapMakerInternalMap$1 implements MapMakerInternalMap$ValueReference {
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
      return false;
   }

   public Object waitForValue() {
      return null;
   }

   public void clear(MapMakerInternalMap$ValueReference var1) {
   }
}
