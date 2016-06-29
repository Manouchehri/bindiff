package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.bs;

class bt implements Comparator {
   private final double[] a;
   private final bs b;

   bt(bs var1, double[] var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      int var3 = ((Integer)var1).intValue();
      int var4 = ((Integer)var2).intValue();
      double var5 = this.a[var3];
      double var7 = this.a[var4];
      return var5 < var7?-1:(var5 > var7?1:0);
   }
}
