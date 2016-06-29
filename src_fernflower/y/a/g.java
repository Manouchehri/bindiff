package y.a;

import y.a.A;
import y.a.h;
import y.a.m;

public final class g {
   public static boolean a(y.c.i var0) {
      return m.a(var0, new int[var0.f()]);
   }

   public static boolean b(y.c.i var0) {
      return !a(var0);
   }

   public static boolean c(y.c.i var0) {
      return h.c(var0);
   }

   public static boolean d(y.c.i var0) {
      return A.b(var0);
   }

   public static boolean e(y.c.i var0) {
      boolean var2 = h.a;
      y.c.e var1 = var0.p();

      boolean var10000;
      while(true) {
         if(var1.f()) {
            var10000 = var1.a().e();
            if(var2) {
               break;
            }

            if(var10000) {
               return false;
            }

            var1.g();
            if(!var2) {
               continue;
            }
         }

         var10000 = true;
         break;
      }

      return var10000;
   }
}
