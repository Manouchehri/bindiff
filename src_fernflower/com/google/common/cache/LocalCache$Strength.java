package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$ValueReference;

enum LocalCache$Strength {
   STRONG,
   SOFT,
   WEAK;

   private LocalCache$Strength() {
   }

   abstract LocalCache$ValueReference referenceValue(LocalCache$Segment var1, LocalCache$ReferenceEntry var2, Object var3, int var4);

   abstract Equivalence defaultEquivalence();

   // $FF: synthetic method
   LocalCache$Strength(LocalCache$1 var3) {
      this();
   }
}
