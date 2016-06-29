package y.f.g;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.f.X;
import y.f.am;
import y.f.c.aj;
import y.f.c.a.N;
import y.f.c.a.Z;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aY;
import y.f.c.a.bK;
import y.f.g.B;
import y.f.g.D;
import y.f.g.F;
import y.f.g.d;
import y.g.I;
import y.g.M;

class A {
   private y.c.A a;
   private double[] b;
   private double[] c;
   private double[] d;
   private boolean[] e;
   private double[] f;
   private double g;

   A(double var1) {
      this.g = var1;
   }

   public void a(X var1, y.f.b.c var2) {
      boolean var18 = d.d;
      this.a = M.a();
      Rectangle var3 = var1.a();
      y.c.A var4 = M.a();
      y.c.h var5 = M.b();
      D var6 = new D(var4, var5);
      y.c.x var7 = var1.o();

      while(var7.f()) {
         y.c.q var8 = var7.e();
         this.a.a(var7.e(), -1);
         B var9 = new B((aY)null, (bK)null, (Z)null);
         var4.a(var8, var9);
         var7.g();
         if(var18) {
            y.c.i.g = !y.c.i.g;
            break;
         }
      }

      F var19 = new F(var6);
      y.c.c var20 = var1.c(d.a);
      I var21 = new I(var1);
      y.c.y var10 = new y.c.y();
      y.c.x var11 = var1.o();

      while(var11.f()) {
         label98: {
            y.c.q var12 = var11.e();
            if(var2.d(var12)) {
               var21.a(var12);
               if(!var18) {
                  break label98;
               }
            }

            if(var20.d(var12)) {
               var10.add(var12);
               var21.a(var12);
            }
         }

         var11.g();
         if(var18) {
            break;
         }
      }

      y.c.e var22 = var1.p();

      while(var22.f()) {
         y.c.d var24 = var22.a();
         if(var24.e()) {
            var21.a(var24);
         }

         var22.g();
         if(var18) {
            break;
         }
      }

      y.f.c.e var23 = new y.f.c.e();
      var23.a(30.0D);
      var23.a(var1, (aU)var19, (aV)var6);
      var21.a(var10, true);
      y.c.e var25 = var1.p();

      while(true) {
         if(var25.f()) {
            y.c.d var13 = var25.a();
            if(var18) {
               break;
            }

            if(var13.e()) {
               var21.a(var13);
            }

            var25.g();
            if(!var18) {
               continue;
            }
         }

         var1.a((Object)N.t, (y.c.c)var20);
         break;
      }

      y.f.c.a.m var26 = new y.f.c.a.m(new aj());
      var26.a(var1, (aU)var19, (aV)var6);
      var1.d_(N.t);
      this.b = new double[var19.b()];
      this.c = new double[var19.b()];
      this.f = new double[var19.b()];
      this.d = new double[var19.b()];
      this.e = new boolean[var19.b()];
      int var27 = 0;

      while(true) {
         if(var27 < var19.b()) {
            aQ var14 = var19.a(var27);
            this.b[var27] = var3.getMaxY();
            this.c[var27] = var3.getMinY();
            int var15 = 0;
            if(var18) {
               break;
            }

            y.c.x var16 = var14.d().a();

            int var10000;
            label66: {
               while(var16.f()) {
                  y.c.q var17 = var16.e();
                  this.f[var27] = Math.max(this.f[var27], var1.q(var17));
                  this.a.a(var17, var27);
                  var10000 = var20.d(var17);
                  if(var18) {
                     break label66;
                  }

                  if(var10000 == 0) {
                     ++var15;
                     this.d[var27] += var1.k(var17);
                     this.b[var27] = Math.min(this.b[var27], var1.n(var17));
                     this.c[var27] = Math.max(this.c[var27], var1.n(var17) + var1.q(var17));
                     this.f[var27] = Math.max(this.f[var27], this.c[var27] - this.b[var27]);
                  }

                  var16.g();
                  if(var18) {
                     break;
                  }
               }

               var10000 = var15;
            }

            if(var10000 > 0) {
               this.e[var27] = true;
               this.d[var27] /= (double)var15;
            }

            ++var27;
            if(!var18) {
               continue;
            }
         }

         var21.f();
         break;
      }

   }

