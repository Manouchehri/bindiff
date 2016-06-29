package y.a;

import y.a.S;
import y.a.T;

class X extends S {
   private X() {
   }

   double a(y.c.d[] var1, y.c.c var2, int var3) {
      if(var1.length == 0) {
         return 0.0D;
      } else {
         double var4 = b().a(var1, var2, var3);
         return var4 / (double)var1.length;
      }
   }

   X(T var1) {
      this();
   }
}
