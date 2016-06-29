package y.f.e.a;

import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.z;

final class B implements am {
   private final z a;

   B(z var1) {
      this.a = var1;
   }

   public void a(l var1, af var2) {
      boolean var30 = af.b;
      y.f.b.c var3 = this.a.a;
      if(var3 != null) {
         y.c.p var4 = this.a.b.l();

         while(var4 != null) {
            label32: {
               y.c.q var5 = (y.c.q)var4.c();
               if(var3.d(var5) && !var2.a(var5).n()) {
                  y.c.y var6 = var3.b(var5);
                  double var7 = Double.MAX_VALUE;
                  double var9 = Double.MAX_VALUE;
                  double var11 = Double.MAX_VALUE;
                  double var13 = -1.7976931348623157E308D;
                  double var15 = -1.7976931348623157E308D;
                  double var17 = -1.7976931348623157E308D;
                  y.c.p var19 = var6.k();

                  while(var19 != null) {
                     y.c.q var20 = (y.c.q)var19.c();
                     m var21 = var2.a(var20);
                     double var22 = var21.b();
                     double var24 = var21.c();
                     double var26 = var21.d();
                     double var28 = var21.h();
                     var7 = Math.min(var7, var22 - var28);
                     var13 = Math.max(var13, var22 + var28);
                     var9 = Math.min(var9, var24 - var28);
                     var15 = Math.max(var15, var24 + var28);
                     var11 = Math.min(var11, var26 - var28);
                     var17 = Math.max(var17, var26 + var28);
                     var19 = var19.a();
                     if(var30) {
                        break label32;
                     }

                     if(var30) {
                        break;
                     }
                  }

                  ag var31 = var2.c(var5);
                  double var32 = (var13 - var7) / 2.0D;
                  var32 = Math.max(var32, (var15 - var9) / 2.0D);
                  var32 = Math.max(var32, (var17 - var11) / 2.0D);
                  var32 = Math.max(50.0D, var32);
                  var31.f(var31.h() * 0.4D + var32 * 0.6D);
               }

               var4 = var4.b();
            }

            if(var30) {
               break;
            }
         }
      }

   }
}
