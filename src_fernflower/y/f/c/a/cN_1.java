package y.f.c.a;

import java.util.Comparator;

final class cN implements Comparator {
   final byte[] a;

   cN(byte[] var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      byte var3 = this.a[((y.c.d)var1).b()];
      byte var4 = this.a[((y.c.d)var2).b()];
      return var3 == -2?(var4 == -2?0:1):(var4 == -2?-1:y.g.e.a(var3, var4));
   }
}
