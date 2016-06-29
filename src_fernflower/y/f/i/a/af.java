package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.ae;

class af implements Comparator {
   private final ae a;

   af(ae var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.d.t var3 = (y.d.t)var1;
      y.d.t var4 = (y.d.t)var2;
      return var3.a() < var4.a() - 1.0E-6D?-1:(var3.a() > var4.a() + 1.0E-6D?1:(var3.b() < var4.b() - 1.0E-6D?-1:(var3.b() > var4.b() + 1.0E-6D?1:(int)(var3.a() + var3.b() - (var4.a() + var4.b())))));
   }
}
