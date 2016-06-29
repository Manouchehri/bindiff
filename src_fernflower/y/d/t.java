package y.d;

public final class t implements Comparable {
   public final double a;
   public final double b;
   public static final t c = new t(0.0D, 0.0D);
   public static boolean d;

   public t() {
      this.a = 0.0D;
      this.b = 0.0D;
   }

   public t(double var1, double var3) {
      this.a = var1;
      this.b = var3;
   }

   public final double a() {
      return this.a;
   }

   public final double b() {
      return this.b;
   }

   public double a(double var1, double var3) {
      var1 -= this.a;
      var3 -= this.b;
      return Math.sqrt(var1 * var1 + var3 * var3);
   }

   public double a(t var1) {
      double var2 = this.a - var1.a;
      double var4 = this.b - var1.b;
      return Math.sqrt(var2 * var2 + var4 * var4);
   }

   public static double a(t var0, t var1) {
      return Math.sqrt((var0.a - var1.a) * (var0.a - var1.a) + (var0.b - var1.b) * (var0.b - var1.b));
   }

   public static double a(double var0, double var2, double var4, double var6) {
      var0 -= var4;
      var2 -= var6;
      return Math.sqrt(var0 * var0 + var2 * var2);
   }

   public static t b(t var0, t var1) {
      return new t(var0.a + var1.a, var0.b + var1.b);
   }

   public static t c(t var0, t var1) {
      return new t((var0.a + var1.a) / 2.0D, (var0.b + var1.b) / 2.0D);
   }

   public static t b(t var0) {
      return new t(var0.b, var0.a);
   }

   public t b(double var1, double var3) {
      return new t(this.a + var1, this.b + var3);
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof t)) {
         return false;
      } else {
         t var2 = (t)var1;
         return var2.a == this.a && var2.b == this.b;
      }
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.a) << 1 ^ Double.doubleToLongBits(this.b);
      return (int)(var1 >> 32 ^ var1);
   }

   public String toString() {
      return "X: " + this.a + " Y: " + this.b;
   }

   public int compareTo(Object var1) {
      if(this == var1) {
         return 0;
      } else {
         t var2 = (t)var1;
         return this.a < var2.a?-1:(this.a > var2.a?1:(this.b < var2.b?-1:(this.b > var2.b?1:0)));
      }
   }
}
