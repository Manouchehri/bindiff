package y.f.a;

import y.f.X;

class C {
   private y.c.d a;
   private y.d.t b;
   private y.d.t c;

   C(y.c.d var1, y.d.t var2, y.d.t var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   y.d.m a(X var1) {
      y.d.t var2 = var1.l(this.a.c());
      y.d.t var3 = var1.l(this.a.d());
      y.d.m var4 = new y.d.m(y.d.t.b(var2, this.b), y.d.t.b(var3, this.c));
      return var4;
   }
}
