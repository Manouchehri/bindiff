package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

final class CharMatcher$InRange extends CharMatcher$FastMatcher {
   private final char startInclusive;
   private final char endInclusive;

   CharMatcher$InRange(char var1, char var2) {
      Preconditions.checkArgument(var2 >= var1);
      this.startInclusive = var1;
      this.endInclusive = var2;
   }

   public boolean matches(char var1) {
      return this.startInclusive <= var1 && var1 <= this.endInclusive;
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      var1.set(this.startInclusive, this.endInclusive + 1);
   }

   public String toString() {
      String var1 = CharMatcher.access$100(this.startInclusive);
      String var2 = CharMatcher.access$100(this.endInclusive);
      return (new StringBuilder(27 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("CharMatcher.inRange(\'").append(var1).append("\', \'").append(var2).append("\')").toString();
   }
}
