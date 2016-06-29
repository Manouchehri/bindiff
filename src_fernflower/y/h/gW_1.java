package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import y.h.az;
import y.h.cV;
import y.h.ch;
import y.h.fj;
import y.h.hk;

public class gW implements az {
   protected ch a;
   protected az b;

   public gW(ch var1, az var2) {
      this.a = var1;
      this.b = var2;
   }

   public Rectangle getBounds() {
      Rectangle var1 = this.a();
      Point2D var2 = this.a.getViewPoint2D();
      double var3 = 1.0D / this.a.getZoom();
      AffineTransform var5 = new AffineTransform();
      var5.translate(var2.getX(), var2.getY());
      var5.scale(var3, var3);
      return var5.createTransformedShape(var1).getBounds();
   }

   public void a(Graphics2D var1) {
      AffineTransform var2;
      label13: {
         var2 = var1.getTransform();
         cV var3 = hk.a(var1);
         if(var3 != null && var3.a() != null) {
            var1.setTransform(var3.a());
            if(!fj.z) {
               break label13;
            }
         }

         Point2D var4 = this.a.getViewPoint2D();
         double var5 = 1.0D / this.a.getZoom();
         var1.translate(var4.getX(), var4.getY());
         var1.scale(var5, var5);
      }

      this.b(var1);
      var1.setTransform(var2);
   }

   protected void b(Graphics2D var1) {
      this.b.a(var1);
   }

   protected Rectangle a() {
      return this.b.getBounds();
   }
}
