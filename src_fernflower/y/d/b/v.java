package y.d.b;

import java.math.BigInteger;
import y.d.b.z;

public class v implements z {
   public static final v a = new v(1L);
   public static final v b = new v(0L);
   protected BigInteger c;
   private static final BigInteger d = new BigInteger("-1");

   public v(long var1) {
      this.c = BigInteger.valueOf(var1);
   }

   public v(BigInteger var1) {
      this.c = var1;
   }

   public z a() {
      return b;
   }

   public z b() {
      return a;
   }

   public z a(z var1) {
      v var2 = (v)var1;
      return new v(this.c.add(var2.c));
   }

   public z b(z var1) {
      v var2 = (v)var1;
      return new v(this.c.subtract(var2.c));
   }

   public z c(z var1) {
      v var2 = (v)var1;
      return new v(this.c.multiply(var2.c));
   }

   public z d(z var1) {
      v var2 = (v)var1;
      return new v(this.c.divide(var2.c));
   }

   public z e(z var1) {
      v var2 = (v)var1;
      return new v(this.c.gcd(var2.c));
   }

   public int c() {
      return this.c.signum();
   }

   public z d() {
      return new v(this.c.negate());
   }

   public int f(z var1) {
      v var2 = (v)var1;
      return this.c.compareTo(var2.c);
   }

   public double e() {
      return this.c.doubleValue();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof v)) {
         return false;
      } else {
         v var2 = (v)var1;
         return this.c.equals(var2.c);
      }
   }

   public String toString() {
      return this.c.toString();
   }
}
