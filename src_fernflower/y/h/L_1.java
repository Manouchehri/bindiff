package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import y.h.F;
import y.h.az;
import y.h.bu;
import y.h.fj;

class L extends bu implements az {
   private final F a;

   L(F var1) {
      this.a = var1;
   }

   public void a(Graphics2D var1) {
      this.i(this.l()).paint(var1);
      if(F.g(this.a)) {
         if(this.a.e() && F.h(this.a) != null) {
            this.a.a(var1, F.h(this.a));
            if(!fj.z) {
               return;
            }
         }

         if(F.i(this.a) != null) {
            this.a.a(var1, this.a.getGraph2D().t(F.i(this.a)));
         }
      }

   }

   public Rectangle getBounds() {
      Rectangle var1 = this.a();
      if(F.g(this.a)) {
         if(F.i(this.a) != null) {
            fj var2 = this.a.getGraph2D().t(F.i(this.a));
            var1 = var1.union(this.a.b(var2).getBounds()).getBounds();
         }

         if(this.a.e() && F.h(this.a) != null) {
            y.d.y var3 = F.h(this.a).k();
            var1.add(var3.c(), var3.d());
            var1.add(var3.c() + var3.a(), var3.d() + var3.b());
         }
      }

      return var1;
   }
}
