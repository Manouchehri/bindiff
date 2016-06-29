package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Striped;
import com.google.common.util.concurrent.Striped$1;

abstract class Striped$PowerOfTwoStriped extends Striped {
   final int mask;

   Striped$PowerOfTwoStriped(int var1) {
      super((Striped$1)null);
      Preconditions.checkArgument(var1 > 0, "Stripes must be positive");
      this.mask = var1 > 1073741824?-1:Striped.access$200(var1) - 1;
   }

   final int indexFor(Object var1) {
      int var2 = Striped.access$300(var1.hashCode());
      return var2 & this.mask;
   }

   public final Object get(Object var1) {
      return this.getAt(this.indexFor(var1));
   }
}
