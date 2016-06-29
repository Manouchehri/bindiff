package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Iterator;
import y.h.az;
import y.h.bu;
import y.h.dc;
import y.h.de;
import y.h.fj;

class dd implements az {
   private final de a;
   private final boolean b;
   private final y.c.q c;
   private final dc d;

   dd(dc var1, de var2, boolean var3, y.c.q var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public void a(Graphics2D var1) {
      boolean var5 = fj.z;
      bu var2 = this.d.c().getGraph2D();
      var1.setColor(this.d.a());
      Iterator var3 = this.a.b.iterator();

      while(true) {
         if(var3.hasNext()) {
            y.c.q var4 = (y.c.q)var3.next();
            dc.a(this.d, var1, var2, var4, this.b);
            if(var5) {
               break;
            }

            if(!var5) {
               continue;
            }
         }

         dc.a(this.d, var1, var2, this.c, this.b);
         break;
      }

   }

   public Rectangle getBounds() {
      boolean var6 = fj.z;
      bu var1 = this.d.c().getGraph2D();
      Double var2 = new Double(0.0D, 0.0D, -1.0D, -1.0D);
      Iterator var3 = this.a.b.iterator();

      while(true) {
         if(var3.hasNext()) {
            y.c.q var4 = (y.c.q)var3.next();
            Rectangle2D var5 = dc.a(this.d, var1, var4, this.b);
            y.d.e.a((Rectangle2D)var2, (Rectangle2D)var5, (Rectangle2D)var2);
            if(var6) {
               break;
            }

            if(!var6) {
               continue;
            }
         }

         y.d.e.a((Rectangle2D)var2, (Rectangle2D)dc.a(this.d, var1, this.c, this.b), (Rectangle2D)var2);
         break;
      }

      return var2.getBounds();
   }
}
