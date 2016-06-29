package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Set;

final class MultimapBuilder$LinkedHashSetSupplier implements Supplier, Serializable {
   private final int expectedValuesPerKey;

   MultimapBuilder$LinkedHashSetSupplier(int var1) {
      this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(var1, "expectedValuesPerKey");
   }

   public Set get() {
      return Sets.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
   }
}
