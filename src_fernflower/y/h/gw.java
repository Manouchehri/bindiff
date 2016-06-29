package y.h;

import java.util.ArrayList;
import java.util.List;
import y.h.fj;
import y.h.gu;
import y.h.gx;

public class gw implements y.f.al {
   private double a;

   public gw() {
      this(4.0D);
   }

   public gw(double var1) {
      this.a = var1;
   }

   public y.d.n a(y.d.q var1, y.f.am var2, Object var3) {
      gx var4 = (gx)var3;
      y.d.n var5 = new y.d.n(new y.d.t(0.0D, 0.0D), var1);
      var5.c(var4.g(), var4.h());
      y.d.y var6 = var5.h();
      double var7 = var6.a();
      double var9 = var6.b();
      double var11 = var2.getX() + var2.getWidth() * 0.5D + var2.getWidth() * var4.a - var4.c * var7 + var4.e;
      var11 -= var7 * 0.5D;
      double var13 = var2.getY() + var2.getHeight() * 0.5D + var2.getHeight() * var4.b - var4.d * var9 + var4.f;
      var13 -= var9 * 0.5D;
      var5.e(var11 + var7 * 0.5D, var13 + var9 * 0.5D);
      return var5;
   }

   public y.c.D a(y.f.aj var1, y.f.am var2) {
      boolean var10 = fj.z;
      y.c.D var3 = new y.c.D();
      y.d.n var4 = var1.getOrientedBox();
      y.d.q var5 = var4.d();
      List var6 = this.a(var4.g(), var4.i());
      int var7 = 0;

      y.c.D var10000;
      while(true) {
         if(var7 < var6.size()) {
            gx var8 = (gx)var6.get(var7);
            y.d.n var9 = this.a(var5, var2, var8);
            var10000 = var3;
            if(var10) {
               break;
            }

            var3.add(new y.f.ai(var9, var8, var1, false));
            ++var7;
            if(!var10) {
               continue;
            }
         }

         var10000 = var3;
         break;
      }

      return var10000;
   }

   public Object a(y.d.n var1, y.f.am var2) {
      boolean var35 = fj.z;
      if(gu.a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         y.d.y var3;
         y.d.y var4;
         double var5;
         double var7;
         double var9;
         label180: {
            var3 = var1.h();
            var4 = new y.d.y(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight());
            double var11 = var3.c();
            double var13 = var3.a();
            double var15 = var4.c();
            double var17 = var4.a();
            if(var11 + var13 < var15) {
               var5 = 0.5D;
               var7 = -0.5D;
               var9 = var11 + var13 - var15;
               if(!var35) {
                  break label180;
               }
            }

            if(var11 > var15 + var17) {
               var5 = -0.5D;
               var7 = 0.5D;
               var9 = var11 - (var15 + var17);
               if(!var35) {
                  break label180;
               }
            }

            if(var11 < var15 && var11 + var13 > var15 + var17) {
               var5 = 0.0D;
               var7 = (var11 + var13 * (0.5D + var5) - var15) / var17 - 0.5D;
               var9 = 0.0D;
               if(!var35) {
                  break label180;
               }
            }

            if(var11 < var15) {
               var5 = (var15 - var11) / var13 - 0.5D;
               var7 = -0.5D;
               var9 = 0.0D;
               if(!var35) {
                  break label180;
               }
            }

            if(var11 + var13 > var15 + var17) {
               var5 = (var15 + var17 - var11) / var13 - 0.5D;
               var7 = 0.5D;
               var9 = 0.0D;
               if(!var35) {
                  break label180;
               }
            }

            label199: {
               boolean var19 = var11 < var15 + var17 * 0.33D;
               boolean var20 = var11 + var13 > var15 + var17 * 0.66D;
               if(var19 && !var20 || var11 == var15) {
                  var5 = -0.5D;
                  if(!var35) {
                     break label199;
                  }
               }

               if(var20 && !var19 || var11 + var13 == var15 + var17) {
                  var5 = 0.5D;
                  if(!var35) {
                     break label199;
                  }
               }

               var5 = 0.0D;
            }

            var7 = (var11 + var13 * (0.5D + var5) - var15) / var17 - 0.5D;
            if(var11 - this.a == var15) {
               var5 = -0.5D;
               var7 = -0.5D;
               var9 = this.a;
               if(!var35) {
                  break label180;
               }
            }

            if(var11 + var13 + this.a == var15 + var17) {
               var5 = 0.5D;
               var7 = 0.5D;
               var9 = -this.a;
               if(!var35) {
                  break label180;
               }
            }

            var9 = 0.0D;
         }

         double var25 = var3.d();
         double var27 = var3.b();
         double var29 = var4.d();
         double var31 = var4.b();
         double var36;
         double var21;
         double var23;
         if(var25 + var27 < var29) {
            var36 = 0.5D;
            var21 = -0.5D;
            var23 = var25 + var27 - var29;
            if(!var35) {
               return new gx(var7, var21, var5, var36, var9, var23, var1.g(), var1.i());
            }
         }

         if(var25 > var29 + var31) {
            var36 = -0.5D;
            var21 = 0.5D;
            var23 = var25 - (var29 + var31);
            if(!var35) {
               return new gx(var7, var21, var5, var36, var9, var23, var1.g(), var1.i());
            }
         }

         if(var25 < var29 && var25 + var27 > var29 + var31) {
            var36 = 0.0D;
            var21 = (var25 + var27 * (0.5D + var36) - var29) / var31 - 0.5D;
            var23 = 0.0D;
            if(!var35) {
               return new gx(var7, var21, var5, var36, var9, var23, var1.g(), var1.i());
            }
         }

         if(var25 < var29) {
            var36 = (var29 - var25) / var27 - 0.5D;
            var21 = -0.5D;
            var23 = 0.0D;
            if(!var35) {
               return new gx(var7, var21, var5, var36, var9, var23, var1.g(), var1.i());
            }
         }

         if(var25 + var27 > var29 + var31) {
            var36 = (var29 + var31 - var25) / var27 - 0.5D;
            var21 = 0.5D;
            var23 = 0.0D;
            if(!var35) {
               return new gx(var7, var21, var5, var36, var9, var23, var1.g(), var1.i());
            }
         }

         label200: {
            boolean var33 = var25 < var29 + var31 * 0.33D;
            boolean var34 = var25 + var27 > var29 + var31 * 0.66D;
            if(var33 && !var34 || var25 == var29) {
               var36 = -0.5D;
               if(!var35) {
                  break label200;
               }
            }

            if(var34 && !var33 || var25 + var27 == var29 + var31) {
               var36 = 0.5D;
               if(!var35) {
                  break label200;
               }
            }

            var36 = 0.0D;
         }

         var21 = (var25 + var27 * (0.5D + var36) - var29) / var31 - 0.5D;
         if(var25 - this.a == var29) {
            var36 = -0.5D;
            var21 = -0.5D;
            var23 = this.a;
            if(!var35) {
               return new gx(var7, var21, var5, var36, var9, var23, var1.g(), var1.i());
            }
         }

         if(var25 + var27 + this.a == var29 + var31) {
            var36 = 0.5D;
            var21 = 0.5D;
            var23 = -this.a;
            if(!var35) {
               return new gx(var7, var21, var5, var36, var9, var23, var1.g(), var1.i());
            }
         }

         var23 = 0.0D;
         return new gx(var7, var21, var5, var36, var9, var23, var1.g(), var1.i());
      }
   }

