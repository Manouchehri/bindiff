package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.N;
import y.f.i.a.n;

class o implements Comparator {
   private final n a;

   o(n var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return (int)(((N)var1).a().c() - ((N)var2).a().c());
   }
}
