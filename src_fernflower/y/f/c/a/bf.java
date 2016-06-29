package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.A;
import y.f.c.a.aV;
import y.f.c.a.bb;
import y.f.c.a.bc;

class bf implements Comparator {
   private final y.c.q a;
   private final aV b;

   private bf(y.c.q var1, aV var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      A var4 = this.b.a(var3);
      boolean var5 = bb.a(var3.c().equals(this.a)?var4.c():var4.e());
      y.c.d var6 = (y.c.d)var2;
      A var7 = this.b.a(var6);
      boolean var8 = bb.a(var6.c().equals(this.a)?var7.c():var7.e());
      return var5 && !var8?-1:(!var5 && var8?1:0);
   }

   bf(y.c.q var1, aV var2, bc var3) {
      this(var1, var2);
   }
}
