package y.f.g;

import y.f.g.n;
import y.f.g.q;
import y.f.g.u;

class p implements y.d.g {
   private y.c.D a;
   private final n b;

   p(n var1) {
      this.b = var1;
      this.a = new y.c.D();
   }

   public void a(Object var1, Object var2) {
      u var3 = (u)var1;
      u var4 = (u)var2;
      int var5 = var3.l() + var4.l();
      y.d.t var6 = y.d.m.a(var3, var4);
      if(var6 != null) {
         this.a.add(new q(var6, var5, var3, var4));
      }

   }

   public y.c.D a() {
      return this.a;
   }
}
