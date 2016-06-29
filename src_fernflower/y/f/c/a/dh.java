package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.dg;

class dh implements Comparator {
   private final float[] a;
   private final dg b;

   dh(dg var1, float[] var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      float var3 = var1 instanceof dg?dg.a((dg)var1):this.a[((y.c.q)var1).d()];
      float var4 = var2 instanceof dg?dg.a((dg)var2):this.a[((y.c.q)var2).d()];
      return var3 < var4?-1:(var3 > var4?1:0);
   }
}
