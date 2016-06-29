package y.h;

import java.util.Iterator;
import y.h.bu;
import y.h.fj;
import y.h.hO;

final class hQ extends hO {
   private final Iterator a;
   private final boolean b;

   hQ(bu var1, Iterator var2, int var3, boolean var4) {
      super(var1, var3);
      this.a = var2;
      this.b = var4;
   }

   void a() {
      boolean var2 = fj.z;

      while(this.f.isEmpty() && this.a.hasNext()) {
         Object var1 = this.a.next();
         if(var1 instanceof y.c.d) {
            if(this.b) {
               this.a((y.c.d)var1);
               if(!var2) {
                  continue;
               }
            }

            this.b((y.c.d)var1);
            if(!var2) {
               continue;
            }
         }

         if(var1 instanceof y.c.q) {
            if(this.b) {
               this.a((y.c.q)var1);
               if(!var2) {
                  continue;
               }
            }

            this.b((y.c.q)var1);
            if(var2) {
               break;
            }
         }
      }

   }
}
