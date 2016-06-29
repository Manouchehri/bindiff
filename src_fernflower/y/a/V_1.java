package y.a;

import y.a.S;
import y.a.T;
import y.a.h;

class V extends S {
   private V() {
   }

   double a(y.c.d[] var1, y.c.c var2, int var3) {
      boolean var10 = h.a;
      if(var1.length == 0) {
         return 0.0D;
      } else {
         y.c.i var4 = var1[0].c().e();
         double var5 = b().a(var1, var2, var3);
         int[] var7 = S.a(var4, var2, var3);
         int var8 = 0;
         int var9 = 0;

         while(var9 < var7.length) {
            if(var7[var9] > 0) {
               var8 += var7[var9] * (var7[var9] - 1);
            }

            ++var9;
            if(var10) {
               break;
            }
         }

         return 1.0D - 2.0D / (double)(var4.e() * (var4.e() - 1)) * ((1.0D - 2.0D * var5 / (double)var1.length) * (double)var1.length + 0.5D * (double)var8);
      }
   }

   V(T var1) {
      this();
   }
}
