package y.f.a;

import y.f.X;
import y.f.ah;
import y.f.a.H;
import y.f.a.f;

class G implements ah {
   private y.c.A e;
   private y.d.t f = new y.d.t();
   boolean a = true;
   boolean b = false;
   double c = 0.0D;
   private double g;
   private y.c.y h;
   double d;

   public void a(y.d.t var1) {
      this.f = var1;
   }

   void a(boolean var1) {
      this.a = var1;
   }

   public void a(double var1) {
      this.c = var1;
   }

   void b(double var1) {
      this.g = var1;
   }

   public y.c.y a() {
      return this.h;
   }

   private y.c.D a(X var1, double var2, double var4, double var6) {
      int var13 = f.u;
      y.c.D var8 = new y.c.D();
      var8.add(this.a(var4, var6, var2, 0, 0));
      y.c.q[] var9 = var1.m();
      int var10 = 1;

      while(var10 < 2 * var9.length) {
         int var11 = 1;

         while(true) {
            if(var11 < 2 * var10) {
               y.d.t var12 = this.a(var4, var6, var2, var11, var10);
               var8.add(var12);
               var11 += 2;
               if(var13 != 0) {
                  break;
               }

               if(var13 == 0) {
                  continue;
               }
            }

            var10 <<= 1;
            break;
         }

         if(var13 != 0) {
            break;
         }
      }

      return var8;
   }

   private double a(double var1, double var3, double var5, double var7, double var9, double var11) {
      double var13 = var5 - var1;
      double var15 = var7 - var3;
      double var17 = var9 - var1;
      double var19 = var11 - var3;
      double var21 = var13 * var17 + var15 * var19;
      double var23 = Math.sqrt(var13 * var13 + var15 * var15) * Math.sqrt(var17 * var17 + var19 * var19);
      double var25 = var23 == 0.0D?0.0D:Math.acos(var21 / var23);
      return var25;
   }

   private y.c.q a(y.d.t var1, X var2, y.c.q[] var3, y.c.A var4, double var5, double var7) {
      int var24 = f.u;
      y.c.q var9 = null;
      double var10 = Double.MAX_VALUE;
      double var12 = Double.MAX_VALUE;
      int var14 = 0;

      y.c.q var10000;
      while(true) {
         if(var14 < var3.length) {
            var10000 = var3[var14];
            if(var24 != 0) {
               break;
            }

            y.c.q var15 = var10000;
            double var16 = var2.j(var15);
            double var18 = var2.k(var15);
            double var20 = this.a(var1.a, var1.b, var16, var18, var5, var7);
            double var22 = this.a(var1.a, var1.b, var16, var18, var20);
            if(var22 < var10) {
               var10 = var22;
               var9 = var15;
            }

            ++var14;
            if(var24 == 0) {
               continue;
            }
         }

         var10000 = var9;
         break;
      }

      return var10000;
   }

   double a(double var1, double var3, double var5, double var7, double var9) {
      double var11 = y.d.t.a(var1, var3, var5, var7);
      return var11 == 0.0D?var11:var11 * (1.0D + Math.pow(4.0D * var9 / 3.141592653589793D, 8.0D));
   }

   private y.d.t a(double var1, double var3, double var5, int var7, int var8) {
      double var9 = var7 == 0?0.0D:3.141592653589793D * (double)var7 / (double)var8;
      double var11 = Math.cos(var9);
      double var13 = Math.sin(var9);
      return new y.d.t(var1 + var11 * var5, var3 + var13 * var5);
   }

   public double b() {
      return this.d;
   }

   public void b(boolean var1) {
      this.b = var1;
   }

   public void c(X var1) {
      double var2;
      double var4;
      int var15;
      label62: {
         var15 = f.u;
         var2 = this.f.a();
         var4 = this.f.b();
         if(this.a) {
            this.d = this.a(var1, var2, var4);
            if(var15 == 0) {
               break label62;
            }
         }

         this.d = this.g;
      }

      y.c.D var6 = this.a(var1, this.d + this.c, var2, var4);
      y.c.A var7 = var1.t();
      y.c.A var8 = var1.t();
      y.c.q[] var9 = var1.m();
      int var10 = 0;
      this.h = new y.c.y();
      y.c.C var11 = var6.m();

      int var10000;
      while(true) {
         if(var11.f()) {
            var10000 = var10;
            if(var15 != 0) {
               break;
            }

            if(var10 <= var9.length) {
               y.d.t var12 = (y.d.t)var11.d();
               y.c.q var13 = this.a(var12, var1, var9, var7, var2, var4);
               if(var13 != null && !var7.d(var13)) {
                  var8.a(var13, var12);
                  this.h.add(var13);
                  if(this.e != null) {
                     this.e.a(var13, true);
                  }

                  ++var10;
                  var7.a(var13, true);
               }

               var11.g();
               if(var15 == 0) {
                  continue;
               }
            }
         }

         var10000 = this.b;
         break;
      }

      if(var10000 == 0) {
         y.c.x var16 = var1.o();

         y.c.q var18;
         label43: {
            while(var16.f()) {
               var18 = var16.e();
               y.d.t var19 = (y.d.t)var8.b(var18);
               if(var15 != 0) {
                  break label43;
               }

               if(var19 != null) {
                  var1.a(var18, var19);
               }

               var16.g();
               if(var15 != 0) {
                  break;
               }
            }

            this.h.sort(new H(this, var8));
         }

         f var17 = new f();
         var17.h(false);
         var17.c(this.d);
         var18 = this.h.b();
         double var20 = Math.atan2(var1.n(var18), var1.m(var18));
         var17.a(var20);
         var17.b(this.h.a(), var20);
      }

      var1.a((y.c.A)var8);
      var1.a((y.c.A)var7);
   }

   private double a(X var1, double var2, double var4) {
      int var10 = f.u;
      double var6 = 0.0D;
      y.c.x var8 = var1.o();

      double var10000;
      while(true) {
         if(var8.f()) {
            y.d.t var9 = var1.l(var8.e());
            var10000 = Math.max(var6, var9.a(var2, var4));
            if(var10 != 0) {
               break;
            }

            var6 = var10000;
            var8.g();
            if(var10 == 0) {
               continue;
            }
         }

         var10000 = var6;
         break;
      }

      return var10000;
   }

   public void a(y.c.A var1) {
      this.e = var1;
   }
}
