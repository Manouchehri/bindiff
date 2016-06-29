package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;

final class Splitter$1 implements Splitter$Strategy {
   // $FF: synthetic field
   final CharMatcher val$separatorMatcher;

   Splitter$1(CharMatcher var1) {
      this.val$separatorMatcher = var1;
   }

   public Splitter$SplittingIterator iterator(Splitter var1, CharSequence var2) {
      return new Splitter$1$1(this, var1, var2);
   }
}
