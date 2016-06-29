package y.f.i;

import java.util.Comparator;
import y.f.i.v;

class A implements Comparator {
   private final int[] a;
   private final v b;

   A(v var1, int[] var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      return y.g.e.a(this.a[var4.b()], this.a[var3.b()]);
   }
}
