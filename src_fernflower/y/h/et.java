package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.h.az;
import y.h.dY;
import y.h.e;
import y.h.er;
import y.h.fj;

class et extends er {
   private final double c;

   public et(byte var1, byte var2, y.d.t var3, double var4, double var6, Object var8, double var9, double var11, double var13, double var15) {
      super(var1, var2, var3, var4, var6, var8, var9, var11, var13);
      this.c = var15;
   }

   public az a(Rectangle2D var1) {
      return new dY(this, var1);
   }

   public Rectangle b(Rectangle2D var1) {
      double var2;
      double var4;
      double var6;
      Double var8;
      Rectangle var9;
      if(this.c() == 0) {
         var4 = Math.min(var1.getX(), this.e()) - 8.0D;
         var6 = Math.max(var1.getX(), this.b().a);
         var2 = this.d() == 1?var1.getY():var1.getY() + var1.getHeight();
         var8 = new Double(Math.min(var4, var6), Math.min(Math.min(this.c, var2), Math.min(this.a, this.b)), Math.abs(var6 - var4), 0.0D);
         var8.height = Math.max(Math.max(this.c, var2), Math.max(this.a, this.b)) - var8.y;
         var9 = var8.getBounds();
         var9.grow(20, 20);
         return var9;
      } else {
         var2 = this.d() == 4?var1.getX():var1.getX() + var1.getWidth();
         var4 = Math.min(var1.getY(), this.e()) - 8.0D;
         var6 = Math.max(var1.getY(), this.b().b);
         var8 = new Double(Math.min(Math.min(this.c, var2), Math.min(this.a, this.b)), Math.min(var4, var6), 0.0D, Math.abs(var6 - var4));
         var8.width = Math.max(Math.max(this.c, var2), Math.max(this.a, this.b)) - var8.x;
         var9 = var8.getBounds();
         var9.grow(20, 20);
         return var9;
      }
   }

   public void a(Graphics2D var1, Rectangle2D var2) {
      double var3;
      double var5;
      double var7;
      boolean var9;
      label32: {
         var9 = fj.z;
         if(this.c() == 0) {
            var5 = Math.min(var2.getX(), this.e()) - 8.0D;
            var7 = Math.max(var2.getX(), this.b().a);
            var3 = this.d() == 1?var2.getY():var2.getY() + var2.getHeight();
            if(!var9) {
               break label32;
            }
         }

         var3 = this.d() == 4?var2.getX():var2.getX() + var2.getWidth();
         var5 = Math.min(var2.getY(), this.e()) - 8.0D;
         var7 = Math.max(var2.getY(), this.b().b);
      }

      if(this.c() == 0) {
         var1.draw(new java.awt.geom.Line2D.Double(var5, this.a, var7, this.a));
         var1.draw(new java.awt.geom.Line2D.Double(var5, this.b, var7, this.b));
         var1.draw(new java.awt.geom.Line2D.Double(var5, this.c, var7, this.c));
         var1.draw(new java.awt.geom.Line2D.Double(var5, var3, var7, var3));
         e.a(var1, var5, this.a, var5, this.b);
         e.a(var1, var5, this.c, var5, var3);
         if(!var9) {
            return;
         }
      }

      var1.draw(new java.awt.geom.Line2D.Double(this.a, var5, this.a, var7));
      var1.draw(new java.awt.geom.Line2D.Double(this.b, var5, this.b, var7));
      var1.draw(new java.awt.geom.Line2D.Double(this.c, var5, this.c, var7));
      var1.draw(new java.awt.geom.Line2D.Double(var3, var5, var3, var7));
      e.a(var1, this.a, var5, this.b, var5);
      e.a(var1, this.c, var5, var3, var5);
   }
}
