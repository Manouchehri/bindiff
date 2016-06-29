package y.f;

public class N {
   double a;
   double b;
   double c;
   double d;

   public N() {
      this(0.0D, 0.0D, 0.0D, -1.0D);
   }

   public N(double var1, double var3) {
      this(var1, var3, 0.0D, -1.0D);
   }

   N(double var1, double var3, double var5, double var7) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
      this.d = var7;
   }
}
