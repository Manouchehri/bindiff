package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ImmutableList;

class ImmutableList$1 extends AbstractIndexedListIterator {
   // $FF: synthetic field
   final ImmutableList this$0;

   ImmutableList$1(ImmutableList var1, int var2, int var3) {
      super(var2, var3);
      this.this$0 = var1;
   }

   protected Object get(int var1) {
      return this.this$0.get(var1);
   }
}
