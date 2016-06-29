package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$StrongValueReference;
import com.google.common.collect.MapMakerInternalMap$ValueReference;

enum MapMakerInternalMap$Strength$1 {
   MapMakerInternalMap$ValueReference referenceValue(MapMakerInternalMap$Segment var1, MapMakerInternalMap$ReferenceEntry var2, Object var3) {
      return new MapMakerInternalMap$StrongValueReference(var3);
   }

   Equivalence defaultEquivalence() {
      return Equivalence.equals();
   }
}
