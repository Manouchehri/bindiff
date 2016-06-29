package y.f.a;

import java.util.Comparator;
import y.f.a.z;

class A implements Comparator {
   private final y.d.t a;
   private final double b;
   private final z c;

   A(z var1, y.d.t var2, double var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public int compare(Object var1, Object var2) {
      y.d.t var3 = z.a(this.c).l(((y.c.d)var1).d());
      y.d.t var4 = z.a(this.c).l(((y.c.d)var2).d());
      double var5 = z.a(this.a, var3);
      if(var5 < this.b) {
         var5 += 6.283185307179586D;
      }

      double var7 = z.a(this.a, var4);
      if(var7 < this.b) {
         var7 += 6.283185307179586D;
      }

      return var5 < var7?1:(var5 > var7?-1:0);
   }
}
