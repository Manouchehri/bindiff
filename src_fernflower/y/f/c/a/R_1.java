package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.aD;
import y.f.c.a.aV;

class R implements Comparator {
   private final aV a;
   private final aD b;

   R(aD var1, aV var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(this.a.a((y.c.q)var1).j(), this.a.a((y.c.q)var2).j());
   }
}
