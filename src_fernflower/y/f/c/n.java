package y.f.c;

import java.util.Comparator;
import y.f.c.h;

class n implements Comparator {
   boolean a;
   boolean b;
   private final h c;

   n(h var1, boolean var2, boolean var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var2;
      y.c.d var4 = (y.c.d)var1;
      return this.a?(this.b?y.g.e.a(this.c.b.n(var3).a, this.c.b.n(var4).a):y.g.e.a(this.c.b.n(var3).b, this.c.b.n(var4).b)):(this.b?y.g.e.a(this.c.b.o(var3).a, this.c.b.o(var4).a):y.g.e.a(this.c.b.o(var3).b, this.c.b.o(var4).b));
   }
}
