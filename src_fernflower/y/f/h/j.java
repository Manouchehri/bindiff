package y.f.h;

import java.util.Comparator;
import y.f.h.i;

class j implements Comparator {
   private final y.c.h a;
   private final i b;

   j(i var1, y.c.h var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      int var5 = this.a.a(var3);
      int var6 = this.a.a(var4);
      return var5 == var6?0:(var5 < var6?1:-1);
   }
}
