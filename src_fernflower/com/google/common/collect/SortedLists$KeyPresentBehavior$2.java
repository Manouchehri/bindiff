package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

enum SortedLists$KeyPresentBehavior$2 {
   int resultIndex(Comparator var1, Object var2, List var3, int var4) {
      int var5 = var4;
      int var6 = var3.size() - 1;

      while(var5 < var6) {
         int var7 = var5 + var6 + 1 >>> 1;
         int var8 = var1.compare(var3.get(var7), var2);
         if(var8 > 0) {
            var6 = var7 - 1;
         } else {
            var5 = var7;
         }
      }

      return var5;
   }
}
