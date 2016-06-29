package y.f.g;

import java.util.Comparator;
import y.f.g.q;

class o implements Comparator {
   public int compare(Object var1, Object var2) {
      int var3 = y.g.e.a(((q)var2).d.size(), ((q)var1).d.size());
      return var3 != 0?var3:y.g.e.a(((q)var1).c, ((q)var2).c);
   }
}
