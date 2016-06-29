package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import y.h.az;
import y.h.e;
import y.h.fj;
import y.h.gz;

class f implements az {
   private final e a;

   f(e var1) {
      this.a = var1;
   }

   public void a(Graphics2D var1) {
      boolean var4 = fj.z;
      var1.setColor(e.a(this.a));
      if(e.b(this.a) != null && e.c(this.a)) {
         y.d.t var2 = new y.d.t(e.d(this.a).a + e.e(this.a), e.d(this.a).b + e.f(this.a));
         int var3 = 0;

         while(var3 < e.b(this.a).size()) {
            ((gz)e.b(this.a).get(var3)).a(this.a, var2).a(var1);
            ++var3;
            if(var4) {
               break;
            }
         }
      }

   }

   public Rectangle getBounds() {
      boolean var5 = fj.z;
      Rectangle var1 = new Rectangle(0, 0, -1, -1);
      Rectangle var10000;
      if(e.b(this.a) != null && e.c(this.a)) {
         y.d.t var2 = new y.d.t(e.d(this.a).a + e.e(this.a), e.d(this.a).b + e.f(this.a));
         int var3 = 0;

         while(var3 < e.b(this.a).size()) {
            Rectangle var4 = ((gz)e.b(this.a).get(var3)).a(this.a, var2).getBounds();
            var10000 = var4;
            if(var5) {
               return var10000;
            }

            y.d.e.a((Rectangle2D)var4, (Rectangle2D)var1, (Rectangle2D)var1);
            ++var3;
            if(var5) {
               break;
            }
         }
      }

      var10000 = var1;
      return var10000;
   }
}
