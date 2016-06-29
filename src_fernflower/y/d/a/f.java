package y.d.a;

import java.util.Comparator;
import y.d.a.b;
import y.d.a.e;

class f implements Comparator, y.g.g {
   Comparator a;
   private final b b;

   f(b var1) {
      this.b = var1;
      this.a = b.a(this.b).b();
   }

   public int compare(Object var1, Object var2) {
      if(var1 == var2) {
         return 0;
      } else {
         e var3 = (e)var1;
         e var4 = (e)var2;
         return this.a.compare(var4.g, var3.g);
      }
   }
}
