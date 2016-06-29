package y.f.c;

import java.util.Comparator;
import y.f.c.N;
import y.f.c.a.bK;

class O implements Comparator, y.g.g {
   private O() {
   }

   public int compare(Object var1, Object var2) {
      bK var3 = (bK)var1;
      bK var4 = (bK)var2;
      return var3.a()?(var4.a()?0:1):(var4.a()?-1:var3.compareTo(var2));
   }

   O(N var1) {
      this();
   }
}
