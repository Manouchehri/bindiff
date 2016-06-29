package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.ar;

class at implements Comparator {
   private final ar a;

   at(ar var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      double var3 = ((y.f.c.a.bt)var1).f();
      double var5 = ((y.f.c.a.bt)var2).f();
      return var3 < var5?-1:(var3 > var5?1:0);
   }
}
