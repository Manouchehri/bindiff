package y.f.h;

import java.util.Comparator;

class B implements Comparator {
   private y.c.q a;
   private int[] b;

   public void a(y.c.q var1) {
      this.a = var1;
   }

   public void a(int[] var1) {
      this.b = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      int var5 = this.b[var3.a(this.a).d()];
      int var6 = this.b[var4.a(this.a).d()];
      return var5 < var6?1:(var5 > var6?-1:0);
   }
}
