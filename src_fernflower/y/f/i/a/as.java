package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.ar;

class as implements Comparator {
   private final ar a;

   as(ar var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      double var3 = ((y.f.c.a.l)var1).g();
      double var5 = ((y.f.c.a.l)var2).g();
      return var3 < var5?-1:(var3 > var5?1:0);
   }
}
