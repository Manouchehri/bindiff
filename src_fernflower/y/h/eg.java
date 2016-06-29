package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D.Double;
import y.h.az;
import y.h.dU;
import y.h.gy;

class eg implements az {
   private final y.d.t a;
   private final dU b;

   eg(dU var1, y.d.t var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a(Graphics2D var1) {
      double var2 = Math.min(this.b.k().b, this.a.b);
      double var4 = Math.max(this.b.k().b, this.a.b);
      var1.draw(new Double(this.b.k().a, var2 - 60.0D, this.b.k().a, var4 + 60.0D));
      gy.a(var1, this.b.k().a, this.b.k().b);
   }

   public Rectangle getBounds() {
      double var1 = Math.min(this.b.k().b, this.a.b);
      double var3 = Math.max(this.b.k().b, this.a.b);
      return new Rectangle((int)(this.b.k().a - 10.0D), (int)(var1 - 60.0D - 10.0D), 20, (int)(var3 - var1 + 140.0D));
   }
}
