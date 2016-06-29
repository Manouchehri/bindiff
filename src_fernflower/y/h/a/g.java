package y.h.a;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import y.h.a.a;
import y.h.a.e;
import y.h.a.f;
import y.h.a.v;

final class g implements a {
   final e a;

   public g(e var1) {
      this.a = var1;
   }

   public void setAutoBoundsEnabled(boolean var1) {
      int var8 = v.a;
      if(!e.a(this.a) && var1) {
         if(!this.a.isGroupClosed() && !this.a()) {
            f var2 = e.b(this.a).m;
            Rectangle2D var3 = var2.f(this.a);
            double var4 = var3.getX() + var3.getWidth();
            double var6 = var3.getY() + var3.getHeight();
            e.a(this.a, e.c(this.a) + e.d(this.a) > var4?e.e(this.a) + e.f(this.a) - var4:0.0D);
            e.b(this.a, e.g(this.a) < var3.getY()?var3.getY() - e.h(this.a):0.0D);
            e.c(this.a, e.i(this.a) + e.j(this.a) > var6?e.k(this.a) + e.l(this.a) - var6:0.0D);
            e.d(this.a, e.m(this.a) < var3.getX()?var3.getX() - e.n(this.a):0.0D);
            e.a(this.a, var1);
            var2.c(this.a);
            if(var8 == 0) {
               return;
            }
         }

         e.a(this.a, var1);
         if(var8 == 0) {
            return;
         }
      }

      e.a(this.a, var1);
   }

   public boolean isAutoBoundsEnabled() {
      return this.a.g() && !this.a.isGroupClosed();
   }

   public Rectangle2D getMinimalAutoBounds() {
      f var1 = e.o(this.a).m;
      if(var1 != null) {
         return var1.f(this.a);
      } else {
         Double var2 = new Double(0.0D, 0.0D, -1.0D, -1.0D);
         this.a.calcUnionRect(var2);
         return var2;
      }
   }

   public void setAutoBoundsInsets(y.d.r var1) {
      this.a.b(var1);
   }

   public y.d.r getAutoBoundsInsets() {
      f var1 = e.p(this.a).m;
      return var1 != null?var1.h(this.a):new y.d.r(0.0D, 0.0D, 0.0D, 0.0D);
   }

   private boolean a() {
      y.c.q var1 = this.a.getNode();
      if(var1 == null) {
         return true;
      } else {
         v var2 = this.b();
         return var2 == null || !var2.p(var1).f();
      }
   }

   private v b() {
      y.c.q var1 = this.a.getNode();
      return var1 == null?null:v.a(var1.e());
   }
}
