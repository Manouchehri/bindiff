package y.f.g;

import y.f.g.u;

class q {
   final int a;
   final int b;
   final int c;
   final y.c.D d;

   private q(y.d.t var1, int var2) {
      this.a = (int)var1.a;
      this.b = (int)var1.b;
      this.c = var2;
      this.d = new y.c.D();
   }

   q(y.d.t var1, int var2, u var3) {
      this(var1, var2);
      this.d.add(var3);
   }

   q(y.d.t var1, int var2, u var3, u var4) {
      this(var1, var2);
      this.d.add(var3);
      this.d.add(var4);
   }
}
