package y.d.b;

import java.util.Comparator;
import y.d.b.d;

class g implements Comparator {
   private final d a;

   g(d var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.a.m(var1, var2);
   }
}
