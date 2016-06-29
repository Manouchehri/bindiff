package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import java.util.BitSet;

final class CharMatcher$Is extends CharMatcher$FastMatcher {
   private final char match;

   CharMatcher$Is(char var1) {
      this.match = var1;
   }

   public boolean matches(char var1) {
      return var1 == this.match;
   }

   public String replaceFrom(CharSequence var1, char var2) {
      return var1.toString().replace(this.match, var2);
   }

   public CharMatcher and(CharMatcher var1) {
      return (CharMatcher)(var1.matches(this.match)?this:none());
   }

   public CharMatcher or(CharMatcher var1) {
      return var1.matches(this.match)?var1:super.or(var1);
   }

   public CharMatcher negate() {
      return isNot(this.match);
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      var1.set(this.match);
   }

   public String toString() {
      String var1 = CharMatcher.access$100(this.match);
      return (new StringBuilder(18 + String.valueOf(var1).length())).append("CharMatcher.is(\'").append(var1).append("\')").toString();
   }
}
