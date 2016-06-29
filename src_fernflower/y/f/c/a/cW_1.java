package y.f.c.a;

import java.util.Comparator;

final class cW implements Comparator {
   final int[] a;

   cW(int[] var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      int var3 = this.a[((y.c.d)var1).b()];
      int var4 = this.a[((y.c.d)var2).b()];
      return var3 > 0 && var4 > 0?y.g.e.a(var3, var4):0;
   }
}
