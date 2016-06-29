package y.d.b;

import java.util.Comparator;
import y.d.b.d;

class f implements Comparator, y.g.g {
   private final d a;

   f(d var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      ++d.c;
      double var3 = this.a.i(var1) * this.a.j(var2);
      double var5 = this.a.i(var2) * this.a.j(var1);
      double var7 = var3 - var5;
      var3 = Math.abs(var3);
      var5 = Math.abs(var5);
      double var9 = 4.0D * (var3 + var5) * d.h;
      if(var7 > var9) {
         return 1;
      } else if(var7 < -var9) {
         return -1;
      } else if(var9 < 1.0D) {
         return 0;
      } else {
         --d.c;
         return this.a.l(var1, var2);
      }
   }
}
