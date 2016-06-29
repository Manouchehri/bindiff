package y.f.a;

import java.util.Comparator;
import y.f.a.G;

class H implements Comparator {
   private final y.c.A a;
   private final G b;

   H(G var1, y.c.A var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      y.d.t var3 = (y.d.t)this.a.b(var1);
      y.d.t var4 = (y.d.t)this.a.b(var2);
      double var5 = Math.atan2(var3.b, var3.a);
      double var7 = Math.atan2(var4.b, var4.a);
      return var5 > var7?1:(var5 < var7?-1:0);
   }
}
