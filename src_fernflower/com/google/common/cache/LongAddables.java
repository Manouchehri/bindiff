package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.common.cache.LongAddable;
import com.google.common.cache.LongAddables$1;
import com.google.common.cache.LongAddables$2;
import com.google.common.cache.LongAdder;

@GwtCompatible(
   emulated = true
)
final class LongAddables {
   private static final Supplier SUPPLIER;

   public static LongAddable create() {
      return (LongAddable)SUPPLIER.get();
   }

   static {
      Object var0;
      try {
         new LongAdder();
         var0 = new LongAddables$1();
      } catch (Throwable var2) {
         var0 = new LongAddables$2();
      }

      SUPPLIER = (Supplier)var0;
   }
}
