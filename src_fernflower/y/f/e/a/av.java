package y.f.e.a;

import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

public class av implements ax {
   private double a = 0.0D;
   private double b = 0.0D;
   private k c = new Z();

   public void a(double var1) {
      this.a = var1;
   }

   public void b(double var1) {
      this.b = var1;
   }

   public k a(m var1, l var2, a var3) {
      k var4 = var1.a();
      double var5 = this.c.d() - var4.d();
      double var7 = this.c.e() - var4.e();
      double var9 = Math.sqrt(var5 * var5 + var7 * var7);
      double var11 = this.b - this.a;
      if(this.a > 0.0D && var11 > 0.0D && var9 >= var11) {
         double var13 = (var9 - var11) / this.a;
         double var15 = var5 / var9 * var13;
         double var17 = var7 / var9 * var13;
         var3.a(var15);
         var3.b(var17);
         var3.c(0.0D);
         return var3;
      } else {
         return var3;
      }
   }
}
