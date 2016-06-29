package y.f.h;

import java.util.Comparator;

class A implements Comparator {
   private int[] a;

   public void a(int[] var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      int var3 = this.a[((y.c.q)var1).d()];
      int var4 = this.a[((y.c.q)var2).d()];
      return y.g.e.a(var3, var4);
   }
}
