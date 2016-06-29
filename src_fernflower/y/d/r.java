package y.d;

import java.awt.Insets;
import java.io.Serializable;

public final class r implements Serializable {
   public final double a;
   public final double b;
   public final double c;
   public final double d;

   public r(double var1, double var3, double var5, double var7) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = var7;
   }

   public r(Insets var1) {
      this((double)var1.top, (double)var1.left, (double)var1.bottom, (double)var1.right);
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         r var2 = (r)var1;
         return a(var2.c, this.c) != 0?false:(a(var2.b, this.b) != 0?false:(a(var2.d, this.d) != 0?false:a(var2.a, this.a) == 0));
      } else {
         return false;
      }
   }

   public int hashCode() {
      long var2 = this.a != 0.0D?Double.doubleToLongBits(this.a):0L;
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = this.b != 0.0D?Double.doubleToLongBits(this.b):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.c != 0.0D?Double.doubleToLongBits(this.c):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      var2 = this.d != 0.0D?Double.doubleToLongBits(this.d):0L;
      var1 = 31 * var1 + (int)(var2 ^ var2 >>> 32);
      return var1;
   }

   public String toString() {
      return this.getClass().getName() + "[top=" + this.a + ";left=" + this.b + ";bottom=" + this.c + ";right=" + this.d + "]";
   }

   static int a(double var0, double var2) {
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

   public static r a(Object var0) {
      return var0 instanceof r?(r)var0:(var0 instanceof Insets?new r((Insets)var0):null);
   }
}
