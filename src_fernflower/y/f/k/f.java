package y.f.k;

import java.awt.geom.Rectangle2D;
import java.util.List;
import y.f.k.P;
import y.f.k.T;
import y.f.k.d;
import y.f.k.m;

class f extends m {
   protected void a(P var1, List var2, Rectangle2D var3, double var4) {
      y.c.q var6;
      y.f.O var7;
      double var8;
      label11: {
         var6 = var1.i().k();
         var7 = (y.f.O)var6.e();
         P var10;
         if(var2.size() % 2 == 0) {
            var10 = (P)var2.get(var2.size() / 2);
            P var11 = (P)var2.get(var2.size() / 2 - 1);
            var8 = (var10.b() + var11.b()) / 2.0D;
            if(d.g == 0) {
               break label11;
            }
         }

         var10 = (P)var2.get(var2.size() / 2);
         var8 = var10.b();
      }

      T var12 = new T(var1.k().a(), var7.a(var6));
      var1.b(-var12.e() + var8);
   }
}
