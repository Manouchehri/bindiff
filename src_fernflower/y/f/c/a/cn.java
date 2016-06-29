package y.f.c.a;

import y.f.c.a.df;

abstract class cn implements df {
   protected double a = 0.0D;
   protected double b = 10.0D;
   protected double c = 20.0D;
   protected double d = 0.0D;
   protected double e = 10.0D;
   protected double f = 0.0D;
   protected double g;
   private double h;
   private double i;
   private y.c.f j;

   public cn() {
      this.b();
   }

   public double a() {
      int var1 = this.d();
      return var1 < 1?this.d:this.d + this.f + (double)(var1 - 1) * this.e + this.g;
   }

   public void b() {
      this.h = this.d + this.f;
      this.i = this.a + this.c;
   }

   public double c() {
      double var1 = this.h;
      this.h += this.e;
      return var1;
   }

   public void a(double var1) {
      this.d = var1;
      this.b();
   }

   public void b(double var1) {
      this.e = this.g = var1;
      this.b();
   }

   public void a(y.c.d var1) {
      this.e().b(var1);
   }

   public int d() {
      return this.j != null?this.j.size():0;
   }

   public y.c.f e() {
      if(this.j == null) {
         this.j = new y.c.f();
      }

      return this.j;
   }

   public y.d.t a(double var1, double var3) {
      return new y.d.t(this.b(var1, var3), this.c(var1, var3));
   }

   public void b(y.c.d var1) {
      this.e().a(var1);
   }
}
