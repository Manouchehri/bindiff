package y.f.i;

import java.awt.geom.Rectangle2D.Double;
import java.util.Comparator;
import y.f.i.X;

class Z implements Comparator {
   private final X a;

   Z(X var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      Double var3 = (Double)var1;
      Double var4 = (Double)var2;
      int var5 = y.g.e.a(var3.x, var4.x);
      if(var5 != 0) {
         return var5;
      } else {
         var5 = y.g.e.a(var3.y, var4.y);
         return var5;
      }
   }
}
