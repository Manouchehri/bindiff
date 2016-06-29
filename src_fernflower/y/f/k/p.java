package y.f.k;

import java.util.Comparator;
import y.f.k.o;

class p implements Comparator {
   private final y.f.X a;
   private final y.d.t b;
   private final double c;
   private final o d;

   p(o var1, y.f.X var2, y.d.t var3, double var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public int compare(Object var1, Object var2) {
      y.d.t var3 = this.a.l(((y.c.d)var1).d());
      y.d.t var4 = this.a.l(((y.c.d)var2).d());
      double var5 = o.a(this.b, var3);
      if(var5 < this.c) {
         var5 += 6.283185307179586D;
      }

      double var7 = o.a(this.b, var4);
      if(var7 < this.c) {
         var7 += 6.283185307179586D;
      }

      return var5 < var7?1:(var5 > var7?-1:0);
   }
}
