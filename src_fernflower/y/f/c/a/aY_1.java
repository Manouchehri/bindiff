package y.f.c.a;

public class aY {
   private double[] a = new double[]{0.5D, 0.5D, 0.5D, 0.5D};
   private double b = 0.5D;
   private double c = 0.0D;
   private byte d = 2;
   private double e = 5.0D;

   public double a(int var1) {
      return this.a[var1];
   }

   public void a(double var1) {
      if(var1 >= 0.0D && var1 <= 1.0D) {
         this.b = var1;
      } else {
         throw new IllegalArgumentException();
      }
   }

   public double a() {
      return this.b;
   }

   public byte b() {
      return this.d;
   }

   public double c() {
      return this.c;
   }

   public double d() {
      return this.e;
   }
}
