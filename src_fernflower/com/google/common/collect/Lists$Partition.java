package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.List;

class Lists$Partition extends AbstractList {
   final List list;
   final int size;

   Lists$Partition(List var1, int var2) {
      this.list = var1;
      this.size = var2;
   }

   public List get(int var1) {
      Preconditions.checkElementIndex(var1, this.size());
      int var2 = var1 * this.size;
      int var3 = Math.min(var2 + this.size, this.list.size());
      return this.list.subList(var2, var3);
   }

   public int size() {
      return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
   }

   public boolean isEmpty() {
      return this.list.isEmpty();
   }
}
