package y.f.c;

import java.util.Comparator;
import y.f.c.h;

class o implements Comparator {
   private final h a;

   o(h var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      int var5 = y.g.e.a(this.a.a[var3.d().d()], this.a.a[var4.d().d()]);
      if(var5 != 0) {
         return var5;
      } else {
         int var6;
         int var8 = this.a.f[var6 = var3.b()];
         int var7;
         int var9 = this.a.f[var7 = var4.b()];
         int var10 = y.g.e.a(var8, var9);
         if(var10 != 0) {
            return var10;
         } else {
            int var11 = this.a.h[var6];
            int var12 = this.a.h[var7];
            if(var11 > 0) {
               return var12 > 0?y.g.e.a(var11, var12):-1;
            } else if(var12 > 0) {
               return 1;
            } else {
               int var13 = var3.c().d();
               int var14 = this.a.a[var13];
               int var15 = var4.c().d();
               int var16 = this.a.a[var15];
               int var17 = y.g.e.a(var14, var16);
               if(var17 != 0) {
                  return var17;
               } else {
                  int var18 = y.g.e.a(this.a.e[var6], this.a.e[var7]);
                  if(var18 != 0) {
                     return var18;
                  } else {
                     int var19 = this.a.g[var6];
                     int var20 = this.a.g[var7];
                     return var19 > 0?(var20 > 0?y.g.e.a(var19, var20):-1):(var20 > 0?1:0);
                  }
               }
            }
         }
      }
   }
}
