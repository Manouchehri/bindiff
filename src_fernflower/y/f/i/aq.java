package y.f.i;

import java.util.Comparator;
import y.f.i.v;

class aq implements Comparator {
   y.f.X a;
   y.c.q b;

   public aq(y.f.X var1, y.c.q var2) {
      this.a = var1;
      this.b = var2;
   }

   public int compare(Object var1, Object var2) {
      int var30 = v.f;
      y.c.d var10 = (y.c.d)var1;
      y.c.d var11 = (y.c.d)var2;
      boolean var12 = this.b == var10.c();
      boolean var13 = this.b == var11.c();
      y.c.D var14 = this.a.m(var10);
      int var3 = var14.size();
      boolean var15 = var3 == 2;
      int var5 = var12?0:var3 - 1;
      y.d.t var16 = (y.d.t)var14.a(var5);
      var5 += var12?1:-1;
      y.d.t var17 = (y.d.t)var14.a(var5);
      boolean var18 = this.a(var16, var17);
      boolean var19 = false;
      if(!var15) {
         var5 += var12?1:-1;
         y.d.t var20 = (y.d.t)var14.a(var5);
         var19 = this.a(var16, var17, var20);
      }

      y.c.D var31 = this.a.m(var11);
      int var4 = var31.size();
      boolean var21 = var4 == 2;
      var5 = var13?0:var4 - 1;
      y.d.t var22 = (y.d.t)var31.a(var5);
      var5 += var13?1:-1;
      y.d.t var23 = (y.d.t)var31.a(var5);
      boolean var24 = this.a(var22, var23);
      boolean var25 = false;
      if(!var21) {
         var5 += var13?1:-1;
         y.d.t var26 = (y.d.t)var31.a(var5);
         var25 = this.a(var22, var23, var26);
      }

      if(var15 && var21) {
         if(var18 != var24) {
            return 0;
         } else {
            double var32 = var18?var16.a:var16.b;
            double var28 = var24?var22.a:var22.b;
            return var32 < var28?-1:(var32 > var28?1:0);
         }
      } else if(var15) {
         return !var25?-1:1;
      } else if(var21) {
         return !var19?1:-1;
      } else if(var19 && !var25) {
         return -1;
      } else if(!var19 && var25) {
         return 1;
      } else {
         double var6 = this.a(var17, var18);
         double var8 = this.a(var23, var24);
         if(var19) {
            return var6 < var8?-1:(var6 > var8?1:0);
         } else if(var8 < var6) {
            return -1;
         } else if(var8 > var6) {
            return 1;
         } else {
            if(y.c.i.g) {
               ++var30;
               v.f = var30;
            }

            return 0;
         }
      }
   }

   private final double a(y.d.t var1, boolean var2) {
      return var2?Math.abs(var1.b - this.a.k(this.b)):Math.abs(var1.a - this.a.j(this.b));
   }

   private final boolean a(y.d.t var1, y.d.t var2, y.d.t var3) {
      return Math.abs(var1.a - var2.a) < Math.abs(var1.b - var2.b)?var3.a <= var2.a:var3.b <= var2.b;
   }

   private final boolean a(y.d.t var1, y.d.t var2) {
      return Math.abs(var1.a - var2.a) < Math.abs(var1.b - var2.b);
   }
}
