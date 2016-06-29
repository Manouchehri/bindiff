package y.b;

import y.b.n;

class o implements n {
   private final double a;
   private final double b;
   private final double c;

   o(double var1, double var3) {
      this.a = 2.0D / (1.0D - var1 + var3);
      this.b = var1;
      this.c = var3;
   }

   public double a(double var1) {
      if(0.0D >= var1) {
         return 0.0D;
      } else if(1.0D <= var1) {
         return 1.0D;
      } else if(this.b > var1) {
         return this.a / (2.0D * this.b) * var1 * var1;
      } else if(this.c < var1) {
         double var3 = 1.0D - var1;
         return 1.0D - this.a / (2.0D - 2.0D * this.c) * var3 * var3;
      } else {
         return this.a * (var1 - this.b / 2.0D);
      }
   }
}
