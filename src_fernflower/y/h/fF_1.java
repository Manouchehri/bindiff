package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D.Double;
import y.h.az;
import y.h.fE;

class fF implements az {
   private Double a;
   private Color b;

   private fF() {
      this.a = new Double();
      this.b = new Color(100, 100, 100, 100);
   }

   public void a(double var1, double var3, double var5, double var7) {
      this.a.setRect(var1, var3, var5, var7);
   }

   public void a(Graphics2D var1) {
      Color var2 = var1.getColor();
      var1.setColor(this.b);
      var1.fill(this.a);
      var1.setColor(var2);
   }

   public boolean a(double var1, double var3) {
      return this.a.contains(var1, var3);
   }

   public Rectangle getBounds() {
      return this.a.getBounds();
   }

   fF(fE var1) {
      this();
   }

   static Double a(fF var0) {
      return var0.a;
   }
}
