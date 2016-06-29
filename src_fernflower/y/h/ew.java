package y.h;

class ew {
   private boolean a;
   private boolean b;
   private y.d.t c;
   private double d;
   private double e;

   public ew(y.d.t var1, boolean var2, boolean var3, double var4, double var6) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      this.d = var4;
      this.e = var6;
   }

   public ew(y.d.t var1, double var2, double var4) {
      this(var1, false, false, var2, var4);
   }

   public boolean a() {
      return this.b;
   }

   public boolean b() {
      return this.a;
   }

   public double c() {
      return this.d;
   }

   public double d() {
      return this.e;
   }

   public y.d.t a(double var1, double var3) {
      return new y.d.t(this.a(var1), this.b(var3));
   }

   public y.d.z a(double var1, double var3, double var5) {
      double var7 = b(this.a(var3), var1);
      if(this.b() && Math.abs(var7) > 0.0D) {
         var7 = Double.MAX_VALUE;
      }

      double var9 = b(this.b(var5), var1);
      if(this.a() && Math.abs(var9) > 0.0D) {
         var9 = Double.MAX_VALUE;
      }

      return new y.d.z(var7, var9);
   }

   public double b(double var1, double var3, double var5) {
      y.d.z var7 = this.a(var1, var3, var5);
      return Math.max(Math.abs(var7.a()), Math.abs(var7.b()));
   }

   public double c(double var1, double var3, double var5) {
      y.d.z var7 = this.a(var1, var3, var5);
      return Math.min(Math.abs(var7.a()), Math.abs(var7.b()));
   }

   public final double a(double var1) {
      return this.b()?this.c.a:this.c.a + var1;
   }

   public final double b(double var1) {
      return this.a()?this.c.b:this.c.b + var1;
   }

   private static double b(double var0, double var2) {
      return Math.floor(var0 / var2 + 0.5D) * var2 - var0;
   }
}
