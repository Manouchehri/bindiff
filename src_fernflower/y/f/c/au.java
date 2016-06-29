package y.f.c;

import java.util.Comparator;

final class au implements Comparator, y.g.g {
   Comparator a;
   y.c.c b;
   int[] c;

   public int compare(Object var1, Object var2) {
      y.c.q var3 = (y.c.q)var1;
      y.c.d var4 = (y.c.d)this.b.b(var3);
      y.c.q var5 = (y.c.q)var2;
      y.c.d var6 = (y.c.d)this.b.b(var5);
      return var4 == null?(var6 == null?y.g.e.a(this.c[var3.d()], this.c[var5.d()]):-1):(var6 == null?1:this.a.compare(var4, var6));
   }
}
