package y.h.b;

import java.util.Comparator;
import y.h.bu;
import y.h.b.v;

class x implements Comparator {
   private final bu a;
   private final v b;

   x(v var1, bu var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      double var3 = this.a.k((y.c.q)var1);
      double var5 = this.a.k((y.c.q)var2);
      if(var3 > var5) {
         return 1;
      } else if(var3 < var5) {
         return -1;
      } else {
         double var7 = this.a.j((y.c.q)var1);
         double var9 = this.a.j((y.c.q)var2);
         return var7 > var9?1:(var7 < var9?-1:0);
      }
   }
}
