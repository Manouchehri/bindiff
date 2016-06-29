package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import y.h.az;
import y.h.cS;

class cT extends Rectangle implements az {
   public double a;
   private final cS b;

   cT(cS var1) {
      this.b = var1;
   }

   public void a(Graphics2D var1) {
      cS.a(this.b).paintZoomIndicator(var1, this.x, this.y, this.width, this.height, this.a, cS.a(this.b).lastMouseWheelEvent);
   }
}
