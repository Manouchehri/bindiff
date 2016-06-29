package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.bF;
import y.f.c.a.by;

class bC implements Comparator {
   private final by a;

   bC(by var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      bF var3 = (bF)var1;
      bF var4 = (bF)var2;
      return y.g.e.a(var3.e().a, var4.e().a);
   }
}
