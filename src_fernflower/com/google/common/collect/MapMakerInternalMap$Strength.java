package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap$1;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$ValueReference;

enum MapMakerInternalMap$Strength {
   STRONG,
   SOFT,
   WEAK;

   private MapMakerInternalMap$Strength() {
   }

   abstract MapMakerInternalMap$ValueReference referenceValue(MapMakerInternalMap$Segment var1, MapMakerInternalMap$ReferenceEntry var2, Object var3);

   abstract Equivalence defaultEquivalence();

   // $FF: synthetic method
   MapMakerInternalMap$Strength(MapMakerInternalMap$1 var3) {
      this();
   }
}
