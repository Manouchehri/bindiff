package y.f.c;

import java.util.Comparator;
import y.f.c.e;

class f implements Comparator {
   private final y.f.X a;
   private final e b;

   f(e var1, y.f.X var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(this.b.a(this.a, (y.c.q)var1), this.b.a(this.a, (y.c.q)var2));
   }
}
