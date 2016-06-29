package y.h.b;

import java.util.Comparator;
import y.h.bu;
import y.h.b.I;
import y.h.b.i;

class A implements Comparator {
   private boolean a;
   private I b;
   private bu c;

   A(boolean var1, I var2, bu var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = this.b.a((i)var1);
      y.c.q var4 = this.b.a((i)var2);
      return this.a?y.g.e.a(this.c.j(var3), this.c.j(var4)):y.g.e.a(this.c.k(var3), this.c.k(var4));
   }
}
