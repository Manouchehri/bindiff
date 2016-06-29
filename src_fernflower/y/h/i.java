package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import y.h.az;
import y.h.dr;

class i implements az {
   GeneralPath a = new GeneralPath(1, 3);
   GeneralPath b = new GeneralPath(1, 3);

   i() {
      this.a.moveTo(0.0F, 0.0F);
      this.a.quadTo(-6.0F, 0.0F, -10.0F, -6.0F);
      this.b.moveTo(0.0F, 0.0F);
      this.b.quadTo(-6.0F, 0.0F, -10.0F, 6.0F);
   }

   public Rectangle getBounds() {
      return null;
   }

   public void a(Graphics2D var1) {
      Stroke var2 = var1.getStroke();
      var1.setStroke(dr.a);
      var1.draw(this.a);
      var1.draw(this.b);
      var1.setStroke(var2);
   }
}
