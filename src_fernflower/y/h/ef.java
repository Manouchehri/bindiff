package y.h;

import java.util.Comparator;
import y.h.dU;
import y.h.eq;

class ef implements Comparator {
   private final dU a;

   ef(dU var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      eq var3 = (eq)var1;
      eq var4 = (eq)var2;
      return y.g.e.a(var3.b, var4.b);
   }
}
