package y.f.a;

import java.util.Comparator;
import y.f.a.x;

class y implements Comparator {
   private final x a;

   y(x var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      double var3 = this.a.p.c(var1);
      double var5 = this.a.p.c(var2);
      return var3 > var5?1:(var3 < var5?-1:0);
   }
}
