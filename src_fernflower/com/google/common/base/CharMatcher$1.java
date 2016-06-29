package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NegatedFastMatcher;

class CharMatcher$1 extends CharMatcher$NegatedFastMatcher {
   // $FF: synthetic field
   final String val$description;
   // $FF: synthetic field
   final CharMatcher this$0;

   CharMatcher$1(CharMatcher var1, CharMatcher var2, String var3) {
      super(var2);
      this.this$0 = var1;
      this.val$description = var3;
   }

   public String toString() {
      return this.val$description;
   }
}
