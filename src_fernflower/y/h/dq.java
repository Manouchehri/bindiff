package y.h;

import y.h.dp;
import y.h.fO;
import y.h.fP;

final class dq implements fP {
   private final dp c;
   private final double d;
   private final double e;
   private final double f;
   private final double g;
   double a;
   double b;

   dq(dp var1, y.d.t var2, y.d.t var3) {
      this.c = var1;
      this.d = var2.a();
      this.e = var2.b();
      this.a = this.d;
      this.b = this.e;
      this.f = var3.a();
      this.g = var3.b();
   }

   public fO a() {
      return this.c;
   }

   void a(double var1, double var3) {
      this.a = var1 * this.d + var3 * this.f;
      this.b = var1 * this.e + var3 * this.g;
   }
}
