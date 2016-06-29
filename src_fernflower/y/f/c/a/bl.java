package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.bk;
import y.f.c.a.bt;

class bl implements Comparator {
   private final bk a;

   bl(bk var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      bt var3 = (bt)var1;
      bt var4 = (bt)var2;
      return var3.j()?(var4.j()?0:1):(var4.j()?-1:var3.compareTo(var2));
   }
}
