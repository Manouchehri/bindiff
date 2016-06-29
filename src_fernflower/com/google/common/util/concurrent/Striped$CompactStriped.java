package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$1;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;

class Striped$CompactStriped extends Striped$PowerOfTwoStriped {
   private final Object[] array;

   private Striped$CompactStriped(int var1, Supplier var2) {
      super(var1);
      Preconditions.checkArgument(var1 <= 1073741824, "Stripes must be <= 2^30)");
      this.array = new Object[this.mask + 1];

      for(int var3 = 0; var3 < this.array.length; ++var3) {
         this.array[var3] = var2.get();
      }

   }

   public Object getAt(int var1) {
      return this.array[var1];
   }

   public int size() {
      return this.array.length;
   }

   // $FF: synthetic method
   Striped$CompactStriped(int var1, Supplier var2, Striped$1 var3) {
      this(var1, var2);
   }
}
