package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheLoader;
import java.io.Serializable;

final class CacheLoader$SupplierToCacheLoader extends CacheLoader implements Serializable {
   private final Supplier computingSupplier;
   private static final long serialVersionUID = 0L;

   public CacheLoader$SupplierToCacheLoader(Supplier var1) {
      this.computingSupplier = (Supplier)Preconditions.checkNotNull(var1);
   }

   public Object load(Object var1) {
      Preconditions.checkNotNull(var1);
      return this.computingSupplier.get();
   }
}
