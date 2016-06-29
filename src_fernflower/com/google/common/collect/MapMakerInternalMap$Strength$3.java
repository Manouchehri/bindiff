package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$ValueReference;
import com.google.common.collect.MapMakerInternalMap$WeakValueReference;

enum MapMakerInternalMap$Strength$3 {
   MapMakerInternalMap$ValueReference referenceValue(MapMakerInternalMap$Segment var1, MapMakerInternalMap$ReferenceEntry var2, Object var3) {
      return new MapMakerInternalMap$WeakValueReference(var1.valueReferenceQueue, var3, var2);
   }

   Equivalence defaultEquivalence() {
      return Equivalence.identity();
   }
}
