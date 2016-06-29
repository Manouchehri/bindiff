package y.a;

import y.a.S;
import y.a.T;
import y.a.h;

class W extends S {
   private W() {
   }

   double a(y.c.d[] var1, y.c.c var2, int var3) {
      boolean var10 = h.a;
      if(var1.length == 0) {
         return -0.5D;
      } else {
         double var4 = 0.0D;
         double[][] var6 = S.b(var1, var2, var3);
         int var7 = 0;

         double var10000;
         while(true) {
            if(var7 < var3) {
               var4 += var6[0][var7] / (double)var1.length;
               double var8 = var6[0][var7] + var6[1][var7];
               var10000 = var4 - var8 * var8 / (4.0D * (double)var1.length * (double)var1.length);
               if(var10) {
                  break;
               }

               var4 = var10000;
               ++var7;
               if(!var10) {
                  continue;
               }
            }

            var10000 = var4;
            break;
         }

         return var10000;
      }
   }

   W(T var1) {
      this();
   }
}
