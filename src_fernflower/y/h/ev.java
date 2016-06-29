package y.h;

import y.h.az;
import y.h.dV;
import y.h.el;
import y.h.gz;

final class ev implements Comparable {
   final double a;
   private final el b;
   private final el c;

   public int compareTo(Object var1) {
      return y.g.e.a(this.a, ((ev)var1).a);
   }

   protected ev(double var1, el var3, el var4) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
   }

   public gz a(boolean var1) {
      return new dV(this, 0.5D, (az)null, var1, this.a, (Object)null);
   }

   static el a(ev var0) {
      return var0.c;
   }

   static el b(ev var0) {
      return var0.b;
   }
}
