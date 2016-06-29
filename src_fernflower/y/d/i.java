package y.d;

import java.util.Comparator;
import y.d.k;

class i implements Comparator {
   public int compare(Object var1, Object var2) {
      k var3 = (k)var1;
      k var4 = (k)var2;
      return var3.a < var4.a?-1:(var3.a > var4.a?1:(var3.b == 1 && var4.b == 0?1:(var3.b == 0 && var4.b == 1?-1:0)));
   }

   public boolean equals(Object var1) {
      return false;
   }
}
