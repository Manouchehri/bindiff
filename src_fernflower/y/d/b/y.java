package y.d.b;

import y.d.b.z;

public class y implements z {
   private static y a = new y(0.0D);
   private static y b = new y(1.0D);
   private double c;

   public y(double var1) {
      this.c = var1;
   }

   public z a() {
      return a;
   }

   public z b() {
      return b;
   }

   public z a(z var1) {
      y var2 = (y)var1;
      return new y(this.c + var2.e());
   }

   public z b(z var1) {
      y var2 = (y)var1;
      return new y(this.c - var2.e());
   }

   public z c(z var1) {
      y var2 = (y)var1;
      return new y(this.c * var2.e());
   }

   public z d(z var1) {
      y var2 = (y)var1;
      return new y(this.c / var2.e());
   }

   public z d() {
      return new y(-this.c);
   }

   public z e(z var1) {
      return b;
   }

   public int c() {
      return this.c < 0.0D?-1:(this.c > 0.0D?1:0);
   }

   public int f(z var1) {
      return var1 == this?0:y.g.e.a(this.c, ((y)var1).e());
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof y)) {
         return false;
      } else {
         y var2 = (y)var1;
         return this.c == var2.e();
      }
   }

   public double e() {
      return this.c;
   }

   public String toString() {
      return "" + this.c;
   }
}
