package y.h;

import y.h.Y;
import y.h.Z;
import y.h.ae;
import y.h.am;
import y.h.fj;

final class ac implements am {
   private final y.c.q a;
   private final y.c.x b;
   private final Y c;

   ac(Y var1, y.c.q var2) {
      this.c = var1;
      this.a = var2;
      this.b = var1.a.p(var2);
      this.b.j();
   }

   public boolean a() {
      boolean var6 = fj.z;
      boolean var1 = false;

      boolean var10000;
      while(true) {
         if(this.b.f()) {
            var10000 = this.c.f.isEmpty();
            if(var6) {
               break;
            }

            if(var10000) {
               y.c.q var2 = this.b.e();
               ae var3 = new ae(this.c, var2);
               this.c.c.add(var3);
               var1 = true;
               Z var4 = new Z(this.c, this.a, var2);
               int var5 = this.c.c.size();
               this.c.c.add(var4);
               if(var4.a()) {
                  this.c.c.remove(var5);
                  if(this.c.f.isEmpty() && var3.a()) {
                     this.c.c.remove(this.c.c.size() - 1);
                     var1 = false;
                  }
               }

               this.b.h();
               if(!var6) {
                  continue;
               }
            }
         }

         var10000 = this.b.f();
         break;
      }

      return !var10000 && !var1;
   }
}
