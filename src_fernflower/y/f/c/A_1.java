package y.f.c;

import java.util.Comparator;
import y.f.c.x;

class A implements Comparator, y.g.g {
   Comparator a;
   Comparator b;
   private final x c;

   A(x var1, Comparator var2, Comparator var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public int compare(Object var1, Object var2) {
      y.f.aE var3 = this.c.b((y.c.d)var1);
      y.f.aE var4 = this.c.b((y.c.d)var2);
      return var3 != null && var3.a()?(var4 != null && var4.a()?this.b.compare(var1, var2):-1):(var4 != null && var4.a()?1:this.a.compare(var1, var2));
   }
}
