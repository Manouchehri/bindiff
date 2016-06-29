package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;
import y.f.e.a.z;

final class A implements ax {
   private final z a;

   A(z var1) {
      this.a = var1;
   }

   public k a(m var1, l var2, a var3) {
      boolean var25 = af.b;
      y.f.b.c var4 = this.a.a;
      y.c.q var5 = var1.j();
      if(var4 != null && var4.d(var5)) {
         k var6 = var1.a();
         w var7 = var2.b();
         double var8 = var1.h();
         y.c.p var10 = var4.b(var5).k();

         while(var10 != null) {
            y.c.q var11 = (y.c.q)var10.c();
            m var12 = var7.a(var11);
            k var13 = var12.a();
            double var14 = var13.d() - var6.d();
            double var16 = var13.e() - var6.e();
            double var18 = var13.f() - var6.f();
            double var20 = Math.sqrt(var14 * var14 + var16 * var16 + var18 * var18);
            if(var20 >= 0.001D) {
               byte var22 = 1;
               if(var8 == 0.0D) {
                  var8 = 0.001D;
               }

               double var23;
               switch(var22) {
               case 1:
                  var23 = 1.0D / var8;
                  if(!var25) {
                     break;
                  }
               case 2:
                  var23 = var20 / (var8 * var8);
                  if(!var25) {
                     break;
                  }
               default:
                  var23 = c.a(var20 / var8, var22) / var20;
               }

               var3.a(var14 * var23, var16 * var23, var18 * var23);
            }

            var10 = var10.a();
            if(var25) {
               break;
            }
         }
      }

      return var3;
   }
}
