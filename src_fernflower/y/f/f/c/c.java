package y.f.f.c;

import java.util.Comparator;
import y.f.f.c.b;
import y.f.f.c.d;

public class c implements Comparator {
   private final b a;

   public c(b var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      d var3 = (d)var1;
      d var4 = (d)var2;
      return var3.a() < var4.a()?-1:(var3.a() > var4.a()?1:(var3.b() == 1 && var4.b() == 0?1:(var3.b() == 0 && var4.b() == 1?-1:(var3.c().i() < var4.c().i()?-1:(var3.c().i() > var4.c().i()?1:0)))));
   }
}
