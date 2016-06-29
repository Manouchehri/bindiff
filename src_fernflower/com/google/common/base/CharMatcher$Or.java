package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

final class CharMatcher$Or extends CharMatcher {
   final CharMatcher first;
   final CharMatcher second;

   CharMatcher$Or(CharMatcher var1, CharMatcher var2) {
      this.first = (CharMatcher)Preconditions.checkNotNull(var1);
      this.second = (CharMatcher)Preconditions.checkNotNull(var2);
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      this.first.setBits(var1);
      this.second.setBits(var1);
   }

   public boolean matches(char var1) {
      return this.first.matches(var1) || this.second.matches(var1);
   }

   public String toString() {
      String var1 = String.valueOf(this.first);
      String var2 = String.valueOf(this.second);
      return (new StringBuilder(18 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("CharMatcher.or(").append(var1).append(", ").append(var2).append(")").toString();
   }
}
