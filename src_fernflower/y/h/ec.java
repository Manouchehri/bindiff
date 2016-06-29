package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D.Double;
import y.h.az;
import y.h.dV;
import y.h.dr;
import y.h.ev;

class ec implements az {
   private final double a;
   private final double b;
   private final dV c;

   ec(dV var1, double var2, double var4) {
      this.c = var1;
      this.a = var2;
      this.b = var4;
   }

   public void a(Graphics2D var1) {
      double var2 = ev.a(dV.a(this.c)).a(this.a);
      double var4 = ev.a(dV.a(this.c)).b(this.b);
      var1.setStroke(dr.c);
      var1.draw(new Double(ev.b(dV.a(this.c)).a(this.a), ev.b(dV.a(this.c)).b(this.b), var2, var4));
      var1.setStroke(dr.a);
   }

   public Rectangle getBounds() {
      double var1 = ev.a(dV.a(this.c)).a(this.a);
      double var3 = ev.a(dV.a(this.c)).b(this.b);
      java.awt.geom.Rectangle2D.Double var5 = new java.awt.geom.Rectangle2D.Double(var1, var3, 0.0D, 0.0D);
      var5.add(ev.b(dV.a(this.c)).a(this.a), ev.b(dV.a(this.c)).b(this.b));
      Rectangle var6 = var5.getBounds();
      var6.grow(5, 5);
      return var6;
   }
}
