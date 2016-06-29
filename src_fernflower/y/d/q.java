package y.d;

public class q implements Comparable {
   public final double a;
   public final double b;

   public q(double var1, double var3) {
      this.a = var1;
      this.b = var3;
   }

   public final double a() {
      return this.a;
   }

   public final double b() {
      return this.b;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof q)) {
         return false;
      } else {
         q var2 = (q)var1;
         return var2.a == this.a && var2.b == this.b;
      }
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.a) << 1 ^ Double.doubleToLongBits(this.b);
      return (int)(var1 ^ var1 >> 32);
   }

   public String toString() {
      return "W: " + this.a + " H: " + this.b;
   }

   public int compareTo(Object var1) {
      q var2 = (q)var1;
      return this.equals(var2)?0:(var2.a > this.a?-1:(var2.a < this.a?1:(var2.b > this.b?-1:(var2.b < this.b?1:0))));
   }
}
