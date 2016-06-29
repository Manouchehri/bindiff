package y.f.i;

import java.util.Comparator;

class aa implements Comparator {
   y.f.X a;
   boolean b;

   aa(y.f.X var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      int var3 = this.b?y.g.e.a(this.a.m((y.c.q)var1), this.a.m((y.c.q)var2)):y.g.e.a(this.a.n((y.c.q)var1), this.a.n((y.c.q)var2));
      if(var3 != 0) {
         return var3;
      } else {
         var3 = !this.b?y.g.e.a(this.a.m((y.c.q)var1), this.a.m((y.c.q)var2)):y.g.e.a(this.a.n((y.c.q)var1), this.a.n((y.c.q)var2));
         return var3;
      }
   }
}
