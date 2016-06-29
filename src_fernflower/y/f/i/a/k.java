package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.ai;
import y.f.i.a.j;

class k implements Comparator {
   private k() {
   }

   public int compare(Object var1, Object var2) {
      ai var3 = (ai)var1;
      ai var4 = (ai)var2;
      double var5 = var3.c().a() - var4.c().a();
      return var5 == 0.0D?0:(var5 < 0.0D?-1:1);
   }

   k(j var1) {
      this();
   }
}
