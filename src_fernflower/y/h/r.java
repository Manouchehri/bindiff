package y.h;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import y.h.az;
import y.h.dr;

abstract class r implements az {
   private final Ellipse2D a = new Double(-20.0D, -5.0D, 10.0D, 10.0D);

   public Rectangle getBounds() {
      return null;
   }

   public void a(Graphics2D var1) {
      Stroke var2 = var1.getStroke();
      var1.setStroke(dr.a);
      this.b(var1);
      var1.setStroke(var2);
   }

   void b(Graphics2D var1) {
   }

   void c(Graphics2D var1) {
      var1.drawLine(-15, -8, -15, 8);
   }

   void d(Graphics2D var1) {
      var1.drawLine(-10, 0, 2, 8);
      var1.drawLine(-10, 0, 2, 0);
      var1.drawLine(-10, 0, 2, -8);
   }

   void e(Graphics2D var1) {
      var1.drawLine(-6, -8, -6, 8);
   }

   void f(Graphics2D var1) {
      var1.drawLine(-10, -8, -10, 8);
   }

   void g(Graphics2D var1) {
      Shape var2 = var1.getClip();
      var1.clipRect(-12, -10, 12, 20);
      this.d(var1);
      var1.setClip(var2);
   }

   void h(Graphics2D var1) {
      Color var2 = var1.getColor();
      var1.setColor(Color.WHITE);
      var1.fill(this.a);
      var1.setColor(var2);
      var1.draw(this.a);
   }
}
