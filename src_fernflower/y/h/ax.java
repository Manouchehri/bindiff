package y.h;

import y.h.am;
import y.h.as;
import y.h.fj;

final class ax implements am {
   private final y.c.e a;
   private final as b;

   ax(as var1, y.c.q var2) {
      this.b = var1;
      this.a = var2.k();
   }

   public boolean a() {
      boolean var2 = fj.z;

      boolean var10000;
      while(true) {
         if(this.a.f()) {
            var10000 = this.b.f.isEmpty();
            if(var2) {
               break;
            }

            if(var10000) {
               y.c.d var1 = this.a.a();
               if(this.b.b.get(var1.c().d()) || var1.e()) {
                  this.b.a(var1);
               }

               this.a.g();
               if(!var2) {
                  continue;
               }
            }
         }

         var10000 = this.a.f();
         break;
      }

      return !var10000;
   }
}
