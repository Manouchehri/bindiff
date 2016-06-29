package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.y;

class z implements Comparator {
   private final y.f.X a;
   private final y b;

   z(y var1, y.f.X var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      double var4 = y.d.t.a(this.a.l(var3.c()), this.a.l(var3.d()));
      y.c.d var6 = (y.c.d)var2;
      double var7 = y.d.t.a(this.a.l(var6.c()), this.a.l(var6.d()));
      return var4 < var7?-1:(var7 < var4?1:0);
   }
}
