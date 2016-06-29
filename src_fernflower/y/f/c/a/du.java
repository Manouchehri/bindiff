package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.dt;

class du implements Comparator {
   private final dt a;

   du(dt var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(dt.a(this.a).b((y.c.q)var1), dt.a(this.a).b((y.c.q)var2));
   }
}
