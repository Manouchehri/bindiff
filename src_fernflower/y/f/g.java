package y.f;

import java.util.Comparator;
import y.f.e;

class g implements Comparator {
   private final e a;

   g(e var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      int var3 = ((Integer)var1).intValue();
      int var4 = ((Integer)var2).intValue();
      return y.g.e.a(e.a(this.a)[var3].e.y, e.a(this.a)[var4].e.y);
   }
}
