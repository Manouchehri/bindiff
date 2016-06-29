package y.f.c.a;

import java.util.Comparator;

final class cO implements Comparator {
   final int[] a;

   cO(int[] var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      int var3 = this.a[((y.c.q)var1).d()];
      int var4 = this.a[((y.c.q)var2).d()];
      if(var3 < 0) {
         var3 = -(var3 + 1);
      }

      if(var4 < 0) {
         var4 = -(var4 + 1);
      }

      return y.g.e.a(var3, var4);
   }
}
