package y.h.b;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import y.h.fj;
import y.h.b.J;
import y.h.b.Y;
import y.h.b.a;

abstract class M extends y.h.b {
   private final boolean a;

   M(boolean var1) {
      this.a = var1;
   }

   public void a(fj var1, Graphics2D var2) {
      if(var1.isVisible()) {
         this.a(var2);

         try {
            this.a(var1, var2, false);
         } finally {
            this.b(var2);
         }
      }

   }

   protected void a(fj var1, Graphics2D var2, boolean var3) {
      int var25 = a.H;
      Rectangle2D var4 = J.e(var1);
      double var5 = var4.getX();
      double var7 = var4.getY();
      double var9 = var4.getWidth();
      double var11 = var4.getHeight();
      a var13 = J.a(var1);
      Y var14 = this.b(var1);
      y.d.r var15 = this.a(var1);
      if((var15.a > 0.0D || var15.b > 0.0D || var15.c > 0.0D || var15.d > 0.0D) && (var14.c(var13) != null || var14.a(var13) != null && var14.b(var13) != null)) {
         double var16;
         double var18;
         double var20;
         double var22;
         label43: {
            var16 = var5 + var15.b;
            var18 = var7 + var15.a;
            var20 = var9 - var15.b - var15.d;
            var22 = var11 - var15.a - var15.c;
            if(this.a) {
               if(var14.a(var13) == null || var14.b(var13) == null) {
                  break label43;
               }

               var4.setFrame(var5, var7, var9, var11);
               var2.setStroke(var14.a(var13));
               var2.setColor(var14.b(var13));
               var2.draw(var4);
               if(var25 == 0) {
                  break label43;
               }
            }

            if(var14.c(var13) != null) {
               Area var24 = new Area(var4);
               var4.setFrame(var16, var18, var20, var22);
               var24.subtract(new Area(var4));
               var2.setColor(var14.c(var13));
               var2.fill(var24);
            }
         }

         var4.setFrame(var16, var18, var20, var22);
      }

      if(this.a) {
         if(var14.d(var13) == null || var14.e(var13) == null) {
            return;
         }

         var2.setStroke(var14.d(var13));
         var2.setColor(var14.e(var13));
         var2.draw(var4);
         if(var25 == 0) {
            return;
         }
      }

      if(var14.f(var13) != null) {
         var2.setColor(var14.f(var13));
         var2.fill(var4);
      }

   }

   abstract y.d.r a(fj var1);

   abstract Y b(fj var1);
}
