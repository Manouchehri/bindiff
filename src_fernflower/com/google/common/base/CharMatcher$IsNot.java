package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import java.util.BitSet;

final class CharMatcher$IsNot extends CharMatcher$FastMatcher {
   private final char match;

   CharMatcher$IsNot(char var1) {
      this.match = var1;
   }

   public boolean matches(char var1) {
      return var1 != this.match;
   }

   public CharMatcher and(CharMatcher var1) {
      return var1.matches(this.match)?super.and(var1):var1;
   }

   public CharMatcher or(CharMatcher var1) {
      return (CharMatcher)(var1.matches(this.match)?any():this);
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      var1.set(0, this.match);
      var1.set(this.match + 1, 65536);
   }

   public CharMatcher negate() {
      return is(this.match);
   }

   public String toString() {
      String var1 = CharMatcher.access$100(this.match);
      return (new StringBuilder(21 + String.valueOf(var1).length())).append("CharMatcher.isNot(\'").append(var1).append("\')").toString();
   }
}
