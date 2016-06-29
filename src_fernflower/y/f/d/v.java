package y.f.d;

import java.util.Comparator;
import y.f.d.u;
import y.f.d.z;

class v implements Comparator {
   private final u a;

   v(u var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      z var3 = (z)var1;
      z var4 = (z)var2;
      return var3.d > var4.d?-1:(var3.d < var4.d?1:0);
   }
}
