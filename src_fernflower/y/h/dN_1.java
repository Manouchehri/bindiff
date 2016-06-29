package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.h.az;
import y.h.dI;
import y.h.fj;

class dN implements az {
   y.c.D a;
   Rectangle2D b;
   y.c.d c;
   y.c.q d;
   private final dI e;

   dN(dI var1, y.c.D var2, Rectangle2D var3, y.c.q var4, y.c.d var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.d = var4;
      this.c = var5;
   }

   public void a(Graphics2D var1) {
      boolean var4 = fj.z;
      y.c.C var2 = this.a.m();

      while(true) {
         if(var2.f()) {
            y.d.t var3 = (y.d.t)var2.d();
            this.e.a(var1, var3, this.d, this.c);
            var2.g();
            if(var4) {
               break;
            }

            if(!var4) {
               continue;
            }
         }

         if(dI.d(this.e) && this.e.f != null) {
            this.e.a(var1, this.e.f);
         }
         break;
      }

   }

   public Rectangle getBounds() {
      return dI.d(this.e) && this.e.f != null?this.b.getBounds().createUnion(dI.e(this.e)).getBounds():this.b.getBounds();
   }
}
