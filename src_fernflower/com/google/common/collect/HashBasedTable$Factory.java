package com.google.common.collect;

import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Map;

class HashBasedTable$Factory implements Supplier, Serializable {
   final int expectedSize;
   private static final long serialVersionUID = 0L;

   HashBasedTable$Factory(int var1) {
      this.expectedSize = var1;
   }

   public Map get() {
      return Maps.newHashMapWithExpectedSize(this.expectedSize);
   }
}
