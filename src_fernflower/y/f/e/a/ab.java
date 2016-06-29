package y.f.e.a;

import java.util.Collections;
import java.util.List;
import y.f.e.a.i;
import y.f.e.a.l;
import y.f.e.a.m;

abstract class ab extends i {
   protected List a(m var1, l var2) {
      y.f.X var3 = var2.b().f();
      y.c.c var4 = this.a(var3);
      if(var4 == null) {
         return Collections.EMPTY_LIST;
      } else {
         List var5 = (List)var4.b(var1.j());
         return var5 == null?Collections.EMPTY_LIST:var5;
      }
   }

   protected abstract y.c.c a(y.f.X var1);
}
