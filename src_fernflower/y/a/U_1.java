package y.a;

import y.a.S;
import y.a.T;
import y.a.h;

class U extends S {
   private U() {
   }

   double a(y.c.d[] var1, y.c.c var2, int var3) {
      boolean var7 = h.a;
      int var4 = 0;
      int var5 = 0;

      int var10000;
      while(true) {
         if(var5 < var1.length) {
            y.c.d var6 = var1[var5];
            var10000 = var2.a(var6.c());
            if(var7) {
               break;
            }

            if(var10000 == var2.a(var6.d())) {
               ++var4;
            }

            ++var5;
            if(!var7) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      return (double)var10000;
   }

   U(T var1) {
      this();
   }
}
