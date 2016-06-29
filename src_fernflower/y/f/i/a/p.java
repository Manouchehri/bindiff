package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.N;
import y.f.i.a.n;

class p implements Comparator {
   private final n a;

   p(n var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return (int)(((N)var1).a().d() - ((N)var2).a().d());
   }
}
