package y.f.f.b;

import java.util.Comparator;
import y.c.A;

class f implements Comparator {
   private A a;
   private boolean b;

   f(A var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      double var3 = this.a.c(var1);
      double var5 = this.a.c(var2);
      return var3 < var5?(this.b?1:-1):(var3 > var5?(this.b?-1:1):0);
   }
}
