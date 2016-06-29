package y.f.f.e;

import y.c.A;
import y.c.q;
import y.f.h.r;
import y.g.p;

class c extends p {
   r a;
   A b;

   c(r var1, A var2) {
      this.a = var1;
      this.b = var2;
   }

   public Object b(Object var1) {
      if(var1 instanceof y.f.h.p) {
         return this.a.b(var1);
      } else if(var1 instanceof q) {
         return this.b.b(var1);
      } else {
         throw new IllegalStateException("Illegal Type " + var1);
      }
   }
}
