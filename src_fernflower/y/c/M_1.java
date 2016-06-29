package y.c;

import y.c.H;
import y.c.I;
import y.c.L;
import y.c.d;
import y.c.q;

class M implements H {
   private I a;
   private final L b;

   M(L var1) {
      this.b = var1;
      this.a = L.a(var1);
   }

   public boolean f() {
      return this.a != null;
   }

   public void g() {
      this.a = this.a.i;
   }

   public void h() {
      this.a = this.a.j;
   }

   public void j() {
      this.a = L.b(this.b);
   }

   public void i() {
      this.a = L.a(this.b);
   }

   public int k() {
      return L.c(this.b);
   }

   public Object d() {
      return this.a;
   }

   public q e() {
      return (q)this.a;
   }

   public d a() {
      return (d)this.a;
   }

   public void b() {
      this.g();
      if(!this.f()) {
         this.i();
      }

   }

   public void c() {
      this.h();
      if(!this.f()) {
         this.j();
      }

   }
}
