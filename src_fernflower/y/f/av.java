package y.f;

import java.util.Comparator;

class av implements Comparator {
   public int compare(Object var1, Object var2) {
      y.d.a var3 = (y.d.a)var1;
      y.d.a var4 = (y.d.a)var2;
      return var3.c() < var4.c()?-1:(var3.c() > var4.c()?1:0);
   }
}
