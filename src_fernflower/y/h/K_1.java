package y.h;

import java.util.Comparator;
import y.h.F;
import y.h.fj;

class K implements Comparator {
   private final F a;

   K(F var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      fj var3 = (fj)var1;
      fj var4 = (fj)var2;
      return y.g.e.a(var3.getCenterY(), var4.getCenterY());
   }
}
