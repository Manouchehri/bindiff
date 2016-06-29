package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Lists$TwoPlusArrayList extends AbstractList implements Serializable, RandomAccess {
   final Object first;
   final Object second;
   final Object[] rest;
   private static final long serialVersionUID = 0L;

   Lists$TwoPlusArrayList(@Nullable Object var1, @Nullable Object var2, Object[] var3) {
      this.first = var1;
      this.second = var2;
      this.rest = (Object[])Preconditions.checkNotNull(var3);
   }

   public int size() {
      return this.rest.length + 2;
   }

   public Object get(int var1) {
      switch(var1) {
      case 0:
         return this.first;
      case 1:
         return this.second;
      default:
         Preconditions.checkElementIndex(var1, this.size());
         return this.rest[var1 - 2];
      }
   }
}
