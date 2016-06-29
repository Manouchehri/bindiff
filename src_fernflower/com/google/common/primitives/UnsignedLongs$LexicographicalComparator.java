package com.google.common.primitives;

import com.google.common.primitives.UnsignedLongs;
import java.util.Comparator;

enum UnsignedLongs$LexicographicalComparator implements Comparator {
   INSTANCE;

   public int compare(long[] var1, long[] var2) {
      int var3 = Math.min(var1.length, var2.length);

      for(int var4 = 0; var4 < var3; ++var4) {
         if(var1[var4] != var2[var4]) {
            return UnsignedLongs.compare(var1[var4], var2[var4]);
         }
      }

      return var1.length - var2.length;
   }
}
