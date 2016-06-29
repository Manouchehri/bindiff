package y.f.c;

import java.util.Comparator;
import y.f.c.h;

class i implements Comparator {
   private final h a;

   i(h var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(h.a(this.a)[((y.c.q)var1).d()], h.a(this.a)[((y.c.q)var2).d()]);
   }
}
