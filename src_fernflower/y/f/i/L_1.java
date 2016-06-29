package y.f.i;

import java.util.Comparator;
import y.f.i.K;
import y.f.i.Q;

class L implements Comparator {
   private final K a;

   L(K var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      Q var3 = (Q)var1;
      y.d.m var5 = var3.a();
      boolean var4 = var5.c().b() >= var5.d().b();
      Q var6 = (Q)var2;
      y.d.m var7 = var6.a();
      boolean var8 = var7.c().b() >= var7.d().b();
      int var9 = var4?K.a(this.a)[Q.a(var3).b()]:K.b(this.a)[Q.a(var3).b()];
      int var10 = var8?K.a(this.a)[Q.a(var6).b()]:K.b(this.a)[Q.a(var6).b()];
      return y.g.e.a(var9, var10);
   }
}
