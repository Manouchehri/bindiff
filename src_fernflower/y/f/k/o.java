package y.f.k;

import java.util.Comparator;
import y.f.ad;
import y.f.ae;
import y.f.aj;
import y.f.k.d;
import y.f.k.p;
import y.f.k.q;
import y.f.k.r;
import y.f.k.s;

public class o extends y.f.c {
   private static double n = 1000.0D;
   private double o = 340.0D;
   private double p = 360.0D;
   private double q = 40.0D;
   private boolean r = false;
   private double t = 0.5D;
   private byte u = 0;
   private boolean v = false;
   private int w = 0;
   private y.c.A x;
   private byte y = 0;
   private boolean z;
   private q[] A;
   protected y.f.X s;
   private Comparator B;
   private y.c.A C;

   public o() {
      ad var1 = this.f();
      if(var1 instanceof y.f.b.b) {
         ((y.f.b.b)var1).a(false);
      }

   }

   public int a() {
      return this.w;
   }

   public boolean n() {
      return this.v;
   }

   public void g(boolean var1) {
      this.v = var1;
   }

   public void a(int var1) {
      label13: {
         if(var1 < 1) {
            var1 = 1;
            if(d.g == 0) {
               break label13;
            }
         }

         if(var1 > 359) {
            var1 = 359;
         }
      }

      this.p = (double)var1;
   }

   public int o() {
      return (int)this.p;
   }

   public int p() {
      return (int)this.o;
   }

   public void h(boolean var1) {
      this.r = var1;
   }

   public double q() {
      return this.t;
   }

   public void b(int var1) {
      this.q = (double)var1;
   }

   public int r() {
      return (int)this.q;
   }

   public boolean s() {
      return this.z;
   }

   public void a(y.f.X var1) {
      int var6 = d.g;
      if(!y.a.A.b(var1)) {
         throw new y.c.B("Graph is not a tree");
      } else {
         this.s = var1;
         this.x = var1.t();
         if(this.s()) {
            this.d(var1);
         }

         y.c.q var2 = this.t();
         y.c.f var3 = y.a.A.a((y.c.i)var1, (y.c.q)var2);
         this.a(var2, this.x);
         ae.a(var1);
         this.A = new q[var1.f()];
         y.c.x var4 = var1.o();

         while(true) {
            if(var4.f()) {
               y.c.q var5 = var4.e();
               if(var6 != 0) {
                  break;
               }

               label43: {
                  if(var5 != var2) {
                     this.a(var5, new q(this.q + this.k(var5.n().e())));
                     if(var6 == 0) {
                        break label43;
                     }
                  }

                  this.a(var5, new q(Math.max(this.q, (double)this.w)));
               }

               var4.g();
               if(var6 == 0) {
                  continue;
               }
            }

            this.i(var2);
            var1.a(var2, 0.0D, 0.0D);
            this.j(var2);
            break;
         }

         if(this.s()) {
            this.e(var1);
         }

         while(true) {
            if(!var3.isEmpty()) {
               y.c.d var7 = var3.d();
               var1.c(var7);
               if(var6 != 0) {
                  break;
               }

               if(var6 == 0) {
                  continue;
               }
            }

            var1.a((y.c.A)this.x);
            break;
         }

      }
   }

   private void d(y.f.X var1) {
      int var11 = d.g;
      this.C = var1.t();
      y.c.x var2 = var1.o();

      while(var2.f()) {
         y.c.q var3 = var2.e();
         y.d.y var4 = var1.s(var3);
         aj[] var5 = var1.a_(var3);
         int var6 = 0;

         while(true) {
            if(var6 < var5.length) {
               aj var7 = var5[var6];
               var4 = a(var4, var7.getBox());
               ++var6;
               if(var11 != 0) {
                  break;
               }

               if(var11 == 0) {
                  continue;
               }
            }

            this.C.a(var3, var1.r(var3));
            break;
         }

         y.d.t var12 = var1.l(var3);
         double var13 = Math.floor(Math.max(var12.a() - var4.c(), var4.c() + var4.a() - var12.a()) + 1.0E-5D);
         double var9 = Math.floor(Math.max(var12.b() - var4.d(), var4.d() + var4.b() - var12.b()) + 1.0E-5D);
         var1.b(var3, 2.0D * var13, 2.0D * var9);
         var1.a(var3, var12);
         var2.g();
         if(var11 != 0) {
            break;
         }
      }

   }

