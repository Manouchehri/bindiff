package y.f.e;

import java.util.HashSet;
import y.f.e.q;
import y.f.e.a.ay;

class u extends y.g.p {
   private final HashSet a;
   private final ay b;
   private final q d;

   u(q var1, HashSet var2, ay var3) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
   }

   public Object b(Object var1) {
      return this.a.contains(var1)?this.b:null;
   }
}
