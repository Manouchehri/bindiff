package y.f.c.a;

import java.util.Comparator;

final class p implements Comparator {
   private y.c.c a;

   p(y.c.c var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      int var3 = this.a.a(var1);
      int var4 = this.a.a(var2);
      return var3 > var4?-1:(var3 < var4?1:0);
   }
}
