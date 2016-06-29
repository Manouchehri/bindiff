package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.z;

class D implements Comparator {
   private y.c.c a;
   private y.c.c b;

   private D(y.c.c var1, y.c.c var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      int var3 = this.a.a(var1) + this.b.a(var1);
      int var4 = this.a.a(var2) + this.b.a(var2);
      return var3 < var4?1:(var3 > var4?-1:0);
   }

   D(y.c.c var1, y.c.c var2, z var3) {
      this(var1, var2);
   }
}
