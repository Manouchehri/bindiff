package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$3;
import com.google.common.base.Splitter$SplittingIterator;
import java.util.regex.Matcher;

class Splitter$3$1 extends Splitter$SplittingIterator {
   // $FF: synthetic field
   final Matcher val$matcher;
   // $FF: synthetic field
   final Splitter$3 this$0;

   Splitter$3$1(Splitter$3 var1, Splitter var2, CharSequence var3, Matcher var4) {
      super(var2, var3);
      this.this$0 = var1;
      this.val$matcher = var4;
   }

   public int separatorStart(int var1) {
      return this.val$matcher.find(var1)?this.val$matcher.start():-1;
   }

   public int separatorEnd(int var1) {
      return this.val$matcher.end();
   }
}
