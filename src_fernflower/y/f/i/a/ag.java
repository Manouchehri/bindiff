package y.f.i.a;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.Iterator;
import java.util.List;
import y.f.i.a.I;
import y.f.i.a.N;
import y.f.i.a.O;
import y.f.i.a.ab;
import y.f.i.a.af;

class ag extends I {
   private ag(O var1) {
      super(var1);
   }

   y.d.y a(y.f.X var1, List var2) {
      int var8 = ab.a;
      Rectangle var3 = var1.a();
      Iterator var4 = var2.iterator();

      y.d.y var10000;
      while(true) {
         if(var4.hasNext()) {
            N var5 = (N)var4.next();
            var10000 = var5.a();
            if(var8 != 0) {
               break;
            }

            y.d.y var6 = var10000;
            Double var7 = new Double(var6.c(), var6.d(), var6.a(), var6.b());
            Rectangle2D.union(var3, var7, var3);
            if(var8 == 0) {
               continue;
            }
         }

         var10000 = new y.d.y(var3.getX() - 100.0D, var3.getY() - 100.0D, var3.getWidth() + 200.0D, var3.getHeight() + 200.0D);
         break;
      }

      return var10000;
   }

   ag(O var1, af var2) {
      this(var1);
   }
}
