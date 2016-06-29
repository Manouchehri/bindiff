package y.f;

import y.f.X;

final class aV {
   private static boolean a(y.d.n var0) {
      return var0.g() == 0.0D && var0.i() == -1.0D || var0.g() == 0.0D && var0.i() == 1.0D || var0.g() == -1.0D && var0.i() == 0.0D || var0.g() == 1.0D && var0.i() == 0.0D;
   }

   private static y.d.y b(y.d.n var0) {
      boolean var9 = X.j;
      double var1;
      double var3;
      double var5;
      double var7;
      if(var0.g() == 0.0D && var0.i() == -1.0D) {
         var1 = var0.b();
         var3 = var0.c() - var0.f();
         var5 = var0.f();
         var7 = var0.e();
         if(!var9) {
            return new y.d.y(var1, var3, var7, var5);
         }
      }

      if(var0.g() == 0.0D && var0.i() == 1.0D) {
         var1 = var0.b() - var0.e();
         var3 = var0.c();
         var5 = var0.f();
         var7 = var0.e();
         if(!var9) {
            return new y.d.y(var1, var3, var7, var5);
         }
      }

      if(var0.g() == 1.0D && var0.i() == 0.0D) {
         var1 = var0.b();
         var3 = var0.c();
         var5 = var0.e();
         var7 = var0.f();
         if(!var9) {
            return new y.d.y(var1, var3, var7, var5);
         }
      }

      if(var0.g() != -1.0D || var0.i() != 0.0D) {
         return null;
      } else {
         var1 = var0.b() - var0.e();
         var3 = var0.c() - var0.f();
         var5 = var0.e();
         var7 = var0.f();
         if(var9) {
            return null;
         } else {
            return new y.d.y(var1, var3, var7, var5);
         }
      }
   }

   static double a(y.d.y var0, y.d.n var1) {
      return a(var1)?a(var0, b(var1)):(y.d.n.a(var1, var0, 0.001D)?0.0D:a(var0, y.d.n.a(var1)));
   }

   static double a(y.d.y var0, y.d.y var1) {
      if(y.d.y.a(var0, var1)) {
         return 0.0D;
      } else {
         double var2 = a(var0, var1, false);
         double var4 = a(var0, var1, true);
         return Math.sqrt(var2 * var2 + var4 * var4);
      }
   }

   private static double a(y.d.y var0, y.d.y var1, boolean var2) {
      double var3 = var2?var0.c():var0.d();
      double var5 = var2?var0.c() + var0.a():var0.d() + var0.b();
      double var7 = var2?var1.c():var1.d();
      double var9 = var2?var1.c() + var1.a():var1.d() + var1.b();
      return a(var3, var5, var7, var9);
   }

   private static double a(double var0, double var2, double var4, double var6) {
      return var6 < var0?var6 - var0:(var2 < var4?var4 - var2:0.0D);
   }

   static double a(y.d.m var0, y.d.m var1) {
      if(y.d.m.a(var0, var1) != null) {
         return 0.0D;
      } else {
         double var2 = a(var0, var1.c());
         var2 = Math.min(var2, a(var0, var1.d()));
         var2 = Math.min(var2, a(var1, var0.c()));
         var2 = Math.min(var2, a(var1, var0.d()));
         return var2;
      }
   }

   private static double a(y.d.y var0, y.d.t[] var1) {
      boolean var12 = X.j;
      y.d.t var2 = var0.e();
      y.d.t var3 = new y.d.t(var2.a, var2.b + var0.b());
      y.d.t var4 = new y.d.t(var3.a + var0.a(), var3.b);
      y.d.t var5 = new y.d.t(var4.a, var2.b);
      y.d.m[] var6 = new y.d.m[]{new y.d.m(var2, var3), new y.d.m(var5, var4), new y.d.m(var2, var5), new y.d.m(var3, var4)};
      double var7 = Double.MAX_VALUE;
      int var9 = 0;

      while(var9 < var1.length) {
         y.d.m var10 = new y.d.m(var1[var9], var1[(var9 + 1) % var1.length]);
         int var11 = 0;

         while(true) {
            if(var11 < var6.length) {
               var7 = Math.min(var7, a(var10, var6[var11]));
               ++var11;
               if(var12) {
                  break;
               }

               if(!var12) {
                  continue;
               }
            }

            ++var9;
            break;
         }

         if(var12) {
            break;
         }
      }

      return var7;
   }

   static double a(y.d.m var0, y.d.t var1) {
      double var2 = var0.c().a;
      double var4 = var0.d().a;
      double var6 = var0.c().b;
      double var8 = var0.d().b;
      double var10 = var1.a();
      double var12 = var1.b();
      var4 -= var2;
      var8 -= var6;
      var10 -= var2;
      var12 -= var6;
      double var14 = 0.0D;
      double var16 = var10 * var4 + var12 * var8;
      if(var16 > 0.0D) {
         label16: {
            var10 = var4 - var10;
            var12 = var8 - var12;
            var16 = var10 * var4 + var12 * var8;
            if(var16 <= 0.0D) {
               var14 = 0.0D;
               if(!X.j) {
                  break label16;
               }
            }

            var14 = var16 * var16 / (var4 * var4 + var8 * var8);
         }
      }

      double var18 = var10 * var10 + var12 * var12 - var14;
      return var18 < 0.0D?0.0D:Math.sqrt(var18);
   }
}
