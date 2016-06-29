package y.f.i;

import java.util.Comparator;
import y.f.i.aM;
import y.f.i.aP;

class aE implements Comparator {
   private y.c.q a;
   private y.c.c b;

   public aE(y.c.q var1, y.c.c var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      y.c.q var5 = var3.a(this.a);
      y.c.q var6 = var4.a(this.a);
      aM var7 = (aM)this.b.b(var5);
      aM var8 = (aM)this.b.b(var6);
      double var9 = ((aP)var7.a()).b;
      double var11 = ((aP)var8.a()).b;
      return var9 < var11?-1:(var9 > var11?1:0);
   }
}
