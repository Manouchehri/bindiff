package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$4$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;

final class Splitter$4 implements Splitter$Strategy {
   // $FF: synthetic field
   final int val$length;

   Splitter$4(int var1) {
      this.val$length = var1;
   }

   public Splitter$SplittingIterator iterator(Splitter var1, CharSequence var2) {
      return new Splitter$4$1(this, var1, var2);
   }
}
