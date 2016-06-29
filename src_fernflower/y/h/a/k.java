package y.h.a;

import y.h.bu;
import y.h.fj;
import y.h.gt;

public class k extends y.g.p {
   private final bu a;
   private y.d.q b = new y.d.q(0.0D, 0.0D);

   public k(bu var1) {
      this.a = var1;
   }

   public Object b(Object var1) {
      fj var2 = this.a.t((y.c.q)var1);
      gt var3 = var2.getSizeConstraintProvider();
      return var3 != null?var3.getMinimumSize():this.b;
   }
}
