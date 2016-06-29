package y.f.c.a;

import java.util.Comparator;

final class cQ implements Comparator, y.g.g {
   final Comparator a;
   final Comparator b;
   final Comparator c;
   final int[] d;

   cQ(int[] var1, Comparator var2, Comparator var3, Comparator var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      y.c.q var5 = var3.d();
      y.c.q var6 = var4.d();
      if(var5 == var6) {
         int var17 = this.b.compare(var3, var4);
         return var17 == 0?this.c.compare(var3, var4):var17;
      } else if(this.d[var5.d()] < 0) {
         y.c.d var16 = var3.h() == null?var3.j():var3.h();
         y.c.q var8 = var16.c();
         if(this.d[var6.d()] < 0) {
            y.c.d var9 = var4.h() == null?var4.j():var4.h();
            y.c.q var10 = var9.c();
            int var11 = this.a.compare(var3.c(), var8);
            int var12 = this.a.compare(var4.c(), var10);
            if(var11 < 0) {
               if(var12 > 0) {
                  return 1;
               }
            } else if(var12 < 0) {
               return -1;
            }

            int var13 = this.a.compare(var10, var8);
            if(var13 == 0) {
               int var14 = this.b.compare(var9, var16);
               if(var14 == 0) {
                  int var15 = this.c.compare(var9, var16);
                  return var15 == 0?y.g.e.a(var5.d(), var6.d()) * var11:var15;
               } else {
                  return var14;
               }
            } else {
               return var13;
            }
         } else {
            return this.a.compare(var8, var3.c());
         }
      } else if(this.d[var6.d()] < 0) {
         y.c.q var7 = var4.h() == null?var4.j().c():var4.h().c();
         return this.a.compare(var4.c(), var7);
      } else {
         return this.a.compare(var5, var6);
      }
   }
}
