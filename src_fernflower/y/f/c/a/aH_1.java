package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.bh;

class aH implements Comparator {
   private y.c.c a;
   private y.c.c b;
   private int[] c;

   aH(y.c.c var1, y.c.c var2, int[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public int compare(Object var1, Object var2) {
      int var3 = this.b.a(var1);
      int var4 = this.b.a(var2);
      bh var5 = (bh)this.a.b(var1);
      bh var6 = (bh)this.a.b(var2);
      int var7 = var5 != null?var5.c().a():this.c[var3];
      int var8 = var6 != null?var6.c().a():this.c[var4];
      int var9 = y.g.e.a(var7, var8);
      return var9 != 0?var9:y.g.e.a(var3, var4);
   }
}
