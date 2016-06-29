package y.h;

import java.awt.geom.Point2D.Double;
import y.h.dI;
import y.h.gz;

class dL extends gz {
   private final dI a;

   dL(dI var1, double var2) {
      super(var2);
      this.a = var1;
   }

   public boolean a(y.d.t var1, y.d.t var2, byte var3) {
      y.d.t var4 = dI.a(this.a, var1.a, var1.b, dI.b(this.a));
      return var4 != null && var4.equals(var2);
   }

   public byte a(y.d.t var1, Double var2, byte var3) {
      y.d.t var4 = dI.a(this.a, var1.a, var1.b, dI.b(this.a));
      if(var4 != null) {
         var2.x = var4.a;
         var2.y = var4.b;
         return (byte)3;
      } else {
         return var3;
      }
   }
}
