package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import y.h.bX;

public abstract class bY extends bX {
   Color g;

   public bY() {
      this.g = Color.lightGray;
   }

   public void a(Graphics2D var1) {
      this.a();
      if(this.g != null) {
         var1.setColor(this.g);
         var1.fill(this.f);
      }

      if(this.c != null && this.e != null) {
         var1.setColor(this.c);
         Rectangle2D var2 = this.e.getBounds();
         this.e.draw(var1, (float)(this.f.x + (this.f.width - var2.getWidth()) / 2.0D), (float)(this.f.y - var2.getY() + (this.f.height - var2.getHeight()) / 2.0D));
      }

   }

   public void b(Color var1) {
      this.g = var1;
   }
}
