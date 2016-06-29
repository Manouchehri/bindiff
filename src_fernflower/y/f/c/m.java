package y.f.c;

import java.util.Comparator;
import y.f.c.h;

class m implements Comparator {
   private final h a;

   m(h var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      int var5;
      int var7 = this.a.e[var5 = var3.b()];
      int var6;
      int var8 = this.a.e[var6 = var4.b()];
      int var9 = y.g.e.a(var7, var8);
      if(var9 != 0) {
         return var9;
      } else {
         int var10 = this.a.g[var5];
         int var11 = this.a.g[var6];
         if(var10 > 0) {
            return var11 > 0?y.g.e.a(var10, var11):-1;
         } else if(var11 > 0) {
            return 1;
         } else {
            int var12 = var3.d().d();
            int var13 = this.a.a[var12];
            int var14 = var4.d().d();
            int var15 = this.a.a[var14];
            int var16 = y.g.e.a(var13, var15);
            if(var16 != 0) {
               return var16;
            } else {
               int var17 = y.g.e.a(this.a.f[var5], this.a.f[var6]);
               if(var17 != 0) {
                  return var17;
               } else {
                  int var18 = this.a.h[var5];
                  int var19 = this.a.h[var6];
                  return var18 > 0?(var19 > 0?y.g.e.a(var18, var19):-1):(var19 > 0?1:0);
               }
            }
         }
      }
   }
}