   public int a(y.c.q var1) {
      int var2 = this.a.a(var1);
      return var2;
   }

   public y.d.y a(y.c.q var1, X var2, y.c.A var3) {
      boolean var19 = d.d;
      int var4 = this.a.a(var1);
      if(var4 < 0) {
         return null;
      } else {
         Rectangle2D var5 = this.a((X)var2, (y.c.q)var1, (y.c.c)var3);
         double var6 = var5.getMinY();
         double var8 = var5.getMinY();
         boolean var10 = false;
         int var11 = var4 - 1;

         while(var11 >= 0) {
            if(this.e[var11]) {
               var6 = this.c[var11] + this.g;
               var8 = this.d[var11];
               var10 = true;
               if(!var19) {
                  break;
               }
            }

            --var11;
            if(var19) {
               break;
            }
         }

         double var20 = var5.getMaxY();
         double var13 = var5.getMaxY();
         double var15 = 0.0D;
         int var17 = var4 + 1;

         boolean var10000;
         while(true) {
            if(var17 < this.e.length) {
               label58: {
                  var10000 = this.e[var17];
                  if(var19) {
                     break;
                  }

                  if(var10000) {
                     var20 = this.b[var17] - this.g;
                     var13 = this.d[var17];
                     if(!var19) {
                        break label58;
                     }
                  }

                  var15 += this.f[var17] + this.g;
                  ++var17;
                  if(!var19) {
                     continue;
                  }
               }
            }

            var10000 = var10;
            break;
         }

         if(!var10000) {
            var6 -= var15;
            var8 -= var15;
            var20 -= var15;
            var13 -= var15;
         }

         if(var20 - var6 <= var2.q(var1)) {
            if(var13 - var8 > var2.q(var1)) {
               return new y.d.y(var5.getX(), var8, var5.getWidth(), var13 - var8);
            } else {
               double var21 = (var8 - var13 + var2.q(var1)) * 0.5D;
               return new y.d.y(var5.getX(), var8 - var21, var5.getWidth(), var2.q(var1));
            }
         } else {
            return new y.d.y(var5.getX(), var6, var5.getWidth(), var20 - var6);
         }
      }
   }

   private Rectangle2D a(X var1, y.c.q var2, y.c.c var3) {
      boolean var16 = d.d;
      y.d.q var4 = var1.r(var2);
      boolean var5 = false;
      double var6 = Double.MAX_VALUE;
      double var8 = Double.MAX_VALUE;
      double var10 = -1.7976931348623157E308D;
      double var12 = -1.7976931348623157E308D;
      y.c.x var14 = var1.o();

      while(var14.f()) {
         if(var3 == null || var3.d(var14.e())) {
            am var15 = var1.h(var14.e());
            var6 = Math.min(var6, var15.getX());
            var8 = Math.min(var8, var15.getY());
            var10 = Math.max(var10, var15.getX() + var15.getWidth());
            var12 = Math.max(var12, var15.getY() + var15.getHeight());
            var5 = true;
         }

         var14.g();
         if(var16) {
            break;
         }
      }

      return var5?new java.awt.geom.Rectangle2D.Double(var6 - this.g - var4.a() - 100.0D, var8 - this.g - var4.b() - 100.0D, var10 - var6 + 2.0D * (this.g + 100.0D + var4.a()), var12 - var8 + 2.0D * (this.g + 100.0D + var4.b())):new java.awt.geom.Rectangle2D.Double(0.0D, 0.0D, var4.a(), var4.b());
   }
}
