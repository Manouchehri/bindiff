package y.f.c.a;

import java.util.Comparator;

final class cH implements Comparator, y.g.g {
   private final Comparator a;
   private final Comparator b;
   private final Comparator c;
   private final Comparator d;
   private final Comparator e;
   private Comparator f;
   private final int[] g;

   cH(int[] var1, Comparator var2, Comparator var3, Comparator var4, Comparator var5, Comparator var6, Comparator var7) {
      this.g = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.f = var7;
      this.e = var6;
   }

   Comparator a() {
      return this.f;
   }

   void a(Comparator var1) {
      this.f = var1;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      y.c.q var5 = var3.c();
      y.c.q var6 = var4.c();
      y.c.q var7 = var3.d();
      y.c.q var8 = var4.d();
      if(this.g[var7.d()] < 0) {
         y.c.d var19 = var3.h() == null?var3.j():var3.h();
         y.c.q var20 = var19.c();
         if(this.g[var8.d()] < 0) {
            y.c.d var21 = var4.h() == null?var4.j():var4.h();
            y.c.q var12 = var21.c();
            int var13 = this.b.compare(var5, var20);
            int var14 = this.b.compare(var6, var12);
            if(var13 < 0) {
               if(var14 > 0) {
                  return 1;
               }
            } else if(var14 < 0) {
               return -1;
            }

            int var15 = this.b.compare(var12, var20);
            if(var15 == 0) {
               int var16 = this.c.compare(var21, var19);
               if(var16 == 0) {
                  int var17 = this.d.compare(var21, var19);
                  return var17 == 0?y.g.e.a(var7.d(), var8.d()) * var13:var17;
               } else {
                  return var16;
               }
            } else {
               return var15;
            }
         } else {
            return this.b.compare(var20, var5);
         }
      } else if(this.g[var8.d()] < 0) {
         y.c.q var18 = var4.h() == null?var4.j().c():var4.h().c();
         return this.b.compare(var6, var18);
      } else {
         int var9 = this.b.compare(var7, var8);
         if(var9 == 0) {
            int var10 = this.e.compare(var3, var4);
            if(var10 == 0) {
               int var11 = this.f.compare(var3, var4);
               return var11 == 0?y.g.e.a(var3.b(), var4.b()):var11;
            } else {
               return var10;
            }
         } else {
            return var9;
         }
      }
   }
}
