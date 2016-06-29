package y.h;

import y.h.ag;
import y.h.am;
import y.h.fj;

final class aj implements am {
   private final y.c.e a;
   private final ag b;

   aj(ag var1, y.c.q var2) {
      this.b = var1;
      this.a = var2.k();
   }

   public boolean a() {
      boolean var3 = fj.z;

      boolean var10000;
      while(true) {
         if(this.a.f()) {
            var10000 = this.b.f.isEmpty();
            if(var3) {
               break;
            }

            if(var10000) {
               y.c.d var1 = this.a.a();
               y.c.q var2 = this.b.a.n(var1.c());
               if(var2 == ag.a(this.b) || this.b.b.get(var2.d()) || var1.e()) {
                  this.b.a(var1);
               }

               this.a.g();
               if(!var3) {
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
