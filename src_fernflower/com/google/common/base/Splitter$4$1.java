package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$4;
import com.google.common.base.Splitter$SplittingIterator;

class Splitter$4$1 extends Splitter$SplittingIterator {
   // $FF: synthetic field
   final Splitter$4 this$0;

   Splitter$4$1(Splitter$4 var1, Splitter var2, CharSequence var3) {
      super(var2, var3);
      this.this$0 = var1;
   }

   public int separatorStart(int var1) {
      int var2 = var1 + this.this$0.val$length;
      return var2 < this.toSplit.length()?var2:-1;
   }

   public int separatorEnd(int var1) {
      return var1;
   }
}
