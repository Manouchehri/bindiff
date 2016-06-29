package y.h;

import java.awt.geom.Point2D.Double;
import y.h.az;
import y.h.dI;
import y.h.el;
import y.h.gz;

class dK extends gz {
   private final y.d.t a;
   private final el c;
   private final dI d;

   dK(dI var1, double var2, az var4, y.d.t var5, el var6) {
      super(var2, var4);
      this.d = var1;
      this.a = var5;
      this.c = var6;
   }

   public byte a(y.d.t var1, Double var2, byte var3) {
      double var4 = var2.x - this.a.a;
      double var6 = var2.y - this.a.b;
      y.d.t var8 = dI.a(this.d, var2.x, var2.y, dI.b(this.d) / this.d.view.getZoom(), this.d.f, this.c.b(var4, var6));
      byte var9 = 0;
      if(var2.x != var8.a || var2.y != var8.b) {
         var9 = 3;
         var2.x = var8.a;
         var2.y = var8.b;
      }

      return var9;
   }

   public boolean a(y.d.t var1, y.d.t var2, byte var3) {
      double var4 = var2.a - this.a.a;
      double var6 = var2.b - this.a.b;
      return dI.a(this.d, var2.a, var2.b, dI.b(this.d) / this.d.view.getZoom(), this.d.f, this.c.b(var4, var6)).equals(var2);
   }
}
