package y.f.e.a;

import y.f.e.a.af;
import y.f.e.a.ag;
import y.f.e.a.am;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.z;

final class C implements am {
   private final z a;

   C(z var1) {
      this.a = var1;
   }

   public void a(l var1, af var2) {
      boolean var37 = af.b;
      this.a.a = null;
      this.a.b = null;
      y.f.X var3 = var2.f();
      if(y.f.b.c.b((y.c.i)var3)) {
         y.f.b.c var4 = new y.f.b.c(var3);
         this.a.a = var4;
         y.c.x var5 = var3.o();

         while(true) {
            if(var5.f()) {
               y.c.q var6 = var5.e();
               ag var7 = var2.c(var6);
               if(var37) {
                  break;
               }

               if(var4.d(var6)) {
                  var7.b(true);
               }

               if(var4.a(var6) != var4.b()) {
                  var7.a(var2.a(var4.a(var6)));
               }

               var5.g();
               if(!var37) {
                  continue;
               }
            }

            this.a.b = var4.c(var4.b());
            break;
         }

         double var40 = var1.h() * 0.5D + var1.g() * 0.5D;
         y.c.p var41 = this.a.b.l();

         while(var41 != null) {
            label45: {
               y.c.q var8 = (y.c.q)var41.c();
               if(var4.d(var8) && !var2.a(var8).n()) {
                  double var9 = 0.0D;
                  y.c.y var11 = var4.b(var8);
                  double var12 = Double.MAX_VALUE;
                  double var14 = Double.MAX_VALUE;
                  double var16 = Double.MAX_VALUE;
                  double var18 = -1.7976931348623157E308D;
                  double var20 = -1.7976931348623157E308D;
                  double var22 = -1.7976931348623157E308D;
                  y.c.p var24 = var11.k();

                  double var29;
                  while(var24 != null) {
                     y.c.q var25 = (y.c.q)var24.c();
                     m var26 = var2.a(var25);
                     double var27 = var26.h();
                     var9 += var27 * var27 * 3.0D;
                     var29 = var26.b();
                     double var31 = var26.c();
                     double var33 = var26.d();
                     double var35 = var26.h();
                     var12 = Math.min(var12, var29 - var35);
                     var18 = Math.max(var18, var29 + var35);
                     var14 = Math.min(var14, var31 - var35);
                     var20 = Math.max(var20, var31 + var35);
                     var16 = Math.min(var16, var33 - var35);
                     var22 = Math.max(var22, var33 + var35);
                     var24 = var24.a();
                     if(var37) {
                        break label45;
                     }

                     if(var37) {
                        break;
                     }
                  }

                  double var38 = var9 / (double)(var11.size() + 1);
                  var38 = Math.sqrt(var38) + var40 * 0.9D;
                  var38 *= var38;
                  double var39 = Math.sqrt(var38 * (double)var11.size()) * 0.5D + var40;
                  ag var28 = var2.c(var8);
                  var28.e(var39 * 0.9D);
                  var29 = (var18 - var12) / 2.0D;
                  var29 = Math.max(var29, (var20 - var14) / 2.0D);
                  var29 = Math.max(var29, (var22 - var16) / 2.0D);
                  var29 = Math.max(50.0D, var29);
                  var28.f(var29);
               }

               var41 = var41.b();
            }

            if(var37) {
               break;
            }
         }

      }
   }
}