   private void e(y.f.X var1) {
      int var5 = d.g;
      y.c.x var2 = var1.o();

      while(true) {
         if(var2.f()) {
            y.c.q var3 = var2.e();
            y.d.t var4 = var1.l(var3);
            var1.a(var3, (y.d.q)this.C.b(var3));
            var1.a(var3, var4);
            var2.g();
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         var1.a((y.c.A)this.C);
         break;
      }

   }

   private static y.d.y a(y.d.y var0, y.d.y var1) {
      if(var0 != null && var1 != null) {
         double var2 = Math.min(var0.c(), var1.c());
         double var4 = Math.max(var0.c() + var0.a(), var1.c() + var1.a());
         double var6 = Math.min(var0.d(), var1.d());
         double var8 = Math.max(var0.d() + var0.b(), var1.d() + var1.b());
         return new y.d.y(var2, var6, var4 - var2, var8 - var6);
      } else {
         return var0 == null?var1:var0;
      }
   }

   private double a(y.c.q var1, y.c.A var2) {
      int var7 = d.g;
      double var3 = this.s.p(var1) * this.s.q(var1);
      y.c.d var5 = var1.f();

      while(true) {
         if(var5 != null) {
            y.c.q var6 = var5.d();
            var3 += this.a(var6, var2);
            var5 = var5.g();
            if(var7 != 0) {
               break;
            }

            if(var7 == 0) {
               continue;
            }
         }

         var2.a(var1, var3);
         break;
      }

      return var3;
   }

   public boolean b(y.f.X var1) {
      return y.a.A.b(var1);
   }

   protected q e(y.c.q var1) {
      return this.A[var1.d()];
   }

   protected y.c.q t() {
      switch(this.u) {
      case 0:
      default:
         return y.a.A.d(this.s);
      case 1:
         return y.a.A.c(this.s);
      case 2:
         return y.a.A.f(this.s);
      }
   }

   protected void b(y.c.q var1) {
      int var10 = d.g;
      double var2 = this.c(var1);

      double var4;
      label39:
      while(true) {
         var4 = this.f(var1);

         while(true) {
            if(var4 <= var2) {
               break label39;
            }

            y.c.x var6 = var1.o();

            while(true) {
               if(!var6.f()) {
                  continue label39;
               }

               y.c.q var7 = var6.e();
               this.e(var7);
               q var10000 = this.e(var7);
               var10000.e *= 1.0D + this.t;
               var6.g();
               if(var10 != 0) {
                  break;
               }

               if(var10 != 0) {
                  break label39;
               }
            }
         }
      }

      double var11 = (var2 - var4) / (double)(2 * var1.c());
      var4 = 0.0D;
      y.c.x var8 = var1.o();

      while(true) {
         if(var8.f()) {
            q var9 = this.e(var8.e());
            var9.b += var11;
            var9.c += var11;
            var4 += var9.b + var9.c;
            var8.g();
            if(var10 != 0) {
               break;
            }

            if(var10 == 0) {
               continue;
            }
         }

         this.a(var1);
         break;
      }

   }

   protected void a(y.c.q var1) {
      int var2 = d.g;
      if(this.v) {
         this.d(var1);
         if(var2 == 0) {
            return;
         }
      }

      if(this.B != null) {
         var1.b(this.B);
         if(var2 == 0) {
            return;
         }
      }

      if(this.y == 0) {
         this.l(var1);
         if(var2 == 0) {
            return;
         }
      }

      this.m(var1);
   }

   static double a(y.d.t var0, y.d.t var1) {
      double var2 = var1.a - var0.a;
      double var4 = var1.b - var0.b;
      return Math.atan2(var4, var2);
   }

   private void d(y.c.q var1) {
      y.f.X var2 = (y.f.X)var1.e();
      y.d.t var3 = var2.l(var1);
      y.d.t var4 = var1.b() > 0?var2.l(var1.g().c()):null;
      double var5 = var4 == null?3.141592653589793D:a(var3, var4);
      p var7 = new p(this, var2, var3, var5);
      var1.b((Comparator)var7);
   }

   private void l(y.c.q var1) {
      int var6 = d.g;
      y.c.d[] var2 = new y.c.d[var1.c()];
      int var3 = 0;
      y.c.e var4 = var1.l();

      while(true) {
         if(var4.f()) {
            var2[var3] = var4.a();
            var4.g();
            ++var3;
            if(var6 != 0) {
               break;
            }

            if(var6 == 0) {
               continue;
            }
         }

         y.g.e.a((Object[])var2, new s(this));
         break;
      }

      int var7 = 0;

      while(true) {
         if(var7 < var2.length) {
            this.s.d(var2[var7]);
            ++var7;
            if(var6 != 0) {
               break;
            }

            if(var6 == 0) {
               continue;
            }
         }

         var7 = 0;
         break;
      }

      while(var7 < var2.length) {
         int var5 = var2.length - 1 - var7;
         if(var5 < var7) {
            break;
         }

         this.s.e(var2[var7]);
         if(var5 == var7) {
            break;
         }

         this.s.e(var2[var5]);
         ++var7;
         if(var6 != 0) {
            break;
         }
      }

   }

   private void m(y.c.q var1) {
      int var5 = d.g;
      y.c.d[] var2 = new y.c.d[var1.c()];
      int var3 = 0;
      y.c.e var4 = var1.l();

      while(true) {
         if(var4.f()) {
            var2[var3] = var4.a();
            var4.g();
            ++var3;
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         y.g.e.a((Object[])var2, new r(this));
         break;
      }

      int var6 = 0;

      while(true) {
         if(var6 < var2.length) {
            this.s.d(var2[var6]);
            ++var6;
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         var6 = 0;
         break;
      }

      while(true) {
         if(var6 < var2.length) {
            this.s.e(var2[var6]);
            var6 += 2;
            if(var5 != 0) {
               break;
            }

            if(var5 == 0) {
               continue;
            }
         }

         var3 = var2.length - 1;
         break;
      }

      if(var3 % 2 == 0) {
         --var3;
      }

      while(var3 > 0) {
         this.s.e(var2[var3]);
         var3 -= 2;
         if(var5 != 0) {
            break;
         }
      }

   }

   protected double c(y.c.q var1) {
      return var1.b() == 0?this.p:(var1.c() == 2?Math.min(180.0D, this.o):this.o);
   }

   protected double f(y.c.q var1) {
      int var22 = d.g;
      double var2 = 0.0D;
      this.k(var1);
      y.c.e var6 = var1.l();

      double var10000;
      while(true) {
         if(var6.f()) {
            y.c.d var7 = var6.a();
            y.c.q var8 = var7.d();
            q var9 = this.e(var8);
            double var10 = -var9.e;
            double var12 = var9.g;
            y.c.D var14 = var9.a;
            double var15 = 0.0D;
            var10000 = var15 + 1.0D;
            if(var22 != 0) {
               break;
            }

            double var17 = var10000;
            y.c.p var19 = var14.k();
            y.d.t var20 = (y.d.t)var19.c();
            y.d.t var21 = null;

            label54: {
               while(var17 > var15) {
                  var21 = var20;
                  var19 = var14.f(var19);
                  var20 = (y.d.t)var19.c();
                  var15 = (var20.b() - var21.b()) / (var20.a() - var21.a());
                  var17 = (var21.b() - var12) / (var21.a() - var10);
                  if(var22 != 0) {
                     break label54;
                  }

                  if(var22 != 0) {
                     break;
                  }
               }

               var9.b = -y.d.e.b(Math.atan(var17));
               var15 = 0.0D;
               var17 = var15 - 1.0D;
               var19 = var14.k();
            }

            var20 = (y.d.t)var19.c();

            label65: {
               while(((y.d.t)var19.a().c()).a() == var20.a()) {
                  var19 = var19.a();
                  var20 = (y.d.t)var19.c();
                  if(var22 != 0) {
                     break label65;
                  }

                  if(var22 != 0) {
                     break;
                  }
               }

               while(var17 < var15) {
                  var21 = var20;
                  var19 = var14.e(var19);
                  var20 = (y.d.t)var19.c();
                  var15 = (var20.b() - var21.b()) / (var20.a() - var21.a());
                  var17 = (var21.b() - var12) / (var21.a() - var10);
                  if(var22 != 0) {
                     break label65;
                  }

                  if(var22 != 0) {
                     break;
                  }
               }

               var9.c = y.d.e.b(Math.atan(var17));
               var2 += var9.b + var9.c;
               var6.g();
            }

            if(var22 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   void a(y.c.q var1, q var2) {
      this.A[var1.d()] = var2;
   }

   void g(y.c.q var1) {
      q var2 = this.e(var1);
      y.c.D var3 = new y.c.D();
      double var4 = 2.0D * this.k(var1);
      var3.add(new y.d.t(0.0D, 0.0D));
      var3.add(new y.d.t(0.0D, var4));
      var3.add(new y.d.t(var4, var4));
      var3.add(new y.d.t(var4, 0.0D));
      var2.a = var3;
      var2.f = var4 / 2.0D;
      var2.g = var4 / 2.0D;
   }

   void h(y.c.q var1) {
      int var22 = d.g;
      if(var1.c() == 0) {
         this.g(var1);
         if(var22 == 0) {
            return;
         }
      }

      q var2 = this.e(var1);
      double var3 = this.k(var1);
      y.c.D var5 = new y.c.D();
      var5.add(new y.d.t(-var3, -var3));
      var5.add(new y.d.t(-var3, var3));
      var5.add(new y.d.t(var3, -var3));
      var5.add(new y.d.t(var3, var3));
      y.c.x var6 = var1.o();

      while(var6.f()) {
         q var7 = this.e(var6.e());
         var5.a(var7.a);
         var6.g();
         if(var22 != 0) {
            return;
         }

         if(var22 != 0) {
            break;
         }
      }

      y.c.D var23 = y.d.e.a(var5);
      double var24 = Double.MAX_VALUE;
      double var9 = Double.MAX_VALUE;
      double var11 = -1.7976931348623157E308D;
      double var13 = -1.7976931348623157E308D;
      y.c.C var15 = var23.m();

      double var10000;
      double var10001;
      label57: {
         while(var15.f()) {
            y.d.t var16 = (y.d.t)var15.d();
            var10000 = var16.a();
            var10001 = var24;
            if(var22 != 0) {
               break label57;
            }

            if(var10000 < var24) {
               var24 = var16.a();
            }

            if(var16.a() > var11) {
               var11 = var16.a();
            }

            if(var16.b() < var9) {
               var9 = var16.b();
            }

            if(var16.b() > var13) {
               var13 = var16.b();
            }

            var15.g();
            if(var22 != 0) {
               break;
            }
         }

         var10000 = var11;
         var10001 = var24;
      }

      double var25 = var10000 - var10001;
      var10000 = var13 - var9;
      y.c.D var19 = new y.c.D();
      y.c.C var20 = var23.m();

      label40: {
         while(var20.f()) {
            y.d.t var21 = (y.d.t)var20.d();
            var19.add(new y.d.t(var21.a() - var24, var21.b() - var9));
            var20.g();
            if(var22 != 0) {
               break label40;
            }

            if(var22 != 0) {
               break;
            }
         }

         var2.a = var19;
         var2.f = -var24;
      }

      var2.g = -var9;
   }

   void i(y.c.q var1) {
      int var20 = d.g;
      if(var1.c() == 0) {
         this.h(var1);
         if(var20 == 0) {
            return;
         }
      }

      y.c.x var2 = var1.o();

      label49: {
         while(var2.f()) {
            this.i(var2.e());
            var2.g();
            if(var20 != 0) {
               break label49;
            }

            if(var20 != 0) {
               break;
            }
         }

         this.b(var1);
      }

      double var21 = 0.0D;
      y.c.x var4 = var1.o();

      while(var4.f()) {
         y.c.q var5 = var4.e();
         q var6 = this.e(var5);
         double var7 = 180.0D - (360.0D - this.c(var1)) / 2.0D - var21 - (var6.c + var6.d);
         var21 += var6.a();
         var7 = y.d.e.a(var7);
         double var9 = Math.sin(var7);
         double var11 = Math.cos(var7);
         if(var20 != 0) {
            return;
         }

         y.c.p var17 = var6.a.k();

         while(true) {
            double var13;
            double var15;
            if(var17 != null) {
               y.d.t var18 = (y.d.t)var17.c();
               var13 = var18.a() + var6.e;
               var15 = var18.b() - var6.g;
               y.d.t var19 = new y.d.t(var13 * var11 - var9 * var15, var13 * var9 + var11 * var15);
               var17.a(var19);
               var17 = var17.a();
               if(var20 != 0) {
                  break;
               }

               if(var20 == 0) {
                  continue;
               }
            }

            var13 = var6.f + var6.e;
            var15 = 0.0D;
            var6.f = var13 * var11;
            var6.g = var13 * var9;
            var4.g();
            break;
         }

         if(var20 != 0) {
            break;
         }
      }

      this.h(var1);
   }

   void j(y.c.q var1) {
      int var16 = d.g;
      y.d.t var2 = this.s.l(var1);
      double var3 = 0.0D;
      if(var1.b() > 0) {
         y.c.q var5 = var1.n().e();
         y.d.t var6 = this.s.l(var5);
         var3 = 3.141592653589793D + Math.atan2(var6.b() - var2.b(), var6.a() - var2.a());
      }

      y.c.x var17 = var1.o();

      while(var17.f()) {
         y.c.q var18 = var17.e();
         q var7 = this.e(var18);
         if(var3 != 0.0D) {
            double var8 = Math.cos(var3);
            double var10 = Math.sin(var3);
            double var12 = var7.f * var8 - var10 * var7.g;
            double var14 = var7.f * var10 + var8 * var7.g;
            var7.f = var12;
            var7.g = var14;
         }

         this.s.a(var18, var2.a() + var7.f, var2.b() + var7.g);
         this.j(var18);
         var17.g();
         if(var16 != 0) {
            break;
         }
      }

   }

   double k(y.c.q var1) {
      return this.r?(this.s.p(var1) + this.s.q(var1)) / 4.0D + 0.5D * (double)this.w:1.41D * (Math.max(this.s.p(var1), this.s.q(var1)) / 2.0D) + 0.5D * (double)this.w;
   }

   static y.c.A a(o var0) {
      return var0.x;
   }

   static double u() {
      return n;
   }
}
