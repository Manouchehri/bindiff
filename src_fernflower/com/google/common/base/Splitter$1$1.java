package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1;
import com.google.common.base.Splitter$SplittingIterator;

class Splitter$1$1 extends Splitter$SplittingIterator {
   // $FF: synthetic field
   final Splitter$1 this$0;

   Splitter$1$1(Splitter$1 var1, Splitter var2, CharSequence var3) {
      super(var2, var3);
      this.this$0 = var1;
   }

   int separatorStart(int var1) {
      return this.this$0.val$separatorMatcher.indexIn(this.toSplit, var1);
   }

   int separatorEnd(int var1) {
      return var1 + 1;
   }
}
