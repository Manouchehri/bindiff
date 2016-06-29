package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;

final class Range$2 implements Function {
   public Cut apply(Range var1) {
      return var1.upperBound;
   }
}
