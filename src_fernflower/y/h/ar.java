package y.h;

import y.h.am;
import y.h.an;
import y.h.fj;

final class ar implements am {
   private final y.c.e a;
   private final an b;

   ar(an var1, y.c.q var2) {
      this.b = var1;
      this.a = var2.k();
      this.a.j();
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
               if(!this.b.b.get(var1.c().d()) || var1.e()) {
                  this.b.b(var1);
               }

               this.a.h();
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
