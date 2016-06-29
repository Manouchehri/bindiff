package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;
import y.h.az;
import y.h.dr;

class j implements az {
   GeneralPath a = new GeneralPath(1, 3);
   GeneralPath b = new GeneralPath(1, 3);

   j() {
      this.a.moveTo(-11.0F, -5.0F);
      this.a.quadTo(-4.0F, -5.0F, -1.0F, 0.25F);
      this.b.moveTo(-11.0F, 5.0F);
      this.b.quadTo(-4.0F, 5.0F, -1.0F, -0.25F);
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
