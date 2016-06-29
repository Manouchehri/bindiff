package y.f.e;

import java.awt.Rectangle;
import java.util.Comparator;
import y.f.e.l;

final class n implements Comparator, y.g.g {
   private final l a;

   n(l var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = (y.c.q)var1;
      Rectangle var4 = l.a(this.a)[var3.d()];
      y.c.q var5 = (y.c.q)var2;
      Rectangle var6 = l.a(this.a)[var5.d()];
      boolean var7 = l.a(this.a, var3);
      boolean var8 = l.a(this.a, var5);
      if(var7 != var8 && var4.x <= var6.x + var6.width && var4.x + var4.width >= var6.x) {
         return var7?(var6.y + var6.height < var4.y?1:-1):(var4.y + var4.height < var6.y?-1:1);
      } else {
         int var9 = y.g.e.a((double)var4.y + (double)var4.height * 0.5D, (double)var6.y + (double)var6.height * 0.5D);
         return var9 != 0?var9:y.g.e.a(((y.c.q)var2).d(), ((y.c.q)var1).d());
      }
   }
}
