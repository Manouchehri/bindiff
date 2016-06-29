package y.f.i;

import java.util.Comparator;
import y.f.i.ao;
import y.f.i.v;

class y implements Comparator {
   private final y.c.q a;
   private final y.c.q b;
   private final ao c;
   private final v d;

   y(v var1, y.c.q var2, y.c.q var3, ao var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public int compare(Object var1, Object var2) {
      y.c.q var4;
      ao var6;
      double var7;
      y.c.q var11;
      int var12;
      label47: {
         var12 = v.f;
         y.c.q var3 = ((y.c.d)var1).a(this.a);
         var4 = ((y.c.d)var2).a(this.a);
         ao var5 = (ao)v.a(this.d).b(var3);
         var6 = (ao)v.a(this.d).b(var4);
         if(var5 == null) {
            var11 = var3 == this.b?v.b(this.d):v.c(this.d);
            var7 = this.c.x()?v.d(this.d).k(var11):v.d(this.d).j(var11);
            if(var12 == 0) {
               break label47;
            }
         }

         var7 = 0.5D * (var5.t() + var5.u());
      }

      double var9;
      if(var6 == null) {
         var11 = var4 == this.b?v.b(this.d):v.c(this.d);
         var9 = this.c.x()?v.d(this.d).k(var11):v.d(this.d).j(var11);
         if(var12 == 0) {
            return var7 > var9?1:(var7 < var9?-1:0);
         }
      }

      var9 = 0.5D * (var6.t() + var6.u());
      return var7 > var9?1:(var7 < var9?-1:0);
   }
}
