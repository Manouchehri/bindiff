package y.f;

import y.f.I;
import y.f.P;
import y.f.X;
import y.f.a;
import y.f.aE;
import y.f.aF;
import y.f.ad;
import y.f.ah;

public class aw extends a implements ad {
   protected double a = 0.2D;

   public aw() {
      super((ah)null);
   }

   public void c(X var1) {
      ah var2 = this.a();
      if(var2 != null) {
         var2.c(var1);
      }

      this.b(var1);
   }

   protected void b(X var1) {
      boolean var31 = X.j;
      y.c.c var4 = var1.c(P.a);
      y.c.c var5 = var1.c(P.b);
      y.c.c var6 = var1.c(aF.a);
      y.c.c var7 = var1.c(aF.b);
      y.c.e var8 = var1.p();

      while(var8.f()) {
         y.c.d var9 = var8.a();
         I var10 = var1.b(var9);
         P var11 = null;
         if(var4 != null && !this.a(var6, var9)) {
            var11 = (P)var4.b(var9);
         }

         y.d.t var13;
         y.d.t var25;
         y.d.t var26;
         double var27;
         if(var11 != null) {
            y.c.q var12;
            label78: {
               var12 = var9.c();
               if(var10.pointCount() > 0) {
                  var13 = var10.getPoint(0);
                  if(!var31) {
                     break label78;
                  }
               }

               var13 = var1.q(var9);
            }

            y.d.t var14 = var1.p(var9);
            double var15 = var14.a;
            double var17 = var14.b;
            double var19 = var15 - var13.a;
            double var21 = var17 - var13.b;
            double var23 = Math.sqrt(var19 * var19 + var21 * var21);
            if(var23 > 0.001D) {
               var19 /= var23;
               var21 /= var23;
               var25 = var1.l(var12);
               var26 = var11.a(var1.a((Object)var12), var15 - var25.a, var17 - var25.b, var19, var21);
               if(var26 != null && !this.a(var25.a + var26.a, var25.b + var26.b, var15, var17)) {
                  var27 = var21 * (var25.a + var26.a - var13.a) - var19 * (var25.b + var26.b - var13.b);
                  if(Math.abs(var27) > 0.001D) {
                     label90: {
                        var10.addPoint(var14.a, var14.b);
                        int var29 = var10.pointCount() - 1;

                        while(var29 > 0) {
                           y.d.t var30 = var10.getPoint(var29 - 1);
                           var10.setPoint(var29, var30.a, var30.b);
                           --var29;
                           if(var31) {
                              break label90;
                           }

                           if(var31) {
                              break;
                           }
                        }

                        var10.setPoint(0, var14.a, var14.b);
                     }
                  }

                  var1.a(var9, var26);
               }
            }
         }

         var11 = null;
         if(var5 != null && !this.a(var7, var9)) {
            var11 = (P)var5.b(var9);
         }

         if(var11 != null) {
            y.d.t var32;
            label54: {
               if(var10.pointCount() > 0) {
                  var32 = var10.getPoint(var10.pointCount() - 1);
                  if(!var31) {
                     break label54;
                  }
               }

               var32 = var1.p(var9);
            }

            var13 = var1.q(var9);
            double var33 = var13.a;
            double var16 = var13.b;
            double var18 = var33 - var32.a;
            double var20 = var16 - var32.b;
            double var22 = Math.sqrt(var18 * var18 + var20 * var20);
            if(var22 > 0.001D) {
               var18 /= var22;
               var20 /= var22;
               y.c.q var24 = var9.d();
               var25 = var1.l(var24);
               var26 = var11.a(var1.a((Object)var24), var33 - var25.a, var16 - var25.b, var18, var20);
               if(var26 != null && !this.a(var25.a + var26.a, var25.b + var26.b, var33, var16)) {
                  var27 = var20 * (var25.a + var26.a - var32.a) - var18 * (var25.b + var26.b - var32.b);
                  if(Math.abs(var27) > 0.001D) {
                     var10.addPoint(var13.a, var13.b);
                  }

                  var1.b(var9, var26);
               }
            }
         }

         var8.g();
         if(var31) {
            break;
         }
      }

   }

   protected boolean a(double var1, double var3, double var5, double var7) {
      return Math.abs(var1 - var5) < this.a && Math.abs(var3 - var7) < this.a;
   }

   boolean a(y.c.c var1, y.c.d var2) {
      return var1 != null && var1.b(var2) instanceof aE?((aE)var1.b(var2)).a():false;
   }
}
