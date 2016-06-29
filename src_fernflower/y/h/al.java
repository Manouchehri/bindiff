package y.h;

import java.util.Iterator;
import y.h.ag;
import y.h.ah;
import y.h.am;
import y.h.fj;

final class al implements am {
   private final Iterator a;
   private final ag b;

   al(ag var1) {
      this.b = var1;
      this.a = var1.a.h(ag.a(var1));
   }

   public boolean a() {
      boolean var5 = fj.z;
      boolean var1 = false;

      boolean var10000;
      while(true) {
         if(this.a.hasNext() && this.b.f.isEmpty()) {
            y.c.q var2 = (y.c.q)this.a.next();
            this.b.b.set(var2.d());
            this.b.a(var2);
            if(!this.b.a.k(var2)) {
               continue;
            }

            ah var3 = new ah(this.b, var2);
            int var4 = this.b.c.size();
            this.b.c.add(var3);
            var1 = true;
            var10000 = var3.a();
            if(var5) {
               break;
            }

            if(!var10000) {
               continue;
            }

            this.b.c.remove(var4);
            var1 = false;
            if(!var5) {
               continue;
            }
         }

         var10000 = this.a.hasNext();
         break;
      }

      return !var10000 && !var1;
   }
}
