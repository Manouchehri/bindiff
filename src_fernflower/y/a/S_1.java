package y.a;

import y.a.T;
import y.a.U;
import y.a.Y;
import y.a.h;

abstract class S {
   abstract double a(y.c.d[] var1, y.c.c var2, int var3);

   static S a() {
      return new Y(0.2D, 0.4D, 0.4D);
   }

   static S b() {
      return new U((T)null);
   }

   private static int[] b(y.c.i var0, y.c.c var1, int var2) {
      boolean var5 = h.a;
      int[] var3 = new int[var2];
      y.c.x var4 = var0.o();

      int[] var10000;
      while(true) {
         if(var4.f()) {
            var10000 = var3;
            if(var5) {
               break;
            }

            ++var3[var1.a(var4.e())];
            var4.g();
            if(!var5) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   private static double[][] c(y.c.d[] var0, y.c.c var1, int var2) {
      boolean var6 = h.a;
      double[][] var3 = new double[2][var2];
      int var4 = 0;

      while(var4 < var0.length) {
         label17: {
            y.c.d var5 = var0[var4];
            if(var1.a(var5.c()) == var1.a(var5.d())) {
               ++var3[0][var1.a(var5.c())];
               if(!var6) {
                  break label17;
               }
            }

            ++var3[1][var1.a(var5.c())];
            ++var3[1][var1.a(var5.d())];
         }

         ++var4;
         if(var6) {
            break;
         }
      }

      return var3;
   }

   static double[][] b(y.c.d[] var0, y.c.c var1, int var2) {
      return c(var0, var1, var2);
   }

   static int[] a(y.c.i var0, y.c.c var1, int var2) {
      return b(var0, var1, var2);
   }
}
