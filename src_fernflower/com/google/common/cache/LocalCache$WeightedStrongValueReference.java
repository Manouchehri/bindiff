package com.google.common.cache;

import com.google.common.cache.LocalCache$StrongValueReference;

final class LocalCache$WeightedStrongValueReference extends LocalCache$StrongValueReference {
   final int weight;

   LocalCache$WeightedStrongValueReference(Object var1, int var2) {
      super(var1);
      this.weight = var2;
   }

   public int getWeight() {
      return this.weight;
   }
}
