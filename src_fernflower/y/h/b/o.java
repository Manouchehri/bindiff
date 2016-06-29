package y.h.b;

import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import y.h.fj;
import y.h.gt;
import y.h.b.a;
import y.h.b.b;
import y.h.b.s;

final class o extends y.h.a.b {
   private static final y.d.r b = new y.d.r(0.0D, 0.0D, 0.0D, 0.0D);

   private o() {
   }

   public y.d.r h(fj var1) {
      if(var1 instanceof a) {
         a var2 = (a)var1;
         s var3 = new s();
         a.a(var2, var3);
         a.b(var2, var3);
         return new y.d.r(var3.a, var3.b, var3.c, var3.d);
      } else {
         return b;
      }
   }

   public void c(fj var1) {
      if(var1 instanceof y.h.a.e) {
         y.h.a.e var2 = (y.h.a.e)var1;
         if(!var2.g()) {
            return;
         }

         var2.b(false);
         double[] var4;
         if(var2.isGroupClosed() || this.j(var2)) {
            if(!this.a()) {
               return;
            }

            Dimension2D var3 = this.e(var2);
            var4 = new double[]{var3.getWidth(), var3.getHeight()};
            this.a(var1, var4);
            double var5 = var2.getWidth();
            boolean var7 = false;
            if(var5 < var4[0]) {
               var5 = var4[0];
               var7 = true;
            }

            double var8 = var2.getHeight();
            if(var8 < var4[1]) {
               var8 = var4[1];
               var7 = true;
            }

            if(!var7) {
               return;
            }

            var2.setFrame(var2.getX(), var2.getY(), var5, var8);
            if(a.H == 0) {
               return;
            }
         }

         Rectangle2D var10 = this.d(var1);
         var4 = new double[]{var10.getWidth(), var10.getHeight()};
         this.a(var1, var4);
         var1.setFrame(var10.getX(), var10.getY(), var4[0], var4[1]);
      }

   }

   private void a(fj var1, double[] var2) {
      gt var3 = var1.getSizeConstraintProvider();
      if(var3 != null) {
         y.d.q var4 = var3.getMinimumSize();
         if(var2[0] < var4.a || var2[1] < var4.b) {
            var2[0] = Math.max(var2[0], var4.a);
            var2[1] = Math.max(var2[1], var4.b);
         }
      }

   }

   private boolean j(fj var1) {
      y.h.a.v var2 = this.i(var1);
      return var2 == null || !var2.p(var1.getNode()).f();
   }

   o(b var1) {
      this();
   }

   static y.d.r b() {
      return b;
   }
}
