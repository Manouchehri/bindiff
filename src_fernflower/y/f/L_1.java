package y.f;

public class L {
   double a;
   double b;
   double c;

   public L() {
      this(50.0D, 0.0D, 0.0D);
   }

   public L(double var1, double var3, double var5) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
   }

   public double a() {
      return this.c;
   }

   public String toString() {
      return this.getClass() + " radius=" + this.a + "  theta(deg)=" + y.d.e.b(this.b);
   }
}
