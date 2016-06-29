package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import java.util.Arrays;
import java.util.BitSet;

final class CharMatcher$AnyOf extends CharMatcher {
   private final char[] chars;

   public CharMatcher$AnyOf(CharSequence var1) {
      this.chars = var1.toString().toCharArray();
      Arrays.sort(this.chars);
   }

   public boolean matches(char var1) {
      return Arrays.binarySearch(this.chars, var1) >= 0;
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      char[] var2 = this.chars;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         char var5 = var2[var4];
         var1.set(var5);
      }

   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("CharMatcher.anyOf(\"");
      char[] var2 = this.chars;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         char var5 = var2[var4];
         var1.append(CharMatcher.access$100(var5));
      }

      var1.append("\")");
      return var1.toString();
   }
}
