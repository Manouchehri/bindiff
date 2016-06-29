package y.h;

public abstract class el {
   final byte a;
   final y.d.t b;

   protected el(y.d.t var1, byte var2) {
      this.b = var1;
      this.a = var2;
   }

   public final y.d.t b() {
      return this.b;
   }

   public final boolean c() {
      return (this.a & 2) == 0;
   }

   public final boolean d() {
      return (this.a & 1) == 0;
   }

   final y.d.t b(double var1, double var3) {
      return new y.d.t(this.a(var1), this.b(var3));
   }

   final double a(double var1) {
      return (this.a & 1) == 0?this.b.a:this.b.a + var1;
   }

   final double b(double var1) {
      return (this.a & 2) == 0?this.b.b:this.b.b + var1;
   }

   public abstract void a(double var1, double var3);
}
