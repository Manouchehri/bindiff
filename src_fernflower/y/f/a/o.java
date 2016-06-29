package y.f.a;

import y.f.a.j;
import y.f.a.m;
import y.f.a.p;

class o implements y.d.g {
   private y.c.D a;
   private final j b;

   o(j var1) {
      this.b = var1;
      this.a = new y.c.D();
   }

   public y.c.D a() {
      return this.a;
   }

   public void a(Object var1, Object var2) {
      m var3 = (m)var1;
      m var4 = (m)var2;
      this.a.add(new p(this.b, var3.a(), var4.a()));
   }
}
