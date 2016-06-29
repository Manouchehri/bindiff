package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.c;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;

class ar implements ax {
   private int a = 2;

   public void a(int var1) {
      this.a = var1;
   }

   public k a(m var1, l var2, a var3) {
      boolean var29 = af.b;
      y.c.q var4 = var1.j();
      k var5 = var1.a();
      w var6 = var2.b();
      double var7 = var1.h();
      y.c.x var9 = var6.f().o();

      while(var9.f()) {
         y.c.q var10 = var9.e();
         if(var10 != var4) {
            m var11 = var6.a(var10);
            if(!var11.n()) {
               k var12 = var11.a();
               double var13 = var5.d() - var12.d();
               double var15 = var5.e() - var12.e();
               double var17 = var5.f() - var12.f();
               double var19 = Math.sqrt(var13 * var13 + var15 * var15 + var17 * var17);
               if(var19 != 0.0D) {
                  double var21 = var11.h();
                  double var23 = Math.max(var19 - (var7 + var21), 0.001D);
                  double var25 = var2.g();
                  double var27;
                  switch(this.a) {
                  case 1:
                     var27 = var25 / (var23 * var19);
                     if(!var29) {
                        break;
                     }
                  case 2:
                     var27 = var25 * var25 / (var23 * var23 * var19);
                     if(!var29) {
                        break;
                     }
                  default:
                     var27 = c.a(var25 / var23, this.a) / var19;
                  }

                  var3.a(var13 * var27, var15 * var27, var17 * var27);
               }
            }
         }

         var9.g();
         if(var29) {
            break;
         }
      }

      return var3;
   }
}
