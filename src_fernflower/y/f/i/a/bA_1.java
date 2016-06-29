package y.f.i.a;

import java.util.Comparator;
import y.f.i.a.bB;
import y.f.i.a.bz;

class bA implements Comparator {
   private final bz a;

   bA(bz var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      bB var3 = (bB)var1;
      bB var4 = (bB)var2;
      return Math.abs(var3.a - var4.a) < 1.0E-6D?y.g.e.a(var4.b, var3.b):y.g.e.a(var3.a, var4.a);
   }
}
