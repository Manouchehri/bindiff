package y.a;

import y.a.S;
import y.a.T;
import y.a.V;
import y.a.W;
import y.a.X;

class Y extends S {
   private final double a;
   private final double b;
   private final double c;
   private final X d;
   private final V e;
   private final W f;

   Y(double var1, double var3, double var5) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = new X((T)null);
      this.e = new V((T)null);
      this.f = new W((T)null);
   }

   double a(y.c.d[] var1, y.c.c var2, int var3) {
      return this.a * this.d.a(var1, var2, var3) + this.b * this.e.a(var1, var2, var3) + this.c * this.f.a(var1, var2, var3);
   }
}
