package com.google.common.primitives;

import java.util.Comparator;

enum Doubles$LexicographicalComparator implements Comparator {
   INSTANCE;

   public int compare(double[] var1, double[] var2) {
      int var3 = Math.min(var1.length, var2.length);

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = Double.compare(var1[var4], var2[var4]);
         if(var5 != 0) {
            return var5;
         }
      }

      return var1.length - var2.length;
   }
}
