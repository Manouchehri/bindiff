package y.h;

import y.h.Y;
import y.h.am;
import y.h.fj;

final class Z implements am {
   private final y.c.q a;
   private final y.c.e b;
   private final Y c;

   Z(Y var1, y.c.q var2, y.c.q var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3.l();
      this.b.j();
   }

   public boolean a() {
      boolean var3 = fj.z;

      boolean var10000;
      while(true) {
         if(this.b.f()) {
            var10000 = this.c.f.isEmpty();
            if(var3) {
               break;
            }

            if(var10000) {
               y.c.d var1 = this.b.a();
               y.c.q var2 = this.c.a.n(var1.d());
               if(!var1.e() && (var2 == Y.a(this.c) || !this.c.b.get(var2.d())) && var2 != this.a) {
                  this.c.b(var1);
               }

               this.b.h();
               if(!var3) {
                  continue;
               }
            }
         }

         var10000 = this.b.f();
         break;
      }

      return !var10000;
   }
}
