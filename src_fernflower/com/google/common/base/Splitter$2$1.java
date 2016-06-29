package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$2;
import com.google.common.base.Splitter$SplittingIterator;

class Splitter$2$1 extends Splitter$SplittingIterator {
   // $FF: synthetic field
   final Splitter$2 this$0;

   Splitter$2$1(Splitter$2 var1, Splitter var2, CharSequence var3) {
      super(var2, var3);
      this.this$0 = var1;
   }

   public int separatorStart(int var1) {
      int var2 = this.this$0.val$separator.length();
      int var3 = var1;

      label24:
      for(int var4 = this.toSplit.length() - var2; var3 <= var4; ++var3) {
         for(int var5 = 0; var5 < var2; ++var5) {
            if(this.toSplit.charAt(var5 + var3) != this.this$0.val$separator.charAt(var5)) {
               continue label24;
            }
         }

         return var3;
      }

      return -1;
   }

   public int separatorEnd(int var1) {
      return var1 + this.this$0.val$separator.length();
   }
}
