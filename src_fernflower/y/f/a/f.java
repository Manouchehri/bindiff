package y.f.a;

import java.awt.geom.Rectangle2D;
import y.f.X;
import y.f.ae;
import y.f.a.g;
import y.f.a.u;

public class f extends y.f.c {
   X n;
   private y.a.p v;
   double o = 200.0D;
   int p = 30;
   boolean q = true;
   private double w;
   private double x = 5.0D;
   double r;
   private double[] y;
   double s;
   boolean t = false;
   private double z = 0.0D;
   private boolean A = false;
   private y.a.p B;
   private double C = 0.0D;
   public static int u;

   public void a(double var1) {
      this.C = var1;
   }

   void b(double var1) {
      this.z = var1;
   }

   public void g(boolean var1) {
      this.t = var1;
      this.B = null;
   }

   public void a(int var1) {
      this.p = var1;
   }

   public int a() {
      return this.p;
   }

   public void c(double var1) {
      if(var1 < 0.0D) {
         var1 = 0.0D;
      }

      this.o = var1;
   }

   public void h(boolean var1) {
      this.q = var1;
   }

   public boolean n() {
      return this.q;
   }

   public y.a.p o() {
      if(this.A) {
         return this.v;
      } else {
         if(this.B == null) {
            if(this.t) {
               this.B = new g(this);
               if(u == 0) {
                  return this.B;
               }
            }

            this.B = new u();
         }

         return this.B;
      }
   }

   public boolean b(X var1) {
      return true;
   }

   public void a(X var1) {
      this.n = var1;
      ae.a(var1);
      y.a.p var2 = this.o();
      if(!this.A && this.t) {
         Rectangle2D var3 = ae.a(var1, var1.o());
         ((g)var2).a(new y.d.t(var3.getCenterX(), var3.getCenterY()));
      }

      y.c.x var4 = var2.a(var1);
      if(this.n()) {
         this.a(var4);
         if(this.r < this.x) {
            this.r = this.x;
         }

         this.w = this.a(var4, this.r);
         if(u == 0) {
            return;
         }
      }

      this.w = this.o;
      this.b(var4, 0.0D);
   }

   double a(y.c.x var1, double var2) {
      int var20 = u;
      int var4 = var1.k();
      double var5 = y.d.e.a(360.0D / (double)var4);
      this.a(var1);
      double var11 = this.s / (double)var4;
      double var9 = this.s / 6.283185307179586D;
      if(var9 < var2) {
         var9 = var2;
      }

      var1.i();
      double var13 = this.C;
      if(this.y.length > 0) {
         var13 -= var5 / var11 * this.y[0] / 2.0D;
      }

      int var15 = 0;

      double var10000;
      while(true) {
         if(var15 < var4) {
            double var7 = var5 / var11 * this.y[var15];
            var13 += var7 / 2.0D;
            double var16 = Math.cos(var13) * var9;
            double var18 = Math.sin(var13) * var9;
            var10000 = var13 + var7 / 2.0D;
            if(var20 != 0) {
               break;
            }

            var13 = var10000;
            this.n.a(var1.e(), var16, var18);
            ++var15;
            var1.g();
            if(var20 == 0) {
               continue;
            }
         }

         var10000 = var9;
         break;
      }

      return var10000;
   }

   void b(y.c.x var1, double var2) {
      int var12 = u;
      double var4 = y.d.e.a(360.0D / (double)var1.k());
      double var6 = this.C;
      var1.i();

      while(var1.f()) {
         double var8 = Math.cos(var6) * this.o;
         double var10 = Math.sin(var6) * this.o;
         if(this.n == null) {
            this.n = (X)var1.e().e();
         }

         this.n.a(var1.e(), var8, var10);
         var6 += var4;
         var1.g();
         if(var12 != 0) {
            break;
         }
      }

   }

   double a(y.c.q var1) {
      double var2 = this.n.p(var1);
      double var4 = this.n.q(var1);
      return var2 > var4?var2:var4;
   }

   void a(y.c.x var1) {
      int var5 = u;
      this.s = 0.0D;
      this.y = new double[var1.k()];
      this.r = 0.0D;
      var1.i();
      int var2 = 0;

      while(var2 < this.y.length) {
         double var3 = this.a(var1.e());
         this.y[var2] = var3 + (double)this.p;
         this.r = Math.max(this.r, var3);
         this.s += this.y[var2];
         ++var2;
         var1.g();
         if(var5 != 0) {
            break;
         }
      }

   }

   static double a(f var0) {
      return var0.z;
   }
}
