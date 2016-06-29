package y.h;

import y.h.am;
import y.h.as;
import y.h.fj;

final class at implements am {
   private final y.c.e a;
   private final y.c.q b;
   private final as c;

   at(as var1, y.c.q var2) {
      this.c = var1;
      this.b = var2;
      this.a = var2.l();
   }

   public boolean a() {
      boolean var2 = fj.z;

      boolean var10000;
      while(true) {
         if(this.a.f()) {
            var10000 = this.c.f.isEmpty();
            if(var2) {
               break;
            }

            if(var10000) {
               y.c.d var1 = this.a.a();
               if(!var1.e() && this.c.b.get(var1.d().d())) {
                  this.c.a(var1);
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

      if(!var10000) {
         this.c.b.set(this.b.d());
      }

      return !this.a.f();
   }
}
