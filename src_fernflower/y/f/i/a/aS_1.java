package y.f.i.a;

import y.f.i.a.R;
import y.f.i.a.aN;
import y.f.i.a.aT;
import y.f.i.a.ab;
import y.f.i.a.ai;
import y.f.i.a.w;

class aS extends aT {
   private w g;
   private double h;
   private double i;
   private final boolean j;
   private double k;
   private double l;
   private Object m;
   private y.d.y n;
   private int o;
   private final aN p;

   aS(aN var1, y.d.m var2, y.d.m var3, w var4, Object var5, int var6) {
      label25: {
         super(var4.c(), var2.b()?var2:var3, var2.a()?var2:var3);
         this.p = var1;
         this.o = var6;
         this.g = var4;
         ai var7 = var4.a(var6);
         ai var8 = var4.a(var6 + 1);
         if(var8.g()) {
            this.j = false;
            this.i = var7.e();
            this.h = var8.e();
            if(ab.a == 0) {
               break label25;
            }
         }

         this.j = true;
         this.i = var8.e();
         this.h = var7.e();
      }

      this.m = var5;
      this.k = var4.b()?0.0D:this.m();
      this.n = this.l();
   }

   public boolean a() {
      return false;
   }

   public Object f() {
      return this.m;
   }

   public double b() {
      return this.h;
   }

   public double c() {
      return this.i;
   }

   public double d() {
      return this.c != 3 && this.c != 1?this.h + this.k:this.h - this.k;
   }

   public double e() {
      return this.c != 0 && this.c != 1?this.i + this.k:this.i - this.k;
   }

   public void a(double var1) {
      this.l = var1;
   }

   private y.d.y l() {
      return this.c == 3?new y.d.y(this.h - this.k, this.i, this.k, this.k):(this.c == 2?new y.d.y(this.h, this.i, this.k, this.k):(this.c == 0?new y.d.y(this.h, this.i - this.k, this.k, this.k):new y.d.y(this.h - this.k, this.i - this.k, this.k, this.k)));
   }

   public y.d.y h() {
      return this.n;
   }

   private double m() {
      int var17 = ab.a;
      double var1 = this.a.g();
      double var3 = this.b.g();
      double var5 = aN.a(this.p) * (var1 < var3?var1:var3);
      R var7 = this.g.c[this.o];
      R var8 = this.g.b[this.o];
      double var9;
      double var11;
      double var13;
      double var15;
      if(var7 != null) {
         label71: {
            var9 = Math.abs(this.i - var7.i());
            var11 = Math.abs(this.i - var7.k());
            if(this.c == 3 || this.c == 2) {
               var5 = Math.min(var5, var11);
               var13 = var9;
               if(var17 == 0) {
                  break label71;
               }
            }

            var5 = Math.min(var5, var9);
            var13 = var11;
         }

         label72: {
            if(this.c == 1 || this.c == 3) {
               var15 = Math.abs(this.h - var7.h());
               if(var17 == 0) {
                  break label72;
               }
            }

            var15 = Math.abs(this.h - var7.j());
         }

         var5 = Math.min(var5, var15 + var13);
      }

      if(var8 != null) {
         label73: {
            var9 = Math.abs(this.h - var8.h());
            var11 = Math.abs(this.h - var8.j());
            if(this.c == 0 || this.c == 2) {
               var5 = Math.min(var5, var11);
               var13 = var9;
               if(var17 == 0) {
                  break label73;
               }
            }

            var5 = Math.min(var5, var9);
            var13 = var11;
         }

         label74: {
            if(this.c == 1 || this.c == 0) {
               var15 = Math.abs(this.i - var8.i());
               if(var17 == 0) {
                  break label74;
               }
            }

            var15 = Math.abs(this.i - var8.k());
         }

         var5 = Math.min(var5, var15 + var13);
      }

      return var5;
   }

   public y.c.D g() {
      int var10 = ab.a;
      y.c.D var1 = new y.c.D();
      if(this.l < 1.0E-6D) {
         var1.add(new y.d.t(this.h, this.i));
         return var1;
      } else {
         double var2;
         double var4;
         double var6;
         double var8;
         label38: {
            var2 = this.b.c().a;
            var8 = this.a.c().b;
            if(this.c == 2) {
               var4 = Math.min(this.b.c().b, this.b.d().b) + this.l;
               var6 = Math.min(this.a.c().a, this.a.d().a) + this.l;
               if(var10 == 0) {
                  break label38;
               }
            }

            if(this.c == 3) {
               var4 = Math.min(this.b.c().b, this.b.d().b) + this.l;
               var6 = Math.max(this.a.c().a, this.a.d().a) - this.l;
               if(var10 == 0) {
                  break label38;
               }
            }

            if(this.c == 1) {
               var4 = Math.max(this.b.c().b, this.b.d().b) - this.l;
               var6 = Math.max(this.a.c().a, this.a.d().a) - this.l;
               if(var10 == 0) {
                  break label38;
               }
            }

            var4 = Math.max(this.b.c().b, this.b.d().b) - this.l;
            var6 = Math.min(this.a.c().a, this.a.d().a) + this.l;
         }

         if(this.j) {
            var1.add(new y.d.t(var2, var4));
            var1.add(new y.d.t(var6, var8));
            if(var10 == 0) {
               return var1;
            }
         }

         var1.add(new y.d.t(var6, var8));
         var1.add(new y.d.t(var2, var4));
         return var1;
      }
   }
}
