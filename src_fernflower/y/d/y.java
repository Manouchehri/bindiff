package y.d;

import y.d.o;
import y.d.q;
import y.d.t;

public class y extends q implements o {
   public final double c;
   public final double d;
   private t e;

   public y() {
      super(0.0D, 0.0D);
      this.c = this.d = 0.0D;
   }

   public y(t var1, q var2) {
      super(var2.a, var2.b);
      this.c = var1.a;
      this.d = var1.b;
      this.e = var1;
   }

   public y(double var1, double var3, double var5, double var7) {
      super(var5, var7);
      this.c = var1;
      this.d = var3;
   }

   public double a(y var1) {
      double var2;
      t var4;
      t var5;
      t var6;
      t var7;
      boolean var8;
      label23: {
         var8 = t.d;
         var2 = 0.0D;
         var4 = new t(this.c(), this.d());
         var5 = new t(this.c() + this.a(), this.d() + this.b());
         var6 = new t(var1.c(), var1.d());
         var7 = new t(var1.c() + var1.a(), var1.d() + var1.b());
         if(var5.a() < var6.a()) {
            var2 += Math.abs(var6.a() - var5.a());
            if(!var8) {
               break label23;
            }
         }

         if(var4.a() > var7.a()) {
            var2 += Math.abs(var7.a() - var4.a());
         }
      }

      if(var5.b() < var6.b()) {
         var2 += Math.abs(var6.b() - var5.b());
         if(!var8) {
            return var2;
         }
      }

      if(var4.b() > var7.b()) {
         var2 += Math.abs(var7.b() - var4.b());
      }

      return var2;
   }

   public final double c() {
      return this.c;
   }

   public final double d() {
      return this.d;
   }

   public final t e() {
      if(this.e == null) {
         this.e = new t(this.c, this.d);
      }

      return this.e;
   }

   public y h() {
      return this;
   }

   public boolean a(double var1, double var3) {
      return a(this.c, this.d, this.a, this.b, var1, var3, false);
   }

   public static boolean a(double var0, double var2, double var4, double var6, double var8, double var10) {
      return a(var0, var2, var4, var6, var8, var10, false);
   }

   public static boolean a(double var0, double var2, double var4, double var6, double var8, double var10, boolean var12) {
      return var12?var8 >= var0 && var8 - var0 <= var4 && var10 >= var2 && var10 - var2 <= var6:var8 >= var0 && var8 - var0 < var4 && var10 >= var2 && var10 - var2 < var6;
   }

   public boolean a(t var1) {
      return this.a(var1.a, var1.b);
   }

   public boolean b(y var1) {
      return this.a(var1.c, var1.d, var1.a, var1.b);
   }

   public boolean a(double var1, double var3, double var5, double var7) {
      return this.a(var1, var3) && this.a(var1 + var5, var3 + var7);
   }

   public static boolean a(y var0, y var1) {
      return var0.c + var0.a > var1.c && var0.d + var0.b > var1.d && var0.c < var1.c + var1.a && var0.d < var1.d + var1.b;
   }

   public String toString() {
      return "[" + this.c + ',' + this.d + ',' + this.a + ',' + this.b + ']';
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.c) >> 1 ^ Double.doubleToLongBits(this.d);
      return super.hashCode() << 1 ^ (int)(var1 ^ var1 >> 32);
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof y)) {
         return false;
      } else {
         y var2 = (y)var1;
         return var2.c == this.c && var2.d == this.d && var2.a == this.a && var2.b == this.b;
      }
   }

   public int compareTo(Object var1) {
      y var2 = (y)var1;
      return this.c < var2.c?-1:(this.c > var2.c?1:(this.d < var2.d?-1:(this.d > var2.d?1:super.compareTo(var1))));
   }
}
