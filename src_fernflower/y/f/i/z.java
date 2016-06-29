package y.f.i;

import java.util.Comparator;
import y.f.i.C;
import y.f.i.v;

class z implements Comparator {
   private final v a;

   z(v var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(((C)var1).a.b, ((C)var2).a.b);
   }
}
