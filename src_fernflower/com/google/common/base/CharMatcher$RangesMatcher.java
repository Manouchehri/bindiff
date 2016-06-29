package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.util.Arrays;

class CharMatcher$RangesMatcher extends CharMatcher {
   private final String description;
   private final char[] rangeStarts;
   private final char[] rangeEnds;

   CharMatcher$RangesMatcher(String var1, char[] var2, char[] var3) {
      this.description = var1;
      this.rangeStarts = var2;
      this.rangeEnds = var3;
      Preconditions.checkArgument(var2.length == var3.length);

      for(int var4 = 0; var4 < var2.length; ++var4) {
         Preconditions.checkArgument(var2[var4] <= var3[var4]);
         if(var4 + 1 < var2.length) {
            Preconditions.checkArgument(var3[var4] < var2[var4 + 1]);
         }
      }

   }

   public boolean matches(char var1) {
      int var2 = Arrays.binarySearch(this.rangeStarts, var1);
      if(var2 >= 0) {
         return true;
      } else {
         var2 = ~var2 - 1;
         return var2 >= 0 && var1 <= this.rangeEnds[var2];
      }
   }

   public String toString() {
      return this.description;
   }
}
