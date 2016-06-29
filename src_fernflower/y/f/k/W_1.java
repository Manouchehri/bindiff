package y.f.k;

import y.f.k.P;
import y.f.k.V;
import y.f.k.Y;
import y.f.k.d;
import y.f.k.l;

class W extends V {
   private y.d.t c;
   private y.f.I d;
   private boolean e;

   W(l var1, y.f.X var2, y.c.d var3, P var4) {
      super(var4);
      this.d = var2.b(var3);
      this.d.clearPoints();
      this.c = d.a(var1, var2.p(var3));
      Y var5 = new Y();
      var5.a(new y.d.t(this.c.a(), this.c.b()));
      this.a(var5);
   }

   void c() {
      if(this.e) {
         throw new IllegalStateException("TargetPoints already have beend appended");
      } else {
         this.b.j();
         this.b.i().a(this.d);
         this.e = true;
      }
   }

   public void d() {
      this.b.a(this.c.a(), this.c.b());
   }

   public void e() {
      this.d();
      this.c();
      this.b.h();
      this.b.j();
   }
}
