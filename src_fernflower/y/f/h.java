package y.f;

import java.util.Comparator;
import y.f.e;
import y.f.i;

class h implements Comparator {
   private final e a;

   h(e var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      i var3 = (i)var1;
      i var4 = (i)var2;
      return y.g.e.a(var4.c, var3.c);
   }
}
