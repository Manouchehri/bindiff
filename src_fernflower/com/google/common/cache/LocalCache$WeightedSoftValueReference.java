package com.google.common.cache;

import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$SoftValueReference;
import com.google.common.cache.LocalCache$ValueReference;
import java.lang.ref.ReferenceQueue;

final class LocalCache$WeightedSoftValueReference extends LocalCache$SoftValueReference {
   final int weight;

   LocalCache$WeightedSoftValueReference(ReferenceQueue var1, Object var2, LocalCache$ReferenceEntry var3, int var4) {
      super(var1, var2, var3);
      this.weight = var4;
   }

   public int getWeight() {
      return this.weight;
   }

   public LocalCache$ValueReference copyFor(ReferenceQueue var1, Object var2, LocalCache$ReferenceEntry var3) {
      return new LocalCache$WeightedSoftValueReference(var1, var2, var3, this.weight);
   }
}
