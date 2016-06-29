package y.f.c;

import java.util.Comparator;
import y.f.c.am;
import y.f.c.x;

final class an implements Comparator {
   int[] a;
   private final am b;

   an(am var1) {
      this.b = var1;
      this.a = new int[]{0, 0, 1, 0};
   }

   public int compare(Object var1, Object var2) {
      y.f.aE var3 = this.b.a((y.c.d)var1);
      y.f.aE var4 = this.b.a((y.c.d)var2);
      y.f.aE var5 = this.b.b((y.c.d)var1);
      y.f.aE var6 = this.b.b((y.c.d)var2);
      int var7 = x.a(var3.b(), 2);
      int var8 = x.a(var4.b(), 2);
      int var9 = x.a(var5.b(), 0);
      int var10 = x.a(var6.b(), 0);
      int var11 = 4 + var9 - var7 & 3;
      int var12 = 4 + var10 - var8 & 3;
      if(var11 == 2 && var12 == 2) {
         return y.g.e.a(Math.min(var8, var10), Math.min(var7, var9));
      } else {
         var11 = this.a[var11];
         var12 = this.a[var12];
         return var11 == var12?y.g.e.a(var7, var8):y.g.e.a(var11, var12);
      }
   }
}
