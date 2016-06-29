package y.f.h;

import java.util.Comparator;
import y.f.h.a;

class b implements Comparator {
   private final y.c.f a;
   private final a b;

   b(a var1, y.c.f var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      return y.g.e.a(this.a.indexOf(var3), this.a.indexOf(var4));
   }
}
