package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D.Double;
import y.h.az;
import y.h.dU;
import y.h.gy;

class ei implements az {
   private final y.d.t a;
   private final dU b;

   ei(dU var1, y.d.t var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a(Graphics2D var1) {
      double var2 = Math.min(this.b.k().a, this.a.a);
      double var4 = Math.max(this.b.k().a, this.a.a);
      var1.draw(new Double(var2 - 60.0D, this.b.k().b, var4 + 60.0D, this.b.k().b));
      gy.a(var1, this.b.k().a, this.b.k().b);
   }

   public Rectangle getBounds() {
      double var1 = Math.min(this.b.k().a, this.a.a);
      double var3 = Math.max(this.b.k().a, this.a.a);
      return new Rectangle((int)(var1 - 60.0D - 10.0D), (int)(this.b.k().b - 20.0D), (int)(var3 - var1 + 130.0D), 40);
   }
}
