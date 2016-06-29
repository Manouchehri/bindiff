package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$FastMatcher;
import java.util.BitSet;

final class CharMatcher$IsEither extends CharMatcher$FastMatcher {
   private final char match1;
   private final char match2;

   CharMatcher$IsEither(char var1, char var2) {
      this.match1 = var1;
      this.match2 = var2;
   }

   public boolean matches(char var1) {
      return var1 == this.match1 || var1 == this.match2;
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      var1.set(this.match1);
      var1.set(this.match2);
   }

   public String toString() {
      String var1 = CharMatcher.access$100(this.match1);
      String var2 = CharMatcher.access$100(this.match2);
      return (new StringBuilder(21 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("CharMatcher.anyOf(\"").append(var1).append(var2).append("\")").toString();
   }
}
