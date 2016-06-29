package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.cr;
import y.f.c.a.cv;

class ct implements Comparator {
   private final cr a;

   ct(cr var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(((cv)var1).b, ((cv)var2).b);
   }
}
