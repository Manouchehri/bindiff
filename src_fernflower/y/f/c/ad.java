package y.f.c;

import java.util.Comparator;

class ad implements Comparator {
   boolean a;
   int[] b;

   ad(int[] var1, boolean var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      int var3;
      int var4;
      if(this.a) {
         var3 = this.b[((y.c.d)var1).c().d()];
         var4 = this.b[((y.c.d)var2).c().d()];
         return y.g.e.a(var3, var4);
      } else {
         var3 = this.b[((y.c.d)var1).d().d()];
         var4 = this.b[((y.c.d)var2).d().d()];
         return y.g.e.a(var3, var4);
      }
   }
}
