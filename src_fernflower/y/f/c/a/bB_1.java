package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.bI;
import y.f.c.a.by;

class bB implements Comparator {
   private final by a;

   bB(by var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(((bI)var1).c, ((bI)var2).c);
   }
}
