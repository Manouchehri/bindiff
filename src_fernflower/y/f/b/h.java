package y.f.b;

import java.awt.geom.Rectangle2D;
import y.c.q;
import y.c.y;
import y.f.X;
import y.f.b.f;
import y.f.b.g;

public class h extends g {
   private Object a;
   private double b;
   private double c;
   private double d;
   private double e;

   public h() {
      this(f.f);
   }

   public h(Object var1) {
      this.d = 0.5D;
      this.e = 0.5D;
      this.a = var1;
   }

   public Rectangle2D a(X var1, q var2, y var3) {
      double var4 = this.b;
      double var6 = this.c;
      if(this.a != null) {
         y.c.c var8 = var1.c(this.a);
         if(var8 != null) {
            y.d.q var9 = (y.d.q)var8.b(var2);
            if(var9 != null) {
               var4 = var9.a;
               var6 = var9.b;
            }
         }
      }

      Rectangle2D var21 = super.a(var1, var2, var3);
      double var22 = var21.getX();
      double var11 = var21.getY();
      double var13 = var21.getWidth();
      double var15 = var21.getHeight();
      double var17;
      double var19;
      if(var13 < var4) {
         var17 = var4 - var13;
         var19 = this.d * var17;
         var22 -= var19;
         var13 = var4;
      }

      if(var15 < var6) {
         var17 = var6 - var15;
         var19 = this.e * var17;
         var11 -= var19;
         var15 = var6;
      }

      var21.setFrame(var22, var11, var13, var15);
      return var21;
   }
}
