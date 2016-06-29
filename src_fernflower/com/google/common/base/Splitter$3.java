package com.google.common.base;

import com.google.common.base.Splitter;
import com.google.common.base.Splitter$3$1;
import com.google.common.base.Splitter$SplittingIterator;
import com.google.common.base.Splitter$Strategy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Splitter$3 implements Splitter$Strategy {
   // $FF: synthetic field
   final Pattern val$separatorPattern;

   Splitter$3(Pattern var1) {
      this.val$separatorPattern = var1;
   }

   public Splitter$SplittingIterator iterator(Splitter var1, CharSequence var2) {
      Matcher var3 = this.val$separatorPattern.matcher(var2);
      return new Splitter$3$1(this, var1, var2, var3);
   }
}
