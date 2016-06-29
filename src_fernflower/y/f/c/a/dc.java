package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.db;

class dc implements Comparator {
   private final int[] a;
   private final db b;

   dc(db var1, int[] var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(this.a[((y.c.q)var1).d()], this.a[((y.c.q)var2).d()]);
   }
}
