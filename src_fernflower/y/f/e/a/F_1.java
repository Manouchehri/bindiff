package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

final class F implements ax {
   public k a(m var1, l var2, a var3) {
      boolean var22 = af.b;
      m var4 = var1.l();
      if(var4 != null && !var4.n()) {
         k var5 = var1.a();
         k var6 = var4.a();
         double var7 = var6.d() - var5.d();
         double var9 = var6.e() - var5.e();
         double var11 = var6.f() - var5.f();
         double var13 = Math.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
         double var15 = var13 - var4.i() * 0.5D;
         if(var15 < 0.001D) {
            return var3;
         }

         double var17 = var4.i() * 0.5D;
         byte var19 = 1;
         if(var17 == 0.0D) {
            var17 = 0.001D;
         }

         double var20;
         switch(var19) {
         case 1:
            var20 = var15 / (var17 * var13);
            if(!var22) {
               break;
            }
         case 2:
            var20 = var15 * var15 / (var17 * var17 * var13);
            if(!var22) {
               break;
            }
         default:
            var20 = c.a(var15 / var17, var19) / var13;
         }

         if(var4.h() > var4.i()) {
            var20 *= Math.sqrt(var4.h() / var4.i());
         }

         var3.b(var7 * var20, var9 * var20, var11 * var20);
      }

      return var3;
   }
}
