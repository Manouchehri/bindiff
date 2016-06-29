package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.o;

final class n implements Comparator {
   public int compare(Object var1, Object var2) {
      o var3 = (o)var1;
      o var4 = (o)var2;
      return var3.b() > var4.b()?-1:(var3.b() < var4.b()?1:0);
   }
}
