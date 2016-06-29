package y.f.i;

class H {
   private y.d.t a;
   private y.d.t b;

   H(y.d.t var1, y.d.t var2) {
      this.a = var1;
      this.b = var2;
   }

   private boolean e() {
      return this.a.a() == this.b.a();
   }

   boolean a() {
      return this.e() && this.a.b() > this.b.b();
   }

   boolean b() {
      return this.e() && this.a.b() < this.b.b();
   }

   boolean c() {
      return !this.e() && this.a.a() > this.b.a();
   }

   int d() {
      return this.a()?0:(this.b()?1:(this.c()?2:3));
   }

   static boolean a(H var0) {
      return var0.e();
   }
}
