package y.f.i;

import java.util.Comparator;
import y.f.i.ao;
import y.f.i.v;

class aD implements Comparator {
   private y.d.t a;

   public aD(y.d.t var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      int var9 = v.f;
      ao var3 = (ao)var1;
      ao var4 = (ao)var2;
      if(var3 == null && var4 == null) {
         return 0;
      } else if(var3 == null) {
         return -1;
      } else if(var4 == null) {
         return 1;
      } else {
         double var5;
         label37: {
            if(var3.x()) {
               var5 = Math.abs(var3.r() - this.a.a);
               if(var9 == 0) {
                  break label37;
               }
            }

            var5 = Math.abs(var3.s() - this.a.b);
         }

         double var7;
         if(var4.x()) {
            var7 = Math.abs(var4.r() - this.a.a);
            if(var9 == 0) {
               return var5 < var7?-1:(var5 > var7?1:0);
            }
         }

         var7 = Math.abs(var4.s() - this.a.b);
         return var5 < var7?-1:(var5 > var7?1:0);
      }
   }
}
