package y.h;

import java.awt.geom.Point2D.Double;
import y.h.az;
import y.h.dU;
import y.h.gz;

class ej extends gz {
   boolean a;
   private final dU c;

   ej(dU var1, double var2, az var4) {
      super(var2, var4);
      this.c = var1;
   }

   public boolean a(y.d.t var1, y.d.t var2, byte var3) {
      return this.a && var2.a != this.c.k().a && var2.b == this.c.k().b;
   }

   public byte a(y.d.t var1, Double var2, byte var3) {
      this.a = (var3 & 2) == 0;
      var2.y = this.c.k().b;
      return (byte)(2 | var3);
   }
}
