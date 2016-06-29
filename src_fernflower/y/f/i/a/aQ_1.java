package y.f.i.a;

import y.f.i.a.aN;
import y.f.i.a.aT;

class aQ extends aT {
   private final y.d.y g;
   private final double h;
   private final y.d.t i;
   private final aN j;

   aQ(aN var1, y.d.m var2, y.d.m var3, y.c.d var4) {
      super(var4, var2.b()?var2:var3, var2.a()?var2:var3);
      this.j = var1;
      this.i = new y.d.t(this.b.c().a, this.a.c().b);
      this.h = var2.b()?Math.abs(this.i.a - var2.d().a):Math.abs(this.i.b - var2.d().b);
      this.g = this.g();
   }

   private y.d.y g() {
      double var1 = this.h + 2.0D;
      return this.c == 3?new y.d.y(this.i.a - this.h - 1.0D, this.i.b - 1.0D, var1, var1):(this.c == 2?new y.d.y(this.i.a - 1.0D, this.i.b - 1.0D, var1, var1):(this.c == 0?new y.d.y(this.i.a - 1.0D, this.i.b - this.h - 1.0D, var1, var1):new y.d.y(this.i.a - this.h - 1.0D, this.i.b - this.h - 1.0D, var1, var1)));
   }

   public boolean a() {
      return true;
   }

   public double b() {
      return this.i.a();
   }

   public double c() {
      return this.i.b();
   }

   public y.d.y h() {
      return this.g;
   }

   public void a(double var1) {
      throw new IllegalStateException("Segment offset is fixed!");
   }

   public double d() {
      return this.c != 3 && this.c != 1?this.b() + this.h:this.b() - this.h;
   }

   public double e() {
      return this.c != 0 && this.c != 1?this.c() + this.h:this.c() - this.h;
   }
}
