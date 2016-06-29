package y.h;

import java.util.Comparator;
import y.h.F;
import y.h.fj;

class J implements Comparator {
   private final F a;

   J(F var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      fj var3 = (fj)var1;
      fj var4 = (fj)var2;
      return y.g.e.a(var3.getCenterX(), var4.getCenterX());
   }
}
