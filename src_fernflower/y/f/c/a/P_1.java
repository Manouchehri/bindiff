package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.aD;

class P implements Comparator {
   private final y.c.h a;
   private final aD b;

   P(aD var1, y.c.h var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(this.a.a(var1), this.a.a(var2));
   }
}
