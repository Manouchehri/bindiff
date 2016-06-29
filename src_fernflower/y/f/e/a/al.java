package y.f.e.a;

import y.f.e.a.Z;
import y.f.e.a.a;
import y.f.e.a.k;

class al {
   private a a = new Z();
   private a b = new Z();
   private double c;
   private double d;

   public void a(k var1) {
      this.b.a(this.a.d());
      this.b.b(this.a.e());
      this.b.c(this.a.f());
      this.a.a(var1.d());
      this.a.b(var1.e());
      this.a.c(var1.f());
      this.c();
   }

   private void c() {
      this.d = this.c;
      double var1 = this.a.c();
      double var3 = this.b.c();
      if(var1 != 0.0D && var3 != 0.0D) {
         this.c = (this.a.d() * this.b.d() + this.a.e() * this.b.e() + this.a.f() * this.b.f()) / (var1 * var3);
      } else {
         this.c = 0.0D;
      }
   }

   public double a() {
      return this.c;
   }

   public double b() {
      return this.d;
   }
}
