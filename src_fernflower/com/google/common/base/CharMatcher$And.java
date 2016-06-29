package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.BitSet;

final class CharMatcher$And extends CharMatcher {
   final CharMatcher first;
   final CharMatcher second;

   CharMatcher$And(CharMatcher var1, CharMatcher var2) {
      this.first = (CharMatcher)Preconditions.checkNotNull(var1);
      this.second = (CharMatcher)Preconditions.checkNotNull(var2);
   }

   public boolean matches(char var1) {
      return this.first.matches(var1) && this.second.matches(var1);
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      BitSet var2 = new BitSet();
      this.first.setBits(var2);
      BitSet var3 = new BitSet();
      this.second.setBits(var3);
      var2.and(var3);
      var1.or(var2);
   }

   public String toString() {
      String var1 = String.valueOf(this.first);
      String var2 = String.valueOf(this.second);
      return (new StringBuilder(19 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("CharMatcher.and(").append(var1).append(", ").append(var2).append(")").toString();
   }
}
