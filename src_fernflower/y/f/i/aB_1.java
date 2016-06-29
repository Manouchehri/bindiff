package y.f.i;

import java.util.Comparator;
import y.f.i.ag;

class aB implements Comparator {
   public int compare(Object var1, Object var2) {
      int var3 = y.g.e.a(((ag)var1).a(), ((ag)var2).a());
      if(var3 != 0) {
         return var3;
      } else {
         var3 = y.g.e.a(((ag)var1).b(), ((ag)var2).b());
         if(var3 != 0) {
            return var3;
         } else {
            var3 = y.g.e.a(((ag)var1).c(), ((ag)var2).c());
            return var3;
         }
      }
   }
}
