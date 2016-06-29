package y.g;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import y.g.av;
import y.g.aw;
import y.g.p;

class au {
   private static final Comparator a = new aw((av)null);

   static void a(List var0, Comparator var1) {
      boolean var6 = p.c;
      Object[] var2 = var0.toArray();
      b(var2, 0, var2.length, var1);
      ListIterator var3 = var0.listIterator();
      int var4 = 0;
      int var5 = var2.length;

      while(var4 < var5) {
         var3.next();
         var3.set(var2[var4]);
         ++var4;
         if(var6) {
            break;
         }
      }

   }

   static void a(Object[] var0, Comparator var1) {
      b(var0, 0, var0.length, var1);
   }

   static void a(Object[] var0, int var1, int var2, Comparator var3) {
      b(var0, var1, var2, var3);
   }

   private static void b(Object[] var0, int var1, int var2, Comparator var3) {
      a(var0, new Object[var2 - var1], var1, var2 - 1, -var1, var3 == null?a:var3);
   }

   private static void a(Object[] var0, Object[] var1, int var2, int var3, int var4, Comparator var5) {
      boolean var12 = p.c;
      int var6;
      int var7;
      int var9;
      if(var3 - var2 < 8) {
         var6 = var2 + 1;
         var7 = var3 + 1;

         do {
            int var10000 = var6;

            Object var8;
            label67:
            while(true) {
               if(var10000 >= var7) {
                  return;
               }

               var8 = var0[var6];
               var9 = var6;

               while(true) {
                  if(var9 <= var2) {
                     break label67;
                  }

                  var10000 = var5.compare(var0[var9 - 1], var8);
                  if(var12) {
                     break;
                  }

                  if(var10000 <= 0) {
                     break label67;
                  }

                  var0[var9] = var0[var9 - 1];
                  --var9;
                  if(var12) {
                     break label67;
                  }
               }
            }

            var0[var9] = var8;
            ++var6;
         } while(!var12);
      }

      var6 = (var2 + var3) / 2;
      a(var0, var1, var2, var6, var4, var5);
      a(var0, var1, var6 + 1, var3, var4, var5);
      if(var5.compare(var0[var6], var0[var6 + 1]) > 0) {
         System.arraycopy(var0, var2, var1, var4 + var2, var6 - var2 + 1);
         var7 = var6;

         label47: {
            while(var7 < var3) {
               var1[var4 + var3 + var6 - var7] = var0[var7 + 1];
               ++var7;
               if(var12) {
                  break label47;
               }

               if(var12) {
                  break;
               }
            }

            var7 = var4 + var2;
         }

         int var13 = var4 + var3;
         var9 = var4 + var6;
         int var10 = var2;
         int var11 = var3 + 1;

         while(var10 < var11) {
            var0[var10] = var7 <= var9 && var5.compare(var1[var7], var1[var13]) <= 0?var1[var7++]:var1[var13--];
            ++var10;
            if(var12) {
               break;
            }
         }
      }

   }
}
