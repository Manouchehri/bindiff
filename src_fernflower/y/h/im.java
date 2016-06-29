package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.h.az;
import y.h.fj;

class im extends y.c.D implements az {
   public void a(Graphics2D var1) {
      boolean var3 = fj.z;
      y.c.C var2 = this.m();

      while(var2.f()) {
         ((az)var2.d()).a(var1);
         var2.g();
         if(var3) {
            break;
         }
      }

   }

   public Rectangle getBounds() {
      boolean var3 = fj.z;
      if(this.isEmpty()) {
         return new Rectangle(0, 0, -1, -1);
      } else {
         y.c.C var1 = this.m();
         Rectangle var2 = ((az)var1.d()).getBounds().getBounds();
         var1.g();

         Rectangle var10000;
         while(true) {
            if(var1.f()) {
               var10000 = ((az)var1.d()).getBounds();
               if(var3) {
                  break;
               }

               y.d.e.a((Rectangle2D)var10000, (Rectangle2D)var2, (Rectangle2D)var2);
               var1.g();
               if(!var3) {
                  continue;
               }
            }

            var10000 = var2;
            break;
         }

         return var10000;
      }
   }
}
