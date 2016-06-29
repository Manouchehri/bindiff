package y.f.c.a;

import y.f.c.a.bb;
import y.f.c.a.bd;

class be extends bd {
   private final y.c.c a;
   private final bb b;

   be(bb var1, y.c.c var2) {
      super(var1, 0);
      this.b = var1;
      this.a = var2;
   }

   private y.f.ax a(y.c.q var1) {
      Object var2 = this.a.b(var1);
      return var2 instanceof y.f.aA?((y.f.aA)var2).a():(y.f.ax)var2;
   }

   public int compare(Object var1, Object var2) {
      y.f.ax var3 = this.a((y.c.q)var1);
      y.f.ax var4 = this.a((y.c.q)var2);
      if(var3 == var4) {
         return 0;
      } else {
         int var5 = this.b.a(1, 2, 1, 4, 8, 2, var3);
         int var6 = this.b.a(1, 2, 1, 4, 8, 2, var4);
         return var5 != var6?y.g.e.a(var5, var6):this.a(var3, var4, var5);
      }
   }
}
