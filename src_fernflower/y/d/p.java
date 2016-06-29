package y.d;

import y.d.t;

public class p implements Comparable {
   public final t a;
   public final double b;

   public p(t var1, t var2, t var3) {
      boolean var22 = t.d;
      super();
      double var4 = var1.a();
      double var6 = var1.b();
      double var8 = var2.a();
      double var10 = var2.b();
      double var12 = var3.a();
      double var14 = var3.b();
      double var16 = (var4 * var4 + var6 * var6) * (var10 - var14) + (var8 * var8 + var10 * var10) * (var14 - var6) + (var12 * var12 + var14 * var14) * (var6 - var10);
      double var18 = -(var4 * var4 + var6 * var6) * (var8 - var12) - (var8 * var8 + var10 * var10) * (var12 - var4) - (var12 * var12 + var14 * var14) * (var4 - var8);
      double var20 = 2.0D * ((var8 - var4) * (var14 - var6) - (var12 - var4) * (var10 - var6));
      if(var20 == 0.0D) {
         throw new IllegalArgumentException("Points are collinear");
      } else {
         this.a = new t(var16 / var20, var18 / var20);
         this.b = t.a(this.a, var1);
         if(var22) {
            y.c.i.g = !y.c.i.g;
         }

      }
   }

   public p(t var1, double var2) {
      this.a = var1;
      this.b = var2;
   }

   public t a() {
      return this.a;
   }

   public final double b() {
      return this.b;
   }

   public t[] a(double var1) {
      double var4 = -2.0D * this.a.a();
      double var6 = this.a.a() * this.a.a() + var1 * var1 - 2.0D * this.a.b() * var1 + this.a.b() * this.a.b() - this.b * this.b;
      double var8 = var4 * var4 / 4.0D - var6;
      if(var8 < 0.0D) {
         return null;
      } else {
         t[] var3;
         if(var8 == 0.0D) {
            var3 = new t[]{new t(-var4 / 2.0D, var1)};
            if(!t.d) {
               return var3;
            }
         }

         var3 = new t[2];
         var8 = Math.sqrt(var8);
         var3[0] = new t(-var4 / 2.0D - var8, var1);
         var3[1] = new t(-var4 / 2.0D + var8, var1);
         return var3;
      }
   }

   public t[] b(double var1) {
      double var4 = -2.0D * this.a.b();
      double var6 = this.a.b() * this.a.b() + var1 * var1 - 2.0D * this.a.a() * var1 + this.a.a() * this.a.a() - this.b * this.b;
      double var8 = var4 * var4 / 4.0D - var6;
      if(var8 < 0.0D) {
         return null;
      } else {
         t[] var3;
         if(var8 == 0.0D) {
            var3 = new t[]{new t(var1, -var4 / 2.0D)};
            if(!t.d) {
               return var3;
            }
         }

         var3 = new t[2];
         var8 = Math.sqrt(var8);
         var3[0] = new t(var1, -var4 / 2.0D - var8);
         var3[1] = new t(var1, -var4 / 2.0D + var8);
         return var3;
      }
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof p)) {
         return false;
      } else {
         p var2 = (p)var1;
         return var2.b == this.b && var2.a.equals(this.a);
      }
   }

   public int hashCode() {
      return this.a.hashCode() ^ (int)Double.doubleToLongBits(this.b);
   }

   public int compareTo(Object var1) {
      p var2 = (p)var1;
      return this.a.a < var2.a.a?-1:(this.a.a > var2.a.a?1:(this.a.b < var2.a.b?-1:(this.a.b > var2.a.b?1:(this.b > var2.b?1:(this.b < var2.b?-1:0)))));
   }
}
