package y.f.f.e;

import java.util.Comparator;
import y.f.f.e.a;

class b implements Comparator {
   private final a a;

   b(a var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      Integer var3 = (Integer)var1;
      Integer var4 = (Integer)var2;
      return y.g.e.a(var3.intValue(), var4.intValue());
   }
}
