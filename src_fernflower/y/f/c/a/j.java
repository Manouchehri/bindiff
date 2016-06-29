package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.f;
import y.f.c.a.g;
import y.f.c.a.i;

class j implements Comparator {
   private final f a;

   private j(f var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      i var3 = (i)var1;
      i var4 = (i)var2;
      return y.g.e.a(var4.d(), var3.d());
   }

   j(f var1, g var2) {
      this(var1);
   }
}
