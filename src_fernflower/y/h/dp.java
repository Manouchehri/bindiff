package y.h;

import y.h.dk;
import y.h.dq;
import y.h.eU;
import y.h.fO;
import y.h.fP;
import y.h.fj;

final class dp implements fO {
   private dp() {
   }

   public fP a(y.d.t var1, y.d.t var2) {
      return new dq(this, var1, var2);
   }

   public fP a(fj var1, y.d.t var2) {
      y.d.t var3 = new y.d.t(var2.a() - var1.getCenterX(), var2.b() - var1.getCenterY());
      return new dq(this, var3, var3);
   }

   public y.d.t a(eU var1, fP var2) {
      dq var3 = (dq)var2;
      fj var4 = var1.b();
      return new y.d.t(var4.getCenterX() + var3.a, var4.getCenterY() + var3.b);
   }

   dp(dk var1) {
      this();
   }
}
