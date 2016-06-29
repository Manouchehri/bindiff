package y.h;

import java.awt.geom.Point2D.Double;
import y.h.az;
import y.h.gz;

class gC extends gz {
   private final boolean a;
   private final double c;

   public gC(double var1, az var3, boolean var4, double var5, Object var7) {
      super(var1, var3, var7);
      this.a = var4;
      this.c = var5;
   }

   public byte a(y.d.t var1, Double var2, byte var3) {
      if(this.a) {
         var2.x = this.c;
         return (byte)(1 | var3);
      } else {
         var2.y = this.c;
         return (byte)(2 | var3);
      }
   }

   public boolean a(y.d.t var1, y.d.t var2, byte var3) {
      return this.a?var2.a == this.c:var2.b == this.c;
   }
}
