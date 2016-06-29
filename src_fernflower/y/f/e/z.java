package y.f.e;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.f.X;
import y.f.am;

final class z implements y.f.b.a {
   private final y.f.b.a a;
   private y.c.c b = null;
   private Object c = null;

   public z(y.f.b.a var1, y.c.c var2) {
      this.b = var2;
      this.a = var1;
   }

   public Rectangle2D a(X var1, y.c.q var2, y.c.y var3) {
      if(this.c != null) {
         this.b = var1.c(this.c);
      }

      if(this.b != null && this.b.d(var2)) {
         if(!var3.isEmpty()) {
            Rectangle2D var14 = this.a.a(var1, var2, var3);
            am var15 = var1.a((Object)var2);
            double var6 = Math.min(var14.getX(), var15.getX());
            double var8 = Math.min(var14.getY(), var15.getY());
            double var10 = Math.max(var14.getMaxX(), var15.getX() + var15.getWidth());
            double var12 = Math.max(var14.getMaxY(), var15.getY() + var15.getHeight());
            var14.setFrame(var6, var8, var10 - var6, var12 - var8);
            return var14;
         } else {
            am var4 = var1.a((Object)var2);
            if(var4.getWidth() == 0.0D || var4.getHeight() == 0.0D) {
               Rectangle2D var5 = this.a.a(var1, var2, var3);
               var4.setSize(var5.getWidth(), var5.getHeight());
            }

            return new Double(var4.getX(), var4.getY(), var4.getWidth(), var4.getHeight());
         }
      } else {
         return this.a.a(var1, var2, var3);
      }
   }
}
