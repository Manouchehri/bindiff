package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

class v implements ax {
   private double a = 50.0D;
   private double b;
   private double c;
   private double d;
   private double e;
   private double f;
   private double g;

   public void a(double var1, double var3, double var5, double var7) {
      this.d = var1;
      this.e = var3;
      this.b = var5;
      this.c = var7;
      this.f = this.d + this.b / 2.0D;
      this.g = this.e + this.c / 2.0D;
   }

   public v() {
      this.f = this.d + this.b / 2.0D;
      this.g = this.e + this.c / 2.0D;
   }

   public v(double var1, double var3, double var5, double var7, double var9) {
      this.f = this.d + this.b / 2.0D;
      this.g = this.e + this.c / 2.0D;
      this.a(var1, var3, var5, var7);
      this.a = var9;
   }

   public k a(m var1, l var2, a var3) {
      k var4 = var1.a();
      if(this.b > 0.0D && this.c > 0.0D) {
         double var5 = this.b - 2.0D * this.a;
         double var7 = this.c - 2.0D * this.a;
         double var9 = var4.d() - this.f - var1.h();
         double var11 = var4.e() - this.g - var1.h();
         if(Math.abs(var9) <= this.b / 2.0D && Math.abs(var11) <= this.c / 2.0D) {
            if(Math.abs(var9) <= var5 / 2.0D && Math.abs(var11) <= var7 / 2.0D) {
               var3.b(var9, var11, 0.0D);
               var3.b();
               return var3;
            } else {
               double var13 = 0.0D;
               double var15 = 0.0D;
               if(var9 > var5 / 2.0D) {
                  var13 = this.b / 2.0D - var9;
                  if(Math.abs(var11) <= var7 / 2.0D) {
                     var3.b(var13 / this.a, 0.0D, 0.0D);
                     return var3;
                  }
               } else if(var9 < -var5 / 2.0D) {
                  var13 = -this.b / 2.0D - var9;
                  if(Math.abs(var11) <= var7 / 2.0D) {
                     var3.b(var13 / this.a, 0.0D, 0.0D);
                     return var3;
                  }
               }

               if(var11 > var7 / 2.0D) {
                  var15 = this.c / 2.0D - var11;
                  if(Math.abs(var9) <= var5 / 2.0D) {
                     var3.b(0.0D, var15 / this.a, 0.0D);
                     return var3;
                  }
               } else if(var11 < -var7 / 2.0D) {
                  var15 = -this.c / 2.0D - var11;
                  if(Math.abs(var9) <= var5 / 2.0D) {
                     var3.b(0.0D, var15 / this.a, 0.0D);
                     return var3;
                  }
               }

               double var17 = this.a - Math.abs(var13);
               double var19 = this.a - Math.abs(var15);
               double var21 = Math.sqrt(var17 * var17 + var19 * var19);
               if(var21 > this.a) {
                  var3.a();
                  return var3;
               } else {
                  double var23 = 1.0D - var21 / this.a;
                  var3.b(var13, var15, 0.0D);
                  var3.b();
                  var3.d(var23);
                  return var3;
               }
            }
         } else {
            var3.a();
            return var3;
         }
      } else {
         return var3;
      }
   }
}
