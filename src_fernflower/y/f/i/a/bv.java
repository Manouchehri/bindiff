package y.f.i.a;

class bv {
   private final double a;
   private final byte b;
   private final int c;
   private final boolean d;

   bv(double var1, byte var3, boolean var4) {
      this.a = var1;
      this.b = var3;
      this.c = this.a()?-1000:(this.f()?16:(this.e()?15:(this.d()?10:0)));
      this.d = var4;
   }

   public boolean a() {
      return (this.b & 32) != 0;
   }

   public boolean b() {
      return (this.b & 1) != 0;
   }

   public boolean c() {
      return (this.b & 2) != 0;
   }

   public boolean d() {
      return (this.b & 4) != 0;
   }

   public boolean e() {
      return (this.b & 8) != 0;
   }

   public boolean f() {
      return (this.b & 16) != 0;
   }

   public int g() {
      return this.c;
   }

   public boolean h() {
      return this.d;
   }

   public double i() {
      return this.a;
   }
}
