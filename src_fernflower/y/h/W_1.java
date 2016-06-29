package y.h;

import java.util.Iterator;
import y.h.bu;
import y.h.fj;
import y.h.hO;

final class W extends hO {
   private final Iterator a;
   private final boolean b;

   W(bu var1, y.h.a.v var2, int var3, boolean var4) {
      this(var1, var4?var2.h(var2.e((y.c.i)var1)):var2.i(var2.e((y.c.i)var1)), var3, var4);
   }

   W(bu var1, int var2, boolean var3) {
      this(var1, var3?y.g.l.a(var1.o()):y.g.l.b(var1.o()), var2, var3);
   }

   private W(bu var1, Iterator var2, int var3, boolean var4) {
      super(var1, var3);
      this.a = var2;
      this.b = var4;
   }

   void a() {
      boolean var2 = fj.z;

      while(this.f.isEmpty() && this.a.hasNext()) {
         y.c.q var1 = (y.c.q)this.a.next();
         if(this.b) {
            this.a(var1);
            if(!var2) {
               continue;
            }
         }

         this.b(var1);
         if(var2) {
            break;
         }
      }

   }
}
