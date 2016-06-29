package y.h;

import java.util.Iterator;
import y.h.Y;
import y.h.aa;
import y.h.ac;
import y.h.am;
import y.h.fj;

final class ab implements am {
   private final Iterator a;
   private final Y b;

   ab(Y var1) {
      this.b = var1;
      this.a = var1.a.i(Y.a(var1));
   }

   public boolean a() {
      boolean var7 = fj.z;
      boolean var1 = false;

      boolean var10000;
      while(true) {
         if(this.a.hasNext() && this.b.f.isEmpty()) {
            y.c.q var2 = (y.c.q)this.a.next();
            aa var3 = new aa(this.b, var2);
            int var4 = this.b.c.size();
            this.b.c.add(var3);
            if(this.b.a.k(var2)) {
               ac var5 = new ac(this.b, var2);
               int var6 = this.b.c.size();
               this.b.c.add(var5);
               var1 = true;
               if(var5.a()) {
                  this.b.c.remove(var6);
                  var1 = false;
               }
            }

            if(var1) {
               continue;
            }

            var10000 = var3.a();
            if(var7) {
               break;
            }

            if(!var10000) {
               continue;
            }

            this.b.c.remove(var4);
            if(!var7) {
               continue;
            }
         }

         var10000 = this.a.hasNext();
         break;
      }

      return !var10000 && !var1;
   }
}
