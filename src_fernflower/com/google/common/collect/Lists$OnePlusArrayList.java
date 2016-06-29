package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import javax.annotation.Nullable;

class Lists$OnePlusArrayList extends AbstractList implements Serializable, RandomAccess {
   final Object first;
   final Object[] rest;
   private static final long serialVersionUID = 0L;

   Lists$OnePlusArrayList(@Nullable Object var1, Object[] var2) {
      this.first = var1;
      this.rest = (Object[])Preconditions.checkNotNull(var2);
   }

   public int size() {
      return this.rest.length + 1;
   }

   public Object get(int var1) {
      Preconditions.checkElementIndex(var1, this.size());
      return var1 == 0?this.first:this.rest[var1 - 1];
   }
}
