package y.f.c.a;

import java.util.Comparator;

final class cV implements Comparator {
   boolean a;
   boolean b;
   y.f.X c;

   cV(y.f.X var1, boolean var2, boolean var3) {
      this.a = var2;
      this.c = var1;
      this.b = var3;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var2;
      y.c.d var4 = (y.c.d)var1;
      return this.a?(this.b?y.g.e.a(this.c.n(var3).a, this.c.n(var4).a):y.g.e.a(this.c.n(var3).b, this.c.n(var4).b)):(this.b?y.g.e.a(this.c.o(var3).a, this.c.o(var4).a):y.g.e.a(this.c.o(var3).b, this.c.o(var4).b));
   }
}
