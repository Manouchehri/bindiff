package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.bk;
import y.f.c.a.l;

class bm implements Comparator {
   private final bk a;

   bm(bk var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      l var3 = (l)var1;
      l var4 = (l)var2;
      return var3.j()?(var4.j()?0:1):(var4.j()?-1:var3.compareTo(var2));
   }
}
