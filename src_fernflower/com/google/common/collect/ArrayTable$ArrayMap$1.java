package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ArrayTable$ArrayMap$1$1;
import java.util.Map.Entry;

class ArrayTable$ArrayMap$1 extends AbstractIndexedListIterator {
   // $FF: synthetic field
   final ArrayTable$ArrayMap this$0;

   ArrayTable$ArrayMap$1(ArrayTable$ArrayMap var1, int var2) {
      super(var2);
      this.this$0 = var1;
   }

   protected Entry get(int var1) {
      return new ArrayTable$ArrayMap$1$1(this, var1);
   }
}
