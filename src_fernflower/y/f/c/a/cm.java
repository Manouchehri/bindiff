package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.aV;
import y.f.c.a.bY;
import y.f.c.a.cd;

final class cm implements Comparator {
   y.f.X a;
   aV b;
   static final int[] c = new int[]{0, 0, 1, 0};

   cm(y.f.X var1, aV var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      y.f.aE var3 = cd.a(this.a, this.b, (y.c.d)var1);
      y.f.aE var4 = cd.a(this.a, this.b, (y.c.d)var2);
      y.f.aE var5 = cd.b(this.a, this.b, (y.c.d)var1);
      y.f.aE var6 = cd.b(this.a, this.b, (y.c.d)var2);
      int var7 = bY.a(var3.b(), 2);
      int var8 = bY.a(var4.b(), 2);
      int var9 = bY.a(var5.b(), 0);
      int var10 = bY.a(var6.b(), 0);
      int var11 = 4 + var9 - var7 & 3;
      int var12 = 4 + var10 - var8 & 3;
      if(var11 == 2 && var12 == 2) {
         return y.g.e.a(Math.min(var8, var10), Math.min(var7, var9));
      } else {
         var11 = c[var11];
         var12 = c[var12];
         return var11 == var12?y.g.e.a(var7, var8):y.g.e.a(var11, var12);
      }
   }
}
