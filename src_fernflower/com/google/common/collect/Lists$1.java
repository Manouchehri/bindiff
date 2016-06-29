package com.google.common.collect;

import com.google.common.collect.Lists$RandomAccessListWrapper;
import java.util.List;
import java.util.ListIterator;

final class Lists$1 extends Lists$RandomAccessListWrapper {
   private static final long serialVersionUID = 0L;

   Lists$1(List var1) {
      super(var1);
   }

   public ListIterator listIterator(int var1) {
      return this.backingList.listIterator(var1);
   }
}
