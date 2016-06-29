package org.ibex.nestedvm.util;

import org.ibex.nestedvm.util.Sort$1;
import org.ibex.nestedvm.util.Sort$Comparable;
import org.ibex.nestedvm.util.Sort$CompareFunc;

public final class Sort {
   private static final Sort$CompareFunc comparableCompareFunc = new Sort$1();

   public static void sort(Sort$Comparable[] var0) {
      sort(var0, comparableCompareFunc);
   }

   public static void sort(Object[] var0, Sort$CompareFunc var1) {
      sort(var0, var1, 0, var0.length - 1);
   }

   private static void sort(Object[] var0, Sort$CompareFunc var1, int var2, int var3) {
      if(var2 < var3) {
         Object var4;
         int var6;
         if(var3 - var2 <= 6) {
            for(int var8 = var2 + 1; var8 <= var3; ++var8) {
               var4 = var0[var8];

               for(var6 = var8 - 1; var6 >= var2 && var1.compare(var0[var6], var4) > 0; --var6) {
                  var0[var6 + 1] = var0[var6];
               }

               var0[var6 + 1] = var4;
            }

         } else {
            Object var5 = var0[var3];
            var6 = var2 - 1;
            int var7 = var3;

            do {
               while(var6 < var7) {
                  ++var6;
                  if(var1.compare(var0[var6], var5) >= 0) {
                     break;
                  }
               }

               while(var7 > var6) {
                  --var7;
                  if(var1.compare(var0[var7], var5) <= 0) {
                     break;
                  }
               }

               var4 = var0[var6];
               var0[var6] = var0[var7];
               var0[var7] = var4;
            } while(var6 < var7);

            var4 = var0[var6];
            var0[var6] = var0[var3];
            var0[var3] = var4;
            sort(var0, var1, var2, var6 - 1);
            sort(var0, var1, var6 + 1, var3);
         }
      }
   }
}
