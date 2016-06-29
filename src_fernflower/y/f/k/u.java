package y.f.k;

import java.util.Comparator;
import y.f.k.d;

final class u implements Comparator {
   private final boolean a;
   private int b = 1;

   u(boolean var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      y.f.X var5 = (y.f.X)var3.a();
      int var6;
      if(this.a) {
         var6 = y.g.e.a(var5.k(var3.d()), var5.k(var4.d()));
         if(d.g == 0) {
            return this.b * var6;
         }
      }

      var6 = y.g.e.a(var5.j(var3.d()), var5.j(var4.d()));
      return this.b * var6;
   }
}
