package y.f;

import java.util.Comparator;
import y.f.aT;

class aS implements Comparator {
   private final y.c.A a;

   aS(y.c.A var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      aT var3 = (aT)this.a.b(var1);
      aT var4 = (aT)this.a.b(var2);
      return var3.a() > var4.a()?1:(var3.a() < var4.a()?-1:0);
   }
}
