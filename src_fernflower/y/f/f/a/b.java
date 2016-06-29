package y.f.f.a;

import java.util.Comparator;
import y.f.S;
import y.f.aG;

class b implements Comparator {
   public int compare(Object var1, Object var2) {
      S var3 = (S)var1;
      S var4 = (S)var2;
      aG var5 = var3.f();
      aG var6 = var4.f();
      int var7 = this.a(var5);
      int var8 = this.a(var6);
      return var7 < var8?-1:(var7 > var8?1:0);
   }

   private int a(aG var1) {
      return var1.i()?0:(!var1.i() && !var1.j()?2:1);
   }
}
