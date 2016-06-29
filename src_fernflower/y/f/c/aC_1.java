package y.f.c;

import java.util.Comparator;
import y.f.c.aB;

final class aC implements Comparator {
   private final aB a;

   aC(aB var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(((Integer)this.a.a.a.get(this.a.c(var1))).intValue(), ((Integer)this.a.a.a.get(this.a.c(var2))).intValue());
   }
}
