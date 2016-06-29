package y.f.g;

import java.util.Comparator;

class m implements Comparator {
   int[] a;

   m(y.c.i var1) {
      if(y.a.g.b(var1)) {
         throw new RuntimeException("Found cycle in constraint graph!");
      } else {
         this.a = new int[var1.e()];
         y.a.m.a(var1, this.a);
      }
   }

   public int compare(Object var1, Object var2) {
      y.c.q var3 = (y.c.q)var1;
      y.c.q var4 = (y.c.q)var2;
      return y.g.e.a(this.a[var3.d()], this.a[var4.d()]);
   }
}
