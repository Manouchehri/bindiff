package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$Negated;

class CharMatcher$NegatedFastMatcher extends CharMatcher$Negated {
   CharMatcher$NegatedFastMatcher(CharMatcher var1) {
      super(var1);
   }

   public final CharMatcher precomputed() {
      return this;
   }
}
