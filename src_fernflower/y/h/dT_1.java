package y.h;

import java.awt.geom.Point2D.Double;
import y.h.dP;
import y.h.gz;

class dT extends gz {
   private final dP a;

   dT(dP var1, double var2) {
      super(var2);
      this.a = var1;
   }

   public byte a(y.d.t var1, Double var2, byte var3) {
      if(this.a.isGridMode()) {
         double var4 = var1.a;
         double var6 = var1.b;
         double var8 = this.a.getGridX(var4);
         double var10 = this.a.getGridY(var6);
         var2.x = var8;
         var2.y = var10;
         return (byte)3;
      } else {
         return var3;
      }
   }

   public boolean a(y.d.t var1, y.d.t var2, byte var3) {
      return this.a.isGridMode();
   }
}
