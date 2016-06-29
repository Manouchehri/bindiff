package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D.Double;
import y.h.e;
import y.h.eo;
import y.h.fj;

class ex extends eo {
   private final double a;

   ex(byte var1, byte var2, y.d.t var3, double var4, double var6, Object var8, double var9, double var11) {
      super(var1, var2, var3, var4, var6, var8, var9);
      this.a = var11;
   }

   protected Rectangle b(Rectangle2D var1) {
      Rectangle var2 = super.b(var1);
      var2.grow((int)this.a, (int)this.a);
      return var2;
   }

   protected void a(Graphics2D var1, Rectangle2D var2) {
      boolean var8 = fj.z;
      y.d.t var3 = this.b();
      double var4;
      double var6;
      switch(this.d()) {
      case 1:
         var4 = Math.max(this.e(), var2.getX());
         var6 = Math.min(this.f(), var2.getX() + var2.getWidth());
         e.a(var1, (var4 + var6) * 0.5D, var3.b, (var4 + var6) * 0.5D, var3.b - this.a);
         var1.draw(new Double(var3.a, var3.b - this.a, (var4 + var6) * 0.5D, var3.b - this.a));
         if(!var8) {
            break;
         }
      case 2:
         var4 = Math.max(this.e(), var2.getX());
         var6 = Math.min(this.f(), var2.getX() + var2.getWidth());
         e.a(var1, (var4 + var6) * 0.5D, var3.b, (var4 + var6) * 0.5D, var3.b + this.a);
         var1.draw(new Double(var3.a, var3.b + this.a, (var4 + var6) * 0.5D, var3.b + this.a));
         if(!var8) {
            break;
         }
      case 4:
         var4 = Math.max(this.e(), var2.getY());
         var6 = Math.min(this.f(), var2.getY() + var2.getHeight());
         e.a(var1, var3.a, (var4 + var6) * 0.5D, var3.a - this.a, (var4 + var6) * 0.5D);
         var1.draw(new Double(var3.a - this.a, var3.b, var3.a - this.a, (var4 + var6) * 0.5D));
         if(!var8) {
            break;
         }
      case 8:
         var4 = Math.max(this.e(), var2.getY());
         var6 = Math.min(this.f(), var2.getY() + var2.getHeight());
         e.a(var1, var3.a, (var4 + var6) * 0.5D, var3.a + this.a, (var4 + var6) * 0.5D);
         var1.draw(new Double(var3.a + this.a, var3.b, var3.a + this.a, (var4 + var6) * 0.5D));
      case 3:
      case 5:
      case 6:
      case 7:
      }

   }
}
