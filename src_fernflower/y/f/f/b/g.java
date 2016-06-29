package y.f.f.b;

import java.util.Comparator;
import y.f.S;
import y.f.aG;

class g implements Comparator {
   public int compare(Object var1, Object var2) {
      S var3 = (S)var1;
      S var4 = (S)var2;
      int var5 = this.a(var3.f());
      int var6 = this.a(var4.f());
      return var5 < var6?-1:(var5 > var6?1:0);
   }

   private int a(aG var1) {
      return var1.i()?0:(!var1.i() && !var1.j()?2:1);
   }
}
