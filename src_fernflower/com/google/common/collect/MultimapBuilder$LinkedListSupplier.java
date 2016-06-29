package com.google.common.collect;

import com.google.common.base.Supplier;
import java.util.LinkedList;
import java.util.List;

enum MultimapBuilder$LinkedListSupplier implements Supplier {
   INSTANCE;

   public static Supplier instance() {
      MultimapBuilder$LinkedListSupplier var0 = INSTANCE;
      return var0;
   }

   public List get() {
      return new LinkedList();
   }
}
