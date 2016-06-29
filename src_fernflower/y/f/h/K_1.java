package y.f.h;

import java.util.Comparator;
import y.f.h.J;

class K implements Comparator {
   private final J a;

   K(J var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      int var5 = J.a(this.a).c(var3).k();
      int var6 = J.a(this.a).c(var4).k();
      return var5 == var6?0:(var5 > var6?-1:1);
   }
}
