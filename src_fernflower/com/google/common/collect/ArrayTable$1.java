package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1$1;
import com.google.common.collect.Table$Cell;

class ArrayTable$1 extends AbstractIndexedListIterator {
   // $FF: synthetic field
   final ArrayTable this$0;

   ArrayTable$1(ArrayTable var1, int var2) {
      super(var2);
      this.this$0 = var1;
   }

   protected Table$Cell get(int var1) {
      return new ArrayTable$1$1(this, var1);
   }
}
