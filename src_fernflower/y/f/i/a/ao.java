package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.aq;

final class ao implements Comparator {
   private y.c.c a;

   ao(y.c.c var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      aq var3 = (aq)var1;
      aq var4 = (aq)var2;
      int var5 = this.a.a(aq.a(var3));
      int var6 = this.a.a(aq.a(var4));
      return var6 - var5;
   }
}
