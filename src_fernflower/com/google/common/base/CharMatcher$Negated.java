package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

class CharMatcher$Negated extends CharMatcher {
   final CharMatcher original;

   CharMatcher$Negated(CharMatcher var1) {
      this.original = (CharMatcher)Preconditions.checkNotNull(var1);
   }

   public boolean matches(char var1) {
      return !this.original.matches(var1);
   }

   public boolean matchesAllOf(CharSequence var1) {
      return this.original.matchesNoneOf(var1);
   }

   public boolean matchesNoneOf(CharSequence var1) {
      return this.original.matchesAllOf(var1);
   }

   public int countIn(CharSequence var1) {
      return var1.length() - this.original.countIn(var1);
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      BitSet var2 = new BitSet();
      this.original.setBits(var2);
      var2.flip(0, 65536);
      var1.or(var2);
   }

   public CharMatcher negate() {
      return this.original;
   }

   public String toString() {
      String var1 = String.valueOf(this.original);
      return (new StringBuilder(9 + String.valueOf(var1).length())).append(var1).append(".negate()").toString();
   }
}
