package y.f.f;

public class a {
   private double b = 15.0D;
   private double c = 15.0D;
   private double d = 15.0D;
   public static boolean a;

   public void a(double var1) {
      this.b = var1;
   }

   public double a() {
      return this.b;
   }

   public void b(double var1) {
      this.c = var1;
   }

   public double b() {
      return this.c;
   }

   public void c(double var1) {
      this.d = var1;
   }

   public double c() {
      return this.d;
   }

   public a d() {
      a var1 = new a();
      var1.a(this.a());
      var1.b(this.b());
      var1.c(this.c());
      return var1;
   }
}
