package y.f;

import java.util.Comparator;
import y.f.at;

class au implements Comparator {
   final y.c.c a;

   private au(y.c.c var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.a.d(var1) && !this.a.d(var2)?-1:(!this.a.d(var1) && this.a.d(var2)?1:0);
   }

   au(y.c.c var1, at var2) {
      this(var1);
   }
}
