package y.f.f.e;

import java.util.Comparator;
import y.d.t;
import y.f.f.e.a;

class d implements Comparator {
   y.c.i a;
   int b;
   private final a c;

   d(a var1) {
      this.c = var1;
   }

   public int compare(Object var1, Object var2) {
      int var6 = a.a;
      t var3 = a.a(this.c).p((y.c.d)var1);
      t var4 = a.a(this.c).p((y.c.d)var2);
      int var5 = 0;
      switch(this.b) {
      case 0:
         var5 = y.g.e.a(var3.a, var4.a);
         if(var6 == 0) {
            break;
         }
      case 3:
         var5 = y.g.e.a(var3.b, var4.b);
         if(var6 == 0) {
            break;
         }
      case 2:
         var5 = y.g.e.a(var4.a, var3.a);
         if(var6 == 0) {
            break;
         }
      case 1:
         var5 = y.g.e.a(var4.b, var3.b);
      }

      return var5;
   }
}
