package y.h;

import y.h.aA;
import y.h.aB;
import y.h.dD;
import y.h.dh;
import y.h.gu;
import y.h.gv;
import y.h.in;

final class it {
   final aA a;
   final gu b;
   final gv c;
   final dh d;
   y.d.n e;
   gv f;

   it(in var1, dD var2) {
      double var3 = var2.c() - in.a(var1);
      double var5 = var2.d() - in.b(var1);
      y.d.t var7 = in.c(var1);
      this.a = (aA)var2.b();
      this.b = in.d(var1);
      this.f = in.e(var1);
      this.c = in.f(var1);
      this.d = in.g(var1);
      this.e = new y.d.n(in.h(var1));
      if(this.b.b()) {
         this.e.a(6.283185307179586D - this.c.f());
      }

      this.e.e(var7.a() + var3, var7.b() + var5);
   }

   double a() {
      return this.d.e() / this.b();
   }

   double b() {
      return this.d.c().getZoom();
   }

   y.d.t a(y.c.D var1) {
      return this.d.b(var1, this.e.k());
   }

   y.d.n c() {
      aB var1 = this.a.getRealizer();
      return this.b.a(this.e.d(), var1, var1.getSourceRealizer(), var1.getTargetRealizer(), this.f);
   }

   void d() {
      this.f = this.b.a(this.e, this.a.getRealizer(), this.f, (byte)2);
   }
}
