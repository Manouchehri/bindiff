package y.f.c.a;

import java.util.Comparator;

final class cU implements Comparator, y.g.g {
   private final Comparator a;
   private final Comparator b;
   private final Comparator c;
   private final Comparator d;
   private final Comparator e;
   private Comparator f;
   private final int[] g;

   cU(int[] var1, Comparator var2, Comparator var3, Comparator var4, Comparator var5, Comparator var6, Comparator var7) {
      this.g = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.f = var7;
      this.e = var6;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      y.c.q var5 = var3.d();
      y.c.q var6 = var4.d();
      int var7 = this.c.compare(var3, var4);
      if(var7 == 0) {
         int var8 = this.d.compare(var3, var4);
         if(var8 == 0) {
            y.c.q var9 = var3.c();
            y.c.q var10 = var4.c();
            if(this.g[var9.d()] < 0) {
               y.c.d var21 = var3.g() == null?var3.i():var3.g();
               y.c.q var22 = var21.d();
               if(this.g[var10.d()] < 0) {
                  y.c.d var23 = var4.g() == null?var4.i():var4.g();
                  y.c.q var14 = var23.d();
                  int var15 = this.b.compare(var5, var22);
                  int var16 = this.b.compare(var6, var14);
                  if(var15 < 0) {
                     if(var16 > 0) {
                        return 1;
                     }
                  } else if(var16 < 0) {
                     return -1;
                  }

                  int var17 = this.b.compare(var14, var22);
                  if(var17 == 0) {
                     int var18 = this.c.compare(var23, var21);
                     if(var18 == 0) {
                        int var19 = this.d.compare(var23, var21);
                        return var19 == 0?y.g.e.a(var9.d(), var10.d()) * var15:var19;
                     } else {
                        return var18;
                     }
                  } else {
                     return var17;
                  }
               } else {
                  return this.b.compare(var22, var5);
               }
            } else if(this.g[var10.d()] < 0) {
               y.c.q var20 = var4.g() == null?var4.i().d():var4.g().d();
               return this.b.compare(var6, var20);
            } else {
               int var11 = this.b.compare(var9, var10);
               if(var11 == 0) {
                  int var12 = this.e.compare(var3, var4);
                  if(var12 == 0) {
                     int var13 = this.f.compare(var3, var4);
                     return var13 == 0?y.g.e.a(var3.b(), var4.b()):var13;
                  } else {
                     return var12;
                  }
               } else {
                  return var11;
               }
            }
         } else {
            return var8;
         }
      } else {
         return var7;
      }
   }
}
