package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;

final class Iterators$12 extends AbstractIndexedListIterator {
   // $FF: synthetic field
   final Object[] val$array;
   // $FF: synthetic field
   final int val$offset;

   Iterators$12(int var1, int var2, Object[] var3, int var4) {
      super(var1, var2);
      this.val$array = var3;
      this.val$offset = var4;
   }

   protected Object get(int var1) {
      return this.val$array[this.val$offset + var1];
   }
}
