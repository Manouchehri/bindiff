package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.bb;

class bd implements Comparator {
   private final int a;
   private final bb b;

   bd(bb var1, int var2) {
      this.b = var1;
      this.a = var2;
   }

   public int compare(Object var1, Object var2) {
      return this.a((y.f.ax)var1, (y.f.ax)var2, this.a);
   }

   int a(y.f.ax var1, y.f.ax var2, int var3) {
      if(var1 == var2) {
         return 0;
      } else if(var1.b() && var2.b()) {
         byte var4 = this.b.b();
         int var5 = this.b.a();
         switch(var3) {
         case 0:
            return y.g.e.a(var1.a(var4, var5), var2.a(var4, var5));
         case 1:
            return y.g.e.a(var1.b(var4, var5), var2.b(var4, var5));
         case 2:
         default:
            return y.g.e.a(var2.a(var4, var5), var1.a(var4, var5));
         case 3:
            return y.g.e.a(var2.b(var4, var5), var1.b(var4, var5));
         }
      } else {
         return var1.b()?-1:(var2.b()?1:0);
      }
   }
}
