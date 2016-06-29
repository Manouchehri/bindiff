package y.f.e.a;

import y.f.e.a.a;
import y.f.e.a.k;

public final class Z implements a {
   private double a;
   private double b;
   private double c;

   public void a() {
      this.a = 0.0D;
      this.b = 0.0D;
      this.c = 0.0D;
   }

   public double c() {
      return Math.sqrt(this.a * this.a + this.b * this.b + this.c * this.c);
   }

   public a a(k var1, a var2) {
      var2.a(this.a - var1.d());
      var2.b(this.b - var1.e());
      var2.c(this.c - var1.f());
      return var2;
   }

   public void a(k var1) {
      if(var1 != null) {
         this.a += var1.d();
         this.b += var1.e();
         this.c += var1.f();
      }
   }

   public void a(double var1, double var3, double var5) {
      this.a += var1;
      this.b += var3;
      this.c += var5;
   }

   public void d(double var1) {
      this.a *= var1;
      this.b *= var1;
      this.c *= var1;
   }

   public boolean g() {
      return this.a == 0.0D && this.b == 0.0D && this.c == 0.0D;
   }

   public void b() {
      this.e(1.0D);
   }

   public void e(double var1) {
      double var3 = this.c();
      if(var3 != 0.0D) {
         double var5 = var1 / var3;
         this.a *= var5;
         this.b *= var5;
         this.c *= var5;
      }
   }

   public double d() {
      return this.a;
   }

   public void a(double var1) {
      this.a = var1;
   }

   public double e() {
      return this.b;
   }

   public void b(double var1) {
      this.b = var1;
   }

   public double f() {
      return this.c;
   }

   public void c(double var1) {
      this.c = var1;
   }

   public void b(double var1, double var3, double var5) {
      this.a(var1);
      this.b(var3);
      this.c(var5);
   }

   public String toString() {
      return "Point3F{x=" + this.a + ", y=" + this.b + ", z=" + this.c + '}';
   }
}
