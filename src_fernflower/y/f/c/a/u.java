package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.r;

class u implements Comparator {
   private final int[] a;
   private final r b;

   u(r var1, int[] var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = (y.c.q)var1;
      y.c.q var4 = (y.c.q)var2;
      return y.g.e.a(this.a[var4.d()], this.a[var3.d()]);
   }
}
