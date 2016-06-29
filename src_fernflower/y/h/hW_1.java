package y.h;

import java.util.HashSet;
import y.h.hV;

class hW extends y.g.p {
   private final HashSet a;
   private final hV b;

   hW(hV var1, HashSet var2) {
      this.b = var1;
      this.a = var2;
   }

   public boolean d(Object var1) {
      y.c.d var2 = (y.c.d)var1;
      return !this.a.contains(var2.c()) && !this.a.contains(var2.d());
   }
}
