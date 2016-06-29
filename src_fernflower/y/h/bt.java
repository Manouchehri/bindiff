package y.h;

import y.h.aZ;
import y.h.bg;
import y.h.gt;

final class bt implements gt {
   final aZ a;

   public bt(aZ var1) {
      this.a = var1;
   }

   public y.d.q getMinimumSize() {
      bg var1 = this.a.a.n;
      return var1 != null?var1.a(this.a):new y.d.q(0.0D, 0.0D);
   }

   public y.d.q getMaximumSize() {
      bg var1 = this.a.a.n;
      return var1 != null?var1.b(this.a):new y.d.q(Double.MAX_VALUE, Double.MAX_VALUE);
   }
}
