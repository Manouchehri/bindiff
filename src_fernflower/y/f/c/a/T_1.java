package y.f.c.a;

import java.util.Set;
import y.f.c.a.J;
import y.f.c.a.N;

class T implements J {
   private final y.c.q a;
   private final Set b;
   private final N c;

   T(N var1, y.c.q var2, Set var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void a(y.c.q var1, y.c.q var2) {
      if(var2 != null && var2 != this.a) {
         this.b.add(var2);
      }

      this.b.add(var1);
   }
}
