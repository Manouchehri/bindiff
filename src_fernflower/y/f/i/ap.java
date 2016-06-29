package y.f.i;

import java.util.Comparator;
import y.f.i.ao;
import y.f.i.v;

class ap implements Comparator {
   private y.d.t a;
   private y.c.q b;
   private y.c.c c;

   public ap(y.d.t var1, y.c.c var2) {
      this.a = var1;
      this.c = var2;
   }

   public void a(y.c.q var1) {
      this.b = var1;
   }

   public int compare(Object var1, Object var2) {
      int var11 = v.f;
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      ao var5 = (ao)this.c.b(var3.a(this.b));
      ao var6 = (ao)this.c.b(var4.a(this.b));
      if(var5 == null && var6 == null) {
         return 0;
      } else if(var5 == null) {
         return -1;
      } else if(var6 == null) {
         return 1;
      } else {
         double var7;
         label37: {
            if(var5.x()) {
               var7 = Math.abs(var5.r() - this.a.a);
               if(var11 == 0) {
                  break label37;
               }
            }

            var7 = Math.abs(var5.s() - this.a.b);
         }

         double var9;
         if(var6.x()) {
            var9 = Math.abs(var6.r() - this.a.a);
            if(var11 == 0) {
               return var7 < var9?-1:(var7 > var9?1:0);
            }
         }

         var9 = Math.abs(var6.s() - this.a.b);
         return var7 < var9?-1:(var7 > var9?1:0);
      }
   }
}
