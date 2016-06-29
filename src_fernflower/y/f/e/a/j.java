package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

class j implements ax {
   private double a;

   j(double var1) {
      this.a = var1;
   }

   j() {
      this(0.2D);
   }

   public k a(m var1, l var2, a var3) {
      k var4 = var1.a();
      double var5 = this.a(var2);
      if(!Double.isNaN(var5) && !Double.isInfinite(var5) && var5 >= 1.0E-7D) {
         var4.a(var2.b().e(), var3);
         var3.b(var3.d() * var5 - var3.d(), var3.e() / var5 - var3.e(), 0.0D);
         return var3;
      } else {
         return var3;
      }
   }

   double a(l var1) {
      double var2 = var1.b().a();
      double var4 = var1.b().b();
      double var6 = var2 / var4;
      return Math.sqrt(this.a / var6);
   }
}
