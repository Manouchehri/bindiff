package y.f.k;

import java.util.Comparator;
import y.f.k.o;

class s implements Comparator, y.g.g {
   private final o a;

   s(o var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = ((y.c.d)var1).d();
      y.c.q var4 = ((y.c.d)var2).d();
      double var5 = o.a(this.a).c(var3);
      double var7 = o.a(this.a).c(var4);
      return var5 > var7 + o.u()?1:(var5 + o.u() < var7?-1:y.g.e.a(this.a.e(var3).a(), this.a.e(var4).a()));
   }
}
