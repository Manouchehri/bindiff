package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.cr;
import y.f.c.a.cy;

class cs implements Comparator {
   private final cr a;

   cs(cr var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      if(var1 == var2) {
         return 0;
      } else {
         cy var3 = (cy)var1;
         cy var4 = (cy)var2;
         return y.g.e.a(var3.d, var4.d);
      }
   }
}
