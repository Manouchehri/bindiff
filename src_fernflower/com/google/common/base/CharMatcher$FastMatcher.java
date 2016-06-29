package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NegatedFastMatcher;

abstract class CharMatcher$FastMatcher extends CharMatcher {
   public final CharMatcher precomputed() {
      return this;
   }

   public CharMatcher negate() {
      return new CharMatcher$NegatedFastMatcher(this);
   }
}
