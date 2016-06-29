package y.f.e.a;

import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

public class an implements ax {
   private double a = 0.0D;
   private double b = 0.0D;
   private double c = 0.0D;
   private k d = new Z();

   public k a(m var1, l var2, a var3) {
      k var4 = var1.a();
      double var5 = this.c / this.b;
      double var7 = this.d.d() - var4.d();
      double var9 = this.d.e() - var4.e();
      var9 /= var5;
      double var11 = Math.sqrt(var7 * var7 + var9 * var9);
      double var13 = this.b - this.a;
      if(this.a > 0.0D && var13 > 0.0D && var11 >= var13) {
         double var15 = (var11 - var13) / this.a;
         double var17 = var7 / var11 * var15;
         double var19 = var9 / var11 * var15;
         var19 *= var5;
         var3.a(var17);
         var3.b(var19);
         var3.c(0.0D);
         return var3;
      } else {
         return var3;
      }
   }
}
