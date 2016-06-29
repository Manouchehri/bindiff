package y.f.a;

import java.util.Comparator;
import y.f.a.j;

class k implements Comparator {
   private final j a;

   k(j var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = (y.c.q)var1;
      y.c.q var4 = (y.c.q)var2;
      double var5 = Math.atan2(this.a.n.k(var3), this.a.n.j(var3));
      double var7 = Math.atan2(this.a.n.k(var4), this.a.n.j(var4));
      return var5 < var7?-1:(var5 > var7?1:0);
   }
}
