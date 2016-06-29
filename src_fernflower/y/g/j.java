package y.g;

import java.util.Comparator;
import y.g.e;

class j implements Comparator {
   y.c.c a;

   public j(y.c.c var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = ((y.c.d)var1).d();
      y.c.q var4 = ((y.c.d)var2).d();
      return e.a(this.a.a(var3), this.a.a(var4));
   }
}
