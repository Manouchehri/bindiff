package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.aN;

class aO implements Comparator {
   private final y.c.A a;
   private final aN b;

   aO(aN var1, y.c.A var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      int var3 = this.a.a(var1);
      int var4 = this.a.a(var2);
      return var3 < var4?-1:(var3 > var4?1:0);
   }
}
