package y.f.i;

import java.util.Comparator;

class t implements Comparator {
   private y.f.X a;

   t(y.f.X var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = (y.c.q)var1;
      y.c.q var4 = (y.c.q)var2;
      y.d.t var5 = this.a.l(var3);
      y.d.t var6 = this.a.l(var4);
      return var5.a() < var6.a()?-1:(var5.a() > var6.a()?1:(var5.b() < var6.b()?-1:(var5.b() > var6.b()?1:0)));
   }
}
