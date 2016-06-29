package y.f.e.a;

import java.awt.geom.Rectangle2D.Double;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;
import y.f.e.a.w;

public class aj implements ax {
   private double a = 50.0D;
   private boolean b = false;

   public void a(boolean var1) {
      this.b = var1;
   }

   public void a(double var1) {
      this.a = var1;
   }

   public k a(m var1, l var2, a var3) {
      boolean var77 = af.b;
      y.c.q var4 = var1.j();
      w var5 = var2.b();
      k var12 = var1.a();
      double var6 = var12.d();
      double var8 = var12.e();
      double var10 = var12.f();
      double var78 = this.a * 5.0D;
      Double var14 = new Double(var6 - var78, var8 - var78, 2.0D * var78, 2.0D * var78);
      double var15 = 0.0D;
      double var17 = 0.0D;
      double var19 = 0.0D;
      y.c.x var21 = var2.b().f().o();

      while(true) {
         if(var21.f()) {
            y.c.q var22 = var21.e();
            if(var77) {
               break;
            }

            y.c.q var10000 = var22;
            y.c.q var10001 = var4;

            label55:
            while(var10000 != var10001 && var22.f() != null) {
               k var35 = var5.a(var22).a();
               double var29;
               double var23 = var6 - (var29 = var35.d());
               double var31;
               double var25 = var8 - (var31 = var35.e());
               double var33;
               double var27 = var10 - (var33 = var35.f());
               double var79 = Math.max(Math.sqrt(var23 * var23 + var25 * var25 + var27 * var27), 0.001D);
               double var37 = 1.0D / var79;
               y.c.d var39 = var22.f();

               while(true) {
                  if(var39 == null) {
                     break label55;
                  }

                  var10000 = var4;
                  var10001 = var39.d();
                  if(var77) {
                     break;
                  }

                  if(var4 != var10001) {
                     double var40 = var5.a(var39).a();
                     double var42 = this.a + var1.h();
                     double var44 = Math.sqrt(var42 * var42 + var40 * var40);
                     k var46 = var5.a(var39.d()).a();
                     if(!this.b || var14.intersectsLine(var29, var31, var46.d(), var46.e())) {
                        double var47 = var46.d() - var29;
                        double var49 = var46.e() - var31;
                        double var51 = var46.f() - var33;
                        double var53 = Math.sqrt(var47 * var47 + var49 * var49 + var51 * var51);
                        if(var53 >= 0.001D) {
                           double var55 = 1.0D / var53;
                           double var57 = (var23 * var47 + var25 * var49 + var27 * var51) * var55;
                           double var65 = -var57 * var55;
                           double var59 = var23 + var65 * var47;
                           double var61 = var25 + var65 * var49;
                           double var63 = var27 + var65 * var51;
                           var65 = var59 * var59 + var61 * var61 + var63 * var63;
                           if(var65 < 0.001D) {
                              var65 = 0.001D;
                           }

                           double var67 = -var57;
                           double var69 = var67 + var53;
                           double var71 = 1.0D / Math.sqrt(var69 * var69 + var65);
                           double var73 = (var71 - var37) * var55 * var44;
                           double var75 = (var69 * var71 - var67 * var37) * var44 / var65;
                           var15 += var47 * var73 + var59 * var75;
                           var17 += var49 * var73 + var61 * var75;
                           var19 += var51 * var73 + var63 * var75;
                        }
                     }
                  }

                  var39 = var39.g();
                  if(var77) {
                     break label55;
                  }
               }
            }

            var21.g();
            if(!var77) {
               continue;
            }
         }

         var3.b(var15, var17, var19);
         break;
      }

      return var3;
   }
}
