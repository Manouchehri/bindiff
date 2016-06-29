package y.f.c.a;

import java.util.Comparator;

final class cK implements Comparator, y.g.g {
   final int[] a;
   final Comparator b;
   final Comparator c;
   final Comparator d;

   cK(int[] var1, Comparator var2, Comparator var3, Comparator var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public int compare(Object var1, Object var2) {
      y.c.d var3 = (y.c.d)var1;
      y.c.d var4 = (y.c.d)var2;
      y.c.q var5 = var3.c();
      y.c.q var6 = var4.c();
      if(var5 == var6) {
         int var17 = this.c.compare(var3, var4);
         return var17 == 0?this.d.compare(var3, var4):var17;
      } else if(this.a[var5.d()] < 0) {
         y.c.d var16 = var3.g() == null?var3.i():var3.g();
         y.c.q var8 = var16.d();
         if(this.a[var6.d()] < 0) {
            y.c.d var9 = var4.g() == null?var4.i():var4.g();
            y.c.q var10 = var9.d();
            int var11 = this.b.compare(var3.d(), var8);
            int var12 = this.b.compare(var4.d(), var10);
            if(var11 < 0) {
               if(var12 > 0) {
                  return 1;
               }
            } else if(var12 < 0) {
               return -1;
            }

            int var13 = this.b.compare(var10, var8);
            if(var13 == 0) {
               int var14 = this.c.compare(var9, var16);
               if(var14 == 0) {
                  int var15 = this.d.compare(var9, var16);
                  return var15 == 0?y.g.e.a(var5.d(), var6.d()) * var11:var15;
               } else {
                  return var14;
               }
            } else {
               return var13;
            }
         } else {
            return this.b.compare(var8, var3.d());
         }
      } else if(this.a[var6.d()] < 0) {
         y.c.q var7 = var4.g() == null?var4.i().d():var4.g().d();
         return this.b.compare(var4.d(), var7);
      } else {
         return this.b.compare(var5, var6);
      }
   }
}
