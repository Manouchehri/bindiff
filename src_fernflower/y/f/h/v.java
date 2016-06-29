package y.f.h;

import java.util.Comparator;

public class v implements Comparator {
   y.c.q a;
   int[] b;

   public void a(int[] var1) {
      this.b = var1;
   }

   public void a(y.c.q var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      int var5 = this.b[this.a.d()];
      int var6 = this.b[var3.a(this.a).d()];
      int var7 = this.b[var4.a(this.a).d()];
      return (var6 <= var5 || var7 <= var5) && (var6 >= var5 || var7 >= var5)?(var6 > var7?1:(var6 < var7?-1:0)):(var6 > var7?-1:(var6 < var7?1:0));
   }
}