   public double a() {
      return this.a;
   }

   private List a(double var1, double var3) {
      ArrayList var5 = new ArrayList();
      var5.add(new gx(0.0D, -0.5D, 0.0D, 0.5D, 0.0D, -this.a, var1, var3));
      var5.add(new gx(-0.5D, -0.5D, 0.5D, 0.5D, -this.a, -this.a, var1, var3));
      var5.add(new gx(0.5D, -0.5D, -0.5D, 0.5D, this.a, -this.a, var1, var3));
      var5.add(new gx(0.5D, 0.0D, -0.5D, 0.0D, this.a, 0.0D, var1, var3));
      var5.add(new gx(-0.5D, 0.0D, 0.5D, 0.0D, -this.a, 0.0D, var1, var3));
      var5.add(new gx(0.0D, 0.5D, 0.0D, -0.5D, 0.0D, this.a, var1, var3));
      var5.add(new gx(-0.5D, 0.5D, 0.5D, -0.5D, -this.a, this.a, var1, var3));
      var5.add(new gx(0.5D, 0.5D, -0.5D, -0.5D, this.a, this.a, var1, var3));
      var5.add(new gx(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, var1, var3));
      var5.add(new gx(0.0D, 0.5D, 0.0D, 0.5D, 0.0D, -this.a, var1, var3));
      var5.add(new gx(0.0D, -0.5D, 0.0D, -0.5D, 0.0D, this.a, var1, var3));
      var5.add(new gx(-0.5D, 0.0D, -0.5D, 0.0D, this.a, 0.0D, var1, var3));
      var5.add(new gx(0.5D, 0.0D, 0.5D, 0.0D, -this.a, 0.0D, var1, var3));
      var5.add(new gx(-0.5D, -0.5D, -0.5D, -0.5D, this.a, this.a, var1, var3));
      var5.add(new gx(0.5D, -0.5D, 0.5D, -0.5D, -this.a, this.a, var1, var3));
      var5.add(new gx(-0.5D, 0.5D, -0.5D, 0.5D, this.a, -this.a, var1, var3));
      var5.add(new gx(0.5D, 0.5D, 0.5D, 0.5D, -this.a, -this.a, var1, var3));
      return var5;
   }

   public Object c() {
      return new gx(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D, -1.0D);
   }

   public Object a(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15) {
      return new gx(var1, var3, var5, var7, var9, var11, var13, var15);
   }
}
