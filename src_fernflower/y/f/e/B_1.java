package y.f.e;

import y.f.X;
import y.f.e.q;

class B extends y.g.p {
   private y.c.c a;
   private y.c.c b;
   private X d;
   private final q e;

   B(q var1, X var2) {
      this.e = var1;
      this.d = var2;
      this.a = var2.c(q.o);
      this.b = var2.c(q.n);
   }

   public boolean d(Object var1) {
      y.c.q var2 = (y.c.q)var1;
      boolean var3 = q.a(this.e, var2, this.a, this.d) || q.a(this.e, var2, this.a) || this.b != null && !this.b.d(var2);
      return var3;
   }
}
