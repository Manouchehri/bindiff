package y.d.b;

import java.math.BigInteger;
import y.d.b.c;
import y.d.b.z;

public class A implements z {
   private static final BigInteger g = BigInteger.valueOf(Long.MAX_VALUE);
   private static final BigInteger h = BigInteger.valueOf(Long.MIN_VALUE);
   public static final A a = new A(1L);
   public static final A b = new A(0L);
   private static final BigInteger i = new BigInteger("-1");
   protected boolean c;
   protected long d;
   protected int e;
   protected BigInteger f;

   public A(long var1) {
      this.c = false;
      this.f = BigInteger.valueOf(var1);
      this.c = true;
      this.d = var1;
      this.e = 0;

      for(long var3 = Math.abs(this.d); var3 != 0L; ++this.e) {
         var3 >>= 1;
      }

   }

   public A(BigInteger var1) {
      int var4 = c.a;
      super();
      this.c = false;
      this.f = var1;
      if(this.f.compareTo(g) < 0 && this.f.compareTo(h) > 0) {
         this.c = true;
         this.d = this.f.longValue();
         this.e = 0;
         long var2 = Math.abs(this.d);

         while(var2 != 0L) {
            var2 >>= 1;
            ++this.e;
            if(var4 != 0) {
               break;
            }
         }
      }

   }

   public z a() {
      return b;
   }

   public z b() {
      return a;
   }

   public z a(z var1) {
      A var2 = (A)var1;
      return this.c && var2.c && this.e + 1 < 62 && var2.e + 1 < 62?new A(this.d + var2.d):new A(this.f.add(var2.f));
   }

   public z b(z var1) {
      A var2 = (A)var1;
      return this.c && var2.c && this.e + 1 < 62 && var2.e + 1 < 62?new A(this.d - var2.d):new A(this.f.subtract(var2.f));
   }

   public z c(z var1) {
      A var2 = (A)var1;
      return this.c && var2.c && this.e + var2.e < 62?(this.d == 1L?var2:(var2.d == 1L?this:new A(this.d * var2.d))):new A(this.f.multiply(var2.f));
   }

   public z d(z var1) {
      A var2 = (A)var1;
      return new A(this.f.divide(var2.f));
   }

   public z e(z var1) {
      A var2 = (A)var1;
      return new A(this.f.gcd(var2.f));
   }

   public int c() {
      return this.f.signum();
   }

   public z d() {
      return new A(this.f.negate());
   }

   public int f(z var1) {
      A var2 = (A)var1;
      return this.c && var2.c && this.e + 1 < 62 && var2.e + 1 < 62?y.g.e.a(this.d, var2.d):this.f.compareTo(var2.f);
   }

   public double e() {
      return this.c?(double)this.d:this.f.doubleValue();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof A)) {
         return false;
      } else {
         A var2 = (A)var1;
         return this.c && var2.c?this.d == var2.d:this.f.equals(var2.f);
      }
   }

   public String toString() {
      return this.c?Long.toString(this.d):this.f.toString();
   }
}
