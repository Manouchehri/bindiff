package y.f.k;

import java.util.Comparator;
import y.f.k.o;

class r implements Comparator {
   private final o a;

   r(o var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = ((y.c.d)var1).d();
      y.c.q var4 = ((y.c.d)var2).d();
      return y.g.e.a(this.a.e(var3).a(), this.a.e(var4).a());
   }
}
