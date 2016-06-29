package y.f.i.a;

public class M {
   private final double a;
   private final double b;

   public M(double var1, double var3) {
      this.a = Math.min(var1, var3);
      this.b = Math.max(var1, var3);
   }

   public double a() {
      return this.a;
   }

   public double b() {
      return this.b;
   }

   public double c() {
      return 0.5D * (this.a + this.b);
   }

   public boolean a(double var1) {
      return var1 >= this.a && var1 <= this.b;
   }

   public double d() {
      return this.b - this.a;
   }

   public boolean a(M var1) {
      return this.a(var1, 0.0D);
   }

   public boolean a(M var1, double var2) {
      return this.a + var2 <= var1.b && this.b - var2 >= var1.a;
   }

   public double b(double var1) {
      return var1 < this.a?this.a - var1:(var1 > this.b?var1 - this.b:0.0D);
   }

   public double b(M var1) {
      return this.b < var1.a?var1.a - this.b:(this.a > var1.b?this.a - var1.b:0.0D);
   }

   public boolean c(M var1) {
      return this.b(var1, 1.0E-6D);
   }

   public boolean b(M var1, double var2) {
      return var1.a - var2 < this.a && var1.b + var2 > this.b;
   }

   public double c(double var1) {
      return var1 < this.a?this.a:(var1 > this.b?this.b:var1);
   }

   public String toString() {
      return "[" + this.a + ", " + this.b + "]";
   }

   public boolean d(M var1) {
      return this.c(var1, 1.0E-6D);
   }

   public boolean c(M var1, double var2) {
      return Math.abs(this.a - var1.a) < var2 && Math.abs(this.b - var1.b) < var2;
   }

   public static M a(M var0, M var1) {
      return !var0.a(var1)?null:new M(Math.max(var0.a, var1.a), Math.min(var0.b, var1.b));
   }

   public static M b(M var0, M var1) {
      return new M(Math.min(var0.a, var1.a), Math.max(var0.b, var1.b));
   }

   public static M d(M var0, double var1) {
      return new M(Math.min(var0.a, var1), Math.max(var0.b, var1));
   }

   public static M c(M var0, M var1) {
      double var2 = Math.min(var0.b, var1.b);
      double var4 = Math.max(var0.a, var1.a);
      return var2 > var4?null:new M(var2, var4);
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         M var2 = (M)var1;
         return a(var2.b, this.b) != 0?false:a(var2.a, this.a) == 0;
      } else {
         return false;
      }
   }

   public int hashCode() {
      long var2 = this.a != 0.0D?Double.doubleToLongBits(this.a):0L;
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = this.b != 0.0D?Double.doubleToLongBits(this.b):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      return var1;
   }

   private static int a(double var0, double var2) {
      if(var0 > var2) {
         return 1;
      } else if(var0 < var2) {
         return -1;
      } else {
         long var4 = Double.doubleToLongBits(var0);
         long var6 = Double.doubleToLongBits(var2);
         return var4 == var6?0:(var4 > var6?1:-1);
      }
   }
}
