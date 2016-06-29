package y.f.c;

import java.util.Comparator;
import y.f.c.h;

class j implements Comparator {
   private final h a;

   j(h var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a((int)h.a(this.a)[((y.c.d)var1).c().d()], (int)h.a(this.a)[((y.c.d)var2).c().d()]);
   }
}
