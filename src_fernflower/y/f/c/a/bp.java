package y.f.c.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import y.f.c.a.bK;
import y.f.c.a.l;

final class bp {
   private final ArrayList a = new ArrayList();
   private final Collection b;

   bp() {
      this.b = Collections.unmodifiableCollection(this.a);
   }

   bK a(l var1) {
      bK var2 = new bK(new Integer(this.a.size()));
      this.a.add(var2);
      var2.a(true);
      var2.b(var1.b());
      var2.c(var1.c());
      var2.d(var1.d());
      var2.a(var1.i());
      return var2;
   }
}
