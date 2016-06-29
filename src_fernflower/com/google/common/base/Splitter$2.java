package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$2$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;

final class Splitter$2 implements Splitter$Strategy {
   // $FF: synthetic field
   final String val$separator;

   Splitter$2(String var1) {
      this.val$separator = var1;
   }

   public Splitter$SplittingIterator iterator(Splitter var1, CharSequence var2) {
      return new Splitter$2$1(this, var1, var2);
   }
}
