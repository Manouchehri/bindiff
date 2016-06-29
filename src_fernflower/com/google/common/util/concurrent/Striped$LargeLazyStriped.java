package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.MapMaker;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;
import java.util.concurrent.ConcurrentMap;

@VisibleForTesting
class Striped$LargeLazyStriped extends Striped$PowerOfTwoStriped {
   final ConcurrentMap locks;
   final Supplier supplier;
   final int size;

   Striped$LargeLazyStriped(int var1, Supplier var2) {
      super(var1);
      this.size = this.mask == -1?Integer.MAX_VALUE:this.mask + 1;
      this.supplier = var2;
      this.locks = (new MapMaker()).weakValues().makeMap();
   }

   public Object getAt(int var1) {
      if(this.size != Integer.MAX_VALUE) {
         Preconditions.checkElementIndex(var1, this.size());
      }

      Object var2 = this.locks.get(Integer.valueOf(var1));
      if(var2 != null) {
         return var2;
      } else {
         Object var3 = this.supplier.get();
         var2 = this.locks.putIfAbsent(Integer.valueOf(var1), var3);
         return MoreObjects.firstNonNull(var2, var3);
      }
   }

   public int size() {
      return this.size;
   }
}
