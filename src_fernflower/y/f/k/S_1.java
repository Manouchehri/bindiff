package y.f.k;

import y.f.aG;
import y.f.k.R;

final class S implements Comparable {
   y.f.S a;
   int b;

   private S(y.f.S var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compareTo(Object var1) {
      S var2 = (S)var1;
      aG var3 = this.a.f();
      aG var4 = var2.a.f();
      int var5 = var3.k()?-1:(var3.j()?0:1);
      int var6 = var4.k()?-1:(var4.j()?0:1);
      return var5 - var6;
   }

   S(y.f.S var1, int var2, R var3) {
      this(var1, var2);
   }
}
