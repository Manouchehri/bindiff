package y.f.e.a;

import java.util.List;
import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.af;
import y.f.e.a.ax;
import y.f.e.a.k;
import y.f.e.a.l;
import y.f.e.a.m;

abstract class i implements ax {
   private a a = new Z();

   public k a(m var1, l var2, a var3) {
      boolean var7 = af.b;
      List var4 = this.a(var1, var2);
      if(var4 != null && !var4.isEmpty()) {
         int var5 = 0;

         a var10000;
         while(true) {
            if(var5 < var4.size()) {
               ax var6 = (ax)var4.get(var5);
               this.a.a();
               var10000 = var3;
               if(var7) {
                  break;
               }

               var3.a(var6.a(var1, var2, this.a));
               ++var5;
               if(!var7) {
                  continue;
               }
            }

            var10000 = var3;
            break;
         }

         return var10000;
      } else {
         return var3;
      }
   }

   protected abstract List a(m var1, l var2);
}
