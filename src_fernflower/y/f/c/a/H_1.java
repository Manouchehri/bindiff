package y.f.c.a;

import y.f.c.a.E;
import y.f.c.a.K;
import y.f.c.a.N;
import y.f.c.a.dg;

class H implements K {
   private final int[] a;
   private final int[] b;
   private final int[] c;
   private final E d;

   H(E var1, int[] var2, int[] var3, int[] var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public int compare(Object var1, Object var2) {
      int var3;
      int var4;
      boolean var7;
      dg var9;
      boolean var10;
      label80: {
         var10 = N.x;
         if(var1 instanceof y.c.q) {
            var3 = var4 = this.a[((y.c.q)var1).d()];
            var7 = false;
            if(!var10) {
               break label80;
            }
         }

         var9 = (dg)var1;
         var3 = this.b[var9.u];
         var4 = this.c[var9.u];
         var7 = var3 != var4;
      }

      int var5;
      int var6;
      boolean var8;
      if(var2 instanceof y.c.q) {
         var5 = var6 = this.a[((y.c.q)var2).d()];
         var8 = false;
         if(!var10) {
            return !var7 && !var8?y.g.e.a(var4, var6):(var4 < var5?-1:(var6 < var3?1:(var7 && var8?(var4 <= var5?-1:(var6 <= var3?1:0)):(var7?(var5 >= var4?-1:(var6 <= var3?1:0)):(var3 >= var6?1:(var4 <= var5?-1:0))))));
         }
      }

      var9 = (dg)var2;
      var5 = this.b[var9.u];
      var6 = this.c[var9.u];
      var8 = var5 != var6;
      return !var7 && !var8?y.g.e.a(var4, var6):(var4 < var5?-1:(var6 < var3?1:(var7 && var8?(var4 <= var5?-1:(var6 <= var3?1:0)):(var7?(var5 >= var4?-1:(var6 <= var3?1:0)):(var3 >= var6?1:(var4 <= var5?-1:0))))));
   }
}
