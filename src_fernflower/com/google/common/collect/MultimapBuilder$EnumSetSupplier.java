package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;

final class MultimapBuilder$EnumSetSupplier implements Supplier, Serializable {
   private final Class clazz;

   MultimapBuilder$EnumSetSupplier(Class var1) {
      this.clazz = (Class)Preconditions.checkNotNull(var1);
   }

   public Set get() {
      return EnumSet.noneOf(this.clazz);
   }
}
