package y.f.c.a;

import java.util.List;
import y.f.c.a.E;
import y.f.c.a.J;
import y.f.c.a.N;

class G implements J {
   private final List a;
   private final E b;

   G(E var1, List var2) {
      this.b = var1;
      this.a = var2;
   }

   public void a(y.c.q var1, y.c.q var2) {
      if(var2 == null) {
         this.a.add(var1);
         if(!N.x) {
            return;
         }
      }

      this.a(var2, this.b.i(var2));
   }
}
