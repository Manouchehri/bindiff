package y.h;

import y.h.Y;
import y.h.am;
import y.h.fj;

final class ae implements am {
   private final y.c.e a;
   private final Y b;

   ae(Y var1, y.c.q var2) {
      this.b = var1;
      this.a = var2.k();
      this.a.j();
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
               if(var2 == Y.a(this.b) || !this.b.b.get(var2.d()) || var1.e()) {
                  this.b.b(var1);
               }

               this.a.h();
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
