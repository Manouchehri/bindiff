package y.f.g;

import java.util.Comparator;
import y.f.g.o;
import y.f.g.u;

class s implements Comparator {
   private s() {
   }

   public int compare(Object var1, Object var2) {
      u var3 = (u)var1;
      u var4 = (u)var2;
      if(var3.b() && !var4.b()) {
         return -1;
      } else if(!var3.b() && var4.b()) {
         return 1;
      } else {
         int var5 = var3.l();
         int var6 = var4.l();
         return var5 < var6?-1:(var5 > var6?1:0);
      }
   }

   s(o var1) {
      this();
   }
}
