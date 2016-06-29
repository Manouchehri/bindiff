package y.f.g;

import java.util.Comparator;
import y.f.g.n;
import y.f.g.q;

class v implements Comparator, y.g.g {
   private y.d.t a;
   private final n b;

   v(n var1) {
      this.b = var1;
      this.a = null;
   }

   v(n var1, double var2, double var4) {
      this.b = var1;
      this.a = new y.d.t(var2, var4);
   }

   public int compare(Object var1, Object var2) {
      double var3 = 50.0D / n.a(this.b);
      q var5 = (q)var1;
      q var6 = (q)var2;
      double var7 = this.a != null?y.d.t.a(this.a.a, this.a.b, (double)var5.a, (double)var5.b):0.0D;
      double var9 = this.a != null?y.d.t.a(this.a.a, this.a.b, (double)var6.a, (double)var6.b):0.0D;
      int var11 = (int)Math.floor(var7 / var3);
      int var12 = (int)Math.floor(var9 / var3);
      if(var11 < var12) {
         return -1;
      } else if(var11 > var12) {
         return 1;
      } else {
         int var13 = y.g.e.a(((q)var2).d.size(), ((q)var1).d.size());
         return var13 != 0?var13:y.g.e.a(((q)var1).c, ((q)var2).c);
      }
   }
}
