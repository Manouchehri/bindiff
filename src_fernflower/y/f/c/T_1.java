package y.f.c;

import java.util.Comparator;
import y.f.c.S;

class T implements Comparator {
   private final int[] a;
   private final S b;

   T(S var1, int[] var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(this.a[((y.c.d)var1).c().d()], this.a[((y.c.d)var2).c().d()]);
   }
}
