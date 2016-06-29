package y.f.k;

import java.awt.geom.Rectangle2D;
import java.util.List;
import y.f.k.P;
import y.f.k.T;
import y.f.k.d;
import y.f.k.l;
import y.f.k.m;

class k extends m {
   protected void a(P var1, List var2, Rectangle2D var3, double var4) {
      int var20 = d.g;
      l var6 = var1.k();
      y.c.q var7 = var1.i().k();
      y.f.O var8 = (y.f.O)var7.e();
      double var9 = Double.MAX_VALUE;
      double var11 = -1.7976931348623157E308D;
      y.c.d var13 = var7.f();

      double var10000;
      while(true) {
         if(var13 != null) {
            y.c.q var14 = var13.d();
            T var15 = new T(l.a(var6), var8.a(var14));
            double var16 = var15.c();
            double var18 = var15.b();
            var10000 = var16;
            if(var20 != 0) {
               break;
            }

            if(var16 < var9) {
               var9 = var16;
            }

            if(var16 + var18 > var11) {
               var11 = var16 + var18;
            }

            var13 = var13.g();
            if(var20 == 0) {
               continue;
            }
         }

         var10000 = var1.l();
         break;
      }

      double var21 = var10000;
      double var22 = (var9 + var11) / 2.0D - var21 / 2.0D;
      var1.b(-var1.f() + var22);
   }
}
