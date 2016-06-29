package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.h.az;
import y.h.er;

class dX implements az {
   private final Rectangle2D a;
   private final er b;

   dX(er var1, Rectangle2D var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a(Graphics2D var1) {
      this.b.a(var1, this.a);
   }

   public Rectangle getBounds() {
      return this.b.b(this.a);
   }
}
