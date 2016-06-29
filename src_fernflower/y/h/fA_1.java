package y.h;

import y.h.eU;
import y.h.em;
import y.h.fL;
import y.h.fO;
import y.h.fP;

final class fA extends em {
   private final eU c;

   fA(eU var1, fL var2, y.d.t var3, byte var4) {
      super(var2, var3, var4);
      this.c = var1;
   }

   y.d.t c(double var1, double var3) {
      fO var5 = this.c.g().a();
      return var5.a(this.c, this.d(var1, var3));
   }

   boolean e() {
      return this.c != null;
   }

   public void a(double var1, double var3) {
      super.a(var1, var3);
      if(this.e()) {
         this.c.a(this.d(var1, var3));
      }

   }

   private fP d(double var1, double var3) {
      eU var5 = this.c;
      fO var6 = var5.g().a();
      return var6.a(var5.b(), new y.d.t(this.a(var1), this.b(var3)));
   }
}
