package y.g.a;

import java.util.Comparator;
import y.c.A;
import y.g.a.j;

class k implements Comparator {
   private final A a;
   private final j b;

   k(j var1, A var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = (y.c.q)var1;
      y.c.q var4 = (y.c.q)var2;
      int var5 = this.a.a(var3);
      int var6 = this.a.a(var4);
      return var5 == var6?y.g.e.a(var3.d(), var4.d()):(var5 < var6?-1:1);
   }
}
