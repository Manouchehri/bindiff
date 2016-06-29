package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$StrongValueReference;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.cache.LocalCache$WeightedStrongValueReference;

enum LocalCache$Strength$1 {
   LocalCache$ValueReference referenceValue(LocalCache$Segment var1, LocalCache$ReferenceEntry var2, Object var3, int var4) {
      return (LocalCache$ValueReference)(var4 == 1?new LocalCache$StrongValueReference(var3):new LocalCache$WeightedStrongValueReference(var3, var4));
   }

   Equivalence defaultEquivalence() {
      return Equivalence.equals();
   }
}
