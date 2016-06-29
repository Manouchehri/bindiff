package y.f.e;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.f.X;
import y.f.am;
import y.f.e.q;

class v implements y.f.b.a {
   private final q a;

   v(q var1) {
      this.a = var1;
   }

   public Rectangle2D a(X var1, y.c.q var2, y.c.y var3) {
      am var4 = var1.h(var2);
      return new Double(var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight());
   }
}
