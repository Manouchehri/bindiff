package y.h;

import y.h.az;
import y.h.e;
import y.h.ec;
import y.h.ev;
import y.h.gC;

class dV extends gC {
   private final ev a;

   dV(ev var1, double var2, az var4, boolean var5, double var6, Object var8) {
      super(var2, var4, var5, var6, var8);
      this.a = var1;
   }

   public az a(e var1, y.d.t var2) {
      double var3 = var2.a - var1.k().a;
      double var5 = var2.b - var1.k().b;
      return new ec(this, var3, var5);
   }

   static ev a(dV var0) {
      return var0.a;
   }
}
